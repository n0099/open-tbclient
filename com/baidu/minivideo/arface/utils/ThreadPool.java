package com.baidu.minivideo.arface.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes15.dex */
public class ThreadPool {
    private static volatile b bMr;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b VW() {
        if (bMr == null) {
            synchronized (ThreadPool.class) {
                if (bMr == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.VX();
                    bMr = bVar;
                }
            }
        }
        return bMr;
    }

    /* loaded from: classes15.dex */
    public static class b {
        private ExecutorService bMx;
        private int bMy;
        private QueueProcessingType bMz;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.bMy = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.bMz = QueueProcessingType.FIFO;
            this.mName = str;
            this.bMy = i;
            this.mPriority = i2;
            this.bMz = queueProcessingType;
            if (this.bMx == null) {
                this.bMx = a(this.mName, this.bMy, this.mPriority, this.bMz);
            }
        }

        protected void VX() {
            if ((this.bMx instanceof ThreadPoolExecutor) && this.bMx != null && !this.bMx.isShutdown()) {
                ((ThreadPoolExecutor) this.bMx).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.bMx.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
        private static final long serialVersionUID = -4114786347960826192L;

        private LIFOLinkedBlockingDeque() {
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            return super.offerFirst(t);
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.Deque
        public T remove() {
            return (T) super.removeFirst();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger bMs = new AtomicInteger(1);
        private final ThreadGroup bMt;
        private final AtomicInteger bMu = new AtomicInteger(1);
        private final String bMv;
        private final int bMw;

        public a(String str, int i) {
            this.bMw = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.bMt = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.bMv = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bMs.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.bMt, runnable, this.bMv + this.bMu.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.bMw);
            return thread;
        }
    }
}
