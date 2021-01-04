package com.baidu.searchbox.elasticthread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class BackupExecutors {
    private static final int BACKUP_THREAD_POOL_CORE_SIZE = 15;
    private static volatile BackupExecutors sInstance = null;
    private ScheduledExecutorService mThreadPoolExecutor = Executors.newScheduledThreadPool(15);
    private ScheduledExecutorService mSerialExecutor = Executors.newSingleThreadScheduledExecutor();

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

    private BackupExecutors() {
    }

    public void postThreadPoolTask(Runnable runnable, long j) {
        this.mThreadPoolExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public void postSerialTask(Runnable runnable, long j) {
        this.mSerialExecutor.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public Executor getThreadPoolExecutor() {
        return this.mThreadPoolExecutor;
    }

    public Executor getSerialExecutor() {
        return this.mSerialExecutor;
    }
}
