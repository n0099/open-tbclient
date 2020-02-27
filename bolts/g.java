package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class g<TResult> {
    private static volatile a dj;
    private boolean cancelled;
    private boolean complete;
    private Exception dk;
    private boolean dl;

    /* renamed from: do  reason: not valid java name */
    private i f0do;
    private TResult result;
    public static final ExecutorService dg = b.aO();
    private static final Executor dh = b.aP();
    public static final Executor di = bolts.a.aM();
    private static g<?> dq = new g<>((Object) null);
    private static g<Boolean> dr = new g<>(true);
    private static g<Boolean> du = new g<>(false);
    private static g<?> dv = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> dp = new ArrayList();

    /* loaded from: classes7.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a aV() {
        return dj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        k(tresult);
    }

    private g(boolean z) {
        if (z) {
            ba();
        } else {
            k(null);
        }
    }

    public boolean aW() {
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

    public boolean aX() {
        boolean z;
        synchronized (this.lock) {
            z = aY() != null;
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

    public Exception aY() {
        Exception exc;
        synchronized (this.lock) {
            if (this.dk != null) {
                this.dl = true;
                if (this.f0do != null) {
                    this.f0do.bd();
                    this.f0do = null;
                }
            }
            exc = this.dk;
        }
        return exc;
    }

    public static <TResult> g<TResult> j(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) dq;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) dr : (g<TResult>) du;
        }
        h hVar = new h();
        hVar.l(tresult);
        return hVar.bb();
    }

    public static <TResult> g<TResult> e(Exception exc) {
        h hVar = new h();
        hVar.g(exc);
        return hVar.bb();
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
                    if (c.this != null && c.this.aS()) {
                        hVar.bc();
                        return;
                    }
                    try {
                        hVar.l(callable.call());
                    } catch (CancellationException e) {
                        hVar.bc();
                    } catch (Exception e2) {
                        hVar.g(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.g(new ExecutorException(e));
        }
        return hVar.bb();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean aW;
        final h hVar = new h();
        synchronized (this.lock) {
            aW = aW();
            if (!aW) {
                this.dp.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        if (aW) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.bb();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, dh, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean aW;
        final h hVar = new h();
        synchronized (this.lock) {
            aW = aW();
            if (!aW) {
                this.dp.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        if (aW) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.bb();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, dh, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.aS()) {
                        hVar.bc();
                        return;
                    }
                    try {
                        hVar.l(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.bc();
                    } catch (Exception e2) {
                        hVar.g(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.g(new ExecutorException(e));
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
                    if (c.this != null && c.this.aS()) {
                        hVar.bc();
                        return;
                    }
                    try {
                        g gVar2 = (g) fVar.a(gVar);
                        if (gVar2 == null) {
                            hVar.l(null);
                        } else {
                            gVar2.a(new f<TContinuationResult, Void>() { // from class: bolts.g.4.1
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: bolts.h */
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // bolts.f
                                /* renamed from: b */
                                public Void a(g<TContinuationResult> gVar3) {
                                    if (c.this != null && c.this.aS()) {
                                        hVar.bc();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.bc();
                                    } else if (gVar3.aX()) {
                                        hVar.g(gVar3.aY());
                                    } else {
                                        hVar.l(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.bc();
                    } catch (Exception e2) {
                        hVar.g(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.g(new ExecutorException(e));
        }
    }

    private void aZ() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.dp) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.dp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ba() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                aZ();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(TResult tresult) {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.result = tresult;
                this.lock.notifyAll();
                aZ();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(Exception exc) {
        synchronized (this.lock) {
            if (this.complete) {
                return false;
            }
            this.complete = true;
            this.dk = exc;
            this.dl = false;
            this.lock.notifyAll();
            aZ();
            if (!this.dl && aV() != null) {
                this.f0do = new i(this);
            }
            return true;
        }
    }
}
