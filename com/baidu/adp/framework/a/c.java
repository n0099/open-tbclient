package com.baidu.adp.framework.a;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c {
    public static ThreadPoolExecutor executor;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.adp.framework.a.c.1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "EasyRouter #" + this.mCount.getAndIncrement());
        }
    };
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int IE = CPU_COUNT + 1;

    public static ThreadPoolExecutor aa(int i) {
        if (i == 0) {
            return null;
        }
        int min = Math.min(i, IE);
        executor = new ThreadPoolExecutor(min, min, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), sThreadFactory);
        executor.allowCoreThreadTimeOut(true);
        return executor;
    }
}
