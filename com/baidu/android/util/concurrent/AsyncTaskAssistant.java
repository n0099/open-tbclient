package com.baidu.android.util.concurrent;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Deprecated
/* loaded from: classes.dex */
public final class AsyncTaskAssistant {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final boolean DEBUG = false;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE;
    public static final String TAG = "AsyncTaskAssistant";
    public static final Executor THREAD_POOL_EXECUTOR;
    public static Handler sHandler = new Handler(Looper.getMainLooper());
    public static final BlockingQueue<Runnable> sPoolWorkQueue;
    public static final ThreadFactory sThreadFactory;

    /* loaded from: classes.dex */
    public static class Task {
        public String name;
        public Runnable runnable;

        public Task() {
        }
    }

    /* loaded from: classes.dex */
    public static class WorkerAsyncTask extends AsyncTask<Task, Object, Object> {
        public WorkerAsyncTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Object doInBackground(Task... taskArr) {
            Process.setThreadPriority(10);
            try {
                if (taskArr[0] == null || taskArr[0].runnable == null) {
                    return null;
                }
                Thread.currentThread().setName(!TextUtils.isEmpty(taskArr[0].name) ? taskArr[0].name : "noname");
                taskArr[0].runnable.run();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(2, Math.min(availableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = Math.max(2, CPU_COUNT - 1);
        sThreadFactory = new ThreadFactory() { // from class: com.baidu.android.util.concurrent.AsyncTaskAssistant.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable);
            }
        };
        sPoolWorkQueue = new LinkedBlockingQueue();
        int i2 = MAXIMUM_POOL_SIZE;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    public static void execute(Runnable runnable, String str) {
        Task task = new Task();
        task.runnable = runnable;
        task.name = str;
        new WorkerAsyncTask().execute(task);
    }

    @SuppressLint({"NewApi"})
    public static void executeOnThreadPool(Runnable runnable, String str) {
        Task task = new Task();
        task.runnable = runnable;
        task.name = str;
        new WorkerAsyncTask().executeOnExecutor(THREAD_POOL_EXECUTOR, task);
    }

    public static void execute(final Runnable runnable, final String str, long j) {
        sHandler.postDelayed(new Runnable() { // from class: com.baidu.android.util.concurrent.AsyncTaskAssistant.2
            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskAssistant.execute(runnable, str);
            }
        }, j);
    }

    public static void executeOnThreadPool(final Runnable runnable, final String str, long j) {
        sHandler.postDelayed(new Runnable() { // from class: com.baidu.android.util.concurrent.AsyncTaskAssistant.3
            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskAssistant.executeOnThreadPool(runnable, str);
            }
        }, j);
    }
}
