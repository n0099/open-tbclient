package c.a.s0.a.u1.k.i;

import androidx.annotation.NonNull;
import c.a.s0.a.u1.l.e;
import c.a.s0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class c implements c.a.s0.a.u1.k.i.a, c.a.s0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f9631e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.s0.a.u1.r.c.a f9632c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.s0.a.u1.r.c.a f9633d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9634e;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9634e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (c.a.s0.a.u1.k.i.a.f9625b) {
                    try {
                        c.a.s0.a.u1.k.i.a.f9625b.wait(this.f9634e);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.s0.a.u1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final Map<Runnable, String> f9635c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9636d;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9635c = new ConcurrentHashMap();
            this.f9636d = false;
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9636d = false;
                f();
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.f9636d) {
                    this.f9635c.put(runnable, str);
                } else {
                    q.l(runnable, str);
                }
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f9636d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f9635c.size();
                f();
                if (c.a.s0.a.f1.f.a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "high task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size;
                }
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f9636d = true;
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9635c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.f9635c.entrySet()) {
                if (entry != null) {
                    q.l(entry.getKey(), entry.getValue());
                }
            }
            this.f9635c.clear();
        }

        @Override // c.a.s0.a.u1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "HighPriorityTask" : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.s0.a.u1.k.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0618c implements c.a.s0.a.u1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final Map<Runnable, String> f9637c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9638d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9639e;

        public C0618c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9639e = cVar;
            this.f9637c = new ConcurrentHashMap();
            this.f9638d = false;
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9638d = false;
                f();
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.f9638d) {
                    this.f9637c.put(runnable, str);
                } else {
                    q.l(runnable, str);
                }
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f9638d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f9637c.size();
                f();
                if (c.a.s0.a.f1.f.a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "low task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size;
                }
                if (e.e()) {
                    this.f9639e.c();
                }
            }
        }

        @Override // c.a.s0.a.u1.r.c.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f9638d = true;
                if (e.e()) {
                    this.f9639e.b(e.f());
                }
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9637c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.f9637c.entrySet()) {
                if (entry != null) {
                    q.l(entry.getKey(), entry.getValue());
                }
            }
            this.f9637c.clear();
        }

        @Override // c.a.s0.a.u1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "LowPriorityTask" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1428507429, "Lc/a/s0/a/u1/k/i/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1428507429, "Lc/a/s0/a/u1/k/i/c$d;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-877463141, "Lc/a/s0/a/u1/k/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-877463141, "Lc/a/s0/a/u1/k/i/c;");
                return;
            }
        }
        f9631e = Executors.newSingleThreadExecutor();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.a : (c) invokeV.objValue;
    }

    @Override // c.a.s0.a.u1.k.i.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (c.a.s0.a.f1.f.a.a) {
                String str = "low priority thread wait = " + i2;
            }
            f9631e.execute(new a(this, i2));
        }
    }

    @Override // c.a.s0.a.u1.k.i.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = c.a.s0.a.f1.f.a.a;
            synchronized (c.a.s0.a.u1.k.i.a.f9625b) {
                try {
                    c.a.s0.a.u1.k.i.a.f9625b.notifyAll();
                }
            }
        }
    }

    public boolean d(@NonNull Runnable runnable, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, runnable, str, z)) == null) {
            if (z) {
                this.f9632c.c(runnable, str);
                return true;
            } else if (e.e()) {
                f9631e.execute(runnable);
                return true;
            } else {
                this.f9633d.c(runnable, str);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.a.u1.r.a.g().i(this.f9632c, 3000);
            c.a.s0.a.u1.r.a.g().i(this.f9633d, 5000);
        }
    }

    public c() {
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
        this.f9632c = new b(this);
        this.f9633d = new C0618c(this);
    }
}
