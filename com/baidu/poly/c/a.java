package com.baidu.poly.c;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class a {
    private static volatile Executor bIF;
    private static final int bIG = Runtime.getRuntime().availableProcessors();
    private static final int bIH = (bIG * 2) + 1;
    private static final ThreadFactory bII = new ThreadFactoryC0271a();

    /* renamed from: com.baidu.poly.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class ThreadFactoryC0271a implements ThreadFactory {
        private final AtomicInteger bIJ = new AtomicInteger(1);

        ThreadFactoryC0271a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "cashier #" + this.bIJ.getAndIncrement());
        }
    }

    public static void execute(Runnable runnable) {
        getExecutor().execute(runnable);
    }

    private static synchronized Executor getExecutor() {
        Executor executor;
        synchronized (a.class) {
            if (bIF == null) {
                synchronized (a.class) {
                    if (bIF == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, bIH, 8L, TimeUnit.SECONDS, new LinkedBlockingQueue(), bII);
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bIF = threadPoolExecutor;
                    }
                }
            }
            executor = bIF;
        }
        return executor;
    }
}
