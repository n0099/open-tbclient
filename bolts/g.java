package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes14.dex */
public class g<TResult> {
    private static volatile a CB;
    private Exception CC;
    private boolean CD;
    private i CE;
    private boolean cancelled;
    private boolean complete;
    private TResult result;
    public static final ExecutorService Cx = b.hB();
    private static final Executor Cy = b.hC();
    public static final Executor Cz = bolts.a.hz();
    private static g<?> CG = new g<>((Object) null);
    private static g<Boolean> CH = new g<>(true);
    private static g<Boolean> CI = new g<>(false);
    private static g<?> CJ = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> CF = new ArrayList();

    /* loaded from: classes14.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a hI() {
        return CB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        l(tresult);
    }

    private g(boolean z) {
        if (z) {
            hM();
        } else {
            l(null);
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

    public boolean hJ() {
        boolean z;
        synchronized (this.lock) {
            z = hK() != null;
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

    public Exception hK() {
        Exception exc;
        synchronized (this.lock) {
            if (this.CC != null) {
                this.CD = true;
                if (this.CE != null) {
                    this.CE.hP();
                    this.CE = null;
                }
            }
            exc = this.CC;
        }
        return exc;
    }

    public static <TResult> g<TResult> k(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) CG;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) CH : (g<TResult>) CI;
        }
        h hVar = new h();
        hVar.m(tresult);
        return hVar.hN();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.hN();
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
                    if (c.this != null && c.this.hF()) {
                        hVar.hO();
                        return;
                    }
                    try {
                        hVar.m(callable.call());
                    } catch (CancellationException e) {
                        hVar.hO();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
        return hVar.hN();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean isCompleted;
        final h hVar = new h();
        synchronized (this.lock) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.CF.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        return hVar.hN();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, Cy, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean isCompleted;
        final h hVar = new h();
        synchronized (this.lock) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.CF.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        return hVar.hN();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, Cy, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.hF()) {
                        hVar.hO();
                        return;
                    }
                    try {
                        hVar.m(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.hO();
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
                    if (c.this != null && c.this.hF()) {
                        hVar.hO();
                        return;
                    }
                    try {
                        g gVar2 = (g) fVar.a(gVar);
                        if (gVar2 == null) {
                            hVar.m(null);
                        } else {
                            gVar2.a(new f<TContinuationResult, Void>() { // from class: bolts.g.4.1
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: bolts.h */
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // bolts.f
                                /* renamed from: b */
                                public Void a(g<TContinuationResult> gVar3) {
                                    if (c.this != null && c.this.hF()) {
                                        hVar.hO();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.hO();
                                    } else if (gVar3.hJ()) {
                                        hVar.h(gVar3.hK());
                                    } else {
                                        hVar.m(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.hO();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void hL() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.CF) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.CF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hM() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                hL();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(TResult tresult) {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.result = tresult;
                this.lock.notifyAll();
                hL();
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
            this.CC = exc;
            this.CD = false;
            this.lock.notifyAll();
            hL();
            if (!this.CD && hI() != null) {
                this.CE = new i(this);
            }
            return true;
        }
    }
}
