package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a {
    private static volatile Executor bPo;
    private static final int bPp = Runtime.getRuntime().availableProcessors();
    private static final int bPq = (bPp * 2) + 1;
    private static final ThreadFactory bPr = new ThreadFactoryC0286a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class ThreadFactoryC0286a implements ThreadFactory {
        private final AtomicInteger bPs = new AtomicInteger(1);

        ThreadFactoryC0286a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bPs.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bPo == null) {
                synchronized (a.class) {
                    if (bPo == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, bPq, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bPr);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bPo = threadPoolExecutor;
                    }
                }
            }
            executor = bPo;
        }
        return executor;
    }
}
