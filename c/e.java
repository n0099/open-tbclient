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
    public static final Executor i;
    public static volatile f j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1464b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1465c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f1466d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f1467e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1468f;

    /* renamed from: g  reason: collision with root package name */
    public g f1469g;

    /* renamed from: a  reason: collision with root package name */
    public final Object f1463a = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<c.d<TResult, Void>> f1470h = new ArrayList();

    /* loaded from: classes.dex */
    public class a implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1472b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1473c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1474d;

        public a(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1471a = fVar;
            this.f1472b = dVar;
            this.f1473c = executor;
            this.f1474d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.f(this.f1471a, this.f1472b, eVar, this.f1473c, this.f1474d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1475a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1476b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1477c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1478d;

        public b(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1475a = fVar;
            this.f1476b = dVar;
            this.f1477c = executor;
            this.f1478d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.e(this.f1475a, this.f1476b, eVar, this.f1477c, this.f1478d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1481g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1482h;

        public c(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1479e = cVar;
            this.f1480f = fVar;
            this.f1481g = dVar;
            this.f1482h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1479e;
            if (cVar != null && cVar.a()) {
                this.f1480f.b();
                return;
            }
            try {
                this.f1480f.d(this.f1481g.then(this.f1482h));
            } catch (CancellationException unused) {
                this.f1480f.b();
            } catch (Exception e2) {
                this.f1480f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1483e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1484f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1485g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1486h;

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
                c.c cVar = d.this.f1483e;
                if (cVar != null && cVar.a()) {
                    d.this.f1484f.b();
                    return null;
                }
                if (eVar.p()) {
                    d.this.f1484f.b();
                } else if (eVar.r()) {
                    d.this.f1484f.c(eVar.m());
                } else {
                    d.this.f1484f.d(eVar.n());
                }
                return null;
            }
        }

        public d(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1483e = cVar;
            this.f1484f = fVar;
            this.f1485g = dVar;
            this.f1486h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1483e;
            if (cVar != null && cVar.a()) {
                this.f1484f.b();
                return;
            }
            try {
                e eVar = (e) this.f1485g.then(this.f1486h);
                if (eVar == null) {
                    this.f1484f.d(null);
                } else {
                    eVar.g(new a());
                }
            } catch (CancellationException unused) {
                this.f1484f.b();
            } catch (Exception e2) {
                this.f1484f.c(e2);
            }
        }
    }

    /* renamed from: c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0014e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1488e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1489f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f1490g;

        public RunnableC0014e(c.c cVar, c.f fVar, Callable callable) {
            this.f1488e = cVar;
            this.f1489f = fVar;
            this.f1490g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1488e;
            if (cVar != null && cVar.a()) {
                this.f1489f.b();
                return;
            }
            try {
                this.f1489f.d(this.f1490g.call());
            } catch (CancellationException unused) {
                this.f1489f.b();
            } catch (Exception e2) {
                this.f1489f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        c.b.a();
        i = c.b.b();
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
            executor.execute(new RunnableC0014e(cVar, fVar, callable));
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
        return h(dVar, i, null);
    }

    public <TContinuationResult> e<TContinuationResult> h(c.d<TResult, TContinuationResult> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1463a) {
            q = q();
            if (!q) {
                this.f1470h.add(new a(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            f(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public <TContinuationResult> e<TContinuationResult> i(c.d<TResult, e<TContinuationResult>> dVar) {
        return j(dVar, i, null);
    }

    public <TContinuationResult> e<TContinuationResult> j(c.d<TResult, e<TContinuationResult>> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1463a) {
            q = q();
            if (!q) {
                this.f1470h.add(new b(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            e(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public Exception m() {
        Exception exc;
        synchronized (this.f1463a) {
            if (this.f1467e != null) {
                this.f1468f = true;
                if (this.f1469g != null) {
                    this.f1469g.a();
                    this.f1469g = null;
                }
            }
            exc = this.f1467e;
        }
        return exc;
    }

    public TResult n() {
        TResult tresult;
        synchronized (this.f1463a) {
            tresult = this.f1466d;
        }
        return tresult;
    }

    public boolean p() {
        boolean z;
        synchronized (this.f1463a) {
            z = this.f1465c;
        }
        return z;
    }

    public boolean q() {
        boolean z;
        synchronized (this.f1463a) {
            z = this.f1464b;
        }
        return z;
    }

    public boolean r() {
        boolean z;
        synchronized (this.f1463a) {
            z = m() != null;
        }
        return z;
    }

    public final void s() {
        synchronized (this.f1463a) {
            for (c.d<TResult, Void> dVar : this.f1470h) {
                try {
                    dVar.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f1470h = null;
        }
    }

    public boolean t() {
        synchronized (this.f1463a) {
            if (this.f1464b) {
                return false;
            }
            this.f1464b = true;
            this.f1465c = true;
            this.f1463a.notifyAll();
            s();
            return true;
        }
    }

    public boolean u(Exception exc) {
        synchronized (this.f1463a) {
            if (this.f1464b) {
                return false;
            }
            this.f1464b = true;
            this.f1467e = exc;
            this.f1468f = false;
            this.f1463a.notifyAll();
            s();
            if (!this.f1468f && o() != null) {
                this.f1469g = new g(this);
            }
            return true;
        }
    }

    public boolean v(TResult tresult) {
        synchronized (this.f1463a) {
            if (this.f1464b) {
                return false;
            }
            this.f1464b = true;
            this.f1466d = tresult;
            this.f1463a.notifyAll();
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
