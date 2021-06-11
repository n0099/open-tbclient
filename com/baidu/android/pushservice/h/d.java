package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3154a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3155b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3156c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3157d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3158e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3156c = availableProcessors;
        f3157d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3158e = f3156c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3157d, f3158e, 2L, TimeUnit.MINUTES, new b());
        f3154a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3155b == null || (aVar = f3154a) == null || aVar.isShutdown() || f3154a.isTerminated()) {
            f3155b = new d();
        }
        return f3155b;
    }

    public boolean a(c cVar) {
        try {
            f3154a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3154a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3154a.getPoolSize() == 0) {
                f3154a = new a(f3157d, f3158e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3154a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3154a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
