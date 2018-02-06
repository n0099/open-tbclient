package com.baidu.fsg.biometrics.base.d;

import android.os.Looper;
/* loaded from: classes2.dex */
public class l implements Runnable {
    public String a;
    public Runnable b;

    public l(Runnable runnable) {
        this.a = "EmptyName";
        this.a = "nullname";
        this.b = runnable;
    }

    public l(Runnable runnable, String str) {
        this.a = "EmptyName";
        this.a = str;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            System.currentTimeMillis();
            this.b.run();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
