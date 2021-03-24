package com.baidu.fsg.face.base.d;

import android.os.Looper;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f5647a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f5648b;

    public k(Runnable runnable) {
        this.f5647a = "EmptyName";
        this.f5647a = "nullname";
        this.f5648b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            System.currentTimeMillis();
            this.f5648b.run();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public k(Runnable runnable, String str) {
        this.f5647a = "EmptyName";
        this.f5647a = str;
        this.f5648b = runnable;
    }
}
