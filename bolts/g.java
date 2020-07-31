package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes19.dex */
public class g<TResult> {
    private static volatile a zC;
    private boolean cancelled;
    private boolean complete;
    private TResult result;
    private Exception zD;
    private boolean zE;
    private i zF;
    public static final ExecutorService zz = b.gB();
    private static final Executor zA = b.gC();
    public static final Executor zB = bolts.a.gz();
    private static g<?> zH = new g<>((Object) null);
    private static g<Boolean> zI = new g<>(true);
    private static g<Boolean> zJ = new g<>(false);
    private static g<?> zK = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> zG = new ArrayList();

    /* loaded from: classes19.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a gI() {
        return zC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        l(tresult);
    }

    private g(boolean z) {
        if (z) {
            gN();
        } else {
            l(null);
        }
    }

    public boolean gJ() {
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

    public boolean gK() {
        boolean z;
        synchronized (this.lock) {
            z = gL() != null;
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

    public Exception gL() {
        Exception exc;
        synchronized (this.lock) {
            if (this.zD != null) {
                this.zE = true;
                if (this.zF != null) {
                    this.zF.gQ();
                    this.zF = null;
                }
            }
            exc = this.zD;
        }
        return exc;
    }

    public static <TResult> g<TResult> k(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) zH;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) zI : (g<TResult>) zJ;
        }
        h hVar = new h();
        hVar.m(tresult);
        return hVar.gO();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.gO();
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
                    if (c.this != null && c.this.gF()) {
                        hVar.gP();
                        return;
                    }
                    try {
                        hVar.m(callable.call());
                    } catch (CancellationException e) {
                        hVar.gP();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
        return hVar.gO();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean gJ;
        final h hVar = new h();
        synchronized (this.lock) {
            gJ = gJ();
            if (!gJ) {
                this.zG.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        if (gJ) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.gO();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, zA, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean gJ;
        final h hVar = new h();
        synchronized (this.lock) {
            gJ = gJ();
            if (!gJ) {
                this.zG.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        if (gJ) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.gO();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, zA, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.gF()) {
                        hVar.gP();
                        return;
                    }
                    try {
                        hVar.m(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.gP();
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
                    if (c.this != null && c.this.gF()) {
                        hVar.gP();
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
                                    if (c.this != null && c.this.gF()) {
                                        hVar.gP();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.gP();
                                    } else if (gVar3.gK()) {
                                        hVar.h(gVar3.gL());
                                    } else {
                                        hVar.m(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.gP();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void gM() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.zG) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.zG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean gN() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                gM();
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
                gM();
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
            this.zD = exc;
            this.zE = false;
            this.lock.notifyAll();
            gM();
            if (!this.zE && gI() != null) {
                this.zF = new i(this);
            }
            return true;
        }
    }
}
