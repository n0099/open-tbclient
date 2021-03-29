package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f3077a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3078b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3079c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3080d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3081e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3079c = availableProcessors;
        f3080d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3081e = f3079c << 3;
    }

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a aVar = new a(f3080d, f3081e, 2L, TimeUnit.MINUTES, new b());
        f3077a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        a aVar;
        if (f3078b == null || (aVar = f3077a) == null || aVar.isShutdown() || f3077a.isTerminated()) {
            f3078b = new d();
        }
        return f3078b;
    }

    public boolean a(c cVar) {
        try {
            f3077a.submit(cVar);
            return true;
        } catch (Exception unused) {
            a aVar = f3077a;
            if (aVar == null || aVar.getCorePoolSize() == 0 || f3077a.getPoolSize() == 0) {
                f3077a = new a(f3080d, f3081e, 2L, TimeUnit.MINUTES, new b());
                return false;
            }
            return false;
        }
    }

    public void b() {
        a aVar = f3077a;
        if (aVar != null) {
            try {
                aVar.getQueue().clear();
                f3077a.shutdown();
            } catch (Exception unused) {
            }
        }
    }
}
