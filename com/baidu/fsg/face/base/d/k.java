package com.baidu.fsg.face.base.d;

import android.os.Looper;
/* loaded from: classes6.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f2155a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f2156b;

    public k(Runnable runnable) {
        this.f2155a = "EmptyName";
        this.f2155a = "nullname";
        this.f2156b = runnable;
    }

    public k(Runnable runnable, String str) {
        this.f2155a = "EmptyName";
        this.f2155a = str;
        this.f2156b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            System.currentTimeMillis();
            this.f2156b.run();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
