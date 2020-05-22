package com.baidu.browser.core.async;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.MainThread;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public abstract class AsyncTask<Params, Progress, Result> {
    public static final Executor aca;
    public static final Executor acb;
    private static final b acc;
    private static volatile Executor sDefaultExecutor;
    private volatile Status acd;
    private final AtomicBoolean mCancelled;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = (CPU_COUNT * 2) + 1;
    private static final ThreadFactory sThreadFactory = new ThreadFactory() { // from class: com.baidu.browser.core.async.AsyncTask.1
        private final AtomicInteger mCount = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.mCount.getAndIncrement());
        }
    };
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue(128);
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 1, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);

    /* loaded from: classes11.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes11.dex */
    private static class a<Data> {
        final AsyncTask ace;
        final Data[] mData;
    }

    static {
        aca = Build.VERSION.SDK_INT >= 11 ? new c() : Executors.newSingleThreadExecutor(sThreadFactory);
        acb = Executors.newFixedThreadPool(2, sThreadFactory);
        acc = new b(Looper.getMainLooper());
        sDefaultExecutor = aca;
    }

    @TargetApi(11)
    /* loaded from: classes11.dex */
    private static class c implements Executor {
        final ArrayDeque<Runnable> acf;
        Runnable acg;

        private c() {
            this.acf = new ArrayDeque<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.acf.offer(new Runnable() { // from class: com.baidu.browser.core.async.AsyncTask.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.rg();
                    }
                }
            });
            if (this.acg == null) {
                rg();
            }
        }

        protected synchronized void rg() {
            this.acg = this.acf.poll();
            if (this.acg != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.acg);
            }
        }
    }

    @MainThread
    protected void onPostExecute(Result result) {
    }

    @MainThread
    protected void onProgressUpdate(Progress... progressArr) {
    }

    @MainThread
    protected void onCancelled(Result result) {
        onCancelled();
    }

    @MainThread
    protected void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        try {
            if (isCancelled()) {
                onCancelled(result);
            } else {
                onPostExecute(result);
            }
        } catch (Throwable th) {
            Log.w("AsyncTask", th);
        }
        this.acd = Status.FINISHED;
    }

    /* loaded from: classes11.dex */
    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.ace.finish(aVar.mData[0]);
                    return;
                case 2:
                    aVar.ace.onProgressUpdate(aVar.mData);
                    return;
                default:
                    return;
            }
        }
    }
}
