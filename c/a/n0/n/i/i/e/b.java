package c.a.n0.n.i.i.e;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import c.a.n0.n.i.i.g.f;
import c.a.n0.n.i.i.g.g;
import c.a.n0.n.i.i.g.l;
import c.a.n0.n.i.l.a;
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
    public c f11633a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f11634b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadPoolExecutor f11635c;

    /* renamed from: d  reason: collision with root package name */
    public f f11636d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f11637e;
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: f  reason: collision with root package name */
    public final c.a.n0.n.i.i.g.b f11638f;

    /* renamed from: g  reason: collision with root package name */
    public final l f11639g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.n0.n.i.i.g.a f11640h;

    /* loaded from: classes3.dex */
    public class a implements c.a.n0.n.i.i.g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11641a;

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
            this.f11641a = bVar;
        }

        @Override // c.a.n0.n.i.i.g.b
        public <T> void a(f<T> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f11641a.f11636d = fVar;
            }
        }

        @Override // c.a.n0.n.i.i.g.b
        public <T> void b(f<T> fVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) && this.f11641a.f11636d == fVar) {
                this.f11641a.f11636d = null;
            }
        }
    }

    /* renamed from: c.a.n0.n.i.i.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0612b implements c.a.n0.n.i.i.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f11642a;

        public C0612b(b bVar) {
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
            this.f11642a = bVar;
        }

        @Override // c.a.n0.n.i.i.g.a
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? this.f11642a.d(z) : (Runnable) invokeZ.objValue;
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
        this.f11637e = new AtomicBoolean(false);
        a aVar = new a(this);
        this.f11638f = aVar;
        this.f11639g = new l(aVar);
        this.f11640h = new C0612b(this);
        this.f11633a = new c();
        this.f11634b = new LinkedBlockingQueue();
        this.f11635c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.f11634b);
        c(this.f11633a);
    }

    public void c(c.a.n0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f11639g.c(bVar);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.f11633a != null) {
                    if (z) {
                        return this.f11633a.g();
                    }
                    return this.f11633a.i();
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
                if (this.f11636d == null) {
                    return false;
                }
                Object f2 = this.f11636d.f();
                if (f2 instanceof c.a.n0.n.h.f) {
                    c.a.n0.n.h.f fVar = (c.a.n0.n.h.f) f2;
                    if (c.a.n0.n.c.f11582a) {
                        String str2 = "Current PMSPkgMain appId: " + fVar.f11611g + ", checking id: " + str;
                    }
                    return TextUtils.equals(fVar.f11611g, str);
                } else if (f2 instanceof a.C0613a) {
                    a.C0613a c0613a = (a.C0613a) f2;
                    if (c.a.n0.n.c.f11582a) {
                        String str3 = "Current Item appId: " + c0613a.f11683b + ", checking id: " + str;
                    }
                    return TextUtils.equals(c0613a.f11683b, str);
                } else {
                    if (c.a.n0.n.c.f11582a) {
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
                Iterator<f> f2 = this.f11633a.f();
                while (f2.hasNext()) {
                    f next = f2.next();
                    if (next != null) {
                        Object f3 = next.f();
                        if (f3 instanceof c.a.n0.n.h.f) {
                            c.a.n0.n.h.f fVar = (c.a.n0.n.h.f) f3;
                            if (c.a.n0.n.c.f11582a) {
                                String str2 = "Queue PMSPkgMain appId: " + fVar.f11611g + ", checking id: " + str;
                            }
                            if (TextUtils.equals(fVar.f11611g, str)) {
                                return true;
                            }
                        } else if (f3 instanceof a.C0613a) {
                            a.C0613a c0613a = (a.C0613a) f3;
                            if (c.a.n0.n.c.f11582a) {
                                String str3 = "Queue Item appId: " + c0613a.f11683b + ", checking id: " + str;
                            }
                            if (TextUtils.equals(c0613a.f11683b, str)) {
                                return true;
                            }
                        } else if (c.a.n0.n.c.f11582a) {
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
                this.f11633a.h(fVar);
                if (c.a.n0.n.c.f11582a) {
                    String str = "put Task:" + fVar;
                    String str2 = "current WaitingQueue===>" + this.f11633a;
                    String str3 = "current WorkingQueue===>" + this.f11634b;
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

    public void i(c.a.n0.n.i.i.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f11639g.d(bVar);
        }
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.f11634b.size() < 1) {
                    this.f11635c.execute(new g(this.f11637e, this.f11639g, this.f11640h));
                }
            }
        }
    }
}
