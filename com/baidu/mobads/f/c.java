package com.baidu.mobads.f;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class c {
    private static volatile c c;

    /* renamed from: a  reason: collision with root package name */
    private d f2378a;
    private ScheduledThreadPoolExecutor b;

    private c() {
        b();
    }

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private void b() {
        this.f2378a = e.a(1, 5);
        this.b = e.a(2);
    }

    public void a(Runnable runnable) {
        if (runnable != null && this.f2378a != null && !this.f2378a.isShutdown()) {
            try {
                this.f2378a.submit(runnable);
            } catch (Throwable th) {
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null && this.f2378a != null && !this.f2378a.isShutdown()) {
            try {
                aVar.a(System.currentTimeMillis());
                FutureTask futureTask = null;
                if (this.f2378a != null && !this.f2378a.isShutdown()) {
                    futureTask = (FutureTask) this.f2378a.submit(aVar);
                }
                aVar.a((Future) futureTask);
            } catch (Throwable th) {
            }
        }
    }

    public void a(a aVar, long j, TimeUnit timeUnit) {
        if (aVar != null && this.b != null && !this.b.isShutdown()) {
            try {
                aVar.a(System.currentTimeMillis());
                aVar.a((Future) this.b.schedule(aVar, j, timeUnit));
            } catch (Throwable th) {
            }
        }
    }
}
