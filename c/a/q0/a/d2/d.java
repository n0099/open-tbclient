package c.a.q0.a.d2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.d2.i;
import c.a.q0.a.f1.e.f.c;
import com.baidu.android.imsdk.internal.Constants;
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
public abstract class d extends c.a.q0.a.d2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static volatile d n;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.a.p.a f4910e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<c.a.q0.a.z2.g1.c<i.a>> f4911f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f4912g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f4913h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4914i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.q0.q.j.g f4915j;

    /* renamed from: k  reason: collision with root package name */
    public c.a.q0.a.f2.f.f0.a f4916k;
    public boolean l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f4917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4918f;

        /* renamed from: c.a.q0.a.d2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0234a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.a.z2.g1.c f4919e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f4920f;

            public RunnableC0234a(a aVar, c.a.q0.a.z2.g1.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4920f = aVar;
                this.f4919e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4919e.onCallback(this.f4920f.f4917e);
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
            this.f4918f = dVar;
            this.f4917e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (c.a.q0.a.z2.g1.c cVar : this.f4918f.f4911f) {
                    if (z && !this.f4917e.e("event_flag_force_post", false)) {
                        cVar.onCallback(this.f4917e);
                    } else {
                        d.L().post(new RunnableC0234a(this, cVar));
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
        public final /* synthetic */ c.a.q0.a.z2.g1.c f4921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4922f;

        public b(d dVar, c.a.q0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4922f = dVar;
            this.f4921e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4922f.f4911f.add(this.f4921e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.a.z2.g1.c f4923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f4924f;

        public c(d dVar, c.a.q0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4924f = dVar;
            this.f4923e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4924f.f4911f.remove(this.f4923e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(618859072, "Lc/a/q0/a/d2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(618859072, "Lc/a/q0/a/d2/d;");
                return;
            }
        }
        m = c.a.q0.a.k.a;
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
        this.f4911f = new HashSet();
        this.f4912g = 0;
        this.f4913h = new ArrayDeque();
        this.f4914i = null;
        this.l = false;
    }

    public static d J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d K = K();
            if (!K.l) {
                K.N();
            }
            return K;
        }
        return (d) invokeV.objValue;
    }

    public static d K() {
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
                    if (m && n != null) {
                        throw new IllegalStateException("When convinced current process is swan client，but Swan instance already init with: " + n);
                    }
                    n = new j();
                    return n;
                } else if (current.isSwanService) {
                    if (!(n instanceof l)) {
                        if (m && n != null) {
                            throw new IllegalStateException("When convinced current process is swan service，but Swan instance already init with: " + n);
                        }
                        n = new l();
                    }
                    return n;
                } else {
                    if (n == null) {
                        n = new c.a.q0.a.d2.c();
                    }
                    return n;
                }
            }
        }
        return (d) invokeV.objValue;
    }

    public static Handler L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (o == null) {
                o = new Handler(Looper.getMainLooper());
            }
            return o;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // c.a.q0.a.d2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (m) {
                String str = "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f4911f.size();
            }
            if (aVar != null) {
                Q(new a(this, aVar));
            }
        }
    }

    @Override // c.a.q0.a.d2.h
    public c.a.q0.a.f2.f.f0.a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f4916k == null) {
                this.f4916k = I();
            }
            return this.f4916k;
        }
        return (c.a.q0.a.f2.f.f0.a) invokeV.objValue;
    }

    public abstract c.a.q0.q.j.g H();

    public abstract c.a.q0.a.f2.f.f0.a I();

    public c.a.q0.q.j.g M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f4915j == null) {
                this.f4915j = H();
            }
            return this.f4915j;
        }
        return (c.a.q0.q.j.g) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.l) {
            return;
        }
        O();
        M();
        c.a.q0.a.y1.b.d.R();
        P();
        this.l = true;
    }

    public final void O() {
        c.a.q0.a.f2.f.f0.a B;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (B = B()) == null) {
            return;
        }
        B.I();
    }

    public abstract void P();

    public final synchronized void Q(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            synchronized (this) {
                this.f4913h.offer(runnable);
                if (this.f4914i == null) {
                    while (!this.f4913h.isEmpty()) {
                        Runnable poll = this.f4913h.poll();
                        this.f4914i = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f4914i = null;
                    }
                }
            }
        }
    }

    @Override // c.a.q0.a.d2.h
    public void p(c.a.q0.a.z2.g1.c<i.a> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null) {
            return;
        }
        Q(new c(this, cVar));
    }

    @Override // c.a.q0.a.d2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            w(str, null);
        }
    }

    @Override // c.a.q0.a.d2.h
    public void v(c.a.q0.a.z2.g1.c<i.a> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null) {
            return;
        }
        Q(new b(this, cVar));
    }

    @Override // c.a.q0.a.d2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new i.a(str, bundle));
        }
    }

    @Override // c.a.q0.a.d2.h
    public c.a.q0.a.p.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f4910e == null) {
                this.f4910e = new c.a.q0.a.p.a();
            }
            return this.f4910e;
        }
        return (c.a.q0.a.p.a) invokeV.objValue;
    }
}
