package com.baidu.android.defense.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class d {
    private static d b = null;
    private ExecutorService a = Executors.newFixedThreadPool(3, new com.baidu.android.moplus.util.c("Defense_DownloadThreadPool"));

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d();
            }
            dVar = b;
        }
        return dVar;
    }

    public static synchronized void b() {
        synchronized (d.class) {
            if (b != null) {
                b.c();
                b = null;
            }
        }
    }

    private void c() {
        try {
            this.a.shutdown();
        } catch (SecurityException e) {
        }
        this.a = null;
    }

    public void a(c cVar) {
        this.a.submit(cVar);
    }
}
