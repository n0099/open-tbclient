package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import java.io.IOException;
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
    public static final int MESSAGE_POST_PROGRESS = 2;
    public static final int MESSAGE_POST_RESULT = 1;
    public static final d.b.c.e.c.a sDefaultExecutor = d.b.c.e.c.a.e();
    public static final e sHandler = new e(Looper.getMainLooper());
    public volatile BdAsyncTaskStatus mStatus = BdAsyncTaskStatus.PENDING;
    public int mPriority = 1;
    public int mTag = 0;
    public String mKey = null;
    public BdAsyncTaskParallel mParallel = null;
    public boolean isSelfExecute = false;
    public final AtomicBoolean mTaskInvoked = new AtomicBoolean(false);
    public final AtomicBoolean mPreCancelInvoked = new AtomicBoolean(false);
    public boolean mIsTimeout = false;
    public final f<Params, Result> mWorker = new a();
    public final d.b.c.e.c.b<Result> mFuture = new b(this.mWorker, this);

    /* loaded from: classes.dex */
    public enum BdAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes.dex */
    public class a extends f<Params, Result> {
        public a() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            if (BdAsyncTask.this.mFuture.isCancelled()) {
                return (Result) BdAsyncTask.this.postResult(null);
            }
            BdAsyncTask bdAsyncTask = BdAsyncTask.this;
            return (Result) bdAsyncTask.postResult(bdAsyncTask.doInBackground(this.f2182e));
        }
    }

    /* loaded from: classes.dex */
    public class b extends d.b.c.e.c.b<Result> {
        public b(Callable callable, BdAsyncTask bdAsyncTask) {
            super(callable, bdAsyncTask);
        }

        @Override // d.b.c.e.c.b
        public void b() {
            BdAsyncTask.this.cancel();
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                BdAsyncTask.this.postResult(get());
            } catch (InterruptedException unused) {
            } catch (CancellationException unused2) {
                BdAsyncTask.this.postResult(null);
            } catch (ExecutionException e2) {
                BdAsyncTask.this.postResult(null);
                if (BdBaseApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e2);
                }
            } catch (Throwable th) {
                throw new RuntimeException("An error occured while executing doInBackground()", th);
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2179a;

        static {
            int[] iArr = new int[BdAsyncTaskStatus.values().length];
            f2179a = iArr;
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2179a[BdAsyncTaskStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final BdAsyncTask f2180a;

        /* renamed from: b  reason: collision with root package name */
        public final Data[] f2181b;

        public d(BdAsyncTask bdAsyncTask, Data... dataArr) {
            this.f2180a = bdAsyncTask;
            this.f2181b = dataArr;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i = message.what;
            if (i == 1) {
                dVar.f2180a.finish(dVar.f2181b[0]);
            } else if (i != 2) {
            } else {
                dVar.f2180a.onProgressUpdate(dVar.f2181b);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f<Params, Result> implements Callable<Result> {

        /* renamed from: e  reason: collision with root package name */
        public Params[] f2182e;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
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

    public static int getTaskNum(BdUniqueId bdUniqueId) {
        return getTaskNum(null, bdUniqueId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result postResult(Result result) {
        if (this.mTaskInvoked.compareAndSet(false, true)) {
            sHandler.obtainMessage(1, new d(this, result)).sendToTarget();
            return result;
        }
        return null;
    }

    public static void removeAllTask(BdUniqueId bdUniqueId) {
        sDefaultExecutor.i(bdUniqueId);
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId) {
        sDefaultExecutor.k(bdUniqueId);
    }

    public static BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return sDefaultExecutor.q(str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId) {
        return sDefaultExecutor.r(bdUniqueId);
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        return sDefaultExecutor.u(str);
    }

    public static BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return sDefaultExecutor.w(str);
    }

    public void cancel() {
        cancel(true);
    }

    public abstract Result doInBackground(Params... paramsArr) throws IOException;

    public final BdAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(sDefaultExecutor, paramsArr);
    }

    public final synchronized BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.mStatus != BdAsyncTaskStatus.PENDING) {
            int i = c.f2179a[this.mStatus.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.mStatus = BdAsyncTaskStatus.RUNNING;
        onPreExecute();
        this.mWorker.f2182e = paramsArr;
        executor.execute(this.mFuture);
        return this;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public String getKey() {
        return this.mKey;
    }

    public BdAsyncTaskParallel getParallel() {
        return this.mParallel;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public final BdAsyncTaskStatus getStatus() {
        return this.mStatus;
    }

    public int getTag() {
        return this.mTag;
    }

    public final boolean isCancelled() {
        return this.mFuture.isCancelled();
    }

    public boolean isSelfExecute() {
        return this.isSelfExecute;
    }

    public boolean isTimeout() {
        return this.mIsTimeout;
    }

    public void onCancelled() {
    }

    public void onCancelled(Result result) {
        onCancelled();
    }

    public void onPostExecute(Result result) {
    }

    public void onPreCancel() {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... progressArr) {
    }

    public final void publishProgress(Progress... progressArr) {
        if (isCancelled()) {
            return;
        }
        sHandler.obtainMessage(2, new d(this, progressArr)).sendToTarget();
    }

    public synchronized String setKey(String str) {
        String str2;
        if (this.mStatus == BdAsyncTaskStatus.PENDING) {
            str2 = this.mKey;
            this.mKey = str;
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return str2;
    }

    public synchronized void setParallel(BdAsyncTaskParallel bdAsyncTaskParallel) {
        if (this.mStatus == BdAsyncTaskStatus.PENDING) {
            this.mParallel = bdAsyncTaskParallel;
        } else {
            throw new IllegalStateException("the task is already running");
        }
    }

    public synchronized int setPriority(int i) {
        int i2;
        if (this.mStatus == BdAsyncTaskStatus.PENDING) {
            i2 = this.mPriority;
            this.mPriority = i;
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return i2;
    }

    public synchronized void setSelfExecute(boolean z) {
        if (this.mStatus == BdAsyncTaskStatus.PENDING) {
            this.isSelfExecute = z;
        } else {
            throw new IllegalStateException("the task is already running");
        }
    }

    public synchronized int setTag(BdUniqueId bdUniqueId) {
        int i;
        if (this.mStatus == BdAsyncTaskStatus.PENDING) {
            i = this.mTag;
            if (bdUniqueId != null) {
                this.mTag = bdUniqueId.getId();
            }
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return i;
    }

    public synchronized void setTimeout(boolean z) {
        this.mIsTimeout = z;
    }

    public static int getTaskNum(String str, BdUniqueId bdUniqueId) {
        return sDefaultExecutor.g(str, bdUniqueId);
    }

    public static void removeAllTask(BdUniqueId bdUniqueId, String str) {
        sDefaultExecutor.j(bdUniqueId, str);
    }

    public static void removeAllWaitingTask(BdUniqueId bdUniqueId, String str) {
        sDefaultExecutor.l(bdUniqueId, str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(BdUniqueId bdUniqueId, String str) {
        return sDefaultExecutor.s(bdUniqueId, str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask(BdUniqueId bdUniqueId) {
        return sDefaultExecutor.x(bdUniqueId);
    }

    public final synchronized boolean cancel(boolean z) {
        boolean cancel;
        if (!this.isSelfExecute) {
            sDefaultExecutor.o(this);
        }
        cancel = this.mFuture.cancel(z);
        if (this.mPreCancelInvoked.compareAndSet(false, true)) {
            onPreCancel();
        }
        return cancel;
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(j, timeUnit);
    }
}
