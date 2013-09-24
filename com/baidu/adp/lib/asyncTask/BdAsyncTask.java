package com.baidu.adp.lib.asyncTask;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class BdAsyncTask<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final f f356a = f.a();
    private static d b = new d(null);
    private static /* synthetic */ int[] l;
    private volatile BdAsyncTaskStatus e = BdAsyncTaskStatus.PENDING;
    private int f = 1;
    private String g = null;
    private String h = null;
    private BdAsyncTaskType i = BdAsyncTaskType.MAX_PARALLEL;
    private boolean j = false;
    private final AtomicBoolean k = new AtomicBoolean();
    private final e<Params, Result> c = new a(this);
    private final l<Result> d = new b(this, this.c, this);

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
    public abstract Result a(Params... paramsArr);

    static /* synthetic */ int[] d() {
        int[] iArr = l;
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
            l = iArr;
        }
        return iArr;
    }

    public static void updateInternalHandler() {
        b = new d(null);
    }

    public static void removeAllTask(String str) {
        f356a.a(str);
    }

    public static void removeAllQueueTask(String str) {
        f356a.b(str);
    }

    public static BdAsyncTask<?, ?, ?> searchTask(String str) {
        return f356a.c(str);
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
                return null;
            }
            this.k.set(true);
            b.obtainMessage(1, new c(this, result)).sendToTarget();
            return result;
        }
    }

    public final BdAsyncTaskStatus getStatus() {
        return this.e;
    }

    public void cancel() {
        cancel(true);
    }

    protected void a() {
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
            f356a.a((BdAsyncTask<?, ?, ?>) this);
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
        return executeOnExecutor(f356a, paramsArr);
    }

    public final BdAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            switch (d()[this.e.ordinal()]) {
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 3:
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
            b.obtainMessage(2, new c(this, progressArr)).sendToTarget();
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
