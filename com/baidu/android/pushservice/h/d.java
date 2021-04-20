package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3112a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3113b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3114c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3115d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3116e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3114c = availableProcessors;
        f3115d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3116e = f3114c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3115d, f3116e, 2L, TimeUnit.MINUTES, new b());
        f3112a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3113b == null || (aVar = f3112a) == null || aVar.isShutdown() || f3112a.isTerminated()) {
            f3113b = new d();
        }
        return f3113b;
    }

    public boolean a(c cVar) {
        try {
            f3112a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3112a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3112a.getPoolSize() == 0) {
                f3112a = new a(f3115d, f3116e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3112a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3112a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
