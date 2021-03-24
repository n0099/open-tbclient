package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3076a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3077b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3078c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3079d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3080e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3078c = availableProcessors;
        f3079d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3080e = f3078c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3079d, f3080e, 2L, TimeUnit.MINUTES, new b());
        f3076a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3077b == null || (aVar = f3076a) == null || aVar.isShutdown() || f3076a.isTerminated()) {
            f3077b = new d();
        }
        return f3077b;
    }

    public boolean a(c cVar) {
        try {
            f3076a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3076a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3076a.getPoolSize() == 0) {
                f3076a = new a(f3079d, f3080e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3076a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3076a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
