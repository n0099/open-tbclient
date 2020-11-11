package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a {
    private static volatile Executor cdx;
    private static final int cdy = Runtime.getRuntime().availableProcessors();
    private static final int cdz = (cdy * 2) + 1;
    private static final ThreadFactory cdA = new ThreadFactoryC0312a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class ThreadFactoryC0312a implements ThreadFactory {
        private final AtomicInteger cdB = new AtomicInteger(1);

        ThreadFactoryC0312a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.cdB.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (cdx == null) {
                synchronized (a.class) {
                    if (cdx == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, cdz, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cdA);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        cdx = threadPoolExecutor;
                    }
                }
            }
            executor = cdx;
        }
        return executor;
    }
}
