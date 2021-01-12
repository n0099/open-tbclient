package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {
    private static volatile Executor ckB;
    private static final int ckC = Runtime.getRuntime().availableProcessors();
    private static final int ckD = (ckC * 2) + 1;
    private static final ThreadFactory ckE = new ThreadFactoryC0304a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class ThreadFactoryC0304a implements ThreadFactory {
        private final AtomicInteger ckF = new AtomicInteger(1);

        ThreadFactoryC0304a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.ckF.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (ckB == null) {
                synchronized (a.class) {
                    if (ckB == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, ckD, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), ckE);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        ckB = threadPoolExecutor;
                    }
                }
            }
            executor = ckB;
        }
        return executor;
    }
}
