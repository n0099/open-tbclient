package com.baidu.minivideo.arface.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class ThreadPool {
    private static volatile b clR;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b acG() {
        if (clR == null) {
            synchronized (ThreadPool.class) {
                if (clR == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.acH();
                    clR = bVar;
                }
            }
        }
        return clR;
    }

    /* loaded from: classes3.dex */
    public static class b {
        private ExecutorService clW;
        private int clX;
        private QueueProcessingType clY;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.clX = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.clY = QueueProcessingType.FIFO;
            this.mName = str;
            this.clX = i;
            this.mPriority = i2;
            this.clY = queueProcessingType;
            if (this.clW == null) {
                this.clW = a(this.mName, this.clX, this.mPriority, this.clY);
            }
        }

        protected void acH() {
            if ((this.clW instanceof ThreadPoolExecutor) && this.clW != null && !this.clW.isShutdown()) {
                ((ThreadPoolExecutor) this.clW).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.clW.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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
    /* loaded from: classes3.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger clS = new AtomicInteger(1);
        private final ThreadGroup clT;
        private final AtomicInteger clU = new AtomicInteger(1);
        private final String clV;
        private final int mThreadPriority;

        public a(String str, int i) {
            this.mThreadPriority = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.clT = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.clV = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + clS.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.clT, runnable, this.clV + this.clU.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.mThreadPriority);
            return thread;
        }
    }
}
