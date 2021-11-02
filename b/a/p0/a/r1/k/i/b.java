package b.a.p0.a.r1.k.i;

import b.a.p0.a.r1.l.e;
import b.a.p0.a.v2.q;
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
public class b implements b.a.p0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final int f7691e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7692b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Runnable, String> f7693c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.a.r1.r.c.a f7694d;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f7695b;

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
            this.f7695b = bVar;
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7695b.f7692b = false;
                this.f7695b.d();
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f7695b.f7692b = false;
                long currentTimeMillis = System.currentTimeMillis();
                int size = this.f7695b.f7693c.size();
                this.f7695b.d();
                if (b.a.p0.a.f1.f.a.f5062a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String str = "thread dispatch cost = " + (currentTimeMillis2 - currentTimeMillis) + "ms ; thread num = " + size;
                }
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f7695b.f7692b = true;
            }
        }

        @Override // b.a.p0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "ThreadDispatch" : (String) invokeV.objValue;
        }
    }

    /* renamed from: b.a.p0.a.r1.k.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0356b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f7696a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1607776255, "Lb/a/p0/a/r1/k/i/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1607776255, "Lb/a/p0/a/r1/k/i/b$b;");
                    return;
                }
            }
            f7696a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1531286147, "Lb/a/p0/a/r1/k/i/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1531286147, "Lb/a/p0/a/r1/k/i/b;");
                return;
            }
        }
        f7691e = e.i();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? C0356b.f7696a : (b) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7693c.isEmpty()) {
            return;
        }
        for (Map.Entry<Runnable, String> entry : this.f7693c.entrySet()) {
            if (entry != null) {
                q.k(entry.getKey(), entry.getValue());
            }
        }
        this.f7693c.clear();
    }

    public boolean f(Runnable runnable, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, str)) == null) {
            if (runnable == null) {
                return false;
            }
            if (f7691e > 0 && this.f7692b) {
                this.f7693c.put(runnable, str);
                return true;
            }
            q.k(runnable, str);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.f().g();
            if (f7691e <= 0) {
                boolean z = b.a.p0.a.f1.f.a.f5062a;
            } else {
                b.a.p0.a.r1.r.a.f().h(this.f7694d, f7691e);
            }
        }
    }

    public b() {
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
        this.f7692b = false;
        this.f7693c = new ConcurrentHashMap();
        this.f7694d = new a(this);
    }
}
