package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class BdAsyncTask<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final g f406a = g.a();
    private static e b = new e(null);
    private volatile BdAsyncTaskStatus e = BdAsyncTaskStatus.PENDING;
    private int f = 1;
    private String g = null;
    private String h = null;
    private BdAsyncTaskType i = BdAsyncTaskType.MAX_PARALLEL;
    private boolean j = false;
    private final AtomicBoolean k = new AtomicBoolean();
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

    public static void removeAllTask(String str) {
        f406a.a(str);
    }

    public static void removeAllQueueTask(String str) {
        f406a.b(str);
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        return f406a.c(str);
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

    public String getTag() {
        return this.g;
    }

    public String setTag(String str) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.g;
        this.g = str;
        return str2;
    }

    public String getKey() {
        return this.h;
    }

    public String setKey(String str) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        String str2 = this.h;
        this.h = str;
        return str2;
    }

    public BdAsyncTaskType getType() {
        return this.i;
    }

    public void setType(BdAsyncTaskType bdAsyncTaskType) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.i = bdAsyncTaskType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result c(Result result) {
        synchronized (this) {
            if (this.k.get()) {
                result = null;
            } else {
                this.k.set(true);
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
        if (!this.j) {
            f406a.a((BdAsyncTask<?, ?, ?>) this);
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
        return executeOnExecutor(f406a, paramsArr);
    }

    public final BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            switch (c.f411a[this.e.ordinal()]) {
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
        return this.j;
    }

    public void setSelfExecute(boolean z) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            throw new IllegalStateException("the task is already running");
        }
        this.j = z;
    }
}
