package c.a.r0.a.d2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.d2.i;
import c.a.r0.a.f1.e.f.c;
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
public abstract class d extends c.a.r0.a.d2.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean m;
    public static volatile d n;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.a.p.a f5665e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<c.a.r0.a.z2.g1.c<i.a>> f5666f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f5667g;

    /* renamed from: h  reason: collision with root package name */
    public final Queue<Runnable> f5668h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f5669i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.q.j.g f5670j;
    public c.a.r0.a.f2.f.f0.a k;
    public boolean l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a f5671e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5672f;

        /* renamed from: c.a.r0.a.d2.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0302a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.z2.g1.c f5673e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f5674f;

            public RunnableC0302a(a aVar, c.a.r0.a.z2.g1.c cVar) {
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
                this.f5674f = aVar;
                this.f5673e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5673e.onCallback(this.f5674f.f5671e);
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
            this.f5672f = dVar;
            this.f5671e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (c.a.r0.a.z2.g1.c cVar : this.f5672f.f5666f) {
                    if (z && !this.f5671e.e("event_flag_force_post", false)) {
                        cVar.onCallback(this.f5671e);
                    } else {
                        d.L().post(new RunnableC0302a(this, cVar));
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
        public final /* synthetic */ c.a.r0.a.z2.g1.c f5675e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5676f;

        public b(d dVar, c.a.r0.a.z2.g1.c cVar) {
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
            this.f5676f = dVar;
            this.f5675e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5676f.f5666f.add(this.f5675e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.z2.g1.c f5677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5678f;

        public c(d dVar, c.a.r0.a.z2.g1.c cVar) {
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
            this.f5678f = dVar;
            this.f5677e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5678f.f5666f.remove(this.f5677e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(422345567, "Lc/a/r0/a/d2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(422345567, "Lc/a/r0/a/d2/d;");
                return;
            }
        }
        m = c.a.r0.a.k.a;
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
        this.f5666f = new HashSet();
        this.f5667g = 0;
        this.f5668h = new ArrayDeque();
        this.f5669i = null;
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
                        n = new c.a.r0.a.d2.c();
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

    @Override // c.a.r0.a.d2.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (m) {
                String str = "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f5666f.size();
            }
            if (aVar != null) {
                Q(new a(this, aVar));
            }
        }
    }

    @Override // c.a.r0.a.d2.h
    public c.a.r0.a.f2.f.f0.a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.k == null) {
                this.k = I();
            }
            return this.k;
        }
        return (c.a.r0.a.f2.f.f0.a) invokeV.objValue;
    }

    public abstract c.a.r0.q.j.g H();

    public abstract c.a.r0.a.f2.f.f0.a I();

    public c.a.r0.q.j.g M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f5670j == null) {
                this.f5670j = H();
            }
            return this.f5670j;
        }
        return (c.a.r0.q.j.g) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.l) {
            return;
        }
        O();
        M();
        c.a.r0.a.y1.b.d.R();
        P();
        this.l = true;
    }

    public final void O() {
        c.a.r0.a.f2.f.f0.a B;
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
                this.f5668h.offer(runnable);
                if (this.f5669i == null) {
                    while (!this.f5668h.isEmpty()) {
                        Runnable poll = this.f5668h.poll();
                        this.f5669i = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f5669i = null;
                    }
                }
            }
        }
    }

    @Override // c.a.r0.a.d2.h
    public void p(c.a.r0.a.z2.g1.c<i.a> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null) {
            return;
        }
        Q(new c(this, cVar));
    }

    @Override // c.a.r0.a.d2.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            w(str, null);
        }
    }

    @Override // c.a.r0.a.d2.h
    public void v(c.a.r0.a.z2.g1.c<i.a> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null) {
            return;
        }
        Q(new b(this, cVar));
    }

    @Override // c.a.r0.a.d2.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new i.a(str, bundle));
        }
    }

    @Override // c.a.r0.a.d2.h
    public c.a.r0.a.p.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f5665e == null) {
                this.f5665e = new c.a.r0.a.p.a();
            }
            return this.f5665e;
        }
        return (c.a.r0.a.p.a) invokeV.objValue;
    }
}
