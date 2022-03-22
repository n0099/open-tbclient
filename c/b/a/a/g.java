package c.b.a.a;

import c.b.b.q.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static w<String, g> f22302e;

    /* renamed from: f  reason: collision with root package name */
    public static int f22303f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f22304g;

    /* renamed from: h  reason: collision with root package name */
    public static final c.b.b.q.d f22305h;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.q.d a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.d f22306b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.q.d f22307c;

    /* renamed from: d  reason: collision with root package name */
    public final int f22308d;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.b.b.q.d a;

        /* renamed from: b  reason: collision with root package name */
        public c.b.b.q.d f22309b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.d f22310c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g.f22305h;
            this.f22309b = g.f22305h;
            this.f22310c = g.f22305h;
        }

        @SafeVarargs
        public final b a(Class<? extends c.b.a.a.a>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, clsArr)) == null) {
                this.a = c.b.a.a.b.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public g b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String f2 = g.f(this.a, this.f22309b, this.f22310c);
                g gVar = (g) g.f22302e.d(f2, null);
                if (gVar == null) {
                    g gVar2 = new g(this.a, this.f22309b, this.f22310c, null);
                    g.f22302e.i(f2, gVar2);
                    return gVar2;
                }
                return gVar;
            }
            return (g) invokeV.objValue;
        }

        @SafeVarargs
        public final b c(Class<? extends c.b.a.a.a>... clsArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, clsArr)) == null) {
                this.f22309b = c.b.a.a.b.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = g.f22305h;
                this.f22309b = g.f22305h;
                this.f22310c = g.f22305h;
                return this;
            }
            return (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(127760853, "Lc/b/a/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(127760853, "Lc/b/a/a/g;");
                return;
            }
        }
        f22302e = new w<>();
        f22303f = 0;
        f22304g = new b();
        f22305h = new c.b.b.q.d();
    }

    public /* synthetic */ g(c.b.b.q.d dVar, c.b.b.q.d dVar2, c.b.b.q.d dVar3, a aVar) {
        this(dVar, dVar2, dVar3);
    }

    @SafeVarargs
    public static final b d(Class<? extends c.b.a.a.a>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, clsArr)) == null) {
            b bVar = f22304g;
            bVar.d();
            bVar.a(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public static String e(c.b.b.q.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, dVar)) == null) {
            StringBuilder sb = new StringBuilder();
            int h2 = dVar.h();
            for (int i = 0; i < h2; i++) {
                sb.append(dVar.e(i) ? "1" : "0");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(c.b.b.q.d dVar, c.b.b.q.d dVar2, c.b.b.q.d dVar3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, dVar, dVar2, dVar3)) == null) {
            StringBuilder sb = new StringBuilder();
            if (!dVar.g()) {
                sb.append("{all:");
                sb.append(e(dVar));
                sb.append("}");
            }
            if (!dVar2.g()) {
                sb.append("{one:");
                sb.append(e(dVar2));
                sb.append("}");
            }
            if (!dVar3.g()) {
                sb.append("{exclude:");
                sb.append(e(dVar3));
                sb.append("}");
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    @SafeVarargs
    public static final b i(Class<? extends c.b.a.a.a>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, clsArr)) == null) {
            b bVar = f22304g;
            bVar.d();
            bVar.c(clsArr);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? this == obj : invokeL.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f22308d : invokeV.intValue;
    }

    public boolean h(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            c.b.b.q.d e2 = dVar.e();
            if (e2.d(this.a)) {
                if (this.f22306b.g() || this.f22306b.f(e2)) {
                    return this.f22307c.g() || !this.f22307c.f(e2);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f22308d : invokeV.intValue;
    }

    public g(c.b.b.q.d dVar, c.b.b.q.d dVar2, c.b.b.q.d dVar3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, dVar2, dVar3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dVar;
        this.f22306b = dVar2;
        this.f22307c = dVar3;
        int i3 = f22303f;
        f22303f = i3 + 1;
        this.f22308d = i3;
    }
}
