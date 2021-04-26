package com.baidu.android.util.time;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes.dex */
public class CountDownTimer {
    public static final int MSG = 1;
    public final long mCountdownInterval;
    public long mCountdownMillis;
    public long mPauseTime;
    public long mStopTimeInFuture;
    public boolean mIsCancelled = false;
    public boolean mIsPaused = true;
    public boolean mIsFinished = false;
    public StatusListener mListener = new StatusListener() { // from class: com.baidu.android.util.time.CountDownTimer.1
        @Override // com.baidu.android.util.time.CountDownTimer.StatusListener
        public void onStart() {
            super.onStart();
        }
    };
    public Handler mHandler = new Handler() { // from class: com.baidu.android.util.time.CountDownTimer.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CountDownTimer.this.handleCountDownMessage(message);
        }
    };

    /* loaded from: classes.dex */
    public static abstract class StatusListener {
        public void onCancel() {
        }

        public void onFinish() {
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void onStart() {
        }

        public void onTick(long j) {
        }
    }

    public CountDownTimer(long j, long j2) {
        this.mCountdownMillis = j;
        this.mCountdownInterval = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCountDownMessage(Message message) {
        long j;
        synchronized (this) {
            if (!this.mIsCancelled && !this.mIsPaused) {
                long elapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
                long j2 = 0;
                if (elapsedRealtime <= 0) {
                    this.mIsFinished = true;
                    this.mListener.onFinish();
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    this.mListener.onTick(elapsedRealtime);
                    long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                    if (elapsedRealtime < this.mCountdownInterval) {
                        j = elapsedRealtime - elapsedRealtime3;
                        if (j < 0) {
                            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), j2);
                        }
                    } else {
                        j = this.mCountdownInterval - elapsedRealtime3;
                        while (j < 0) {
                            j += this.mCountdownInterval;
                        }
                    }
                    j2 = j;
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), j2);
                }
            }
        }
    }

    public final synchronized void cancel() {
        this.mIsCancelled = true;
        this.mHandler.removeMessages(1);
        this.mListener.onCancel();
    }

    public final synchronized void pause() {
        if (!this.mIsPaused && !this.mIsCancelled && !this.mIsFinished) {
            this.mPauseTime = SystemClock.elapsedRealtime();
            this.mIsPaused = true;
            this.mListener.onPause();
            this.mHandler.removeMessages(1);
        }
    }

    public final synchronized void resume() {
        if (this.mIsPaused && !this.mIsCancelled && !this.mIsFinished) {
            this.mIsPaused = false;
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + (this.mStopTimeInFuture - this.mPauseTime);
            this.mListener.onResume();
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        }
    }

    public void setCountDownMillis(long j) {
        this.mCountdownMillis = j;
    }

    public CountDownTimer setStatusListener(StatusListener statusListener) {
        if (statusListener != null) {
            this.mListener = statusListener;
        }
        return this;
    }

    public final synchronized CountDownTimer start() {
        this.mIsCancelled = false;
        if (this.mCountdownMillis <= 0) {
            this.mIsFinished = true;
            this.mListener.onFinish();
            return this;
        }
        this.mIsFinished = false;
        this.mIsPaused = false;
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mCountdownMillis;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        this.mListener.onStart();
        return this;
    }
}
