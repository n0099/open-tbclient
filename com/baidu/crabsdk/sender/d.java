package com.baidu.crabsdk.sender;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public final class d extends Thread {
    public static boolean l = false;

    /* renamed from: e  reason: collision with root package name */
    public final Context f4761e;

    /* renamed from: f  reason: collision with root package name */
    public final SoftReference<Looper> f4762f;

    /* renamed from: g  reason: collision with root package name */
    public SoftReference<Handler> f4763g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4764h;
    public volatile int i;
    public a j;
    public final Runnable k;

    public d(Context context, int i) {
        this.f4762f = new SoftReference<>(Looper.getMainLooper());
        this.i = 0;
        this.k = new d.b.n.d.a(this);
        this.f4761e = context;
        this.f4764h = 3000;
        if (i == 1) {
            this.j = new b(context);
        } else if (i != 2) {
        } else {
            this.j = new c(context);
        }
    }

    public d(Context context, int i, byte b2) {
        this(context, i);
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
            int i = this.i;
            if (this.f4762f.get() == null) {
                break;
            }
            try {
                if (this.f4763g == null || this.f4763g.get() == null) {
                    this.f4763g = new SoftReference<>(new Handler(this.f4762f.get()));
                }
                this.f4763g.get().post(this.k);
                Thread.sleep(this.f4764h);
                if (com.baidu.crabsdk.a.I == 0) {
                    l = false;
                    com.baidu.crabsdk.c.a.e("anr watch thread is breakdown!");
                    break;
                } else if (this.i == i) {
                    if (this.f4761e != null && !com.baidu.crabsdk.a.J) {
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
