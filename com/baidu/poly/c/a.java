package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a {
    private static volatile Executor bGA;
    private static final int bGB = Runtime.getRuntime().availableProcessors();
    private static final int bGC = (bGB * 2) + 1;
    private static final ThreadFactory bGD = new ThreadFactoryC0273a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class ThreadFactoryC0273a implements ThreadFactory {
        private final AtomicInteger bGE = new AtomicInteger(1);

        ThreadFactoryC0273a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bGE.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bGA == null) {
                synchronized (a.class) {
                    if (bGA == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, bGC, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bGD);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bGA = threadPoolExecutor;
                    }
                }
            }
            executor = bGA;
        }
        return executor;
    }
}
