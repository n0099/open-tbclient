package com.baidu.android.pushservice.g;

import java.util.concurrent.TimeUnit;
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f1315a;

    /* renamed from: b  reason: collision with root package name */
    private static d f1316b;
    private static final int c = Runtime.getRuntime().availableProcessors();
    private static final int d = Math.max(2, Math.min(c - 1, 4));
    private static final int e = c << 3;

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.g.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        f1315a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
        f1315a.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        if (f1316b == null || f1315a == null || f1315a.isShutdown() || f1315a.isTerminated()) {
            f1316b = new d();
        }
        return f1316b;
    }

    public boolean a(c cVar) {
        try {
            f1315a.submit(cVar);
            return true;
        } catch (Exception e2) {
            if (f1315a == null || f1315a.getCorePoolSize() == 0 || f1315a.getPoolSize() == 0) {
                f1315a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (f1315a != null) {
            try {
                f1315a.getQueue().clear();
                f1315a.shutdown();
            } catch (Exception e2) {
            }
        }
    }
}
