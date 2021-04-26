package com.baidu.adp.framework.cmdRouter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class DefaultPoolExecutor {
    public static final int CPU_COUNT;
    public static final int MAX_CORE_POOL_SIZE;
    public static final long SURPLUS_THREAD_LIFE = 30;
    public static ThreadPoolExecutor executor;
    public static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.adp.framework.cmdRouter.DefaultPoolExecutor.1
        public final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "EasyRouter #" + this.mCount.getAndIncrement());
        }
    };

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        MAX_CORE_POOL_SIZE = availableProcessors + 1;
    }

    public static ThreadPoolExecutor newDefaultPoolExecutor(int i2) {
        if (i2 == 0) {
            return null;
        }
        int min = Math.min(i2, MAX_CORE_POOL_SIZE);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(min, min, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), sThreadFactory);
        executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return executor;
    }
}
