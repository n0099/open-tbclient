package com.baidu.sapi2.passhost.pluginsdk.service;

import android.os.Looper;
/* loaded from: classes.dex */
public class TPRunnable implements Runnable {
    public Runnable runable;
    public String taskName;

    public TPRunnable(Runnable runnable) {
        this.taskName = "EmptyName";
        this.taskName = "nullname";
        this.runable = runnable;
    }

    public TPRunnable(Runnable runnable, String str) {
        this.taskName = "EmptyName";
        this.taskName = str;
        this.runable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            System.currentTimeMillis();
            this.runable.run();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
