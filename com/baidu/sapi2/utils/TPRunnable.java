package com.baidu.sapi2.utils;

import android.os.Looper;
/* loaded from: classes2.dex */
public class TPRunnable implements com.baidu.sapi2.c, Runnable {
    public Runnable runable;

    public TPRunnable(Runnable runnable) {
        this.runable = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            this.runable.run();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
