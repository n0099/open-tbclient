package com.baidu.poly.b;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class a {
    private static volatile Executor bor;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_SIZE = (CPU_COUNT * 2) + 1;
    private static final ThreadFactory bos = new ThreadFactoryC0209a();

    /* renamed from: com.baidu.poly.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class ThreadFactoryC0209a implements ThreadFactory {
        private final AtomicInteger bou = new AtomicInteger(1);

        ThreadFactoryC0209a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bou.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bor == null) {
                synchronized (a.class) {
                    if (bor == null) {
                        bor = new ThreadPoolExecutor(1, MAX_POOL_SIZE, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bos);
                    }
                }
            }
            executor = bor;
        }
        return executor;
    }
}
