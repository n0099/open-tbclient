package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes19.dex */
public class a {
    private static volatile Executor cio;
    private static final int cip = Runtime.getRuntime().availableProcessors();
    private static final int ciq = (cip * 2) + 1;
    private static final ThreadFactory cir = new ThreadFactoryC0321a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    static class ThreadFactoryC0321a implements ThreadFactory {
        private final AtomicInteger cis = new AtomicInteger(1);

        ThreadFactoryC0321a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.cis.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (cio == null) {
                synchronized (a.class) {
                    if (cio == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, ciq, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cir);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        cio = threadPoolExecutor;
                    }
                }
            }
            executor = cio;
        }
        return executor;
    }
}
