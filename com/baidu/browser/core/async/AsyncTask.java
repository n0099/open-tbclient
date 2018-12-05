package com.baidu.browser.core.async;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.browser.core.util.BdLog;
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
/* loaded from: classes2.dex */
public abstract class AsyncTask<Params, Progress, Result> {
    public static final Executor SERIAL_EXECUTOR;
    public static final Executor UW;
    private static final b UX;
    private static volatile Executor sDefaultExecutor;
    private volatile Status UY;
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

    /* loaded from: classes2.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes2.dex */
    private static class a<Data> {
        final AsyncTask UZ;
        final Data[] mData;
    }

    static {
        SERIAL_EXECUTOR = Build.VERSION.SDK_INT >= 11 ? new c() : Executors.newSingleThreadExecutor(sThreadFactory);
        UW = Executors.newFixedThreadPool(2, sThreadFactory);
        UX = new b(Looper.getMainLooper());
        sDefaultExecutor = SERIAL_EXECUTOR;
    }

    @TargetApi(11)
    /* loaded from: classes2.dex */
    private static class c implements Executor {
        final ArrayDeque<Runnable> Va;
        Runnable Vb;

        private c() {
            this.Va = new ArrayDeque<>();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.Va.offer(new Runnable() { // from class: com.baidu.browser.core.async.AsyncTask.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.qi();
                    }
                }
            });
            if (this.Vb == null) {
                qi();
            }
        }

        protected synchronized void qi() {
            this.Vb = this.Va.poll();
            if (this.Vb != null) {
                try {
                    AsyncTask.THREAD_POOL_EXECUTOR.execute(this.Vb);
                } catch (Exception e) {
                    BdLog.d("scheduleNext exception " + e);
                }
            }
        }
    }

    protected void onPostExecute(Result result) {
    }

    protected void onProgressUpdate(Progress... progressArr) {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

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
        this.UY = Status.FINISHED;
    }

    /* loaded from: classes2.dex */
    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.UZ.finish(aVar.mData[0]);
                    return;
                case 2:
                    aVar.UZ.onProgressUpdate(aVar.mData);
                    return;
                default:
                    return;
            }
        }
    }
}
