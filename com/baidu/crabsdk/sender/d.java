package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public final class d extends Thread {
    public static boolean l = false;

    /* renamed from: e  reason: collision with root package name */
    public final Context f4765e;

    /* renamed from: f  reason: collision with root package name */
    public final SoftReference<Looper> f4766f;

    /* renamed from: g  reason: collision with root package name */
    public SoftReference<Handler> f4767g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4768h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f4769i;
    public a j;
    public final Runnable k;

    public d(Context context, int i2) {
        this.f4766f = new SoftReference<>(Looper.getMainLooper());
        this.f4769i = 0;
        this.k = new d.a.m.d.a(this);
        this.f4765e = context;
        this.f4768h = 3000;
        if (i2 == 1) {
            this.j = new b(context);
        } else if (i2 != 2) {
        } else {
            this.j = new c(context);
        }
    }

    public d(Context context, int i2, byte b2) {
        this(context, i2);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        com.baidu.crabsdk.c.a.c("***isRunning = " + l + "***");
        if (l) {
            return;
        }
        l = true;
        setName("|AnrWatchThread|");
        com.baidu.crabsdk.c.a.b("AnrWatchThread start!");
        while (true) {
            if (isInterrupted()) {
                break;
            }
            int i2 = this.f4769i;
            if (this.f4766f.get() == null) {
                break;
            }
            try {
                if (this.f4767g == null || this.f4767g.get() == null) {
                    this.f4767g = new SoftReference<>(new Handler(this.f4766f.get()));
                }
                this.f4767g.get().post(this.k);
                Thread.sleep(this.f4768h);
                if (com.baidu.crabsdk.a.I == 0) {
                    l = false;
                    com.baidu.crabsdk.c.a.e("anr watch thread is breakdown!");
                    break;
                } else if (this.f4769i == i2) {
                    if (this.f4765e != null && !com.baidu.crabsdk.a.J) {
                        com.baidu.crabsdk.c.a.b("onAppNotResponding!");
                        a aVar = this.j;
                        if (aVar != null) {
                            aVar.a("/data/anr/traces.txt");
                        }
                    }
                }
            } catch (Exception e2) {
                com.baidu.crabsdk.c.a.d("AnrWatchThread Exception: " + e2.getMessage());
            }
        }
        l = false;
        l = false;
        com.baidu.crabsdk.c.a.e("anr watch thread is over!");
    }
}
