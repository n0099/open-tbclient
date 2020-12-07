package com.baidu.minivideo.arface.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class ThreadPool {
    private static volatile b cfn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b acO() {
        if (cfn == null) {
            synchronized (ThreadPool.class) {
                if (cfn == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.acP();
                    cfn = bVar;
                }
            }
        }
        return cfn;
    }

    /* loaded from: classes8.dex */
    public static class b {
        private ExecutorService cft;
        private int cfu;
        private QueueProcessingType cfv;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.cfu = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.cfv = QueueProcessingType.FIFO;
            this.mName = str;
            this.cfu = i;
            this.mPriority = i2;
            this.cfv = queueProcessingType;
            if (this.cft == null) {
                this.cft = a(this.mName, this.cfu, this.mPriority, this.cfv);
            }
        }

        protected void acP() {
            if ((this.cft instanceof ThreadPoolExecutor) && this.cft != null && !this.cft.isShutdown()) {
                ((ThreadPoolExecutor) this.cft).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.cft.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger cfo = new AtomicInteger(1);
        private final ThreadGroup cfp;
        private final AtomicInteger cfq = new AtomicInteger(1);
        private final String cfr;
        private final int cfs;

        public a(String str, int i) {
            this.cfs = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.cfp = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.cfr = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + cfo.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.cfp, runnable, this.cfr + this.cfq.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.cfs);
            return thread;
        }
    }
}
