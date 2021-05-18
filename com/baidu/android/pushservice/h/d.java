package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3132a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3133b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3134c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3135d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3136e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3134c = availableProcessors;
        f3135d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3136e = f3134c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3135d, f3136e, 2L, TimeUnit.MINUTES, new b());
        f3132a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3133b == null || (aVar = f3132a) == null || aVar.isShutdown() || f3132a.isTerminated()) {
            f3133b = new d();
        }
        return f3133b;
    }

    public boolean a(c cVar) {
        try {
            f3132a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3132a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3132a.getPoolSize() == 0) {
                f3132a = new a(f3135d, f3136e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3132a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3132a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
