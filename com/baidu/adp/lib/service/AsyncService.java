package com.baidu.adp.lib.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public enum AsyncService {
    INSTANCE;
    
    private Handler mHandler;
    private Looper mLooper;

    AsyncService() {
        HandlerThread handlerThread = new HandlerThread("BdAsyncService");
        handlerThread.start();
        this.mLooper = handlerThread.getLooper();
        this.mHandler = new Handler(this.mLooper);
    }

    public void sendRunnable(Runnable runnable) {
        if (this.mHandler != null && runnable != null) {
            this.mHandler.post(runnable);
        }
    }

    public void removeRunnable(Runnable runnable) {
        if (this.mHandler != null && runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public void release() {
        if (this.mLooper != null) {
            this.mLooper.quit();
        }
    }
}
