package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class g<TResult> {
    private static volatile a cI;
    private Exception cJ;
    private boolean cK;
    private i cL;
    private boolean cancelled;
    private boolean complete;
    private TResult result;
    public static final ExecutorService cF = b.aC();
    private static final Executor cG = b.aD();
    public static final Executor cH = bolts.a.aA();
    private static g<?> cN = new g<>((Object) null);
    private static g<Boolean> cO = new g<>(true);
    private static g<Boolean> cP = new g<>(false);
    private static g<?> cQ = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> cM = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a aJ() {
        return cI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        h(tresult);
    }

    private g(boolean z) {
        if (z) {
            aO();
        } else {
            h(null);
        }
    }

    public boolean aK() {
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

    public boolean aL() {
        boolean z;
        synchronized (this.lock) {
            z = aM() != null;
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

    public Exception aM() {
        Exception exc;
        synchronized (this.lock) {
            if (this.cJ != null) {
                this.cK = true;
                if (this.cL != null) {
                    this.cL.aR();
                    this.cL = null;
                }
            }
            exc = this.cJ;
        }
        return exc;
    }

    public static <TResult> g<TResult> g(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) cN;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) cO : (g<TResult>) cP;
        }
        h hVar = new h();
        hVar.i(tresult);
        return hVar.aP();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.aP();
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
                    if (c.this != null && c.this.aG()) {
                        hVar.aQ();
                        return;
                    }
                    try {
                        hVar.i(callable.call());
                    } catch (CancellationException e) {
                        hVar.aQ();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h((Exception) new ExecutorException(e));
        }
        return hVar.aP();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean aK;
        final h hVar = new h();
        synchronized (this.lock) {
            aK = aK();
            if (!aK) {
                this.cM.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        if (aK) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.aP();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, cG, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean aK;
        final h hVar = new h();
        synchronized (this.lock) {
            aK = aK();
            if (!aK) {
                this.cM.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        if (aK) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.aP();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, cG, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.aG()) {
                        hVar.aQ();
                        return;
                    }
                    try {
                        hVar.i(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.aQ();
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
                    if (c.this != null && c.this.aG()) {
                        hVar.aQ();
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
                                    if (c.this != null && c.this.aG()) {
                                        hVar.aQ();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.aQ();
                                    } else if (gVar3.aL()) {
                                        hVar.h(gVar3.aM());
                                    } else {
                                        hVar.i(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.aQ();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void aN() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.cM) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.cM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean aO() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                aN();
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
                aN();
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
            this.cJ = exc;
            this.cK = false;
            this.lock.notifyAll();
            aN();
            if (!this.cK && aJ() != null) {
                this.cL = new i(this);
            }
            return true;
        }
    }
}
