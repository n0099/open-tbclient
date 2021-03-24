package com.baidu.android.imsdk.task;

import android.content.Context;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class TaskManager {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE;
    public static final String TAG = "TaskManager";
    public static volatile TaskManager mInstance;
    public ThreadPoolExecutor service;
    public ExecutorService singleThreadService;

    /* loaded from: classes2.dex */
    public static class Task implements Runnable {
        public String mAction;
        public String mJson;

        public Task() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public Task(String str, String str2) {
            this.mAction = str;
            this.mJson = str2;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = Math.max(4, Math.min(availableProcessors - 1, 4));
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 3) + 1;
    }

    public TaskManager() {
        this.service = null;
        this.singleThreadService = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.service = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(false);
        this.singleThreadService = Executors.newSingleThreadExecutor();
    }

    public static TaskManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (TaskManager.class) {
                if (mInstance == null) {
                    mInstance = new TaskManager();
                }
            }
        }
        return mInstance;
    }

    public void clearTask() {
        this.service.purge();
    }

    public <T> Future<T> submitForLocalCallable(Callable<T> callable) {
        return this.singleThreadService.submit(callable);
    }

    public void submitForLocalOperation(Runnable runnable) {
        try {
            this.singleThreadService.submit(runnable);
        } catch (Exception e2) {
            LogUtils.e("TaskManager", "Exception ", e2);
        }
    }

    public boolean submitForNetWork(Runnable runnable) {
        try {
            this.service.submit(runnable);
            return true;
        } catch (Throwable th) {
            LogUtils.e("TaskManager", "Exception ", th);
            return false;
        }
    }
}
