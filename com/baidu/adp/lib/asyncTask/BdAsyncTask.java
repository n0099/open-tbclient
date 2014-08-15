package com.baidu.adp.lib.asyncTask;

import com.baidu.adp.BdUniqueId;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class BdAsyncTask<Params, Progress, Result> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$adp$lib$asyncTask$BdAsyncTask$BdAsyncTaskStatus = null;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    private static final f sDefaultExecutor = f.b();
    private static final d sHandler = new d(null);
    private final k<Result> mFuture;
    private final e<Params, Result> mWorker;
    private volatile BdAsyncTaskStatus mStatus = BdAsyncTaskStatus.PENDING;
    private int mPriority = 1;
    private int mTag = 0;
    private String mKey = null;
    private BdAsyncTaskParallel mParallel = null;
    private boolean isSelfExecute = false;
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean(false);
    private final AtomicBoolean mPreCancelInvoked = new AtomicBoolean(false);
    private boolean mIsTimeout = false;

    /* loaded from: classes.dex */
    public enum BdAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static BdAsyncTaskStatus[] valuesCustom() {
            BdAsyncTaskStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            BdAsyncTaskStatus[] bdAsyncTaskStatusArr = new BdAsyncTaskStatus[length];
            System.arraycopy(valuesCustom, 0, bdAsyncTaskStatusArr, 0, length);
            return bdAsyncTaskStatusArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Result doInBackground(Params... paramsArr);

    static /* synthetic */ int[] $SWITCH_TABLE$com$baidu$adp$lib$asyncTask$BdAsyncTask$BdAsyncTaskStatus() {
        int[] iArr = $SWITCH_TABLE$com$baidu$adp$lib$asyncTask$BdAsyncTask$BdAsyncTaskStatus;
        if (iArr == null) {
            iArr = new int[BdAsyncTaskStatus.valuesCustom().length];
            try {
                iArr[BdAsyncTaskStatus.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[BdAsyncTaskStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $SWITCH_TABLE$com$baidu$adp$lib$asyncTask$BdAsyncTask$BdAsyncTaskStatus = iArr;
        }
        return iArr;
    }

    public BdAsyncTask() {
        com.baidu.adp.lib.util.j.a();
        this.mWorker = new a(this);
        this.mFuture = new b(this, this.mWorker, this);
    }

    public int setPriority(int i) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i2 = this.mPriority;
        this.mPriority = i;
        return i2;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getTag() {
        return this.mTag;
    }

    public int setTag(BdUniqueId bdUniqueId) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i = this.mTag;
        if (bdUniqueId != null) {
            this.mTag = bdUniqueId.getId();
        }
        return i;
    }

    public String getKey() {
        return this.mKey;
    }

    public String setKey(String str) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.mKey;
        this.mKey = str;
        return str2;
    }

    public BdAsyncTaskParallel getParallel() {
        return this.mParallel;
    }

    public void setParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.mParallel = bdAsyncTaskParallel;
    }

    public boolean isSelfExecute() {
        return this.isSelfExecute;
    }

    public void setSelfExecute(boolean z) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.isSelfExecute = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTimeout(boolean z) {
        this.mIsTimeout = z;
    }

    public boolean isTimeout() {
        return this.mIsTimeout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result postResult(Result result) {
        if (this.mTaskInvoked.compareAndSet(false, true)) {
            sHandler.obtainMessage(1, new c(this, result)).sendToTarget();
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

    public final boolean cancel(boolean z) {
        com.baidu.adp.lib.util.j.a();
        if (!this.isSelfExecute) {
            sDefaultExecutor.a((BdAsyncTask<?, ?, ?>) this);
        }
        boolean cancel = this.mFuture.cancel(z);
        if (this.mPreCancelInvoked.compareAndSet(false, true)) {
            onPreCancel();
        }
        return cancel;
    }

    public final Result get() {
        return this.mFuture.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.mFuture.get(j, timeUnit);
    }

    public final BdAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        com.baidu.adp.lib.util.j.a();
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            switch ($SWITCH_TABLE$com$baidu$adp$lib$asyncTask$BdAsyncTask$BdAsyncTaskStatus()[this.mStatus.ordinal()]) {
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 3:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = BdAsyncTaskStatus.RUNNING;
        onPreExecute();
        this.mWorker.b = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void publishProgress(Progress... progressArr) {
        if (!isCancelled()) {
            sHandler.obtainMessage(2, new c(this, progressArr)).sendToTarget();
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

    public static void removeAllTask(BdUniqueId bdUniqueId) {
        sDefaultExecutor.a(bdUniqueId);
    }

    public static void removeAllTask(BdUniqueId bdUniqueId, String str) {
        sDefaultExecutor.a(bdUniqueId, str);
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        sDefaultExecutor.b(bdUniqueId);
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        sDefaultExecutor.b(bdUniqueId, str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return sDefaultExecutor.c(bdUniqueId);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        return sDefaultExecutor.c(bdUniqueId, str);
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        return sDefaultExecutor.a(str);
    }

    public static BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return sDefaultExecutor.b(str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        return sDefaultExecutor.d(bdUniqueId);
    }

    public static BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return sDefaultExecutor.c(str);
    }

    public static int getTaskNum(BdUniqueId bdUniqueId) {
        return getTaskNum(null, bdUniqueId);
    }

    public static int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return sDefaultExecutor.a(str, bdUniqueId);
    }
}
