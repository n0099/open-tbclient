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
    private static volatile b brp;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b Mc() {
        if (brp == null) {
            synchronized (ThreadPool.class) {
                if (brp == null) {
                    b bVar = new b("ComputationThreadPool", b.CORE_POOL_SIZE);
                    bVar.Md();
                    brp = bVar;
                }
            }
        }
        return brp;
    }

    /* loaded from: classes3.dex */
    public static class b {
        private ExecutorService brv;
        private int brw;
        private QueueProcessingType brx;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.brw = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.brx = QueueProcessingType.FIFO;
            this.mName = str;
            this.brw = i;
            this.mPriority = i2;
            this.brx = queueProcessingType;
            if (this.brv == null) {
                this.brv = a(this.mName, this.brw, this.mPriority, this.brx);
            }
        }

        protected void Md() {
            if ((this.brv instanceof ThreadPoolExecutor) && this.brv != null && !this.brv.isShutdown()) {
                ((ThreadPoolExecutor) this.brv).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.brv.execute(runnable);
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
        private static final AtomicInteger brq = new AtomicInteger(1);
        private final ThreadGroup brr;
        private final AtomicInteger brs = new AtomicInteger(1);
        private final String brt;
        private final int bru;

        public a(String str, int i) {
            this.bru = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.brr = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.brt = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + brq.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.brr, runnable, this.brt + this.brs.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.bru);
            return thread;
        }
    }
}
