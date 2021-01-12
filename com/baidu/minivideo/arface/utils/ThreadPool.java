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
    private static volatile b chC;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b aaS() {
        if (chC == null) {
            synchronized (ThreadPool.class) {
                if (chC == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.aaT();
                    chC = bVar;
                }
            }
        }
        return chC;
    }

    /* loaded from: classes5.dex */
    public static class b {
        private ExecutorService chH;
        private int chI;
        private QueueProcessingType chJ;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.chI = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.chJ = QueueProcessingType.FIFO;
            this.mName = str;
            this.chI = i;
            this.mPriority = i2;
            this.chJ = queueProcessingType;
            if (this.chH == null) {
                this.chH = a(this.mName, this.chI, this.mPriority, this.chJ);
            }
        }

        protected void aaT() {
            if ((this.chH instanceof ThreadPoolExecutor) && this.chH != null && !this.chH.isShutdown()) {
                ((ThreadPoolExecutor) this.chH).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.chH.execute(runnable);
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
        private static final AtomicInteger chD = new AtomicInteger(1);
        private final ThreadGroup chE;
        private final AtomicInteger chF = new AtomicInteger(1);
        private final String chG;
        private final int mThreadPriority;

        public a(String str, int i) {
            this.mThreadPriority = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.chE = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.chG = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + chD.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.chE, runnable, this.chG + this.chF.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.mThreadPriority);
            return thread;
        }
    }
}
