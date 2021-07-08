package c;

import androidx.core.view.InputDeviceCompat;
import bolts.ExecutorException;
import bolts.UnobservedTaskException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class e<TResult> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f1485i;
    public static volatile f j;
    public static e<?> k;
    public static e<Boolean> l;
    public static e<Boolean> m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f1486a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1487b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1488c;

    /* renamed from: d  reason: collision with root package name */
    public TResult f1489d;

    /* renamed from: e  reason: collision with root package name */
    public Exception f1490e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1491f;

    /* renamed from: g  reason: collision with root package name */
    public g f1492g;

    /* renamed from: h  reason: collision with root package name */
    public List<c.d<TResult, Void>> f1493h;

    /* loaded from: classes.dex */
    public class a implements c.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1494a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1495b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1496c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1497d;

        public a(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, dVar, executor, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1494a = fVar;
            this.f1495b = dVar;
            this.f1496c = executor;
            this.f1497d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.f(this.f1494a, this.f1495b, eVar, this.f1496c, this.f1497d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.d<TResult, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.f f1498a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.d f1499b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Executor f1500c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.c f1501d;

        public b(e eVar, c.f fVar, c.d dVar, Executor executor, c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, dVar, executor, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1498a = fVar;
            this.f1499b = dVar;
            this.f1500c = executor;
            this.f1501d = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.d
        /* renamed from: a */
        public Void then(e<TResult> eVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                e.e(this.f1498a, this.f1499b, eVar, this.f1500c, this.f1501d);
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1502e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1503f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1504g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1505h;

        public c(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1502e = cVar;
            this.f1503f = fVar;
            this.f1504g = dVar;
            this.f1505h = eVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.c cVar = this.f1502e;
                if (cVar != null && cVar.a()) {
                    this.f1503f.b();
                    return;
                }
                try {
                    this.f1503f.d(this.f1504g.then(this.f1505h));
                } catch (CancellationException unused) {
                    this.f1503f.b();
                } catch (Exception e2) {
                    this.f1503f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1506e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1507f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.d f1508g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f1509h;

        /* loaded from: classes.dex */
        public class a implements c.d<TContinuationResult, Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f1510a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1510a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: c.f */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.d
            /* renamed from: a */
            public Void then(e<TContinuationResult> eVar) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
                    c.c cVar = this.f1510a.f1506e;
                    if (cVar != null && cVar.a()) {
                        this.f1510a.f1507f.b();
                        return null;
                    }
                    if (eVar.p()) {
                        this.f1510a.f1507f.b();
                    } else if (eVar.r()) {
                        this.f1510a.f1507f.c(eVar.m());
                    } else {
                        this.f1510a.f1507f.d(eVar.n());
                    }
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }

        public d(c.c cVar, c.f fVar, c.d dVar, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, dVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1506e = cVar;
            this.f1507f = fVar;
            this.f1508g = dVar;
            this.f1509h = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.c cVar = this.f1506e;
                if (cVar != null && cVar.a()) {
                    this.f1507f.b();
                    return;
                }
                try {
                    e eVar = (e) this.f1508g.then(this.f1509h);
                    if (eVar == null) {
                        this.f1507f.d(null);
                    } else {
                        eVar.g(new a(this));
                    }
                } catch (CancellationException unused) {
                    this.f1507f.b();
                } catch (Exception e2) {
                    this.f1507f.c(e2);
                }
            }
        }
    }

    /* renamed from: c.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0014e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.c f1511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.f f1512f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Callable f1513g;

        public RunnableC0014e(c.c cVar, c.f fVar, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1511e = cVar;
            this.f1512f = fVar;
            this.f1513g = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: c.f */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.c cVar = this.f1511e;
                if (cVar != null && cVar.a()) {
                    this.f1512f.b();
                    return;
                }
                try {
                    this.f1512f.d(this.f1513g.call());
                } catch (CancellationException unused) {
                    this.f1512f.b();
                } catch (Exception e2) {
                    this.f1512f.c(e2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(e<?> eVar, UnobservedTaskException unobservedTaskException);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(73185262, "Lc/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(73185262, "Lc/e;");
                return;
            }
        }
        c.b.a();
        f1485i = c.b.b();
        c.a.c();
        k = new e<>((Object) null);
        l = new e<>(Boolean.TRUE);
        m = new e<>(Boolean.FALSE);
        new e(true);
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1486a = new Object();
        this.f1493h = new ArrayList();
    }

    public static <TResult> e<TResult> c(Callable<TResult> callable, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, callable, executor)) == null) ? d(callable, executor, null) : (e) invokeLL.objValue;
    }

    public static <TResult> e<TResult> d(Callable<TResult> callable, Executor executor, c.c cVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, callable, executor, cVar)) == null) {
            c.f fVar = new c.f();
            try {
                executor.execute(new RunnableC0014e(cVar, fVar, callable));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public static <TContinuationResult, TResult> void e(c.f<TContinuationResult> fVar, c.d<TResult, e<TContinuationResult>> dVar, e<TResult> eVar, Executor executor, c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, fVar, dVar, eVar, executor, cVar) == null) {
            try {
                executor.execute(new d(cVar, fVar, dVar, eVar));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TContinuationResult, TResult> void f(c.f<TContinuationResult> fVar, c.d<TResult, TContinuationResult> dVar, e<TResult> eVar, Executor executor, c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65545, null, fVar, dVar, eVar, executor, cVar) == null) {
            try {
                executor.execute(new c(cVar, fVar, dVar, eVar));
            } catch (Exception e2) {
                fVar.c(new ExecutorException(e2));
            }
        }
    }

    public static <TResult> e<TResult> k(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, exc)) == null) {
            c.f fVar = new c.f();
            fVar.c(exc);
            return fVar.a();
        }
        return (e) invokeL.objValue;
    }

    public static <TResult> e<TResult> l(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, tresult)) == null) {
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
        return (e) invokeL.objValue;
    }

    public static f o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? j : (f) invokeV.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> g(c.d<TResult, TContinuationResult> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? h(dVar, f1485i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> h(c.d<TResult, TContinuationResult> dVar, Executor executor, c.c cVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, executor, cVar)) == null) {
            c.f fVar = new c.f();
            synchronized (this.f1486a) {
                q = q();
                if (!q) {
                    this.f1493h.add(new a(this, fVar, dVar, executor, cVar));
                }
            }
            if (q) {
                f(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> i(c.d<TResult, e<TContinuationResult>> dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) ? j(dVar, f1485i, null) : (e) invokeL.objValue;
    }

    public <TContinuationResult> e<TContinuationResult> j(c.d<TResult, e<TContinuationResult>> dVar, Executor executor, c.c cVar) {
        InterceptResult invokeLLL;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, dVar, executor, cVar)) == null) {
            c.f fVar = new c.f();
            synchronized (this.f1486a) {
                q = q();
                if (!q) {
                    this.f1493h.add(new b(this, fVar, dVar, executor, cVar));
                }
            }
            if (q) {
                e(fVar, dVar, this, executor, cVar);
            }
            return fVar.a();
        }
        return (e) invokeLLL.objValue;
    }

    public Exception m() {
        InterceptResult invokeV;
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.f1486a) {
                if (this.f1490e != null) {
                    this.f1491f = true;
                    if (this.f1492g != null) {
                        this.f1492g.a();
                        this.f1492g = null;
                    }
                }
                exc = this.f1490e;
            }
            return exc;
        }
        return (Exception) invokeV.objValue;
    }

    public TResult n() {
        InterceptResult invokeV;
        TResult tresult;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this.f1486a) {
                tresult = this.f1489d;
            }
            return tresult;
        }
        return (TResult) invokeV.objValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.f1486a) {
                z = this.f1488c;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this.f1486a) {
                z = this.f1487b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this.f1486a) {
                z = m() != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.f1486a) {
                for (c.d<TResult, Void> dVar : this.f1493h) {
                    try {
                        dVar.then(this);
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new RuntimeException(e3);
                    }
                }
                this.f1493h = null;
            }
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this.f1486a) {
                if (this.f1487b) {
                    return false;
                }
                this.f1487b = true;
                this.f1488c = true;
                this.f1486a.notifyAll();
                s();
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean u(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, exc)) == null) {
            synchronized (this.f1486a) {
                if (this.f1487b) {
                    return false;
                }
                this.f1487b = true;
                this.f1490e = exc;
                this.f1491f = false;
                this.f1486a.notifyAll();
                s();
                if (!this.f1491f && o() != null) {
                    this.f1492g = new g(this);
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean v(TResult tresult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tresult)) == null) {
            synchronized (this.f1486a) {
                if (this.f1487b) {
                    return false;
                }
                this.f1487b = true;
                this.f1489d = tresult;
                this.f1486a.notifyAll();
                s();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public e(TResult tresult) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tresult};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f1486a = new Object();
        this.f1493h = new ArrayList();
        v(tresult);
    }

    public e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f1486a = new Object();
        this.f1493h = new ArrayList();
        if (z) {
            t();
        } else {
            v(null);
        }
    }
}
