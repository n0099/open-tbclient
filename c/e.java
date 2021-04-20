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
    public boolean f1450b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1451c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f1452d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f1453e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1454f;

    /* renamed from: g  reason: collision with root package name */
    public g f1455g;

    /* renamed from: a  reason: collision with root package name */
    public final Object f1449a = new Object();

    /* renamed from: h  reason: collision with root package name */
    public List<c.d<TResult, Void>> f1456h = new ArrayList();

    /* loaded from: classes.dex */
    public class a implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1457a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1458b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1459c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1460d;

        public a(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1457a = fVar;
            this.f1458b = dVar;
            this.f1459c = executor;
            this.f1460d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.f(this.f1457a, this.f1458b, eVar, this.f1459c, this.f1460d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d<TResult, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1461a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1462b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1463c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1464d;

        public b(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            this.f1461a = fVar;
            this.f1462b = dVar;
            this.f1463c = executor;
            this.f1464d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            e.e(this.f1461a, this.f1462b, eVar, this.f1463c, this.f1464d);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1466f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1467g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1468h;

        public c(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1465e = cVar;
            this.f1466f = fVar;
            this.f1467g = dVar;
            this.f1468h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1465e;
            if (cVar != null && cVar.a()) {
                this.f1466f.b();
                return;
            }
            try {
                this.f1466f.d(this.f1467g.then(this.f1468h));
            } catch (CancellationException unused) {
                this.f1466f.b();
            } catch (Exception e2) {
                this.f1466f.c(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1469e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1470f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1471g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1472h;

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
                c.c cVar = d.this.f1469e;
                if (cVar != null && cVar.a()) {
                    d.this.f1470f.b();
                    return null;
                }
                if (eVar.p()) {
                    d.this.f1470f.b();
                } else if (eVar.r()) {
                    d.this.f1470f.c(eVar.m());
                } else {
                    d.this.f1470f.d(eVar.n());
                }
                return null;
            }
        }

        public d(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            this.f1469e = cVar;
            this.f1470f = fVar;
            this.f1471g = dVar;
            this.f1472h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1469e;
            if (cVar != null && cVar.a()) {
                this.f1470f.b();
                return;
            }
            try {
                e eVar = (e) this.f1471g.then(this.f1472h);
                if (eVar == null) {
                    this.f1470f.d(null);
                } else {
                    eVar.g(new a());
                }
            } catch (CancellationException unused) {
                this.f1470f.b();
            } catch (Exception e2) {
                this.f1470f.c(e2);
            }
        }
    }

    /* renamed from: c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0013e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1475f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f1476g;

        public RunnableC0013e(c.c cVar, c.f fVar, Callable callable) {
            this.f1474e = cVar;
            this.f1475f = fVar;
            this.f1476g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c cVar = this.f1474e;
            if (cVar != null && cVar.a()) {
                this.f1475f.b();
                return;
            }
            try {
                this.f1475f.d(this.f1476g.call());
            } catch (CancellationException unused) {
                this.f1475f.b();
            } catch (Exception e2) {
                this.f1475f.c(e2);
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
        return h(dVar, i, null);
    }

    public <TContinuationResult> e<TContinuationResult> h(c.d<TResult, TContinuationResult> dVar, Executor executor, c.c cVar) {
        boolean q;
        c.f fVar = new c.f();
        synchronized (this.f1449a) {
            q = q();
            if (!q) {
                this.f1456h.add(new a(this, fVar, dVar, executor, cVar));
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
        synchronized (this.f1449a) {
            q = q();
            if (!q) {
                this.f1456h.add(new b(this, fVar, dVar, executor, cVar));
            }
        }
        if (q) {
            e(fVar, dVar, this, executor, cVar);
        }
        return fVar.a();
    }

    public Exception m() {
        Exception exc;
        synchronized (this.f1449a) {
            if (this.f1453e != null) {
                this.f1454f = true;
                if (this.f1455g != null) {
                    this.f1455g.a();
                    this.f1455g = null;
                }
            }
            exc = this.f1453e;
        }
        return exc;
    }

    public TResult n() {
        TResult tresult;
        synchronized (this.f1449a) {
            tresult = this.f1452d;
        }
        return tresult;
    }

    public boolean p() {
        boolean z;
        synchronized (this.f1449a) {
            z = this.f1451c;
        }
        return z;
    }

    public boolean q() {
        boolean z;
        synchronized (this.f1449a) {
            z = this.f1450b;
        }
        return z;
    }

    public boolean r() {
        boolean z;
        synchronized (this.f1449a) {
            z = m() != null;
        }
        return z;
    }

    public final void s() {
        synchronized (this.f1449a) {
            for (c.d<TResult, Void> dVar : this.f1456h) {
                try {
                    dVar.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f1456h = null;
        }
    }

    public boolean t() {
        synchronized (this.f1449a) {
            if (this.f1450b) {
                return false;
            }
            this.f1450b = true;
            this.f1451c = true;
            this.f1449a.notifyAll();
            s();
            return true;
        }
    }

    public boolean u(Exception exc) {
        synchronized (this.f1449a) {
            if (this.f1450b) {
                return false;
            }
            this.f1450b = true;
            this.f1453e = exc;
            this.f1454f = false;
            this.f1449a.notifyAll();
            s();
            if (!this.f1454f && o() != null) {
                this.f1455g = new g(this);
            }
            return true;
        }
    }

    public boolean v(TResult tresult) {
        synchronized (this.f1449a) {
            if (this.f1450b) {
                return false;
            }
            this.f1450b = true;
            this.f1452d = tresult;
            this.f1449a.notifyAll();
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
