package b.a.p0.a.n2;

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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7277a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.e f7278e;

        public a(b.a.p0.a.n2.s.e eVar) {
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
            this.f7278e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("934", this.f7278e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330166412, "Lb/a/p0/a/n2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330166412, "Lb/a/p0/a/n2/d;");
                return;
            }
        }
        f7277a = b.a.p0.a.k.f6863a;
    }

    public static void a(b.a.p0.a.n2.s.e eVar, b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, eVar, bVar) == null) || eVar == null || bVar == null) {
            return;
        }
        eVar.f7379a = n.n(bVar.G());
        eVar.f7384f = bVar.H();
        eVar.f7381c = bVar.T();
        eVar.a("swan", b.a.p0.a.q2.b.h(bVar.G()));
        eVar.a("appversion", bVar.v1());
        eVar.a("thirdversion", bVar.w1());
        eVar.b(n.k(bVar.W()));
        eVar.d(bVar.s0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(b.a.p0.a.n2.s.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            if (fVar == null) {
                boolean z = f7277a;
                return;
            }
            b.a.p0.a.n2.s.e eVar = new b.a.p0.a.n2.s.e();
            eVar.f7384f = fVar.f7384f;
            eVar.f7379a = fVar.f7379a;
            eVar.f7385g = fVar.f7385g;
            eVar.f7381c = fVar.f7381c;
            eVar.f7380b = fVar.f7380b;
            eVar.f7383e = fVar.f7383e;
            eVar.e(fVar.c());
            c(eVar);
        }
    }

    public static void c(b.a.p0.a.n2.s.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eVar) == null) {
            b.a.p0.a.z2.q.j(new a(eVar), "SwanAppFuncClickUBC");
        }
    }
}
