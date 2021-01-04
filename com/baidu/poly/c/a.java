package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {
    private static volatile Executor cpq;
    private static final int cpr = Runtime.getRuntime().availableProcessors();
    private static final int cps = (cpr * 2) + 1;
    private static final ThreadFactory cpt = new ThreadFactoryC0321a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class ThreadFactoryC0321a implements ThreadFactory {
        private final AtomicInteger cpv = new AtomicInteger(1);

        ThreadFactoryC0321a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.cpv.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (cpq == null) {
                synchronized (a.class) {
                    if (cpq == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, cps, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cpt);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        cpq = threadPoolExecutor;
                    }
                }
            }
            executor = cpq;
        }
        return executor;
    }
}
