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
abstract class e {
    private static final ThreadFactory a = new f();
    private static final BlockingQueue b = new LinkedBlockingQueue(10);
    public static final Executor d = new ThreadPoolExecutor(5, (int) DERTags.TAGGED, 1, TimeUnit.SECONDS, b, a);
    private static final k c = new k(null);
    private static volatile Executor e = d;
    private volatile l h = l.PENDING;
    private final AtomicBoolean i = new AtomicBoolean();
    private final m f = new g(this);
    private final FutureTask g = new h(this, this.f);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(Object... objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        if (!this.i.get()) {
            d(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object d(Object obj) {
        c.obtainMessage(1, new j(this, obj)).sendToTarget();
        return obj;
    }

    protected void b() {
    }

    protected void a(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object... objArr) {
    }

    protected void b(Object obj) {
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

    public final e a(Executor executor, Object... objArr) {
        if (this.h != l.PENDING) {
            switch (i.a[this.h.ordinal()]) {
                case 1:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case 2:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.h = l.RUNNING;
        b();
        this.f.b = objArr;
        executor.execute(this.g);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Object obj) {
        if (c()) {
            b(obj);
        } else {
            a(obj);
        }
        this.h = l.FINISHED;
    }
}
