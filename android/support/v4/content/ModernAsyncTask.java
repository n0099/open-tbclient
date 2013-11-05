package android.support.v4.content;

import com.baidu.zeus.bouncycastle.DERTags;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadFactory f308a = new j();
    private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue(10);
    public static final Executor d = new ThreadPoolExecutor(5, (int) DERTags.TAGGED, 1, TimeUnit.SECONDS, b, f308a);
    private static final o c = new o(null);
    private static volatile Executor e = d;
    private volatile Status h = Status.PENDING;
    private final AtomicBoolean i = new AtomicBoolean();
    private final p<Params, Result> f = new k(this);
    private final FutureTask<Result> g = new l(this, this.f);

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Result a(Params... paramsArr);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Result result) {
        if (!this.i.get()) {
            d(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Result d(Result result) {
        c.obtainMessage(1, new n(this, result)).sendToTarget();
        return result;
    }

    protected void b() {
    }

    protected void a(Result result) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    protected void b(Result result) {
        a();
    }

    protected void a() {
    }

    public final boolean c() {
        return this.g.isCancelled();
    }

    public final boolean a(boolean z) {
        return this.g.cancel(z);
    }

    public final ModernAsyncTask<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.h != Status.PENDING) {
            switch (m.f319a[this.h.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.h = Status.RUNNING;
        b();
        this.f.b = paramsArr;
        executor.execute(this.g);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Result result) {
        if (c()) {
            b((ModernAsyncTask<Params, Progress, Result>) result);
        } else {
            a((ModernAsyncTask<Params, Progress, Result>) result);
        }
        this.h = Status.FINISHED;
    }
}
