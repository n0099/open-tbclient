package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f6574a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f6575b;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static v f6576a = new v();
    }

    public v() {
    }

    public static v a() {
        return a.f6576a;
    }

    public synchronized ExecutorService b() {
        if (this.f6574a == null || this.f6574a.isShutdown()) {
            this.f6574a = null;
            this.f6574a = Executors.newSingleThreadExecutor();
        }
        return this.f6574a;
    }

    public synchronized ExecutorService c() {
        if (this.f6575b == null || this.f6575b.isShutdown()) {
            this.f6575b = null;
            this.f6575b = Executors.newFixedThreadPool(2);
        }
        return this.f6575b;
    }

    public void d() {
        ExecutorService executorService = this.f6574a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.f6575b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
