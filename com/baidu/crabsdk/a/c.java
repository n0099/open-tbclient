package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import d.a.m.a.h;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f4800c;

    /* renamed from: d  reason: collision with root package name */
    public static Context f4801d;

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f4802e;

    /* renamed from: a  reason: collision with root package name */
    public h f4803a;

    /* renamed from: b  reason: collision with root package name */
    public p f4804b;

    public c(Context context) {
        f4801d = context;
        this.f4804b = new p(Looper.getMainLooper().getThread(), a.f4788g);
        this.f4803a = new h(new d.a.m.a.a(this), context);
        if (f4802e == null) {
            f4802e = Executors.newSingleThreadExecutor();
        }
    }

    public static /* synthetic */ void a(long j, long j2, long j3, long j4) {
        ArrayList<String> e2 = p.e(j, j2);
        com.baidu.crabsdk.c.a.c("-BlockCanaryCore- threadStackEntries: size = " + e2.size());
        if (e2.isEmpty()) {
            return;
        }
        a b2 = a.b();
        b2.f4796f = e2;
        b2.a(j, j2, j3, j4);
    }

    public static c b(Context context) {
        if (f4800c == null) {
            synchronized (c.class) {
                if (f4800c == null) {
                    f4800c = new c(context);
                }
            }
        }
        return f4800c;
    }

    public static void e() {
        if (Build.VERSION.SDK_INT >= 16) {
            d.a.m.a.b.j.c();
            com.baidu.crabsdk.c.a.b("start FrameMonitor...");
        }
    }

    public static void f() {
        if (Build.VERSION.SDK_INT >= 16) {
            d.a.m.a.b.j.d();
        }
    }
}
