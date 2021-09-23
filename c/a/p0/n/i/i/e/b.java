package c.a.p0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.p0.n.i.i.g.f;
import c.a.p0.n.i.i.g.g;
import c.a.p0.n.i.i.g.l;
import c.a.p0.n.i.l.a;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f11915a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f11916b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f11917c;

    /* renamed from: d  reason: collision with root package name */
    public f f11918d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f11919e;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final c.a.p0.n.i.i.g.b f11920f;

    /* renamed from: g  reason: collision with root package name */
    public final l f11921g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.n.i.i.g.a f11922h;

    /* loaded from: classes3.dex */
    public class a implements c.a.p0.n.i.i.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11923a;

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
            this.f11923a = bVar;
        }

        @Override // c.a.p0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f11923a.f11918d = fVar;
            }
        }

        @Override // c.a.p0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) && this.f11923a.f11918d == fVar) {
                this.f11923a.f11918d = null;
            }
        }
    }

    /* renamed from: c.a.p0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0622b implements c.a.p0.n.i.i.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11924a;

        public C0622b(b bVar) {
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
            this.f11924a = bVar;
        }

        @Override // c.a.p0.n.i.i.g.a
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.f11924a.d(z) : (Runnable) invokeZ.objValue;
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
        this.f11919e = new AtomicBoolean(false);
        a aVar = new a(this);
        this.f11920f = aVar;
        this.f11921g = new l(aVar);
        this.f11922h = new C0622b(this);
        this.f11915a = new c();
        this.f11916b = new LinkedBlockingQueue();
        this.f11917c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f11916b);
        c(this.f11915a);
    }

    public void c(c.a.p0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f11921g.c(bVar);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.f11915a != null) {
                    if (z) {
                        return this.f11915a.g();
                    }
                    return this.f11915a.i();
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
                if (this.f11918d == null) {
                    return false;
                }
                Object f2 = this.f11918d.f();
                if (f2 instanceof c.a.p0.n.h.f) {
                    c.a.p0.n.h.f fVar = (c.a.p0.n.h.f) f2;
                    if (c.a.p0.n.c.f11864a) {
                        String str2 = "Current PMSPkgMain appId: " + fVar.f11893g + ", checking id: " + str;
                    }
                    return TextUtils.equals(fVar.f11893g, str);
                } else if (f2 instanceof a.C0623a) {
                    a.C0623a c0623a = (a.C0623a) f2;
                    if (c.a.p0.n.c.f11864a) {
                        String str3 = "Current Item appId: " + c0623a.f11965b + ", checking id: " + str;
                    }
                    return TextUtils.equals(c0623a.f11965b, str);
                } else {
                    if (c.a.p0.n.c.f11864a) {
                        String str4 = "Current model type not match: " + f2.getClass().getSimpleName();
                    }
                    return false;
                }
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                Iterator<f> f2 = this.f11915a.f();
                while (f2.hasNext()) {
                    f next = f2.next();
                    if (next != null) {
                        Object f3 = next.f();
                        if (f3 instanceof c.a.p0.n.h.f) {
                            c.a.p0.n.h.f fVar = (c.a.p0.n.h.f) f3;
                            if (c.a.p0.n.c.f11864a) {
                                String str2 = "Queue PMSPkgMain appId: " + fVar.f11893g + ", checking id: " + str;
                            }
                            if (TextUtils.equals(fVar.f11893g, str)) {
                                return true;
                            }
                        } else if (f3 instanceof a.C0623a) {
                            a.C0623a c0623a = (a.C0623a) f3;
                            if (c.a.p0.n.c.f11864a) {
                                String str3 = "Queue Item appId: " + c0623a.f11965b + ", checking id: " + str;
                            }
                            if (TextUtils.equals(c0623a.f11965b, str)) {
                                return true;
                            }
                        } else if (c.a.p0.n.c.f11864a) {
                            String str4 = "Queue model type not match: " + f3.getClass().getSimpleName();
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
                this.f11915a.h(fVar);
                if (c.a.p0.n.c.f11864a) {
                    String str = "put Task:" + fVar;
                    String str2 = "current WaitingQueue===>" + this.f11915a;
                    String str3 = "current WorkingQueue===>" + this.f11916b;
                }
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

    public void i(c.a.p0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f11921g.d(bVar);
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f11916b.size() < 1) {
                    this.f11917c.execute(new g(this.f11919e, this.f11921g, this.f11922h));
                }
            }
        }
    }
}
