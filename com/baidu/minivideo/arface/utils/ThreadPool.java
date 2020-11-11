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
    private static volatile b cay;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b aap() {
        if (cay == null) {
            synchronized (ThreadPool.class) {
                if (cay == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.aaq();
                    cay = bVar;
                }
            }
        }
        return cay;
    }

    /* loaded from: classes15.dex */
    public static class b {
        private ExecutorService caE;
        private int caF;
        private QueueProcessingType caG;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.caF = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.caG = QueueProcessingType.FIFO;
            this.mName = str;
            this.caF = i;
            this.mPriority = i2;
            this.caG = queueProcessingType;
            if (this.caE == null) {
                this.caE = a(this.mName, this.caF, this.mPriority, this.caG);
            }
        }

        protected void aaq() {
            if ((this.caE instanceof ThreadPoolExecutor) && this.caE != null && !this.caE.isShutdown()) {
                ((ThreadPoolExecutor) this.caE).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.caE.execute(runnable);
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
        private static final AtomicInteger caz = new AtomicInteger(1);
        private final ThreadGroup caA;
        private final AtomicInteger caB = new AtomicInteger(1);
        private final String caC;
        private final int caD;

        public a(String str, int i) {
            this.caD = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.caA = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.caC = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + caz.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.caA, runnable, this.caC + this.caB.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.caD);
            return thread;
        }
    }
}
