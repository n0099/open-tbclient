package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class a {
    private static volatile Executor cbK;
    private static final int cbL = Runtime.getRuntime().availableProcessors();
    private static final int cbM = (cbL * 2) + 1;
    private static final ThreadFactory cbN = new ThreadFactoryC0310a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class ThreadFactoryC0310a implements ThreadFactory {
        private final AtomicInteger cbO = new AtomicInteger(1);

        ThreadFactoryC0310a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.cbO.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (cbK == null) {
                synchronized (a.class) {
                    if (cbK == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, cbM, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), cbN);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        cbK = threadPoolExecutor;
                    }
                }
            }
            executor = cbK;
        }
        return executor;
    }
}
