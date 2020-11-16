package com.baidu.minivideo.arface.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes14.dex */
public class ThreadPool {
    private static volatile b bYN;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b ZG() {
        if (bYN == null) {
            synchronized (ThreadPool.class) {
                if (bYN == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.ZH();
                    bYN = bVar;
                }
            }
        }
        return bYN;
    }

    /* loaded from: classes14.dex */
    public static class b {
        private ExecutorService bYT;
        private int bYU;
        private QueueProcessingType bYV;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.bYU = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.bYV = QueueProcessingType.FIFO;
            this.mName = str;
            this.bYU = i;
            this.mPriority = i2;
            this.bYV = queueProcessingType;
            if (this.bYT == null) {
                this.bYT = a(this.mName, this.bYU, this.mPriority, this.bYV);
            }
        }

        protected void ZH() {
            if ((this.bYT instanceof ThreadPoolExecutor) && this.bYT != null && !this.bYT.isShutdown()) {
                ((ThreadPoolExecutor) this.bYT).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.bYT.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
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
    /* loaded from: classes14.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger bYO = new AtomicInteger(1);
        private final ThreadGroup bYP;
        private final AtomicInteger bYQ = new AtomicInteger(1);
        private final String bYR;
        private final int bYS;

        public a(String str, int i) {
            this.bYS = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.bYP = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.bYR = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bYO.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.bYP, runnable, this.bYR + this.bYQ.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.bYS);
            return thread;
        }
    }
}
