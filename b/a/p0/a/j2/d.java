package b.a.p0.a.j2;

import b.a.p0.a.v2.q;
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
    public static final boolean f6299a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j2.p.e f6300e;

        public a(b.a.p0.a.j2.p.e eVar) {
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
            this.f6300e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("934", this.f6300e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1326472328, "Lb/a/p0/a/j2/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1326472328, "Lb/a/p0/a/j2/d;");
                return;
            }
        }
        f6299a = b.a.p0.a.k.f6397a;
    }

    public static void a(b.a.p0.a.j2.p.e eVar, b.a.p0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, eVar, bVar) == null) || eVar == null || bVar == null) {
            return;
        }
        eVar.f6383a = k.m(bVar.F());
        eVar.f6388f = bVar.G();
        eVar.f6385c = bVar.S();
        eVar.a("swan", b.a.p0.a.m2.b.h(bVar.F()));
        eVar.a("appversion", bVar.s1());
        eVar.a("thirdversion", bVar.t1());
        eVar.b(k.k(bVar.V()));
        eVar.d(bVar.q0().getString(UBCCloudControlProcessor.UBC_KEY));
    }

    public static void b(b.a.p0.a.j2.p.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fVar) == null) {
            if (fVar == null) {
                boolean z = f6299a;
                return;
            }
            b.a.p0.a.j2.p.e eVar = new b.a.p0.a.j2.p.e();
            eVar.f6388f = fVar.f6388f;
            eVar.f6383a = fVar.f6383a;
            eVar.f6389g = fVar.f6389g;
            eVar.f6385c = fVar.f6385c;
            eVar.f6384b = fVar.f6384b;
            eVar.f6387e = fVar.f6387e;
            eVar.e(fVar.c());
            c(eVar);
        }
    }

    public static void c(b.a.p0.a.j2.p.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, eVar) == null) {
            q.i(new a(eVar), "SwanAppFuncClickUBC");
        }
    }
}
