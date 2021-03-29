package com.baidu.mobads.f;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f8226c;

    /* renamed from: a  reason: collision with root package name */
    public d f8227a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledThreadPoolExecutor f8228b;

    public c() {
        b();
    }

    public static c a() {
        if (f8226c == null) {
            synchronized (c.class) {
                if (f8226c == null) {
                    f8226c = new c();
                }
            }
        }
        return f8226c;
    }

    private void b() {
        this.f8227a = e.a(1, 5);
        this.f8228b = e.a(2);
    }

    public void a(Runnable runnable) {
        d dVar;
        if (runnable == null || (dVar = this.f8227a) == null || dVar.isShutdown()) {
            return;
        }
        try {
            this.f8227a.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(a aVar) {
        d dVar;
        if (aVar == null || (dVar = this.f8227a) == null || dVar.isShutdown()) {
            return;
        }
        try {
            aVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            if (this.f8227a != null && !this.f8227a.isShutdown()) {
                futureTask = (FutureTask) this.f8227a.submit(aVar);
            }
            aVar.a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    public void a(a aVar, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (aVar == null || (scheduledThreadPoolExecutor = this.f8228b) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            aVar.a(System.currentTimeMillis());
            aVar.a((Future) this.f8228b.schedule(aVar, j, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
