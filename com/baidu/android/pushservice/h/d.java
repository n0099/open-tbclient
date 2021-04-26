package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3131a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3132b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3133c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3134d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3135e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3133c = availableProcessors;
        f3134d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3135e = f3133c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3134d, f3135e, 2L, TimeUnit.MINUTES, new b());
        f3131a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3132b == null || (aVar = f3131a) == null || aVar.isShutdown() || f3131a.isTerminated()) {
            f3132b = new d();
        }
        return f3132b;
    }

    public boolean a(c cVar) {
        try {
            f3131a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3131a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3131a.getPoolSize() == 0) {
                f3131a = new a(f3134d, f3135e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3131a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3131a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
