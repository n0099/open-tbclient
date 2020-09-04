package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a {
    private static volatile Executor bGE;
    private static final int bGF = Runtime.getRuntime().availableProcessors();
    private static final int bGG = (bGF * 2) + 1;
    private static final ThreadFactory bGH = new ThreadFactoryC0273a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class ThreadFactoryC0273a implements ThreadFactory {
        private final AtomicInteger bGI = new AtomicInteger(1);

        ThreadFactoryC0273a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bGI.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bGE == null) {
                synchronized (a.class) {
                    if (bGE == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, bGG, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bGH);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bGE = threadPoolExecutor;
                    }
                }
            }
            executor = bGE;
        }
        return executor;
    }
}
