package com.example.circleprogressbar


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val timer = object : CountDownTimer(10000L, 1000L){
        override fun onTick(millisUntilFinished: Long) {
            Log.d("MyLog", "onTick $millisUntilFinished")
            findViewById<TextView>(R.id.tv_progress_circle).text = (millisUntilFinished/1000).toString()
            findViewById<ProgressBar>(R.id.progressBar).progress = (millisUntilFinished/1000).toInt()
        }

        override fun onFinish() {
            Log.d("MyLog", "onFinish ")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max = 10
        progressBar.progress = 10
        findViewById<TextView>(R.id.tv_progress_circle).text = "10"
        findViewById<Button>(R.id.button).setOnClickListener {
            progressBar.progress = 10
            timer.start()
        }
        findViewById<Button>(R.id.stop).setOnClickListener {
            timer.cancel()
        }
        findViewById<Button>(R.id.pause).setOnClickListener {
            timer.onTick(5000)
        }

    }

}