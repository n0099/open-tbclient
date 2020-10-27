package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a {
    private static volatile Executor bXL;
    private static final int bXM = Runtime.getRuntime().availableProcessors();
    private static final int bXN = (bXM * 2) + 1;
    private static final ThreadFactory bXO = new ThreadFactoryC0300a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class ThreadFactoryC0300a implements ThreadFactory {
        private final AtomicInteger bXP = new AtomicInteger(1);

        ThreadFactoryC0300a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bXP.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bXL == null) {
                synchronized (a.class) {
                    if (bXL == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, bXN, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bXO);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bXL = threadPoolExecutor;
                    }
                }
            }
            executor = bXL;
        }
        return executor;
    }
}
