package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3135a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3136b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3137c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3138d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3139e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3137c = availableProcessors;
        f3138d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3139e = f3137c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3138d, f3139e, 2L, TimeUnit.MINUTES, new b());
        f3135a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3136b == null || (aVar = f3135a) == null || aVar.isShutdown() || f3135a.isTerminated()) {
            f3136b = new d();
        }
        return f3136b;
    }

    public boolean a(c cVar) {
        try {
            f3135a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3135a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3135a.getPoolSize() == 0) {
                f3135a = new a(f3138d, f3139e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3135a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3135a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
