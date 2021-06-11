package com.baidu.live.asynctask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public abstract class BdAsyncTask<ParamsT, ProgressT, ResultT> {
    public static final d.a.v.a.a k = d.a.v.a.a.e();
    public static final e l = new e(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f6416c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f6417d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public volatile BdAsyncTaskStatus f6418e = BdAsyncTaskStatus.PENDING;

    /* renamed from: f  reason: collision with root package name */
    public int f6419f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f6420g = 0;

    /* renamed from: h  reason: collision with root package name */
    public d.a.v.a.c f6421h = null;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6422i = false;
    public boolean j = false;

    /* renamed from: a  reason: collision with root package name */
    public final f<ParamsT, ResultT> f6414a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final d.a.v.a.b<ResultT> f6415b = new b(this.f6414a, this);

    /* loaded from: classes2.dex */
    public enum BdAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes2.dex */
    public class a extends f<ParamsT, ResultT> {
        public a() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public ResultT call() throws Exception {
            if (BdAsyncTask.this.f6415b.isCancelled()) {
                return (ResultT) BdAsyncTask.this.u(null);
            }
            BdAsyncTask bdAsyncTask = BdAsyncTask.this;
            return (ResultT) bdAsyncTask.u(bdAsyncTask.f(this.f6428e));
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.v.a.b<ResultT> {
        public b(Callable callable, BdAsyncTask bdAsyncTask) {
            super(callable, bdAsyncTask);
        }

        @Override // d.a.v.a.b
        public void b() {
            BdAsyncTask.this.d();
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                BdAsyncTask.this.u(get());
            } catch (InterruptedException unused) {
            } catch (CancellationException unused2) {
                BdAsyncTask.this.u(null);
            } catch (ExecutionException e2) {
                BdAsyncTask.this.u(null);
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6425a;

        static {
            int[] iArr = new int[BdAsyncTaskStatus.values().length];
            f6425a = iArr;
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6425a[BdAsyncTaskStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d<DataT> {

        /* renamed from: a  reason: collision with root package name */
        public final BdAsyncTask f6426a;

        /* renamed from: b  reason: collision with root package name */
        public final DataT[] f6427b;

        public d(BdAsyncTask bdAsyncTask, DataT... datatArr) {
            this.f6426a = bdAsyncTask;
            this.f6427b = datatArr;
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                dVar.f6426a.i(dVar.f6427b[0]);
            } else if (i2 != 2) {
            } else {
                dVar.f6426a.t(dVar.f6427b);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class f<ParamsT, ResultT> implements Callable<ResultT> {

        /* renamed from: e  reason: collision with root package name */
        public ParamsT[] f6428e;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public void d() {
        e(true);
    }

    public final synchronized boolean e(boolean z) {
        boolean cancel;
        if (!this.f6422i) {
            k.h(this);
        }
        cancel = this.f6415b.cancel(z);
        if (this.f6417d.compareAndSet(false, true)) {
            r();
        }
        return cancel;
    }

    public abstract ResultT f(ParamsT... paramstArr);

    public final BdAsyncTask<ParamsT, ProgressT, ResultT> g(ParamsT... paramstArr) {
        h(k, paramstArr);
        return this;
    }

    public final synchronized BdAsyncTask<ParamsT, ProgressT, ResultT> h(Executor executor, ParamsT... paramstArr) {
        if (this.f6418e != BdAsyncTaskStatus.PENDING) {
            int i2 = c.f6425a[this.f6418e.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f6418e = BdAsyncTaskStatus.RUNNING;
        s();
        this.f6414a.f6428e = paramstArr;
        executor.execute(this.f6415b);
        return this;
    }

    public final void i(ResultT resultt) {
        if (l()) {
            p(resultt);
        } else {
            q(resultt);
        }
        this.f6418e = BdAsyncTaskStatus.FINISHED;
    }

    public d.a.v.a.c j() {
        return this.f6421h;
    }

    public int k() {
        return this.f6419f;
    }

    public final boolean l() {
        return this.f6415b.isCancelled();
    }

    public boolean m() {
        return this.f6422i;
    }

    public boolean n() {
        return this.j;
    }

    public void o() {
    }

    public void p(ResultT resultt) {
        o();
    }

    public abstract void q(ResultT resultt);

    public void r() {
    }

    public void s() {
    }

    public void t(ProgressT... progresstArr) {
    }

    public final ResultT u(ResultT resultt) {
        if (this.f6416c.compareAndSet(false, true)) {
            l.obtainMessage(1, new d(this, resultt)).sendToTarget();
            return resultt;
        }
        return null;
    }

    public synchronized void v(d.a.v.a.c cVar) {
        if (this.f6418e == BdAsyncTaskStatus.PENDING) {
            this.f6421h = cVar;
        } else {
            throw new IllegalStateException("the task is already running");
        }
    }

    public synchronized int w(int i2) {
        int i3;
        if (this.f6418e == BdAsyncTaskStatus.PENDING) {
            i3 = this.f6419f;
            this.f6419f = i2;
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return i3;
    }

    public synchronized int x(d.a.v.e.b bVar) {
        int i2;
        if (this.f6418e == BdAsyncTaskStatus.PENDING) {
            i2 = this.f6420g;
            if (bVar != null) {
                this.f6420g = bVar.b();
            }
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return i2;
    }

    public synchronized void y(boolean z) {
        this.j = z;
    }
}
