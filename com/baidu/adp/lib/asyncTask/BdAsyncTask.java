package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class BdAsyncTask<Params, Progress, Result> {
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final com.baidu.adp.lib.asyncTask.a sDefaultExecutor = com.baidu.adp.lib.asyncTask.a.jV();
    private static final b sHandler = new b(Looper.getMainLooper());
    private volatile BdAsyncTaskStatus mStatus = BdAsyncTaskStatus.PENDING;
    private int mPriority = 1;
    private int mTag = 0;
    private String mKey = null;
    private BdAsyncTaskParallel mParallel = null;
    private boolean isSelfExecute = false;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean(false);
    private final AtomicBoolean mPreCancelInvoked = new AtomicBoolean(false);
    private boolean mIsTimeout = false;
    private final c<Params, Result> mWorker = new c<Params, Result>() { // from class: com.baidu.adp.lib.asyncTask.BdAsyncTask.1
        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            return !BdAsyncTask.this.mFuture.isCancelled() ? (Result) BdAsyncTask.this.postResult(BdAsyncTask.this.doInBackground(this.mParams)) : (Result) BdAsyncTask.this.postResult(null);
        }
    };
    private final com.baidu.adp.lib.asyncTask.b<Result> mFuture = new com.baidu.adp.lib.asyncTask.b<Result>(this.mWorker, this) { // from class: com.baidu.adp.lib.asyncTask.BdAsyncTask.2
        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                BdAsyncTask.this.postResult(get());
            } catch (InterruptedException e) {
            } catch (CancellationException e2) {
                BdAsyncTask.this.postResult(null);
            } catch (ExecutionException e3) {
                BdAsyncTask.this.postResult(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e3);
                }
            } catch (Throwable th) {
                throw new RuntimeException("An error occured while executing doInBackground()", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.b
        public void cancelTask() {
            BdAsyncTask.this.cancel();
        }
    };

    /* loaded from: classes.dex */
    public enum BdAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED
    }

    protected abstract Result doInBackground(Params... paramsArr);

    public synchronized int setPriority(int i) {
        int i2;
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        i2 = this.mPriority;
        this.mPriority = i;
        return i2;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getTag() {
        return this.mTag;
    }

    public synchronized int setTag(BdUniqueId bdUniqueId) {
        int i;
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        i = this.mTag;
        if (bdUniqueId != null) {
            this.mTag = bdUniqueId.getId();
        }
        return i;
    }

    public String getKey() {
        return this.mKey;
    }

    public synchronized String setKey(String str) {
        String str2;
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        str2 = this.mKey;
        this.mKey = str;
        return str2;
    }

    public BdAsyncTaskParallel getParallel() {
        return this.mParallel;
    }

    public synchronized void setParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.mParallel = bdAsyncTaskParallel;
    }

    public boolean isSelfExecute() {
        return this.isSelfExecute;
    }

    public synchronized void setSelfExecute(boolean z) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.isSelfExecute = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setTimeout(boolean z) {
        this.mIsTimeout = z;
    }

    public boolean isTimeout() {
        return this.mIsTimeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result postResult(Result result) {
        if (this.mTaskInvoked.compareAndSet(false, true)) {
            sHandler.obtainMessage(1, new a(this, result)).sendToTarget();
            return result;
        }
        return null;
    }

    public final BdAsyncTaskStatus getStatus() {
        return this.mStatus;
    }

    public void cancel() {
        cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreCancel() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPreExecute() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPostExecute(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProgressUpdate(Progress... progressArr) {
    }

    protected void onCancelled(Result result) {
        onCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancelled() {
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public final synchronized boolean cancel(boolean z) {
        boolean cancel;
        if (!this.isSelfExecute) {
            sDefaultExecutor.a((BdAsyncTask<?, ?, ?>) this);
        }
        cancel = this.mFuture.cancel(z);
        if (this.mPreCancelInvoked.compareAndSet(false, true)) {
            onPreCancel();
        }
        return cancel;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }

    public final BdAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final synchronized BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            switch (this.mStatus) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = BdAsyncTaskStatus.RUNNING;
        onPreExecute();
        this.mWorker.mParams = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new a(this, progressArr)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish(Result result) {
        if (isCancelled()) {
            onCancelled(result);
        } else {
            onPostExecute(result);
        }
        this.mStatus = BdAsyncTaskStatus.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.IH.finish(aVar.mData[0]);
                    return;
                case 2:
                    aVar.IH.onProgressUpdate(aVar.mData);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c<Params, Result> implements Callable<Result> {
        Params[] mParams;

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<Data> {
        final BdAsyncTask IH;
        final Data[] mData;

        a(BdAsyncTask bdAsyncTask, Data... dataArr) {
            this.IH = bdAsyncTask;
            this.mData = dataArr;
        }
    }

    public static void removeAllTask(BdUniqueId bdUniqueId) {
        sDefaultExecutor.removeAllTask(bdUniqueId);
    }

    public static void removeAllTask(BdUniqueId bdUniqueId, String str) {
        sDefaultExecutor.removeAllTask(bdUniqueId, str);
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        sDefaultExecutor.removeAllWaitingTask(bdUniqueId);
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        sDefaultExecutor.removeAllWaitingTask(bdUniqueId, str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return sDefaultExecutor.searchAllTask(bdUniqueId);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        return sDefaultExecutor.searchAllTask(bdUniqueId, str);
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        return sDefaultExecutor.searchTask(str);
    }

    public static BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return sDefaultExecutor.searchWaitingTask(str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        return sDefaultExecutor.searchWaitingTask(bdUniqueId);
    }

    public static BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return sDefaultExecutor.searchActivTask(str);
    }

    public static int getTaskNum(BdUniqueId bdUniqueId) {
        return getTaskNum(null, bdUniqueId);
    }

    public static int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return sDefaultExecutor.getTaskNum(str, bdUniqueId);
    }
}
