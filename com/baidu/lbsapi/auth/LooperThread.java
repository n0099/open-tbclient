package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class LooperThread extends Thread {
    Handler a;
    private Object b;
    private boolean c;

    LooperThread() {
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LooperThread(String str) {
        super(str);
        this.a = null;
        this.b = new Object();
        this.c = false;
    }

    public void looperRun() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    public void looperWait() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void quit() {
        if (BLog.a) {
            BLog.d("Looper thread quit()");
        }
        this.a.getLooper().quit();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.a = new Handler();
        if (BLog.a) {
            BLog.d("new Handler() finish!!");
        }
        Looper.loop();
        if (BLog.a) {
            BLog.d("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }
}
