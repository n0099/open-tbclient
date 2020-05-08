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
    private static volatile b bjU;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b Kj() {
        if (bjU == null) {
            synchronized (ThreadPool.class) {
                if (bjU == null) {
                    b bVar = new b("ComputationThreadPool", b.CORE_POOL_SIZE);
                    bVar.Kk();
                    bjU = bVar;
                }
            }
        }
        return bjU;
    }

    /* loaded from: classes3.dex */
    public static class b {
        private ExecutorService bka;
        private int bkb;
        private QueueProcessingType bkc;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.bkb = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.bkc = QueueProcessingType.FIFO;
            this.mName = str;
            this.bkb = i;
            this.mPriority = i2;
            this.bkc = queueProcessingType;
            if (this.bka == null) {
                this.bka = a(this.mName, this.bkb, this.mPriority, this.bkc);
            }
        }

        protected void Kk() {
            if ((this.bka instanceof ThreadPoolExecutor) && this.bka != null && !this.bka.isShutdown()) {
                ((ThreadPoolExecutor) this.bka).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.bka.execute(runnable);
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
        private static final AtomicInteger bjV = new AtomicInteger(1);
        private final ThreadGroup bjW;
        private final AtomicInteger bjX = new AtomicInteger(1);
        private final String bjY;
        private final int bjZ;

        public a(String str, int i) {
            this.bjZ = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.bjW = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.bjY = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + bjV.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.bjW, runnable, this.bjY + this.bjX.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.bjZ);
            return thread;
        }
    }
}
