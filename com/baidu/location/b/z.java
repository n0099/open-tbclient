package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f2669a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2670b;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static z f2671a = new z();
    }

    private z() {
    }

    public static z a() {
        return a.f2671a;
    }

    public synchronized ExecutorService b() {
        if (this.f2669a == null || this.f2669a.isShutdown()) {
            this.f2669a = null;
            this.f2669a = Executors.newSingleThreadExecutor();
        }
        return this.f2669a;
    }

    public synchronized ExecutorService c() {
        if (this.f2670b == null || this.f2670b.isShutdown()) {
            this.f2670b = null;
            this.f2670b = Executors.newFixedThreadPool(2);
        }
        return this.f2670b;
    }

    public void d() {
        if (this.f2669a != null) {
            this.f2669a.shutdown();
        }
        if (this.f2670b != null) {
            this.f2670b.shutdown();
        }
    }
}
