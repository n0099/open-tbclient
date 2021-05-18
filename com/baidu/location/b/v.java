package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f6674a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f6675b;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static v f6676a = new v();
    }

    public v() {
    }

    public static v a() {
        return a.f6676a;
    }

    public synchronized ExecutorService b() {
        if (this.f6674a == null || this.f6674a.isShutdown()) {
            this.f6674a = null;
            this.f6674a = Executors.newSingleThreadExecutor();
        }
        return this.f6674a;
    }

    public synchronized ExecutorService c() {
        if (this.f6675b == null || this.f6675b.isShutdown()) {
            this.f6675b = null;
            this.f6675b = Executors.newFixedThreadPool(2);
        }
        return this.f6675b;
    }

    public void d() {
        ExecutorService executorService = this.f6674a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.f6675b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
