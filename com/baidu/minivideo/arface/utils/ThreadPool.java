package com.baidu.minivideo.arface.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class ThreadPool {
    private static volatile b cns;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b acJ() {
        if (cns == null) {
            synchronized (ThreadPool.class) {
                if (cns == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.acK();
                    cns = bVar;
                }
            }
        }
        return cns;
    }

    /* loaded from: classes5.dex */
    public static class b {
        private QueueProcessingType cnA;
        private ExecutorService cny;
        private int cnz;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.cnz = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.cnA = QueueProcessingType.FIFO;
            this.mName = str;
            this.cnz = i;
            this.mPriority = i2;
            this.cnA = queueProcessingType;
            if (this.cny == null) {
                this.cny = a(this.mName, this.cnz, this.mPriority, this.cnA);
            }
        }

        protected void acK() {
            if ((this.cny instanceof ThreadPoolExecutor) && this.cny != null && !this.cny.isShutdown()) {
                ((ThreadPoolExecutor) this.cny).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.cny.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger cnu = new AtomicInteger(1);
        private final ThreadGroup cnv;
        private final AtomicInteger cnw = new AtomicInteger(1);
        private final String cnx;
        private final int mThreadPriority;

        public a(String str, int i) {
            this.mThreadPriority = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.cnv = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.cnx = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + cnu.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.cnv, runnable, this.cnx + this.cnw.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.mThreadPriority);
            return thread;
        }
    }
}
