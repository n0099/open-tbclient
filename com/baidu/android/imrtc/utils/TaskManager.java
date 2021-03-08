package com.baidu.android.imrtc.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class TaskManager {
    private static final int KEEP_ALIVE_SECONDS = 30;
    public static final String TAG = "TaskManager";
    private static TaskManager instance;
    private ThreadPoolExecutor service;
    private ExecutorService singleThreadService;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;

    private TaskManager() {
        this.service = null;
        this.singleThreadService = null;
        this.service = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.service.allowCoreThreadTimeOut(true);
        this.singleThreadService = Executors.newSingleThreadExecutor();
    }

    public static TaskManager getInstance() {
        if (instance == null) {
            synchronized (TaskManager.class) {
                if (instance == null) {
                    instance = new TaskManager();
                }
            }
        }
        return instance;
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

    public void submitForNetWork(Runnable runnable) {
        try {
            this.service.submit(runnable);
        } catch (Throwable th) {
            LogUtils.e("TaskManager", "Exception ", th);
        }
    }

    /* loaded from: classes3.dex */
    public static class Task implements Runnable {
        protected String mAction;
        protected String mJson;

        protected Task() {
        }

        protected Task(String str, String str2) {
            this.mAction = str;
            this.mJson = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
