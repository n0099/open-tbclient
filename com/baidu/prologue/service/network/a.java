package com.baidu.prologue.service.network;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class a {
    private static final Executor THREAD_POOL_EXECUTOR;
    private static final boolean DEBUG = com.baidu.prologue.a.a.a.ctc;
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    private static final int MAXIMUM_POOL_SIZE = Math.max(2, CPU_COUNT - 1);
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.prologue.service.network.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    };
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue();

    static {
        if (DEBUG) {
            Log.d("AsyncTaskAssistant", "core pool size: " + CORE_POOL_SIZE + " max size: " + MAXIMUM_POOL_SIZE);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(MAXIMUM_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        THREAD_POOL_EXECUTOR = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.prologue.service.network.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0332a {
        String name;
        Runnable runnable;

        private C0332a() {
        }
    }

    /* loaded from: classes5.dex */
    private static class b extends AsyncTask<C0332a, Object, Object> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Object doInBackground(C0332a... c0332aArr) {
            String str;
            Process.setThreadPriority(10);
            try {
                if (c0332aArr[0] != null && c0332aArr[0].runnable != null) {
                    if (!TextUtils.isEmpty(c0332aArr[0].name)) {
                        str = c0332aArr[0].name;
                    } else {
                        str = "noname";
                    }
                    Thread.currentThread().setName(str);
                    if (a.DEBUG) {
                        Log.d("AsyncTaskAssistant", "start to run task " + str);
                    }
                    c0332aArr[0].runnable.run();
                    return null;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static void execute(Runnable runnable, String str) {
        C0332a c0332a = new C0332a();
        c0332a.runnable = runnable;
        c0332a.name = str;
        new b().execute(c0332a);
    }
}
