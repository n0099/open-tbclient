package com.baidu.sapi2.utils;

import android.os.Looper;
/* loaded from: classes.dex */
public class g implements Runnable {
    public String a;
    public Runnable b;

    public g(Runnable runnable) {
        this.a = "EmptyName";
        this.a = "nullname";
        this.b = runnable;
    }

    public g(Runnable runnable, String str) {
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
