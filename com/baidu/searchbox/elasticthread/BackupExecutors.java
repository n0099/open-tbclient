package com.baidu.searchbox.elasticthread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class BackupExecutors {
    public static final int BACKUP_THREAD_POOL_CORE_SIZE = 15;
    public static volatile BackupExecutors sInstance;
    public ScheduledExecutorService mThreadPoolExecutor = Executors.newScheduledThreadPool(15);
    public ScheduledExecutorService mSerialExecutor = Executors.newSingleThreadScheduledExecutor();

    public static BackupExecutors getInstance() {
        if (sInstance == null) {
            synchronized (BackupExecutors.class) {
                if (sInstance == null) {
                    sInstance = new BackupExecutors();
                }
            }
        }
        return sInstance;
    }

    public Executor getSerialExecutor() {
        return this.mSerialExecutor;
    }

    public Executor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public void postSerialTask(Runnable runnable, long j) {
        this.mSerialExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public void postThreadPoolTask(Runnable runnable, long j) {
        this.mThreadPoolExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
