package com.baidu.mobads.sdk.internal;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class ThreadPoolFactory {
    public static final int BACKUP_POOL_SIZE = 5;
    public static final int KEEP_ALIVE_SECONDS = 60;
    public static final String LOG_TAG = "ThreadPoolFactory";
    public static ThreadPoolExecutor sBackupExecutor;
    public static LinkedBlockingQueue<Runnable> sBackupExecutorQueue;
    public static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.mobads.sdk.internal.ThreadPoolFactory.1
        public final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "TaskScheduler #" + this.mCount.getAndIncrement());
            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.baidu.mobads.sdk.internal.ThreadPoolFactory.1.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread2, Throwable th) {
                    Log.i("ThreadPoolFactory", "线程名字=" + thread2.getName() + "线程crash信息", th);
                }
            });
            return thread;
        }
    };
    public static final RejectedExecutionHandler sRunOnSerialPolicy = new RejectedExecutionHandler() { // from class: com.baidu.mobads.sdk.internal.ThreadPoolFactory.2
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Log.w("ThreadPoolFactory", "Exceeded ThreadPoolExecutor pool size");
            synchronized (this) {
                if (ThreadPoolFactory.sBackupExecutor == null) {
                    LinkedBlockingQueue unused = ThreadPoolFactory.sBackupExecutorQueue = new LinkedBlockingQueue();
                    ThreadPoolExecutor unused2 = ThreadPoolFactory.sBackupExecutor = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, ThreadPoolFactory.sBackupExecutorQueue, ThreadPoolFactory.sThreadFactory);
                }
            }
            ThreadPoolFactory.sBackupExecutor.execute(runnable);
        }
    };

    public static ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(int i2) {
        return new ScheduledThreadPoolExecutor(i2, sThreadFactory);
    }

    public static ThreadPoolExecutor getThreadPoolExecutor(int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), sThreadFactory);
        threadPoolExecutor.setRejectedExecutionHandler(sRunOnSerialPolicy);
        return threadPoolExecutor;
    }
}
