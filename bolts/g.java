package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes12.dex */
public class g<TResult> {
    private static volatile a Al;
    private Exception Am;
    private boolean An;
    private i Ao;
    private boolean cancelled;
    private boolean complete;
    private TResult result;
    public static final ExecutorService Ai = b.ia();
    private static final Executor Aj = b.ib();
    public static final Executor Ak = bolts.a.hY();
    private static g<?> Aq = new g<>((Object) null);
    private static g<Boolean> Ar = new g<>(true);
    private static g<Boolean> As = new g<>(false);
    private static g<?> At = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> Ap = new ArrayList();

    /* loaded from: classes12.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a ii() {
        return Al;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        m(tresult);
    }

    private g(boolean z) {
        if (z) {
            in();
        } else {
            m(null);
        }
    }

    public boolean ij() {
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

    public boolean ik() {
        boolean z;
        synchronized (this.lock) {
            z = il() != null;
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

    public Exception il() {
        Exception exc;
        synchronized (this.lock) {
            if (this.Am != null) {
                this.An = true;
                if (this.Ao != null) {
                    this.Ao.ir();
                    this.Ao = null;
                }
            }
            exc = this.Am;
        }
        return exc;
    }

    public static <TResult> g<TResult> l(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) Aq;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) Ar : (g<TResult>) As;
        }
        h hVar = new h();
        hVar.n(tresult);
        return hVar.ip();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.ip();
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
                    if (c.this != null && c.this.m7if()) {
                        hVar.iq();
                        return;
                    }
                    try {
                        hVar.n(callable.call());
                    } catch (CancellationException e) {
                        hVar.iq();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
        return hVar.ip();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean ij;
        final h hVar = new h();
        synchronized (this.lock) {
            ij = ij();
            if (!ij) {
                this.Ap.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        if (ij) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.ip();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, Aj, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean ij;
        final h hVar = new h();
        synchronized (this.lock) {
            ij = ij();
            if (!ij) {
                this.Ap.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        if (ij) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.ip();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, Aj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.m7if()) {
                        hVar.iq();
                        return;
                    }
                    try {
                        hVar.n(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.iq();
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
                    if (c.this != null && c.this.m7if()) {
                        hVar.iq();
                        return;
                    }
                    try {
                        g gVar2 = (g) fVar.a(gVar);
                        if (gVar2 == null) {
                            hVar.n(null);
                        } else {
                            gVar2.a(new f<TContinuationResult, Void>() { // from class: bolts.g.4.1
                                /* JADX DEBUG: Method merged with bridge method */
                                /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: bolts.h */
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // bolts.f
                                /* renamed from: b */
                                public Void a(g<TContinuationResult> gVar3) {
                                    if (c.this != null && c.this.m7if()) {
                                        hVar.iq();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.iq();
                                    } else if (gVar3.ik()) {
                                        hVar.h(gVar3.il());
                                    } else {
                                        hVar.n(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.iq();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void im() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.Ap) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.Ap = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean in() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                im();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m(TResult tresult) {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.result = tresult;
                this.lock.notifyAll();
                im();
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
            this.Am = exc;
            this.An = false;
            this.lock.notifyAll();
            im();
            if (!this.An && ii() != null) {
                this.Ao = new i(this);
            }
            return true;
        }
    }
}
