package c.a.r0.a.u1.k.i;

import androidx.annotation.NonNull;
import c.a.r0.a.u1.l.e;
import c.a.r0.a.z2.q;
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
public class c implements c.a.r0.a.u1.k.i.a, c.a.r0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f9531e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.r0.a.u1.r.c.a f9532c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.a.u1.r.c.a f9533d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9534e;

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
            this.f9534e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (c.a.r0.a.u1.k.i.a.f9525b) {
                    try {
                        c.a.r0.a.u1.k.i.a.f9525b.wait(this.f9534e);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.u1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final Map<Runnable, String> f9535c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9536d;

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
            this.f9535c = new ConcurrentHashMap();
            this.f9536d = false;
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9536d = false;
                f();
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.f9536d) {
                    this.f9535c.put(runnable, str);
                } else {
                    q.l(runnable, str);
                }
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f9536d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f9535c.size();
                f();
                if (c.a.r0.a.f1.f.a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "high task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size;
                }
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f9536d = true;
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9535c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.f9535c.entrySet()) {
                if (entry != null) {
                    q.l(entry.getKey(), entry.getValue());
                }
            }
            this.f9535c.clear();
        }

        @Override // c.a.r0.a.u1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "HighPriorityTask" : (String) invokeV.objValue;
        }
    }

    /* renamed from: c.a.r0.a.u1.k.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0607c implements c.a.r0.a.u1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final Map<Runnable, String> f9537c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9538d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9539e;

        public C0607c(c cVar) {
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
            this.f9539e = cVar;
            this.f9537c = new ConcurrentHashMap();
            this.f9538d = false;
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f9538d = false;
                f();
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void c(@NonNull Runnable runnable, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
                if (this.f9538d) {
                    this.f9537c.put(runnable, str);
                } else {
                    q.l(runnable, str);
                }
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f9538d = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f9537c.size();
                f();
                if (c.a.r0.a.f1.f.a.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "low task dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; task num = " + size;
                }
                if (e.e()) {
                    this.f9539e.c();
                }
            }
        }

        @Override // c.a.r0.a.u1.r.c.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f9538d = true;
                if (e.e()) {
                    this.f9539e.b(e.f());
                }
            }
        }

        public final void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f9537c.isEmpty()) {
                return;
            }
            for (Map.Entry<Runnable, String> entry : this.f9537c.entrySet()) {
                if (entry != null) {
                    q.l(entry.getKey(), entry.getValue());
                }
            }
            this.f9537c.clear();
        }

        @Override // c.a.r0.a.u1.r.c.a
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-917973252, "Lc/a/r0/a/u1/k/i/c$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-917973252, "Lc/a/r0/a/u1/k/i/c$d;");
                    return;
                }
            }
            a = new c(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-371904516, "Lc/a/r0/a/u1/k/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-371904516, "Lc/a/r0/a/u1/k/i/c;");
                return;
            }
        }
        f9531e = Executors.newSingleThreadExecutor();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.a : (c) invokeV.objValue;
    }

    @Override // c.a.r0.a.u1.k.i.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (c.a.r0.a.f1.f.a.a) {
                String str = "low priority thread wait = " + i2;
            }
            f9531e.execute(new a(this, i2));
        }
    }

    @Override // c.a.r0.a.u1.k.i.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            boolean z = c.a.r0.a.f1.f.a.a;
            synchronized (c.a.r0.a.u1.k.i.a.f9525b) {
                try {
                    c.a.r0.a.u1.k.i.a.f9525b.notifyAll();
                }
            }
        }
    }

    public boolean d(@NonNull Runnable runnable, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, runnable, str, z)) == null) {
            if (z) {
                this.f9532c.c(runnable, str);
                return true;
            } else if (e.e()) {
                f9531e.execute(runnable);
                return true;
            } else {
                this.f9533d.c(runnable, str);
                return true;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.a.u1.r.a.g().i(this.f9532c, 3000);
            c.a.r0.a.u1.r.a.g().i(this.f9533d, 5000);
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
        this.f9532c = new b(this);
        this.f9533d = new C0607c(this);
    }
}
