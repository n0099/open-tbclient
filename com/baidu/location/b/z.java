package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f2668a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2669b;

    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static z f2670a = new z();
    }

    private z() {
    }

    public static z a() {
        return a.f2670a;
    }

    public synchronized ExecutorService b() {
        if (this.f2668a == null || this.f2668a.isShutdown()) {
            this.f2668a = null;
            this.f2668a = Executors.newSingleThreadExecutor();
        }
        return this.f2668a;
    }

    public synchronized ExecutorService c() {
        if (this.f2669b == null || this.f2669b.isShutdown()) {
            this.f2669b = null;
            this.f2669b = Executors.newFixedThreadPool(2);
        }
        return this.f2669b;
    }

    public void d() {
        if (this.f2668a != null) {
            this.f2668a.shutdown();
        }
        if (this.f2669b != null) {
            this.f2669b.shutdown();
        }
    }
}
