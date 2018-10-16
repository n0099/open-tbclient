package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class g<TResult> {
    private static volatile a jU;
    private boolean cancelled;
    private boolean complete;
    private Exception jV;
    private boolean jW;
    private i jX;
    private TResult result;
    public static final ExecutorService jR = b.aX();
    private static final Executor jS = b.aY();
    public static final Executor jT = bolts.a.aV();
    private static g<?> jZ = new g<>((Object) null);
    private static g<Boolean> kb = new g<>(true);
    private static g<Boolean> kc = new g<>(false);
    private static g<?> kd = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> jY = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a be() {
        return jU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        g((g<TResult>) tresult);
    }

    private g(boolean z) {
        if (z) {
            bi();
        } else {
            g((g<TResult>) null);
        }
    }

    public boolean isCompleted() {
        boolean z;
        synchronized (this.lock) {
            z = this.complete;
        }
        return z;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.lock) {
            z = this.cancelled;
        }
        return z;
    }

    public boolean bf() {
        boolean z;
        synchronized (this.lock) {
            z = bg() != null;
        }
        return z;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.lock) {
            tresult = this.result;
        }
        return tresult;
    }

    public Exception bg() {
        Exception exc;
        synchronized (this.lock) {
            if (this.jV != null) {
                this.jW = true;
                if (this.jX != null) {
                    this.jX.bl();
                    this.jX = null;
                }
            }
            exc = this.jV;
        }
        return exc;
    }

    public static <TResult> g<TResult> f(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) jZ;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) kb : (g<TResult>) kc;
        }
        h hVar = new h();
        hVar.h((h) tresult);
        return hVar.bj();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.bj();
    }

    public static <TResult> g<TResult> a(Callable<TResult> callable, Executor executor) {
        return a(callable, executor, (c) null);
    }

    public static <TResult> g<TResult> a(final Callable<TResult> callable, Executor executor, final c cVar) {
        final h hVar = new h();
        try {
            executor.execute(new Runnable() { // from class: bolts.g.5
                /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.bb()) {
                        hVar.bk();
                        return;
                    }
                    try {
                        hVar.h((h) callable.call());
                    } catch (CancellationException e) {
                        hVar.bk();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h((Exception) new ExecutorException(e));
        }
        return hVar.bj();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean isCompleted;
        final h hVar = new h();
        synchronized (this.lock) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.jY.add(new f<TResult, Void>() { // from class: bolts.g.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // bolts.f
                    /* renamed from: b */
                    public Void a(g<TResult> gVar) {
                        g.a(hVar, fVar, gVar, executor, cVar);
                        return null;
                    }
                });
            }
        }
        if (isCompleted) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.bj();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, jS, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean isCompleted;
        final h hVar = new h();
        synchronized (this.lock) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.jY.add(new f<TResult, Void>() { // from class: bolts.g.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // bolts.f
                    /* renamed from: b */
                    public Void a(g<TResult> gVar) {
                        g.b(hVar, fVar, gVar, executor, cVar);
                        return null;
                    }
                });
            }
        }
        if (isCompleted) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.bj();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, jS, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.bb()) {
                        hVar.bk();
                        return;
                    }
                    try {
                        hVar.h((h) fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.bk();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void b(final h<TContinuationResult> hVar, final f<TResult, g<TContinuationResult>> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.4
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:18:0x0011). Please submit an issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:18:0x0011). Please submit an issue!!! */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.bb()) {
                        hVar.bk();
                        return;
                    }
                    try {
                        g gVar2 = (g) fVar.a(gVar);
                        if (gVar2 == null) {
                            hVar.h((h) null);
                        } else {
                            gVar2.a(new f<TContinuationResult, Void>() { // from class: bolts.g.4.1
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: bolts.h */
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // bolts.f
                                /* renamed from: b */
                                public Void a(g<TContinuationResult> gVar3) {
                                    if (c.this != null && c.this.bb()) {
                                        hVar.bk();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.bk();
                                    } else if (gVar3.bf()) {
                                        hVar.h(gVar3.bg());
                                    } else {
                                        hVar.h((h) gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.bk();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void bh() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.jY) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.jY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bi() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                bh();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(TResult tresult) {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.result = tresult;
                this.lock.notifyAll();
                bh();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(Exception exc) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.jV = exc;
            this.jW = false;
            this.lock.notifyAll();
            bh();
            if (!this.jW && be() != null) {
                this.jX = new i(this);
            }
            return true;
        }
    }
}
