package com.baidu.android.defense.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class b {
    private static b b = null;

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f232a = Executors.newFixedThreadPool(3, new com.baidu.android.moplus.util.a("Defense_DownloadThreadPool"));

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public static synchronized void b() {
        synchronized (b.class) {
            if (b != null) {
                b.c();
                b = null;
            }
        }
    }

    private void c() {
        try {
            this.f232a.shutdown();
        } catch (SecurityException e) {
        }
        this.f232a = null;
    }

    public void a(a aVar) {
        this.f232a.submit(aVar);
    }
}
