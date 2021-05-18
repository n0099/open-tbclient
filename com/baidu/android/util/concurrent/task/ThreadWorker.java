package com.baidu.android.util.concurrent.task;

import android.os.Looper;
import android.os.Process;
/* loaded from: classes.dex */
public class ThreadWorker implements Runnable {
    public final Object mLockObj = new Object();
    public Looper mLooper = null;

    public ThreadWorker(String str) {
        Thread thread = new Thread(null, this, str);
        thread.setPriority(1);
        thread.start();
        synchronized (this.mLockObj) {
            while (this.mLooper == null) {
                try {
                    this.mLockObj.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public void join() {
        Looper looper = getLooper();
        if (looper != null) {
            try {
                Thread thread = looper.getThread();
                if (thread != null) {
                    thread.join();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void pause() {
        Thread thread = getLooper().getThread();
        if (thread != null) {
            try {
                synchronized (thread) {
                    thread.wait();
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void quit() {
        this.mLooper.quit();
    }

    public void restart() {
        Thread thread = getLooper().getThread();
        if (thread != null) {
            try {
                synchronized (thread) {
                    thread.notifyAll();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.mLockObj) {
            Process.setThreadPriority(10);
            Looper.prepare();
            this.mLooper = Looper.myLooper();
            this.mLockObj.notifyAll();
        }
        Looper.loop();
    }
}
