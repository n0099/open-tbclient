package c.a.n0.a.t1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.t1.i;
import c.a.n0.a.v0.e.f.c;
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
public abstract class d extends c.a.n0.a.t1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static volatile d j;
    public static Handler k;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.n0.a.f.a a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<c.a.n0.a.p2.g1.c<i.a>> f6333b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f6334c;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<Runnable> f6335d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f6336e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.q.i.g f6337f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.n0.a.v1.f.f0.a f6338g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6339h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f6340b;

        /* renamed from: c.a.n0.a.t1.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0459a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.p2.g1.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f6341b;

            public RunnableC0459a(a aVar, c.a.n0.a.p2.g1.c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6341b = aVar;
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.onCallback(this.f6341b.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6340b = dVar;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (c.a.n0.a.p2.g1.c cVar : this.f6340b.f6333b) {
                    if (z && !this.a.e("event_flag_force_post", false)) {
                        cVar.onCallback(this.a);
                    } else {
                        d.L().post(new RunnableC0459a(this, cVar));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p2.g1.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f6342b;

        public b(d dVar, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6342b = dVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6342b.f6333b.add(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p2.g1.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f6343b;

        public c(d dVar, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6343b = dVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6343b.f6333b.remove(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1223146132, "Lc/a/n0/a/t1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1223146132, "Lc/a/n0/a/t1/d;");
                return;
            }
        }
        i = c.a.n0.a.a.a;
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
        this.f6333b = new HashSet();
        this.f6334c = 0;
        this.f6335d = new ArrayDeque();
        this.f6336e = null;
        this.f6339h = false;
    }

    public static d J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            d K = K();
            if (!K.f6339h) {
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
            if (j instanceof j) {
                return j;
            }
            synchronized (d.class) {
                if (j instanceof j) {
                    return j;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    if (i && j != null) {
                        throw new IllegalStateException("When convinced current process is swan client，but Swan instance already init with: " + j);
                    }
                    j = new j();
                    return j;
                } else if (current.isSwanService) {
                    if (!(j instanceof l)) {
                        if (i && j != null) {
                            throw new IllegalStateException("When convinced current process is swan service，but Swan instance already init with: " + j);
                        }
                        j = new l();
                    }
                    return j;
                } else {
                    if (j == null) {
                        j = new c.a.n0.a.t1.c();
                    }
                    return j;
                }
            }
        }
        return (d) invokeV.objValue;
    }

    public static Handler L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (k == null) {
                k = new Handler(Looper.getMainLooper());
            }
            return k;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // c.a.n0.a.t1.h
    public void A(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (i) {
                Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.f6333b.size());
            }
            if (aVar != null) {
                Q(new a(this, aVar));
            }
        }
    }

    @Override // c.a.n0.a.t1.h
    public c.a.n0.a.v1.f.f0.a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f6338g == null) {
                this.f6338g = I();
            }
            return this.f6338g;
        }
        return (c.a.n0.a.v1.f.f0.a) invokeV.objValue;
    }

    public abstract c.a.n0.q.i.g H();

    public abstract c.a.n0.a.v1.f.f0.a I();

    public c.a.n0.q.i.g M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f6337f == null) {
                this.f6337f = H();
            }
            return this.f6337f;
        }
        return (c.a.n0.q.i.g) invokeV.objValue;
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f6339h) {
            return;
        }
        O();
        M();
        c.a.n0.a.o1.b.d.R();
        P();
        this.f6339h = true;
    }

    public final void O() {
        c.a.n0.a.v1.f.f0.a B;
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
                this.f6335d.offer(runnable);
                if (this.f6336e == null) {
                    while (!this.f6335d.isEmpty()) {
                        Runnable poll = this.f6335d.poll();
                        this.f6336e = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.f6336e = null;
                    }
                }
            }
        }
    }

    @Override // c.a.n0.a.t1.h
    public void p(c.a.n0.a.p2.g1.c<i.a> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || cVar == null) {
            return;
        }
        Q(new c(this, cVar));
    }

    @Override // c.a.n0.a.t1.h
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            w(str, null);
        }
    }

    @Override // c.a.n0.a.t1.h
    public void v(c.a.n0.a.p2.g1.c<i.a> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null) {
            return;
        }
        Q(new b(this, cVar));
    }

    @Override // c.a.n0.a.t1.h
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new i.a(str, bundle));
        }
    }

    @Override // c.a.n0.a.t1.h
    public c.a.n0.a.f.a y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.n0.a.f.a();
            }
            return this.a;
        }
        return (c.a.n0.a.f.a) invokeV.objValue;
    }
}
