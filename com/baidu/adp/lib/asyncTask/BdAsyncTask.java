package com.baidu.adp.lib.asyncTask;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class BdAsyncTask<Params, Progress, Result> {
    private static final g a = g.a();
    private static e b = new e(null);
    private volatile BdAsyncTaskStatus e = BdAsyncTaskStatus.PENDING;
    private int f = 1;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private BdAsyncTaskParallelType j = BdAsyncTaskParallelType.MAX_PARALLEL;
    private boolean k = false;
    private final AtomicBoolean l = new AtomicBoolean();
    private final f<Params, Result> c = new a(this);
    private final m<Result> d = new b(this, this.c, this);

    /* loaded from: classes.dex */
    public enum BdAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    public static void updateInternalHandler() {
        b = new e(null);
    }

    public static void removeAllTask(int i) {
        a.a(i);
    }

    public static void removeAllTask(int i, String str) {
        a.a(i, str);
    }

    public static void removeAllQueueTask(int i) {
        a.b(i);
    }

    public static void removeAllQueueTask(int i, String str) {
        a.b(i, str);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(int i) {
        return a.c(i);
    }

    public static LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask(int i, String str) {
        return a.c(i, str);
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        return a.a(str);
    }

    public static BdAsyncTask<?, ?, ?> searchWaitingTask(String str) {
        return a.b(str);
    }

    public static BdAsyncTask<?, ?, ?> searchActivTask(String str) {
        return a.c(str);
    }

    public int setPriority(int i) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i2 = this.f;
        this.f = i;
        return i2;
    }

    public int getPriority() {
        return this.f;
    }

    public int getTag() {
        return this.g;
    }

    public int setTag(int i) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        int i2 = this.g;
        this.g = i;
        return i2;
    }

    public String getKey() {
        return this.i;
    }

    public String setKey(String str) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.i;
        this.i = str;
        return str2;
    }

    public BdAsyncTaskParallelType getType() {
        return this.j;
    }

    public void setType(BdAsyncTaskParallelType bdAsyncTaskParallelType) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        if (this.h == 0) {
            throw new IllegalStateException("ParallelTag hasn't setted!");
        }
        this.j = bdAsyncTaskParallelType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result c(Result result) {
        synchronized (this) {
            if (this.l.get()) {
                result = null;
            } else {
                this.l.set(true);
                b.obtainMessage(1, new d(this, result)).sendToTarget();
            }
        }
        return result;
    }

    public final BdAsyncTaskStatus getStatus() {
        return this.e;
    }

    public void cancel() {
        cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    protected void b(Result result) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
    }

    public final boolean isCancelled() {
        return this.d.isCancelled();
    }

    public final boolean cancel(boolean z) {
        if (!this.k) {
            a.a((BdAsyncTask<?, ?, ?>) this);
        }
        boolean cancel = this.d.cancel(z);
        a();
        return cancel;
    }

    public final Result get() {
        return this.d.get();
    }

    public final Result get(long j, TimeUnit timeUnit) {
        return this.d.get(j, timeUnit);
    }

    public final BdAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(a, paramsArr);
    }

    public final BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            switch (c.a[this.e.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.e = BdAsyncTaskStatus.RUNNING;
        b();
        this.c.b = paramsArr;
        executor.execute(this.d);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Progress... progressArr) {
        if (!isCancelled()) {
            b.obtainMessage(2, new d(this, progressArr)).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Result result) {
        if (isCancelled()) {
            b((BdAsyncTask<Params, Progress, Result>) result);
        } else {
            a((BdAsyncTask<Params, Progress, Result>) result);
        }
        this.e = BdAsyncTaskStatus.FINISHED;
    }

    public boolean isSelfExecute() {
        return this.k;
    }

    public void setSelfExecute(boolean z) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.k = z;
    }

    public void setImmediatelyExecut(boolean z) {
        this.f = 4;
    }

    public boolean isImmediatelyExecut() {
        return this.f == 4;
    }

    public int getParallelTag() {
        return this.h;
    }

    public void setParallelTag(int i) {
        this.h = i;
    }
}
