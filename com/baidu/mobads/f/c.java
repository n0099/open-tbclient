package com.baidu.mobads.f;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class c {
    private static volatile c c;

    /* renamed from: a  reason: collision with root package name */
    private d f3324a;

    /* renamed from: b  reason: collision with root package name */
    private ScheduledThreadPoolExecutor f3325b;

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
        this.f3324a = e.a(1, 5);
        this.f3325b = e.a(2);
    }

    public void a(Runnable runnable) {
        if (runnable != null && this.f3324a != null && !this.f3324a.isShutdown()) {
            try {
                this.f3324a.submit(runnable);
            } catch (Throwable th) {
            }
        }
    }

    public void a(a aVar) {
        if (aVar != null && this.f3324a != null && !this.f3324a.isShutdown()) {
            try {
                aVar.a(System.currentTimeMillis());
                FutureTask futureTask = null;
                if (this.f3324a != null && !this.f3324a.isShutdown()) {
                    futureTask = (FutureTask) this.f3324a.submit(aVar);
                }
                aVar.a((Future) futureTask);
            } catch (Throwable th) {
            }
        }
    }

    public void a(a aVar, long j, TimeUnit timeUnit) {
        if (aVar != null && this.f3325b != null && !this.f3325b.isShutdown()) {
            try {
                aVar.a(System.currentTimeMillis());
                aVar.a((Future) this.f3325b.schedule(aVar, j, timeUnit));
            } catch (Throwable th) {
            }
        }
    }
}
