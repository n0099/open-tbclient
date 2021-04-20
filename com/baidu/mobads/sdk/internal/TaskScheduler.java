package com.baidu.mobads.sdk.internal;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class TaskScheduler {
    public static final String LOG_TAG = "TaskScheduler";
    public static volatile TaskScheduler sInstance;
    public ThreadPoolExecutor mHighPoolExecutor;
    public ScheduledThreadPoolExecutor mScheduledPoolExecutor;

    public TaskScheduler() {
        initThreadPool();
    }

    public static TaskScheduler getInstance() {
        if (sInstance == null) {
            synchronized (TaskScheduler.class) {
                if (sInstance == null) {
                    sInstance = new TaskScheduler();
                }
            }
        }
        return sInstance;
    }

    private void initThreadPool() {
        this.mHighPoolExecutor = ThreadPoolFactory.getThreadPoolExecutor(1, 5);
        this.mScheduledPoolExecutor = ThreadPoolFactory.getScheduledThreadPoolExecutor(2);
    }

    public void submit(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.mHighPoolExecutor) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.mHighPoolExecutor.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void submitAtFixedRate(BaseTask baseTask, long j, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (baseTask == null || (scheduledThreadPoolExecutor = this.mScheduledPoolExecutor) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            baseTask.setTaskAddTime(System.currentTimeMillis());
            baseTask.setTask(this.mScheduledPoolExecutor.scheduleAtFixedRate(baseTask, j, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void submitWithDelay(BaseTask baseTask, long j, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (baseTask == null || (scheduledThreadPoolExecutor = this.mScheduledPoolExecutor) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            baseTask.setTaskAddTime(System.currentTimeMillis());
            baseTask.setTask(this.mScheduledPoolExecutor.schedule(baseTask, j, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void submit(BaseTask baseTask) {
        ThreadPoolExecutor threadPoolExecutor;
        if (baseTask == null || (threadPoolExecutor = this.mHighPoolExecutor) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            baseTask.setTaskAddTime(System.currentTimeMillis());
            FutureTask futureTask = null;
            if (this.mHighPoolExecutor != null && !this.mHighPoolExecutor.isShutdown()) {
                futureTask = (FutureTask) this.mHighPoolExecutor.submit(baseTask);
            }
            baseTask.setTask(futureTask);
        } catch (Throwable unused) {
        }
    }
}
