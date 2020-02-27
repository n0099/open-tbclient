package com.baidu.poly.b;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class a {
    private static volatile Executor aRU;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_SIZE = (CPU_COUNT * 2) + 1;
    private static final ThreadFactory aRV = new ThreadFactoryC0163a();

    /* renamed from: com.baidu.poly.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class ThreadFactoryC0163a implements ThreadFactory {
        private final AtomicInteger aRX = new AtomicInteger(1);

        ThreadFactoryC0163a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.aRX.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (aRU == null) {
                synchronized (a.class) {
                    if (aRU == null) {
                        aRU = new ThreadPoolExecutor(1, MAX_POOL_SIZE, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aRV);
                    }
                }
            }
            executor = aRU;
        }
        return executor;
    }
}
