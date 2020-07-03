package com.baidu.poly.b;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class a {
    private static volatile Executor bAI;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_SIZE = (CPU_COUNT * 2) + 1;
    private static final ThreadFactory bAJ = new ThreadFactoryC0248a();

    /* renamed from: com.baidu.poly.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class ThreadFactoryC0248a implements ThreadFactory {
        private final AtomicInteger bAK = new AtomicInteger(1);

        ThreadFactoryC0248a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bAK.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bAI == null) {
                synchronized (a.class) {
                    if (bAI == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, MAX_POOL_SIZE, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bAJ);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bAI = threadPoolExecutor;
                    }
                }
            }
            executor = bAI;
        }
        return executor;
    }
}
