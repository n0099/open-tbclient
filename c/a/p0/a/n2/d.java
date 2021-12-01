package c.a.p0.a.n2;

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
        public final /* synthetic */ c.a.p0.a.n2.s.e f7016e;

        public a(c.a.p0.a.n2.s.e eVar) {
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
            this.f7016e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("934", this.f7016e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(824607787, "Lc/a/p0/a/n2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(824607787, "Lc/a/p0/a/n2/d;");
                return;
            }
        }
        a = c.a.p0.a.k.a;
    }

    public static void a(c.a.p0.a.n2.s.e eVar, c.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, eVar, bVar) == null) || eVar == null || bVar == null) {
            return;
        }
        eVar.a = n.n(bVar.G());
        eVar.f7117f = bVar.H();
        eVar.f7114c = bVar.T();
        eVar.a("swan", c.a.p0.a.q2.b.h(bVar.G()));
        eVar.a("appversion", bVar.v1());
        eVar.a("thirdversion", bVar.w1());
        eVar.b(n.k(bVar.W()));
        eVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(c.a.p0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            if (fVar == null) {
                boolean z = a;
                return;
            }
            c.a.p0.a.n2.s.e eVar = new c.a.p0.a.n2.s.e();
            eVar.f7117f = fVar.f7117f;
            eVar.a = fVar.a;
            eVar.f7118g = fVar.f7118g;
            eVar.f7114c = fVar.f7114c;
            eVar.f7113b = fVar.f7113b;
            eVar.f7116e = fVar.f7116e;
            eVar.e(fVar.c());
            c(eVar);
        }
    }

    public static void c(c.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eVar) == null) {
            c.a.p0.a.z2.q.j(new a(eVar), "SwanAppFuncClickUBC");
        }
    }
}
