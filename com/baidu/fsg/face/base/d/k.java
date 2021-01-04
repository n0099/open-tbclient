package com.baidu.fsg.face.base.d;

import android.os.Looper;
/* loaded from: classes6.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f2154a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f2155b;

    public k(Runnable runnable) {
        this.f2154a = "EmptyName";
        this.f2154a = "nullname";
        this.f2155b = runnable;
    }

    public k(Runnable runnable, String str) {
        this.f2154a = "EmptyName";
        this.f2154a = str;
        this.f2155b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            System.currentTimeMillis();
            this.f2155b.run();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
