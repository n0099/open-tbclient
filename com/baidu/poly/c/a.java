package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public class a {
    private static volatile Executor cqu;
    private static final int cqv = Runtime.getRuntime().availableProcessors();
    private static final int cqw = (cqv * 2) + 1;
    private static final ThreadFactory cqx = new ThreadFactoryC0314a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    static class ThreadFactoryC0314a implements ThreadFactory {
        private final AtomicInteger cqy = new AtomicInteger(1);

        ThreadFactoryC0314a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.cqy.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (cqu == null) {
                synchronized (a.class) {
                    if (cqu == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, cqw, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cqx);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        cqu = threadPoolExecutor;
                    }
                }
            }
            executor = cqu;
        }
        return executor;
    }
}
