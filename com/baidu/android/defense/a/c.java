package com.baidu.android.defense.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class c {
    private static c b = null;

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f519a = Executors.newFixedThreadPool(3, new com.baidu.android.moplus.util.a("Defense_DownloadThreadPool"));

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    public static synchronized void b() {
        synchronized (c.class) {
            if (b != null) {
                b.c();
                b = null;
            }
        }
    }

    private void c() {
        try {
            this.f519a.shutdown();
        } catch (SecurityException e) {
        }
        this.f519a = null;
    }

    public void a(d dVar) {
        this.f519a.submit(dVar);
    }
}
