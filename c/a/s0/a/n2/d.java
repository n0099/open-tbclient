package c.a.s0.a.n2;

import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.n2.s.e f8125e;

        public a(c.a.s0.a.n2.s.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8125e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("934", this.f8125e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(235067272, "Lc/a/s0/a/n2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(235067272, "Lc/a/s0/a/n2/d;");
                return;
            }
        }
        a = c.a.s0.a.k.a;
    }

    public static void a(c.a.s0.a.n2.s.e eVar, c.a.s0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, eVar, bVar) == null) || eVar == null || bVar == null) {
            return;
        }
        eVar.a = n.n(bVar.G());
        eVar.f8223f = bVar.H();
        eVar.f8220c = bVar.T();
        eVar.a("swan", c.a.s0.a.q2.b.h(bVar.G()));
        eVar.a("appversion", bVar.v1());
        eVar.a("thirdversion", bVar.w1());
        eVar.b(n.k(bVar.W()));
        eVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(c.a.s0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            if (fVar == null) {
                boolean z = a;
                return;
            }
            c.a.s0.a.n2.s.e eVar = new c.a.s0.a.n2.s.e();
            eVar.f8223f = fVar.f8223f;
            eVar.a = fVar.a;
            eVar.f8224g = fVar.f8224g;
            eVar.f8220c = fVar.f8220c;
            eVar.f8219b = fVar.f8219b;
            eVar.f8222e = fVar.f8222e;
            eVar.e(fVar.c());
            c(eVar);
        }
    }

    public static void c(c.a.s0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eVar) == null) {
            c.a.s0.a.z2.q.j(new a(eVar), "SwanAppFuncClickUBC");
        }
    }
}
