package com.baidu.android.imsdk.task;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
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
    private static TaskManager mInstance;
    private Context mContext;
    private ThreadPoolExecutor service;
    private ExecutorService singleThreadService;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;

    private TaskManager(Context context) {
        this.service = null;
        this.singleThreadService = null;
        this.mContext = context;
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        this.service = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), discardOldestPolicy);
        this.service.allowCoreThreadTimeOut(false);
        this.singleThreadService = Executors.newSingleThreadExecutor();
    }

    public static TaskManager getInstance(Context context) {
        if (context == null) {
            return null;
        }
        if (mInstance == null) {
            synchronized (TaskManager.class) {
                if (mInstance == null) {
                    mInstance = new TaskManager(context);
                }
            }
        }
        return mInstance;
    }

    public void submitForLocalOperation(Runnable runnable) {
        try {
            this.singleThreadService.submit(runnable);
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
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
            LogUtils.e(TAG, "Exception ", th);
            return false;
        }
    }

    public void clearTask() {
        this.service.purge();
    }

    /* loaded from: classes3.dex */
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
