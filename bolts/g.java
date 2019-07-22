package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class g<TResult> {
    private static volatile a jX;
    private boolean cancelled;
    private boolean complete;
    private Exception jY;
    private boolean jZ;
    private i kb;
    private TResult result;
    public static final ExecutorService jU = b.aZ();
    private static final Executor jV = b.ba();
    public static final Executor jW = bolts.a.aX();
    private static g<?> kd = new g<>((Object) null);
    private static g<Boolean> ke = new g<>(true);
    private static g<Boolean> kf = new g<>(false);
    private static g<?> kg = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> kc = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a bg() {
        return jX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        h(tresult);
    }

    private g(boolean z) {
        if (z) {
            bl();
        } else {
            h(null);
        }
    }

    public boolean bh() {
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

    public boolean bi() {
        boolean z;
        synchronized (this.lock) {
            z = bj() != null;
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

    public Exception bj() {
        Exception exc;
        synchronized (this.lock) {
            if (this.jY != null) {
                this.jZ = true;
                if (this.kb != null) {
                    this.kb.bo();
                    this.kb = null;
                }
            }
            exc = this.jY;
        }
        return exc;
    }

    public static <TResult> g<TResult> g(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) kd;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) ke : (g<TResult>) kf;
        }
        h hVar = new h();
        hVar.i(tresult);
        return hVar.bm();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.bm();
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
                    if (c.this != null && c.this.bd()) {
                        hVar.bn();
                        return;
                    }
                    try {
                        hVar.i(callable.call());
                    } catch (CancellationException e) {
                        hVar.bn();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h((Exception) new ExecutorException(e));
        }
        return hVar.bm();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean bh;
        final h hVar = new h();
        synchronized (this.lock) {
            bh = bh();
            if (!bh) {
                this.kc.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        if (bh) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.bm();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, jV, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean bh;
        final h hVar = new h();
        synchronized (this.lock) {
            bh = bh();
            if (!bh) {
                this.kc.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        if (bh) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.bm();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, jV, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.bd()) {
                        hVar.bn();
                        return;
                    }
                    try {
                        hVar.i(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.bn();
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
                    if (c.this != null && c.this.bd()) {
                        hVar.bn();
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
                                    if (c.this != null && c.this.bd()) {
                                        hVar.bn();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.bn();
                                    } else if (gVar3.bi()) {
                                        hVar.h(gVar3.bj());
                                    } else {
                                        hVar.i(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.bn();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void bk() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.kc) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.kc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bl() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                bk();
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
                bk();
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
            this.jY = exc;
            this.jZ = false;
            this.lock.notifyAll();
            bk();
            if (!this.jZ && bg() != null) {
                this.kb = new i(this);
            }
            return true;
        }
    }
}
