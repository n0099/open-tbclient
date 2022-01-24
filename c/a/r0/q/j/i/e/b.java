package c.a.r0.q.j.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.r0.q.i.g;
import c.a.r0.q.j.i.g.f;
import c.a.r0.q.j.i.g.l;
import c.a.r0.q.j.l.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f11651b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f11652c;

    /* renamed from: d  reason: collision with root package name */
    public f f11653d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f11654e;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final c.a.r0.q.j.i.g.b f11655f;

    /* renamed from: g  reason: collision with root package name */
    public final l f11656g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.q.j.i.g.a f11657h;

    /* loaded from: classes6.dex */
    public class a implements c.a.r0.q.j.i.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.q.j.i.g.b
        public <T> void a(f<T> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.a.f11653d = fVar;
            }
        }

        @Override // c.a.r0.q.j.i.g.b
        public <T> void b(f<T> fVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) && this.a.f11653d == fVar) {
                this.a.f11653d = null;
            }
        }
    }

    /* renamed from: c.a.r0.q.j.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0804b implements c.a.r0.q.j.i.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0804b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.q.j.i.g.a
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.a.d(z) : (Runnable) invokeZ.objValue;
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11654e = new AtomicBoolean(false);
        this.f11655f = new a(this);
        this.f11656g = new l(this.f11655f);
        this.f11657h = new C0804b(this);
        this.a = new c();
        this.f11651b = new LinkedBlockingQueue();
        this.f11652c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f11651b);
        c(this.a);
    }

    public void c(c.a.r0.q.j.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f11656g.c(bVar);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    if (z) {
                        return this.a.g();
                    }
                    return this.a.i();
                }
                return null;
            }
        }
        return (Runnable) invokeZ.objValue;
    }

    public synchronized boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.f11653d == null) {
                    return false;
                }
                Object f2 = this.f11653d.f();
                if (f2 instanceof g) {
                    return TextUtils.equals(((g) f2).f11636g, str);
                }
                if (f2 instanceof b.a) {
                    return TextUtils.equals(((b.a) f2).f11693b, str);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                Iterator<f> f2 = this.a.f();
                while (f2.hasNext()) {
                    f next = f2.next();
                    if (next != null) {
                        Object f3 = next.f();
                        if (f3 instanceof g) {
                            if (TextUtils.equals(((g) f3).f11636g, str)) {
                                return true;
                            }
                        } else if ((f3 instanceof b.a) && TextUtils.equals(((b.a) f3).f11693b, str)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized <T> void g(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            synchronized (this) {
                this.a.h(fVar);
            }
        }
    }

    public synchronized <T> void h(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            synchronized (this) {
                g(fVar);
                j();
            }
        }
    }

    public void i(c.a.r0.q.j.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f11656g.d(bVar);
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f11651b.size() < 1) {
                    this.f11652c.execute(new c.a.r0.q.j.i.g.g(this.f11654e, this.f11656g, this.f11657h));
                }
            }
        }
    }
}
