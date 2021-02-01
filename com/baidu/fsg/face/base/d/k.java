package com.baidu.fsg.face.base.d;

import android.os.Looper;
/* loaded from: classes5.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public String f2103a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f2104b;

    public k(Runnable runnable) {
        this.f2103a = "EmptyName";
        this.f2103a = "nullname";
        this.f2104b = runnable;
    }

    public k(Runnable runnable, String str) {
        this.f2103a = "EmptyName";
        this.f2103a = str;
        this.f2104b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            System.currentTimeMillis();
            this.f2104b.run();
            System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
