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
/* loaded from: classes5.dex */
public final class AsyncTaskAssistant {
    private static final boolean DEBUG = false;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final String TAG = "AsyncTaskAssistant";
    private static final Executor THREAD_POOL_EXECUTOR;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = Math.max(2, CPU_COUNT - 1);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.android.util.concurrent.AsyncTaskAssistant.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    };
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(MAXIMUM_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Task {
        String name;
        Runnable runnable;

        private Task() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class WorkerAsyncTask extends AsyncTask<Task, Object, Object> {
        private WorkerAsyncTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Object doInBackground(Task... taskArr) {
            String str;
            Process.setThreadPriority(10);
            try {
                if (taskArr[0] != null && taskArr[0].runnable != null) {
                    if (!TextUtils.isEmpty(taskArr[0].name)) {
                        str = taskArr[0].name;
                    } else {
                        str = "noname";
                    }
                    Thread.currentThread().setName(str);
                    taskArr[0].runnable.run();
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private AsyncTaskAssistant() {
    }

    public static void execute(Runnable runnable, String str) {
        Task task = new Task();
        task.runnable = runnable;
        task.name = str;
        new WorkerAsyncTask().execute(task);
    }

    public static void execute(final Runnable runnable, final String str, long j) {
        sHandler.postDelayed(new Runnable() { // from class: com.baidu.android.util.concurrent.AsyncTaskAssistant.2
            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskAssistant.execute(runnable, str);
            }
        }, j);
    }

    @SuppressLint({"NewApi"})
    public static void executeOnThreadPool(Runnable runnable, String str) {
        Task task = new Task();
        task.runnable = runnable;
        task.name = str;
        new WorkerAsyncTask().executeOnExecutor(THREAD_POOL_EXECUTOR, task);
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
