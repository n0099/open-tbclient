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
    public static final Executor f1481i;
    public static volatile f j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1483b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1484c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f1485d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f1486e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1487f;

    /* renamed from: g  reason: collision with root package name */
    public g f1488g;

    /* renamed from: a  reason: collision with root package name */
    public final Object f1482a = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<c.d<TResult, Void>> f1489h = new ArrayList();

    /* loaded from: classes.dex */
    public class a implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1490a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1491b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1492c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1493d;

        public a(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1490a = fVar;
            this.f1491b = dVar;
            this.f1492c = executor;
            this.f1493d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.f(this.f1490a, this.f1491b, eVar, this.f1492c, this.f1493d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1494a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1495b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1496c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1497d;

        public b(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1494a = fVar;
            this.f1495b = dVar;
            this.f1496c = executor;
            this.f1497d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.e(this.f1494a, this.f1495b, eVar, this.f1496c, this.f1497d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1499f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1500g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1501h;

        public c(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1498e = cVar;
            this.f1499f = fVar;
            this.f1500g = dVar;
            this.f1501h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1498e;
            if (cVar != null && cVar.a()) {
                this.f1499f.b();
                return;
            }
            try {
                this.f1499f.d(this.f1500g.then(this.f1501h));
            } catch (CancellationException unused) {
                this.f1499f.b();
            } catch (Exception e2) {
                this.f1499f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1503f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1504g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1505h;

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
                c.c cVar = d.this.f1502e;
                if (cVar != null && cVar.a()) {
                    d.this.f1503f.b();
                    return null;
                }
                if (eVar.p()) {
                    d.this.f1503f.b();
                } else if (eVar.r()) {
                    d.this.f1503f.c(eVar.m());
                } else {
                    d.this.f1503f.d(eVar.n());
                }
                return null;
            }
        }

        public d(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1502e = cVar;
            this.f1503f = fVar;
            this.f1504g = dVar;
            this.f1505h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1502e;
            if (cVar != null && cVar.a()) {
                this.f1503f.b();
                return;
            }
            try {
                e eVar = (e) this.f1504g.then(this.f1505h);
                if (eVar == null) {
                    this.f1503f.d(null);
                } else {
                    eVar.g(new a());
                }
            } catch (CancellationException unused) {
                this.f1503f.b();
            } catch (Exception e2) {
                this.f1503f.c(e2);
            }
        }
    }

    /* renamed from: c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0014e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1507e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1508f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f1509g;

        public RunnableC0014e(c.c cVar, c.f fVar, Callable callable) {
            this.f1507e = cVar;
            this.f1508f = fVar;
            this.f1509g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1507e;
            if (cVar != null && cVar.a()) {
                this.f1508f.b();
                return;
            }
            try {
                this.f1508f.d(this.f1509g.call());
            } catch (CancellationException unused) {
                this.f1508f.b();
            } catch (Exception e2) {
                this.f1508f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        c.b.a();
        f1481i = c.b.b();
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
        return h(dVar, f1481i, null);
    }

    public <TContinuationResult> e<TContinuationResult> h(c.d<TResult, TContinuationResult> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1482a) {
            q = q();
            if (!q) {
                this.f1489h.add(new a(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            f(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public <TContinuationResult> e<TContinuationResult> i(c.d<TResult, e<TContinuationResult>> dVar) {
        return j(dVar, f1481i, null);
    }

    public <TContinuationResult> e<TContinuationResult> j(c.d<TResult, e<TContinuationResult>> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1482a) {
            q = q();
            if (!q) {
                this.f1489h.add(new b(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            e(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public Exception m() {
        Exception exc;
        synchronized (this.f1482a) {
            if (this.f1486e != null) {
                this.f1487f = true;
                if (this.f1488g != null) {
                    this.f1488g.a();
                    this.f1488g = null;
                }
            }
            exc = this.f1486e;
        }
        return exc;
    }

    public TResult n() {
        TResult tresult;
        synchronized (this.f1482a) {
            tresult = this.f1485d;
        }
        return tresult;
    }

    public boolean p() {
        boolean z;
        synchronized (this.f1482a) {
            z = this.f1484c;
        }
        return z;
    }

    public boolean q() {
        boolean z;
        synchronized (this.f1482a) {
            z = this.f1483b;
        }
        return z;
    }

    public boolean r() {
        boolean z;
        synchronized (this.f1482a) {
            z = m() != null;
        }
        return z;
    }

    public final void s() {
        synchronized (this.f1482a) {
            for (c.d<TResult, Void> dVar : this.f1489h) {
                try {
                    dVar.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f1489h = null;
        }
    }

    public boolean t() {
        synchronized (this.f1482a) {
            if (this.f1483b) {
                return false;
            }
            this.f1483b = true;
            this.f1484c = true;
            this.f1482a.notifyAll();
            s();
            return true;
        }
    }

    public boolean u(Exception exc) {
        synchronized (this.f1482a) {
            if (this.f1483b) {
                return false;
            }
            this.f1483b = true;
            this.f1486e = exc;
            this.f1487f = false;
            this.f1482a.notifyAll();
            s();
            if (!this.f1487f && o() != null) {
                this.f1488g = new g(this);
            }
            return true;
        }
    }

    public boolean v(TResult tresult) {
        synchronized (this.f1482a) {
            if (this.f1483b) {
                return false;
            }
            this.f1483b = true;
            this.f1485d = tresult;
            this.f1482a.notifyAll();
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
