package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f1916a;
    private ExecutorService b;

    /* loaded from: classes7.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static z f1917a = new z();
    }

    private z() {
    }

    public static z a() {
        return a.f1917a;
    }

    public synchronized ExecutorService b() {
        if (this.f1916a == null || this.f1916a.isShutdown()) {
            this.f1916a = null;
            this.f1916a = Executors.newSingleThreadExecutor();
        }
        return this.f1916a;
    }

    public synchronized ExecutorService c() {
        if (this.b == null || this.b.isShutdown()) {
            this.b = null;
            this.b = Executors.newFixedThreadPool(2);
        }
        return this.b;
    }

    public void d() {
        if (this.f1916a != null) {
            this.f1916a.shutdown();
        }
        if (this.b != null) {
            this.b.shutdown();
        }
    }
}
