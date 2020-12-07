package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes26.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f1920a;
    private ExecutorService b;

    /* loaded from: classes26.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static z f1921a = new z();
    }

    private z() {
    }

    public static z a() {
        return a.f1921a;
    }

    public synchronized ExecutorService b() {
        if (this.f1920a == null || this.f1920a.isShutdown()) {
            this.f1920a = null;
            this.f1920a = Executors.newSingleThreadExecutor();
        }
        return this.f1920a;
    }

    public synchronized ExecutorService c() {
        if (this.b == null || this.b.isShutdown()) {
            this.b = null;
            this.b = Executors.newFixedThreadPool(2);
        }
        return this.b;
    }

    public void d() {
        if (this.f1920a != null) {
            this.f1920a.shutdown();
        }
        if (this.b != null) {
            this.b.shutdown();
        }
    }
}
