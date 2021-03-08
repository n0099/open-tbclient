package com.baidu.android.pushservice.g;

import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f1159a;
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
        f1159a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
        f1159a.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        if (b == null || f1159a == null || f1159a.isShutdown() || f1159a.isTerminated()) {
            b = new d();
        }
        return b;
    }

    public boolean a(c cVar) {
        try {
            f1159a.submit(cVar);
            return true;
        } catch (Exception e2) {
            if (f1159a == null || f1159a.getCorePoolSize() == 0 || f1159a.getPoolSize() == 0) {
                f1159a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (f1159a != null) {
            try {
                f1159a.getQueue().clear();
                f1159a.shutdown();
            } catch (Exception e2) {
            }
        }
    }
}
