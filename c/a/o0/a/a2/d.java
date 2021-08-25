package c.a.o0.a.a2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a2.i;
import c.a.o0.a.f1.e.f.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class d extends c.a.o0.a.a2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static volatile d n;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.p.a f4516e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<c.a.o0.a.v2.e1.b<i.a>> f4517f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f4518g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f4519h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4520i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.o0.n.i.g f4521j;
    public c.a.o0.a.c2.f.g0.a k;
    public boolean l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f4522e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4523f;

        /* renamed from: c.a.o0.a.a2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0116a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.o0.a.v2.e1.b f4524e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f4525f;

            public RunnableC0116a(a aVar, c.a.o0.a.v2.e1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4525f = aVar;
                this.f4524e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4524e.onCallback(this.f4525f.f4522e);
                }
            }
        }

        public a(d dVar, i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4523f = dVar;
            this.f4522e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (c.a.o0.a.v2.e1.b bVar : this.f4523f.f4517f) {
                    if (z && !this.f4522e.e("event_flag_force_post", false)) {
                        bVar.onCallback(this.f4522e);
                    } else {
                        d.i().post(new RunnableC0116a(this, bVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f4526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4527f;

        public b(d dVar, c.a.o0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4527f = dVar;
            this.f4526e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4527f.f4517f.add(this.f4526e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.v2.e1.b f4528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4529f;

        public c(d dVar, c.a.o0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4529f = dVar;
            this.f4528e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4529f.f4517f.remove(this.f4528e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1009115519, "Lc/a/o0/a/a2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1009115519, "Lc/a/o0/a/a2/d;");
                return;
            }
        }
        m = c.a.o0.a.k.f7049a;
    }

    public d() {
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
        new c.a();
        this.f4517f = new HashSet();
        this.f4518g = 0;
        this.f4519h = new ArrayDeque();
        this.f4520i = null;
        this.l = false;
    }

    public static d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d h2 = h();
            if (!h2.l) {
                h2.k();
            }
            return h2;
        }
        return (d) invokeV.objValue;
    }

    public static d h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (n instanceof j) {
                return n;
            }
            synchronized (d.class) {
                if (n instanceof j) {
                    return n;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    n = new j();
                    return n;
                } else if (current.isSwanService) {
                    if (!(n instanceof l)) {
                        n = new l();
                    }
                    return n;
                } else {
                    if (n == null) {
                        n = new c.a.o0.a.a2.c();
                    }
                    return n;
                }
            }
        }
        return (d) invokeV.objValue;
    }

    public static Handler i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (o == null) {
                o = new Handler(Looper.getMainLooper());
            }
            return o;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // c.a.o0.a.a2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (m) {
                String str = "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f4517f.size();
            }
            if (aVar != null) {
                E(new a(this, aVar));
            }
        }
    }

    @Override // c.a.o0.a.a2.h
    public c.a.o0.a.c2.f.g0.a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.k == null) {
                this.k = f();
            }
            return this.k;
        }
        return (c.a.o0.a.c2.f.g0.a) invokeV.objValue;
    }

    public final void D() {
        c.a.o0.a.c2.f.g0.a B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (B = B()) == null) {
            return;
        }
        B.f();
    }

    public final synchronized void E(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            synchronized (this) {
                this.f4519h.offer(runnable);
                if (this.f4520i == null) {
                    while (!this.f4519h.isEmpty()) {
                        Runnable poll = this.f4519h.poll();
                        this.f4520i = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f4520i = null;
                    }
                }
            }
        }
    }

    public abstract c.a.o0.n.i.g e();

    public abstract c.a.o0.a.c2.f.g0.a f();

    public c.a.o0.n.i.g j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f4521j == null) {
                this.f4521j = e();
            }
            return this.f4521j;
        }
        return (c.a.o0.n.i.g) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.l) {
            return;
        }
        D();
        j();
        c.a.o0.a.v1.b.c.G();
        this.l = true;
    }

    @Override // c.a.o0.a.a2.h
    public void p(c.a.o0.a.v2.e1.b<i.a> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || bVar == null) {
            return;
        }
        E(new c(this, bVar));
    }

    @Override // c.a.o0.a.a2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            w(str, null);
        }
    }

    @Override // c.a.o0.a.a2.h
    public void v(c.a.o0.a.v2.e1.b<i.a> bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || bVar == null) {
            return;
        }
        E(new b(this, bVar));
    }

    @Override // c.a.o0.a.a2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, bundle) == null) {
            A(new i.a(str, bundle));
        }
    }

    @Override // c.a.o0.a.a2.h
    public c.a.o0.a.p.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f4516e == null) {
                this.f4516e = new c.a.o0.a.p.a();
            }
            return this.f4516e;
        }
        return (c.a.o0.a.p.a) invokeV.objValue;
    }
}
