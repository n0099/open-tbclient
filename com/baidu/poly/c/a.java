package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class a {
    private static volatile Executor bAW;
    private static final int bAX = Runtime.getRuntime().availableProcessors();
    private static final int bAY = (bAX * 2) + 1;
    private static final ThreadFactory bAZ = new ThreadFactoryC0252a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class ThreadFactoryC0252a implements ThreadFactory {
        private final AtomicInteger bBa = new AtomicInteger(1);

        ThreadFactoryC0252a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bBa.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bAW == null) {
                synchronized (a.class) {
                    if (bAW == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, bAY, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bAZ);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bAW = threadPoolExecutor;
                    }
                }
            }
            executor = bAW;
        }
        return executor;
    }
}
