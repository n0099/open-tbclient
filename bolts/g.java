package bolts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes10.dex */
public class g<TResult> {
    private static volatile a Bw;
    private Exception Bx;
    private boolean By;
    private i Bz;
    private boolean cancelled;
    private boolean complete;
    private TResult result;
    public static final ExecutorService Bt = b.ib();
    private static final Executor Bu = b.ic();
    public static final Executor Bv = bolts.a.hZ();
    private static g<?> BB = new g<>((Object) null);
    private static g<Boolean> BC = new g<>(true);
    private static g<Boolean> BD = new g<>(false);
    private static g<?> BE = new g<>(true);
    private final Object lock = new Object();
    private List<f<TResult, Void>> BA = new ArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(g<?> gVar, UnobservedTaskException unobservedTaskException);
    }

    public static a ij() {
        return Bw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    private g(TResult tresult) {
        m(tresult);
    }

    private g(boolean z) {
        if (z) {
            ip();
        } else {
            m(null);
        }
    }

    public boolean ik() {
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

    public boolean il() {
        boolean z;
        synchronized (this.lock) {
            z = im() != null;
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

    public Exception im() {
        Exception exc;
        synchronized (this.lock) {
            if (this.Bx != null) {
                this.By = true;
                if (this.Bz != null) {
                    this.Bz.is();
                    this.Bz = null;
                }
            }
            exc = this.Bx;
        }
        return exc;
    }

    public static <TResult> g<TResult> l(TResult tresult) {
        if (tresult == null) {
            return (g<TResult>) BB;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (g<TResult>) BC : (g<TResult>) BD;
        }
        h hVar = new h();
        hVar.n(tresult);
        return hVar.iq();
    }

    public static <TResult> g<TResult> f(Exception exc) {
        h hVar = new h();
        hVar.h(exc);
        return hVar.iq();
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
                    if (c.this != null && c.this.ig()) {
                        hVar.ir();
                        return;
                    }
                    try {
                        hVar.n(callable.call());
                    } catch (CancellationException e) {
                        hVar.ir();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
        return hVar.iq();
    }

    public <TContinuationResult> g<TContinuationResult> a(final f<TResult, TContinuationResult> fVar, final Executor executor, final c cVar) {
        boolean ik;
        final h hVar = new h();
        synchronized (this.lock) {
            ik = ik();
            if (!ik) {
                this.BA.add(new f<TResult, Void>() { // from class: bolts.g.1
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
        if (ik) {
            a(hVar, fVar, this, executor, cVar);
        }
        return hVar.iq();
    }

    public <TContinuationResult> g<TContinuationResult> a(f<TResult, TContinuationResult> fVar) {
        return a(fVar, Bu, (c) null);
    }

    public <TContinuationResult> g<TContinuationResult> b(final f<TResult, g<TContinuationResult>> fVar, final Executor executor, final c cVar) {
        boolean ik;
        final h hVar = new h();
        synchronized (this.lock) {
            ik = ik();
            if (!ik) {
                this.BA.add(new f<TResult, Void>() { // from class: bolts.g.2
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
        if (ik) {
            b(hVar, fVar, this, executor, cVar);
        }
        return hVar.iq();
    }

    public <TContinuationResult> g<TContinuationResult> b(f<TResult, g<TContinuationResult>> fVar) {
        return b(fVar, Bu, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void a(final h<TContinuationResult> hVar, final f<TResult, TContinuationResult> fVar, final g<TResult> gVar, Executor executor, final c cVar) {
        try {
            executor.execute(new Runnable() { // from class: bolts.g.3
                /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: bolts.h */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this != null && c.this.ig()) {
                        hVar.ir();
                        return;
                    }
                    try {
                        hVar.n(fVar.a(gVar));
                    } catch (CancellationException e) {
                        hVar.ir();
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
                    if (c.this != null && c.this.ig()) {
                        hVar.ir();
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
                                    if (c.this != null && c.this.ig()) {
                                        hVar.ir();
                                    } else if (gVar3.isCancelled()) {
                                        hVar.ir();
                                    } else if (gVar3.il()) {
                                        hVar.h(gVar3.im());
                                    } else {
                                        hVar.n(gVar3.getResult());
                                    }
                                    return null;
                                }
                            });
                        }
                    } catch (CancellationException e) {
                        hVar.ir();
                    } catch (Exception e2) {
                        hVar.h(e2);
                    }
                }
            });
        } catch (Exception e) {
            hVar.h(new ExecutorException(e));
        }
    }

    private void in() {
        synchronized (this.lock) {
            for (f<TResult, Void> fVar : this.BA) {
                try {
                    fVar.a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.BA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ip() {
        boolean z = true;
        synchronized (this.lock) {
            if (this.complete) {
                z = false;
            } else {
                this.complete = true;
                this.cancelled = true;
                this.lock.notifyAll();
                in();
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
                in();
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
            this.Bx = exc;
            this.By = false;
            this.lock.notifyAll();
            in();
            if (!this.By && ij() != null) {
                this.Bz = new i(this);
            }
            return true;
        }
    }
}
