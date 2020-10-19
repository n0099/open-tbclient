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
/* loaded from: classes5.dex */
public class TaskManager {
    private static final int KEEP_ALIVE_SECONDS = 30;
    public static final String TAG = "TaskManager";
    private static volatile TaskManager mInstance;
    private ThreadPoolExecutor service;
    private ExecutorService singleThreadService;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(4, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 3) + 1;

    private TaskManager() {
        this.service = null;
        this.singleThreadService = null;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        this.service = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.service.allowCoreThreadTimeOut(false);
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

    public void submitForLocalOperation(Runnable runnable) {
        try {
            this.singleThreadService.submit(runnable);
        } catch (Exception e) {
            LogUtils.e("TaskManager", "Exception ", e);
        }
    }

    public <T> Future<T> submitForLocalCallable(Callable<T> callable) {
        return this.singleThreadService.submit(callable);
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

    public void clearTask() {
        this.service.purge();
    }

    /* loaded from: classes5.dex */
    public static class Task implements Runnable {
        protected String mAction;
        protected String mJson;

        /* JADX INFO: Access modifiers changed from: protected */
        public Task() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Task(String str, String str2) {
            this.mAction = str;
            this.mJson = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
