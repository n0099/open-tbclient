package com.baidu.fsg.face.base.d;

import android.os.Looper;
/* loaded from: classes11.dex */
public class k implements Runnable {
    public String a;
    public Runnable b;

    public k(Runnable runnable) {
        this.a = "EmptyName";
        this.a = "nullname";
        this.b = runnable;
    }

    public k(Runnable runnable, String str) {
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
