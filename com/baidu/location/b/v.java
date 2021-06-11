package com.baidu.location.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f6617a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f6618b;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static v f6619a = new v();
    }

    public v() {
    }

    public static v a() {
        return a.f6619a;
    }

    public synchronized ExecutorService b() {
        if (this.f6617a == null || this.f6617a.isShutdown()) {
            this.f6617a = null;
            this.f6617a = Executors.newSingleThreadExecutor();
        }
        return this.f6617a;
    }

    public synchronized ExecutorService c() {
        if (this.f6618b == null || this.f6618b.isShutdown()) {
            this.f6618b = null;
            this.f6618b = Executors.newFixedThreadPool(2);
        }
        return this.f6618b;
    }

    public void d() {
        ExecutorService executorService = this.f6617a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.f6618b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
