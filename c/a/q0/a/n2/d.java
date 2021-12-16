package c.a.q0.a.n2;

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
        public final /* synthetic */ c.a.q0.a.n2.s.e f7325e;

        public a(c.a.q0.a.n2.s.e eVar) {
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
            this.f7325e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("934", this.f7325e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628094282, "Lc/a/q0/a/n2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628094282, "Lc/a/q0/a/n2/d;");
                return;
            }
        }
        a = c.a.q0.a.k.a;
    }

    public static void a(c.a.q0.a.n2.s.e eVar, c.a.q0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, eVar, bVar) == null) || eVar == null || bVar == null) {
            return;
        }
        eVar.a = n.n(bVar.G());
        eVar.f7426f = bVar.H();
        eVar.f7423c = bVar.T();
        eVar.a("swan", c.a.q0.a.q2.b.h(bVar.G()));
        eVar.a("appversion", bVar.v1());
        eVar.a("thirdversion", bVar.w1());
        eVar.b(n.k(bVar.W()));
        eVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(c.a.q0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            if (fVar == null) {
                boolean z = a;
                return;
            }
            c.a.q0.a.n2.s.e eVar = new c.a.q0.a.n2.s.e();
            eVar.f7426f = fVar.f7426f;
            eVar.a = fVar.a;
            eVar.f7427g = fVar.f7427g;
            eVar.f7423c = fVar.f7423c;
            eVar.f7422b = fVar.f7422b;
            eVar.f7425e = fVar.f7425e;
            eVar.e(fVar.c());
            c(eVar);
        }
    }

    public static void c(c.a.q0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eVar) == null) {
            c.a.q0.a.z2.q.j(new a(eVar), "SwanAppFuncClickUBC");
        }
    }
}
