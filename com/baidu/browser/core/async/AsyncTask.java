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
    private static final b IB;
    public static final Executor Iy;
    public static final Executor Iz;
    private static volatile Executor sDefaultExecutor;
    private volatile Status IC;
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
        final AsyncTask IE;
        final Data[] mData;
    }

    static {
        Iy = Build.VERSION.SDK_INT >= 11 ? new c() : Executors.newSingleThreadExecutor(sThreadFactory);
        Iz = Executors.newFixedThreadPool(2, sThreadFactory);
        IB = new b(Looper.getMainLooper());
        sDefaultExecutor = Iy;
    }

    @TargetApi(11)
    /* loaded from: classes11.dex */
    private static class c implements Executor {
        final ArrayDeque<Runnable> IF;
        Runnable IG;

        private c() {
            this.IF = new ArrayDeque<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.IF.offer(new Runnable() { // from class: com.baidu.browser.core.async.AsyncTask.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.mx();
                    }
                }
            });
            if (this.IG == null) {
                mx();
            }
        }

        protected synchronized void mx() {
            this.IG = this.IF.poll();
            if (this.IG != null) {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.IG);
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
        this.IC = Status.FINISHED;
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
                    aVar.IE.finish(aVar.mData[0]);
                    return;
                case 2:
                    aVar.IE.onProgressUpdate(aVar.mData);
                    return;
                default:
                    return;
            }
        }
    }
}
