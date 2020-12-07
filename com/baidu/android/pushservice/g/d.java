package com.baidu.android.pushservice.g;

import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f1091a;
    private static d b;
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
        f1091a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
        f1091a.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        if (b == null || f1091a == null || f1091a.isShutdown() || f1091a.isTerminated()) {
            b = new d();
        }
        return b;
    }

    public boolean a(c cVar) {
        try {
            f1091a.submit(cVar);
            return true;
        } catch (Exception e2) {
            if (f1091a == null || f1091a.getCorePoolSize() == 0 || f1091a.getPoolSize() == 0) {
                f1091a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (f1091a != null) {
            try {
                f1091a.getQueue().clear();
                f1091a.shutdown();
            } catch (Exception e2) {
            }
        }
    }
}
