package com.baidu.pass.biometrics.base.utils.thread;

import android.os.Looper;
/* loaded from: classes5.dex */
public class TPRunnable implements Runnable {
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
