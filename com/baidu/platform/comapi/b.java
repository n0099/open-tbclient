package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes26.dex */
public class b {
    private static Context d;
    private static a e;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static boolean j;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicBoolean f2822a = new AtomicBoolean(false);
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static final CountDownLatch f = new CountDownLatch(1);

    public static void a(Application application, boolean z, boolean z2, boolean z3, boolean z4) {
        if (application == null) {
            throw new RuntimeException();
        }
        g = z;
        h = z2;
        i = z3;
        j = z4;
        if (d == null) {
            d = application;
        }
        VIContext.init(application);
    }

    public static boolean a() {
        return c.get();
    }

    public static void b() {
        while (true) {
            boolean z = f2822a.get();
            if (z) {
                return;
            }
            if (f2822a.compareAndSet(z, true)) {
                e = new a();
                if (!e.a(d)) {
                    throw new RuntimeException("engine init failed");
                }
            }
        }
    }

    public static void c() {
        while (true) {
            boolean z = c.get();
            if (z) {
                return;
            }
            if (c.compareAndSet(z, true)) {
                try {
                    com.baidu.platform.comapi.d.b.f2861a.a();
                } finally {
                    f.countDown();
                }
            }
        }
    }

    public static void d() {
        e.b();
        f2822a.set(false);
    }

    public static Context e() {
        return d;
    }

    public static boolean f() {
        return h;
    }

    public static boolean g() {
        return i;
    }

    public static boolean h() {
        return j;
    }
}
