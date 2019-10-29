package com.baidu.poly.b;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class g extends ThreadPoolExecutor {
    private static g aBn;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int ct = (CPU_COUNT * 2) + 1;
    private static final ThreadFactory aBo = new ThreadFactory() { // from class: com.baidu.poly.b.g.1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ImageLoader#" + this.mCount.getAndIncrement());
        }
    };

    public g(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public static synchronized g zI() {
        g gVar;
        synchronized (g.class) {
            if (aBn == null) {
                aBn = new g(CORE_POOL_SIZE, ct, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque(), aBo);
            }
            gVar = aBn;
        }
        return gVar;
    }
}
