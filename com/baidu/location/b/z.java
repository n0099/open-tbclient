package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes20.dex */
public class z {
    private ExecutorService a;
    private ExecutorService b;

    /* loaded from: classes20.dex */
    private static class a {
        private static z a = new z();
    }

    private z() {
    }

    public static z a() {
        return a.a;
    }

    public synchronized ExecutorService b() {
        if (this.a == null || this.a.isShutdown()) {
            this.a = null;
            this.a = Executors.newSingleThreadExecutor();
        }
        return this.a;
    }

    public synchronized ExecutorService c() {
        if (this.b == null || this.b.isShutdown()) {
            this.b = null;
            this.b = Executors.newFixedThreadPool(2);
        }
        return this.b;
    }

    public void d() {
        if (this.a != null) {
            this.a.shutdown();
        }
        if (this.b != null) {
            this.b.shutdown();
        }
    }
}
