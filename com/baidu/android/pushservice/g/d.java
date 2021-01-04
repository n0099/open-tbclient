package com.baidu.android.pushservice.g;

import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static a f1308a;

    /* renamed from: b  reason: collision with root package name */
    private static d f1309b;
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
        f1308a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
        f1308a.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        if (f1309b == null || f1308a == null || f1308a.isShutdown() || f1308a.isTerminated()) {
            f1309b = new d();
        }
        return f1309b;
    }

    public boolean a(c cVar) {
        try {
            f1308a.submit(cVar);
            return true;
        } catch (Exception e2) {
            if (f1308a == null || f1308a.getCorePoolSize() == 0 || f1308a.getPoolSize() == 0) {
                f1308a = new a(d, e, 2L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (f1308a != null) {
            try {
                f1308a.getQueue().clear();
                f1308a.shutdown();
            } catch (Exception e2) {
            }
        }
    }
}
