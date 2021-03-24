package com.baidu.adp.lib.service;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public enum AsyncService {
    INSTANCE;
    
    public Handler mHandler;
    public Looper mLooper;

    AsyncService() {
        HandlerThread handlerThread = new HandlerThread("BdAsyncService");
        handlerThread.start();
        this.mLooper = handlerThread.getLooper();
        this.mHandler = new Handler(this.mLooper);
    }

    public void release() {
        Looper looper = this.mLooper;
        if (looper != null) {
            looper.quit();
        }
    }

    public void removeRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null || runnable == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void sendRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null || runnable == null) {
            return;
        }
        handler.post(runnable);
    }
}
