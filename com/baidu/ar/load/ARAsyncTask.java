package com.baidu.ar.load;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.util.ARLog;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class ARAsyncTask<PARAMS, PROGRESS, RESULT> {
    private static final int MESSAGE_POST_DELAY = 5;
    private static final int MESSAGE_POST_ERROR = 4;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final int MESSAGE_POST_TIME_OUT = 3;
    private static final b sHandler = new b();
    private static volatile Executor sDefaultExecutor = AsyncTask.SERIAL_EXECUTOR;
    private volatile Status mStatus = Status.PENDING;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private boolean mTimerEnable = false;
    private long mTimeout = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private boolean mCatchError = true;
    private boolean mDelayEnable = false;
    private final c<PARAMS, RESULT> mWorker = new c<PARAMS, RESULT>() { // from class: com.baidu.ar.load.ARAsyncTask.1
        @Override // java.util.concurrent.Callable
        public RESULT call() {
            ARAsyncTask.this.mTaskInvoked.set(true);
            if (ARAsyncTask.this.mCatchError) {
                try {
                    return (RESULT) ARAsyncTask.this.postResult(ARAsyncTask.this.doInBackground(this.b));
                } catch (Exception e) {
                    ARLog.e(e.getMessage());
                    ARAsyncTask.this.postError(e.getMessage());
                    return null;
                }
            }
            return (RESULT) ARAsyncTask.this.postResult(ARAsyncTask.this.doInBackground(this.b));
        }
    };
    private final FutureTask<RESULT> mFuture = new FutureTask<RESULT>(this.mWorker) { // from class: com.baidu.ar.load.ARAsyncTask.2
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                ARAsyncTask.this.postResultIfNotInvoked(get());
            } catch (InterruptedException e) {
                ARLog.e(e.getMessage());
                ARAsyncTask.this.postError(e.getMessage());
            } catch (CancellationException e2) {
                ARAsyncTask.this.postResultIfNotInvoked(null);
            } catch (ExecutionException e3) {
                ARAsyncTask.this.postError(e3.getMessage());
                throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
            }
        }
    };

    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a<DATA> {
        final ARAsyncTask a;
        final DATA[] b;

        a(ARAsyncTask aRAsyncTask, DATA... dataArr) {
            this.a = aRAsyncTask;
            this.b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.a.finish(aVar.b[0]);
                    return;
                case 2:
                    aVar.a.onProgressUpdate(aVar.b);
                    return;
                case 3:
                    aVar.a.onTimeout();
                    return;
                case 4:
                    aVar.a.onError(Arrays.toString(aVar.b));
                    return;
                case 5:
                    aVar.a.executeDelay(((Integer) aVar.b[0]).intValue());
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class c<PARAMS, RESULT> implements Callable<RESULT> {
        PARAMS[] b;

        private c() {
        }
    }

    public static void execute(Runnable runnable) {
        sDefaultExecutor.execute(runnable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.ar.load.ARAsyncTask<PARAMS, PROGRESS, RESULT> */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void executeDelay(int i) {
        if (i == 0) {
            execute(new Object[0]);
        } else {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(RESULT result) {
        if (this.mCatchError) {
            try {
                if (this.mTimerEnable) {
                    removeTimer();
                }
                if (isCancelled()) {
                    onCancelled();
                } else {
                    onPostExecute(result);
                }
            } catch (Exception e) {
                ARLog.e(e.getMessage());
                postError(e.getMessage());
            }
        } else {
            if (this.mTimerEnable) {
                removeTimer();
            }
            if (isCancelled()) {
                onCancelled();
            } else {
                onPostExecute(result);
            }
        }
        this.mStatus = Status.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postError(String str) {
        sHandler.obtainMessage(4, new a(this, str)).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RESULT postResult(RESULT result) {
        sHandler.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResultIfNotInvoked(RESULT result) {
        if (this.mTaskInvoked.get()) {
            return;
        }
        postResult(result);
    }

    private void postTimer() {
        sHandler.sendMessageDelayed(sHandler.obtainMessage(3, new a(this, null)), this.mTimeout);
    }

    private void removeDelay() {
        sHandler.removeMessages(5);
    }

    private void removeTimer() {
        sHandler.removeMessages(3);
    }

    protected static void setDefaultExecutor(Executor executor) {
        sDefaultExecutor = executor;
    }

    public final boolean cancel(boolean z) {
        if (this.mTimerEnable) {
            removeTimer();
        }
        if (this.mDelayEnable) {
            removeDelay();
        }
        this.mCancelled.set(true);
        return this.mFuture.cancel(z);
    }

    protected abstract RESULT doInBackground(PARAMS... paramsArr);

    public void enableTimer() {
        this.mTimerEnable = true;
    }

    public final ARAsyncTask<PARAMS, PROGRESS, RESULT> execute(PARAMS... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final ARAsyncTask<PARAMS, PROGRESS, RESULT> executeOnExecutor(Executor executor, PARAMS... paramsArr) {
        if (this.mStatus != Status.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = Status.RUNNING;
        if (this.mCatchError) {
            try {
                onPreExecute();
            } catch (Exception e) {
                ARLog.e(e.getMessage());
                postError(e.getMessage());
                return null;
            }
        } else {
            onPreExecute();
        }
        this.mWorker.b = paramsArr;
        if (this.mTimerEnable) {
            postTimer();
        }
        executor.execute(this.mFuture);
        return this;
    }

    public final RESULT get() {
        return this.mFuture.get();
    }

    public final RESULT get(long j, TimeUnit timeUnit) {
        return this.mFuture.get(j, timeUnit);
    }

    protected final FutureTask<RESULT> getFutureTask() {
        return this.mFuture;
    }

    protected Handler getHandler() {
        return sHandler;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public final boolean isFinished() {
        return this.mStatus == Status.FINISHED;
    }

    protected void onCancelled() {
    }

    protected void onCancelled(RESULT result) {
        onCancelled();
    }

    protected void onError(String str) {
    }

    protected void onPostExecute(RESULT result) {
    }

    protected void onPreExecute() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProgressUpdate(PROGRESS... progressArr) {
    }

    protected void onTimeout() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postDelay(long j, int i) {
        sHandler.sendMessageDelayed(sHandler.obtainMessage(5, new a(this, Integer.valueOf(i))), j);
        this.mDelayEnable = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void publishProgress(PROGRESS... progressArr) {
        if (isCancelled()) {
            return;
        }
        sHandler.obtainMessage(2, new a(this, progressArr)).sendToTarget();
    }

    public void setTimeOut(long j) {
        this.mTimeout = j;
    }
}
