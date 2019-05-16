package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class g<TResult> {
    private static volatile a jY;
    private boolean cancelled;
    private boolean complete;
    private Exception jZ;
    private boolean kb;
    private i kc;
    private TResult result;
    public static final ExecutorService jV = b.aX();
    private static final Executor jW = b.aY();
    public static final Executor jX = bolts.a.aV();
    private static g<?> ke = new g<>((Object) null);
    private static g<Boolean> kf = new g<>(true);
    private static g<Boolean> kg = new g<>(false);
    private static g<?> kh = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> kd = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a be() {
        return jY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        h(tresult);
    }

    private g(boolean z) {
        if (z) {
            bi();
        } else {
            h(null);
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
            if (this.jZ != null) {
                this.kb = true;
                if (this.kc != null) {
                    this.kc.bl();
                    this.kc = null;
                }
            }
            exc = this.jZ;
        }
        return exc;
    }

    public static <TResult> g<TResult> g(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) ke;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) kf : (g<TResult>) kg;
        }
        h hVar = new h();
        hVar.i(tresult);
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
                        hVar.i(callable.call());
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
                this.kd.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        return a(fVar, jW, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean isCompleted;
        final h hVar = new h();
        synchronized (this.lock) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.kd.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        return b(fVar, jW, null);
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
                        hVar.i(fVar.a(gVar));
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
                            hVar.i(null);
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
                                        hVar.i(gVar3.getResult());
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
            for (f<TResult, Void> fVar : this.kd) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.kd = null;
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
    public boolean h(TResult tresult) {
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
            this.jZ = exc;
            this.kb = false;
            this.lock.notifyAll();
            bh();
            if (!this.kb && be() != null) {
                this.kc = new i(this);
            }
            return true;
        }
    }
}
