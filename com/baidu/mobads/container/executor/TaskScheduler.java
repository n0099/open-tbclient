package com.baidu.mobads.container.executor;

import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class TaskScheduler {
    public static final String LOG_TAG = "TaskScheduler";
    public static volatile TaskScheduler sInstance;
    public ThreadPoolExecutor mDownloadPoolExecutor;
    public ThreadPoolExecutor mHighPoolExecutor;
    public ThreadPoolExecutor mMiddlePoolExecutor;
    public ScheduledThreadPoolExecutor mScheduledPoolExecutor;

    /* loaded from: classes2.dex */
    public interface ThreadType {
        public static final int THREAD_TYPE_DOWNLOAD = 3;
        public static final int THREAD_TYPE_HIGH = 1;
        public static final int THREAD_TYPE_MIDDLE = 2;
    }

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
        this.mHighPoolExecutor = ThreadPoolFactory.getThreadPoolExecutor(5, 15);
        this.mMiddlePoolExecutor = ThreadPoolFactory.getThreadPoolExecutor(5, 10);
        this.mDownloadPoolExecutor = ThreadPoolFactory.getThreadPoolExecutor(6, 10);
        this.mScheduledPoolExecutor = ThreadPoolFactory.getScheduledThreadPoolExecutor(3);
    }

    private FutureTask submitTask(ThreadPoolExecutor threadPoolExecutor, BaseTask baseTask) {
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            return null;
        }
        return (FutureTask) threadPoolExecutor.submit(baseTask);
    }

    public void submit(Runnable runnable) {
        if (runnable != null) {
            try {
                this.mHighPoolExecutor.submit(runnable);
            } catch (Throwable unused) {
            }
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

    public void submit(BaseTask baseTask, int i) {
        FutureTask submitTask;
        if (baseTask != null) {
            try {
                baseTask.setTaskAddTime(System.currentTimeMillis());
                if (i == 1) {
                    submitTask = submitTask(this.mHighPoolExecutor, baseTask);
                } else if (i == 2) {
                    submitTask = submitTask(this.mMiddlePoolExecutor, baseTask);
                } else if (i != 3) {
                    submitTask = submitTask(this.mMiddlePoolExecutor, baseTask);
                } else {
                    submitTask = submitTask(this.mDownloadPoolExecutor, baseTask);
                }
                baseTask.setTask(submitTask);
            } catch (Throwable unused) {
            }
        }
    }
}
