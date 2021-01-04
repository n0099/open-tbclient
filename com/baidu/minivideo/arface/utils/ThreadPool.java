package com.baidu.minivideo.arface.utils;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class ThreadPool {
    private static volatile b cmq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public enum QueueProcessingType {
        FIFO,
        LIFO
    }

    public static b aeK() {
        if (cmq == null) {
            synchronized (ThreadPool.class) {
                if (cmq == null) {
                    b bVar = new b("IOThreadPool", b.MAXIMUM_POOL_SIZE);
                    bVar.aeL();
                    cmq = bVar;
                }
            }
        }
        return cmq;
    }

    /* loaded from: classes6.dex */
    public static class b {
        private ExecutorService cmv;
        private int cmw;
        private QueueProcessingType cmx;
        private String mName;
        private int mPriority;
        private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
        private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
        private static final int MAXIMUM_POOL_SIZE = CPU_COUNT;

        public b(String str, int i) {
            this(str, i, 9, QueueProcessingType.FIFO);
        }

        public b(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            this.cmw = CORE_POOL_SIZE;
            this.mPriority = 4;
            this.cmx = QueueProcessingType.FIFO;
            this.mName = str;
            this.cmw = i;
            this.mPriority = i2;
            this.cmx = queueProcessingType;
            if (this.cmv == null) {
                this.cmv = a(this.mName, this.cmw, this.mPriority, this.cmx);
            }
        }

        protected void aeL() {
            if ((this.cmv instanceof ThreadPoolExecutor) && this.cmv != null && !this.cmv.isShutdown()) {
                ((ThreadPoolExecutor) this.cmv).allowsCoreThreadTimeOut();
            }
        }

        private ExecutorService a(String str, int i, int i2, QueueProcessingType queueProcessingType) {
            return new ThreadPoolExecutor(i, i, 3L, TimeUnit.SECONDS, queueProcessingType == QueueProcessingType.FIFO ? new LinkedBlockingQueue() : new LIFOLinkedBlockingDeque(), new a(str, i2));
        }

        public void execute(Runnable runnable) {
            this.cmv.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {
        private static final AtomicInteger cmr = new AtomicInteger(1);
        private final ThreadGroup cms;
        private final AtomicInteger cmt = new AtomicInteger(1);
        private final String cmu;
        private final int mThreadPriority;

        public a(String str, int i) {
            this.mThreadPriority = i;
            SecurityManager securityManager = System.getSecurityManager();
            this.cms = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
            this.cmu = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + cmr.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.cms, runnable, this.cmu + this.cmt.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.mThreadPriority);
            return thread;
        }
    }
}
