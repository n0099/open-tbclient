package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a {
    private static volatile Executor coS;
    private static final int coT = Runtime.getRuntime().availableProcessors();
    private static final int coU = (coT * 2) + 1;
    private static final ThreadFactory coV = new ThreadFactoryC0308a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class ThreadFactoryC0308a implements ThreadFactory {
        private final AtomicInteger coW = new AtomicInteger(1);

        ThreadFactoryC0308a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.coW.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (coS == null) {
                synchronized (a.class) {
                    if (coS == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, coU, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), coV);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        coS = threadPoolExecutor;
                    }
                }
            }
            executor = coS;
        }
        return executor;
    }
}
