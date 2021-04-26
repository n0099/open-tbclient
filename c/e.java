package c;

import bolts.ExecutorException;
import bolts.UnobservedTaskException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class e<TResult> {

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f1468i;
    public static volatile f j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1470b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1471c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f1472d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f1473e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1474f;

    /* renamed from: g  reason: collision with root package name */
    public g f1475g;

    /* renamed from: a  reason: collision with root package name */
    public final Object f1469a = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<c.d<TResult, Void>> f1476h = new ArrayList();

    /* loaded from: classes.dex */
    public class a implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1477a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1478b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1479c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1480d;

        public a(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1477a = fVar;
            this.f1478b = dVar;
            this.f1479c = executor;
            this.f1480d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.f(this.f1477a, this.f1478b, eVar, this.f1479c, this.f1480d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1481a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1482b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1483c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1484d;

        public b(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1481a = fVar;
            this.f1482b = dVar;
            this.f1483c = executor;
            this.f1484d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.e(this.f1481a, this.f1482b, eVar, this.f1483c, this.f1484d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1485e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1486f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1487g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1488h;

        public c(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1485e = cVar;
            this.f1486f = fVar;
            this.f1487g = dVar;
            this.f1488h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1485e;
            if (cVar != null && cVar.a()) {
                this.f1486f.b();
                return;
            }
            try {
                this.f1486f.d(this.f1487g.then(this.f1488h));
            } catch (CancellationException unused) {
                this.f1486f.b();
            } catch (Exception e2) {
                this.f1486f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1489e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1490f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1491g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1492h;

        /* loaded from: classes.dex */
        public class a implements c.d<TContinuationResult, Void> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: c.f */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.d
            /* renamed from: a */
            public Void then(e<TContinuationResult> eVar) {
                c.c cVar = d.this.f1489e;
                if (cVar != null && cVar.a()) {
                    d.this.f1490f.b();
                    return null;
                }
                if (eVar.p()) {
                    d.this.f1490f.b();
                } else if (eVar.r()) {
                    d.this.f1490f.c(eVar.m());
                } else {
                    d.this.f1490f.d(eVar.n());
                }
                return null;
            }
        }

        public d(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1489e = cVar;
            this.f1490f = fVar;
            this.f1491g = dVar;
            this.f1492h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1489e;
            if (cVar != null && cVar.a()) {
                this.f1490f.b();
                return;
            }
            try {
                e eVar = (e) this.f1491g.then(this.f1492h);
                if (eVar == null) {
                    this.f1490f.d(null);
                } else {
                    eVar.g(new a());
                }
            } catch (CancellationException unused) {
                this.f1490f.b();
            } catch (Exception e2) {
                this.f1490f.c(e2);
            }
        }
    }

    /* renamed from: c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0013e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1494e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1495f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f1496g;

        public RunnableC0013e(c.c cVar, c.f fVar, Callable callable) {
            this.f1494e = cVar;
            this.f1495f = fVar;
            this.f1496g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1494e;
            if (cVar != null && cVar.a()) {
                this.f1495f.b();
                return;
            }
            try {
                this.f1495f.d(this.f1496g.call());
            } catch (CancellationException unused) {
                this.f1495f.b();
            } catch (Exception e2) {
                this.f1495f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        c.b.a();
        f1468i = c.b.b();
        c.a.c();
        k = new e<>((Object) null);
        l = new e<>(Boolean.TRUE);
        m = new e<>(Boolean.FALSE);
        new e(true);
    }

    public e() {
    }

    public static <TResult> e<TResult> c(Callable<TResult> callable, Executor executor) {
        return d(callable, executor, null);
    }

    public static <TResult> e<TResult> d(Callable<TResult> callable, Executor executor, c.c cVar) {
        c.f fVar = new c.f();
        try {
            executor.execute(new RunnableC0013e(cVar, fVar, callable));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
        return fVar.a();
    }

    public static <TContinuationResult, TResult> void e(c.f<TContinuationResult> fVar, c.d<TResult, e<TContinuationResult>> dVar, e<TResult> eVar, Executor executor, c.c cVar) {
        try {
            executor.execute(new d(cVar, fVar, dVar, eVar));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
    }

    public static <TContinuationResult, TResult> void f(c.f<TContinuationResult> fVar, c.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, c.c cVar) {
        try {
            executor.execute(new c(cVar, fVar, dVar, eVar));
        } catch (Exception e2) {
            fVar.c(new ExecutorException(e2));
        }
    }

    public static <TResult> e<TResult> k(Exception exc) {
        c.f fVar = new c.f();
        fVar.c(exc);
        return fVar.a();
    }

    public static <TResult> e<TResult> l(TResult tresult) {
        if (tresult == null) {
            return (e<TResult>) k;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (e<TResult>) l : (e<TResult>) m;
        }
        c.f fVar = new c.f();
        fVar.d(tresult);
        return fVar.a();
    }

    public static f o() {
        return j;
    }

    public <TContinuationResult> e<TContinuationResult> g(c.d<TResult, TContinuationResult> dVar) {
        return h(dVar, f1468i, null);
    }

    public <TContinuationResult> e<TContinuationResult> h(c.d<TResult, TContinuationResult> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1469a) {
            q = q();
            if (!q) {
                this.f1476h.add(new a(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            f(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public <TContinuationResult> e<TContinuationResult> i(c.d<TResult, e<TContinuationResult>> dVar) {
        return j(dVar, f1468i, null);
    }

    public <TContinuationResult> e<TContinuationResult> j(c.d<TResult, e<TContinuationResult>> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1469a) {
            q = q();
            if (!q) {
                this.f1476h.add(new b(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            e(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public Exception m() {
        Exception exc;
        synchronized (this.f1469a) {
            if (this.f1473e != null) {
                this.f1474f = true;
                if (this.f1475g != null) {
                    this.f1475g.a();
                    this.f1475g = null;
                }
            }
            exc = this.f1473e;
        }
        return exc;
    }

    public TResult n() {
        TResult tresult;
        synchronized (this.f1469a) {
            tresult = this.f1472d;
        }
        return tresult;
    }

    public boolean p() {
        boolean z;
        synchronized (this.f1469a) {
            z = this.f1471c;
        }
        return z;
    }

    public boolean q() {
        boolean z;
        synchronized (this.f1469a) {
            z = this.f1470b;
        }
        return z;
    }

    public boolean r() {
        boolean z;
        synchronized (this.f1469a) {
            z = m() != null;
        }
        return z;
    }

    public final void s() {
        synchronized (this.f1469a) {
            for (c.d<TResult, Void> dVar : this.f1476h) {
                try {
                    dVar.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f1476h = null;
        }
    }

    public boolean t() {
        synchronized (this.f1469a) {
            if (this.f1470b) {
                return false;
            }
            this.f1470b = true;
            this.f1471c = true;
            this.f1469a.notifyAll();
            s();
            return true;
        }
    }

    public boolean u(Exception exc) {
        synchronized (this.f1469a) {
            if (this.f1470b) {
                return false;
            }
            this.f1470b = true;
            this.f1473e = exc;
            this.f1474f = false;
            this.f1469a.notifyAll();
            s();
            if (!this.f1474f && o() != null) {
                this.f1475g = new g(this);
            }
            return true;
        }
    }

    public boolean v(TResult tresult) {
        synchronized (this.f1469a) {
            if (this.f1470b) {
                return false;
            }
            this.f1470b = true;
            this.f1472d = tresult;
            this.f1469a.notifyAll();
            s();
            return true;
        }
    }

    public e(TResult tresult) {
        v(tresult);
    }

    public e(boolean z) {
        if (z) {
            t();
        } else {
            v(null);
        }
    }
}
