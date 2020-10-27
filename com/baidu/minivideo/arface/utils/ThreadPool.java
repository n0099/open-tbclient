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
    private static volatile b bUO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b XQ() {
        if (bUO == null) {
            synchronized (ThreadPool.class) {
                if (bUO == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.XR();
                    bUO = bVar;
                }
            }
        }
        return bUO;
    }

    /* loaded from: classes15.dex */
    public static class b {
        private ExecutorService bUU;
        private int bUV;
        private QueueProcessingType bUW;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.bUV = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.bUW = QueueProcessingType.FIFO;
            this.mName = str;
            this.bUV = i;
            this.mPriority = i2;
            this.bUW = queueProcessingType;
            if (this.bUU == null) {
                this.bUU = a(this.mName, this.bUV, this.mPriority, this.bUW);
            }
        }

        protected void XR() {
            if ((this.bUU instanceof ThreadPoolExecutor) && this.bUU != null && !this.bUU.isShutdown()) {
                ((ThreadPoolExecutor) this.bUU).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.bUU.execute(runnable);
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
        private static final AtomicInteger bUP = new AtomicInteger(1);
        private final ThreadGroup bUQ;
        private final AtomicInteger bUR = new AtomicInteger(1);
        private final String bUS;
        private final int bUT;

        public a(String str, int i) {
            this.bUT = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.bUQ = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.bUS = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bUP.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.bUQ, runnable, this.bUS + this.bUR.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.bUT);
            return thread;
        }
    }
}
