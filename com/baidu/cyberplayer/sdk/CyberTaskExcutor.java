package com.baidu.cyberplayer.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public final class CyberTaskExcutor {
    public static final String TAG = "CyberTaskExcutor";
    public final int IDLE_KEEP_ALIVE_TIME;
    public final int MAX_CORE_THREAD_NUM;
    public final int MAX_THREAD_NUM;
    public ExecutorService mExecutor;
    public ExecutorService mSingleHighThreadExecutor;
    public ExecutorService mSingleThreadExecutor;

    /* loaded from: classes3.dex */
    public static class CyberThreadFactory implements ThreadFactory {
        public final String mNamePrefix;
        public int mPriority;
        public final AtomicInteger mThreadNumber = new AtomicInteger(1);

        public CyberThreadFactory(String str) {
            this.mPriority = 5;
            this.mNamePrefix = str + "-";
            this.mPriority = 5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.mNamePrefix + this.mThreadNumber.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(true);
            }
            thread.setPriority(this.mPriority);
            return thread;
        }

        public CyberThreadFactory(String str, int i) {
            this.mPriority = 5;
            this.mNamePrefix = str + "-";
            this.mPriority = i;
        }
    }

    /* loaded from: classes3.dex */
    public static class SingletonHolder {
        public static final CyberTaskExcutor INSTANCE = new CyberTaskExcutor();
    }

    public CyberTaskExcutor() {
        this.MAX_CORE_THREAD_NUM = 2;
        this.MAX_THREAD_NUM = 7;
        this.IDLE_KEEP_ALIVE_TIME = 120;
        this.mExecutor = new ThreadPoolExecutor(2, 7, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new CyberThreadFactory("cyber-thread", 5));
        this.mSingleThreadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new CyberThreadFactory("cyber-thread-Single", 5));
        this.mSingleHighThreadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new CyberThreadFactory("cyber-thread-Single-high", 5));
        ExecutorService executorService = this.mExecutor;
        if (executorService != null && (executorService instanceof ThreadPoolExecutor)) {
            ((ThreadPoolExecutor) executorService).allowCoreThreadTimeOut(true);
        }
    }

    @Keep
    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    @Keep
    public void executeSingleHighThread(Runnable runnable) {
        this.mSingleHighThreadExecutor.execute(runnable);
    }

    @Keep
    public void executeSingleThread(Runnable runnable) {
        this.mSingleThreadExecutor.execute(runnable);
    }

    @Keep
    public static CyberTaskExcutor getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
