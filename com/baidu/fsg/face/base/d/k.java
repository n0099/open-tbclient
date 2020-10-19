package com.baidu.fsg.face.base.d;

import android.os.Looper;
/* loaded from: classes17.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f1590a;
    public Runnable b;

    public k(Runnable runnable) {
        this.f1590a = "EmptyName";
        this.f1590a = "nullname";
        this.b = runnable;
    }

    public k(Runnable runnable, String str) {
        this.f1590a = "EmptyName";
        this.f1590a = str;
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
