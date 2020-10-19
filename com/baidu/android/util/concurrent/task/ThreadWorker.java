package com.baidu.android.util.concurrent.task;

import android.os.Looper;
import android.os.Process;
/* loaded from: classes8.dex */
public final class ThreadWorker implements Runnable {
    private final Object mLockObj = new Object();
    private Looper mLooper = null;

    public ThreadWorker(String str) {
        Thread thread = new Thread(null, this, str);
        thread.setPriority(1);
        thread.start();
        synchronized (this.mLockObj) {
            while (this.mLooper == null) {
                try {
                    this.mLockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    public void quit() {
        this.mLooper.quit();
    }

    public void pause() {
        Thread thread = this.mLooper.getThread();
        if (thread != null) {
            try {
                synchronized (thread) {
                    thread.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void restart() {
        Thread thread = this.mLooper.getThread();
        if (thread != null) {
            try {
                synchronized (thread) {
                    thread.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
