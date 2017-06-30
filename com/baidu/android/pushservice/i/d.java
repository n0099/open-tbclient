package com.baidu.android.pushservice.i;

import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d {
    private static a a;
    private static d b;

    public d() {
        Runtime.getRuntime().addShutdownHook(new Thread() { // from class: com.baidu.android.pushservice.i.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                d.this.b();
            }
        });
        a = new a(3, 100, 1L, TimeUnit.MINUTES, new b());
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
        } catch (Exception e) {
            com.baidu.android.pushservice.g.a.e("ThreadPool", "submitRunnable e: " + e);
            if (a == null || a.getCorePoolSize() == 0 || a.getPoolSize() == 0) {
                a = new a(3, 100, 1L, TimeUnit.MINUTES, new b());
            }
            return false;
        }
    }

    public void b() {
        if (a != null) {
            try {
                a.getQueue().clear();
                a.shutdown();
            } catch (Exception e) {
                com.baidu.android.pushservice.g.a.c("ThreadPool", " ThreadPool shutdown e: " + e);
            }
        }
    }
}
