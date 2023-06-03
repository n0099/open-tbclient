package com.baidu.live.asynctask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.tieba.ee0;
import com.baidu.tieba.wa0;
import com.baidu.tieba.xa0;
import com.baidu.tieba.ya0;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public abstract class BdAsyncTask<ParamsT, ProgressT, ResultT> {
    public static final wa0 k = wa0.e();
    public static final e l = new e(Looper.getMainLooper());
    public final AtomicBoolean c = new AtomicBoolean(false);
    public final AtomicBoolean d = new AtomicBoolean(false);
    public volatile BdAsyncTaskStatus e = BdAsyncTaskStatus.PENDING;
    public int f = 1;
    public int g = 0;
    public ya0 h = null;
    public boolean i = false;
    public boolean j = false;
    public final f<ParamsT, ResultT> a = new a();
    public final xa0<ResultT> b = new b(this.a, this);

    /* loaded from: classes3.dex */
    public enum BdAsyncTaskStatus {
        PENDING,
        RUNNING,
        FINISHED
    }

    public abstract ResultT f(ParamsT... paramstArr);

    public void o() {
    }

    public abstract void q(ResultT resultt);

    public void r() {
    }

    public void s() {
    }

    public void t(ProgressT... progresstArr) {
    }

    /* loaded from: classes3.dex */
    public class a extends f<ParamsT, ResultT> {
        public a() {
            super(null);
        }

        @Override // java.util.concurrent.Callable
        public ResultT call() throws Exception {
            if (!BdAsyncTask.this.b.isCancelled()) {
                BdAsyncTask bdAsyncTask = BdAsyncTask.this;
                return (ResultT) bdAsyncTask.u(bdAsyncTask.f(this.a));
            }
            return (ResultT) BdAsyncTask.this.u(null);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends xa0<ResultT> {
        public b(Callable callable, BdAsyncTask bdAsyncTask) {
            super(callable, bdAsyncTask);
        }

        @Override // com.baidu.tieba.xa0
        public void a() {
            BdAsyncTask.this.d();
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                BdAsyncTask.this.u(get());
            } catch (InterruptedException unused) {
            } catch (CancellationException unused2) {
                BdAsyncTask.this.u(null);
            } catch (ExecutionException e) {
                BdAsyncTask.this.u(null);
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BdAsyncTaskStatus.values().length];
            a = iArr;
            try {
                iArr[BdAsyncTaskStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BdAsyncTaskStatus.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d<DataT> {
        public final BdAsyncTask a;
        public final DataT[] b;

        public d(BdAsyncTask bdAsyncTask, DataT... datatArr) {
            this.a = bdAsyncTask;
            this.b = datatArr;
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) message.obj;
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    dVar.a.t(dVar.b);
                    return;
                }
                return;
            }
            dVar.a.i(dVar.b[0]);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f<ParamsT, ResultT> implements Callable<ResultT> {
        public ParamsT[] a;

        public f() {
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public void d() {
        e(true);
    }

    public ya0 j() {
        return this.h;
    }

    public int k() {
        return this.f;
    }

    public final boolean l() {
        return this.b.isCancelled();
    }

    public boolean m() {
        return this.i;
    }

    public boolean n() {
        return this.j;
    }

    public final synchronized boolean e(boolean z) {
        boolean cancel;
        if (!this.i) {
            k.h(this);
        }
        cancel = this.b.cancel(z);
        if (this.d.compareAndSet(false, true)) {
            r();
        }
        return cancel;
    }

    public final BdAsyncTask<ParamsT, ProgressT, ResultT> g(ParamsT... paramstArr) {
        h(k, paramstArr);
        return this;
    }

    public final void i(ResultT resultt) {
        if (l()) {
            p(resultt);
        } else {
            q(resultt);
        }
        this.e = BdAsyncTaskStatus.FINISHED;
    }

    public void p(ResultT resultt) {
        o();
    }

    public final ResultT u(ResultT resultt) {
        if (this.c.compareAndSet(false, true)) {
            l.obtainMessage(1, new d(this, resultt)).sendToTarget();
            return resultt;
        }
        return null;
    }

    public synchronized void v(ya0 ya0Var) {
        if (this.e == BdAsyncTaskStatus.PENDING) {
            this.h = ya0Var;
        } else {
            throw new IllegalStateException("the task is already running");
        }
    }

    public synchronized int w(int i) {
        int i2;
        if (this.e == BdAsyncTaskStatus.PENDING) {
            i2 = this.f;
            this.f = i;
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return i2;
    }

    public synchronized int x(ee0 ee0Var) {
        int i;
        if (this.e == BdAsyncTaskStatus.PENDING) {
            i = this.g;
            if (ee0Var != null) {
                this.g = ee0Var.b();
            }
        } else {
            throw new IllegalStateException("the task is already running");
        }
        return i;
    }

    public synchronized void y(boolean z) {
        this.j = z;
    }

    public final synchronized BdAsyncTask<ParamsT, ProgressT, ResultT> h(Executor executor, ParamsT... paramstArr) {
        if (this.e != BdAsyncTaskStatus.PENDING) {
            int i = c.a[this.e.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
                }
            } else {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
        }
        this.e = BdAsyncTaskStatus.RUNNING;
        s();
        this.a.a = paramstArr;
        executor.execute(this.b);
        return this;
    }
}
