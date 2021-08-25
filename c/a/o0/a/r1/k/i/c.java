package c.a.o0.a.r1.k.i;

import c.a.o0.a.r1.l.e;
import c.a.o0.a.v2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class c implements c.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f8387e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8388b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f8389c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.a.r1.r.c.a f8390d;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8391b;

        public a(c cVar) {
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
            this.f8391b = cVar;
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8391b.f8388b = false;
                this.f8391b.d();
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f8391b.f8388b = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f8391b.f8389c.size();
                this.f8391b.d();
                if (c.a.o0.a.f1.f.a.f5674a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size;
                }
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f8391b.f8388b = true;
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "TaskDispatch" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f8392a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1709515998, "Lc/a/o0/a/r1/k/i/c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1709515998, "Lc/a/o0/a/r1/k/i/c$b;");
                    return;
                }
            }
            f8392a = new c(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2022799844, "Lc/a/o0/a/r1/k/i/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2022799844, "Lc/a/o0/a/r1/k/i/c;");
                return;
            }
        }
        f8387e = e.k();
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.f8392a : (c) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8389c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f8389c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f8389c.clear();
    }

    public boolean e(Runnable runnable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str)) == null) {
            if (runnable == null) {
                return false;
            }
            if (f8387e > 0 && this.f8388b) {
                this.f8389c.put(runnable, str);
                return true;
            }
            q.k(runnable, str);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f8387e <= 0) {
                boolean z = c.a.o0.a.f1.f.a.f5674a;
            } else {
                c.a.o0.a.r1.r.a.f().h(this.f8390d, f8387e);
            }
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
        this.f8388b = false;
        this.f8389c = new ConcurrentHashMap();
        this.f8390d = new a(this);
    }
}
