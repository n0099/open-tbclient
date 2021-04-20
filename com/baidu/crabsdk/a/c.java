package com.baidu.crabsdk.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import d.b.m.a.h;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f4689c;

    /* renamed from: d  reason: collision with root package name */
    public static Context f4690d;

    /* renamed from: e  reason: collision with root package name */
    public static ExecutorService f4691e;

    /* renamed from: a  reason: collision with root package name */
    public h f4692a;

    /* renamed from: b  reason: collision with root package name */
    public p f4693b;

    public c(Context context) {
        f4690d = context;
        this.f4693b = new p(Looper.getMainLooper().getThread(), a.f4678g);
        this.f4692a = new h(new d.b.m.a.a(this), context);
        if (f4691e == null) {
            f4691e = Executors.newSingleThreadExecutor();
        }
    }

    public static /* synthetic */ void a(long j, long j2, long j3, long j4) {
        ArrayList<String> e2 = p.e(j, j2);
        com.baidu.crabsdk.c.a.c("-BlockCanaryCore- threadStackEntries: size = " + e2.size());
        if (e2.isEmpty()) {
            return;
        }
        a b2 = a.b();
        b2.f4685f = e2;
        b2.a(j, j2, j3, j4);
    }

    public static c b(Context context) {
        if (f4689c == null) {
            synchronized (c.class) {
                if (f4689c == null) {
                    f4689c = new c(context);
                }
            }
        }
        return f4689c;
    }

    public static void e() {
        if (Build.VERSION.SDK_INT >= 16) {
            d.b.m.a.b.j.c();
            com.baidu.crabsdk.c.a.b("start FrameMonitor...");
        }
    }

    public static void f() {
        if (Build.VERSION.SDK_INT >= 16) {
            d.b.m.a.b.j.d();
        }
    }
}
