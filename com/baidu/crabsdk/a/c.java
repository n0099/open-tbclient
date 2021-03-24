package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import d.b.n.a.h;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f4653c;

    /* renamed from: d  reason: collision with root package name */
    public static Context f4654d;

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f4655e;

    /* renamed from: a  reason: collision with root package name */
    public h f4656a;

    /* renamed from: b  reason: collision with root package name */
    public p f4657b;

    public c(Context context) {
        f4654d = context;
        this.f4657b = new p(Looper.getMainLooper().getThread(), a.f4642g);
        this.f4656a = new h(new d.b.n.a.a(this), context);
        if (f4655e == null) {
            f4655e = Executors.newSingleThreadExecutor();
        }
    }

    public static /* synthetic */ void a(long j, long j2, long j3, long j4) {
        ArrayList<String> e2 = p.e(j, j2);
        com.baidu.crabsdk.c.a.c("-BlockCanaryCore- threadStackEntries: size = " + e2.size());
        if (e2.isEmpty()) {
            return;
        }
        a b2 = a.b();
        b2.f4649f = e2;
        b2.a(j, j2, j3, j4);
    }

    public static c b(Context context) {
        if (f4653c == null) {
            synchronized (c.class) {
                if (f4653c == null) {
                    f4653c = new c(context);
                }
            }
        }
        return f4653c;
    }

    public static void e() {
        if (Build.VERSION.SDK_INT >= 16) {
            d.b.n.a.b.j.c();
            com.baidu.crabsdk.c.a.b("start FrameMonitor...");
        }
    }

    public static void f() {
        if (Build.VERSION.SDK_INT >= 16) {
            d.b.n.a.b.j.d();
        }
    }
}
