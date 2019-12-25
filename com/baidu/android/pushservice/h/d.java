package com.baidu.android.pushservice.h;

import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class d {
    private static a a;
    private static d b;
    private static final int c = Runtime.getRuntime().availableProcessors();
    private static final int d = Math.max(2, Math.min(c - 1, 4));
    private static final int e = c << 3;

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.h.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
        a.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        if (b == null || a == null || a.isShutdown() || a.isTerminated()) {
            b = new d();
        }
        return b;
    }

    public boolean a(c cVar) {
        try {
            a.submit(cVar);
            return true;
        } catch (Exception e2) {
            if (a == null || a.getCorePoolSize() == 0 || a.getPoolSize() == 0) {
                a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (a != null) {
            try {
                a.getQueue().clear();
                a.shutdown();
            } catch (Exception e2) {
            }
        }
    }
}
