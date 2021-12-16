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
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static w<String, g> f27662e;

    /* renamed from: f  reason: collision with root package name */
    public static int f27663f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f27664g;

    /* renamed from: h  reason: collision with root package name */
    public static final c.b.b.q.d f27665h;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.b.b.q.d a;

    /* renamed from: b  reason: collision with root package name */
    public final c.b.b.q.d f27666b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.b.q.d f27667c;

    /* renamed from: d  reason: collision with root package name */
    public final int f27668d;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.b.b.q.d a;

        /* renamed from: b  reason: collision with root package name */
        public c.b.b.q.d f27669b;

        /* renamed from: c  reason: collision with root package name */
        public c.b.b.q.d f27670c;

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
            this.a = g.f27665h;
            this.f27669b = g.f27665h;
            this.f27670c = g.f27665h;
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
                String f2 = g.f(this.a, this.f27669b, this.f27670c);
                g gVar = (g) g.f27662e.d(f2, null);
                if (gVar == null) {
                    g gVar2 = new g(this.a, this.f27669b, this.f27670c, null);
                    g.f27662e.i(f2, gVar2);
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
                this.f27669b = c.b.a.a.b.a(clsArr);
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.a = g.f27665h;
                this.f27669b = g.f27665h;
                this.f27670c = g.f27665h;
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
        f27662e = new w<>();
        f27663f = 0;
        f27664g = new b();
        f27665h = new c.b.b.q.d();
    }

    public /* synthetic */ g(c.b.b.q.d dVar, c.b.b.q.d dVar2, c.b.b.q.d dVar3, a aVar) {
        this(dVar, dVar2, dVar3);
    }

    @SafeVarargs
    public static final b d(Class<? extends c.b.a.a.a>... clsArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, clsArr)) == null) {
            b bVar = f27664g;
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
            for (int i2 = 0; i2 < h2; i2++) {
                sb.append(dVar.e(i2) ? "1" : "0");
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
            b bVar = f27664g;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f27668d : invokeV.intValue;
    }

    public boolean h(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            c.b.b.q.d e2 = dVar.e();
            if (e2.d(this.a)) {
                if (this.f27666b.g() || this.f27666b.f(e2)) {
                    return this.f27667c.g() || !this.f27667c.f(e2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f27668d : invokeV.intValue;
    }

    public g(c.b.b.q.d dVar, c.b.b.q.d dVar2, c.b.b.q.d dVar3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, dVar2, dVar3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = dVar;
        this.f27666b = dVar2;
        this.f27667c = dVar3;
        int i4 = f27663f;
        f27663f = i4 + 1;
        this.f27668d = i4;
    }
}
