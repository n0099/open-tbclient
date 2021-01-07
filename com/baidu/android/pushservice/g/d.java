package com.baidu.android.pushservice.g;

import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f1309a;

    /* renamed from: b  reason: collision with root package name */
    private static d f1310b;
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
        f1309a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
        f1309a.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        if (f1310b == null || f1309a == null || f1309a.isShutdown() || f1309a.isTerminated()) {
            f1310b = new d();
        }
        return f1310b;
    }

    public boolean a(c cVar) {
        try {
            f1309a.submit(cVar);
            return true;
        } catch (Exception e2) {
            if (f1309a == null || f1309a.getCorePoolSize() == 0 || f1309a.getPoolSize() == 0) {
                f1309a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (f1309a != null) {
            try {
                f1309a.getQueue().clear();
                f1309a.shutdown();
            } catch (Exception e2) {
            }
        }
    }
}
