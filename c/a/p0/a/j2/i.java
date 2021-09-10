package c.a.p0.a.j2;

import c.a.p0.a.v2.q;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7005a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j2.p.d f7006e;

        public a(c.a.p0.a.j2.p.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7006e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("671", this.f7006e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820913858, "Lc/a/p0/a/j2/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820913858, "Lc/a/p0/a/j2/i;");
                return;
            }
        }
        f7005a = c.a.p0.a.k.f7077a;
    }

    public static void a(c.a.p0.n.f.d dVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{dVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (dVar == null) {
                boolean z2 = f7005a;
                return;
            }
            c.a.p0.a.q2.a aVar = new c.a.p0.a.q2.a();
            aVar.j(11L);
            aVar.h(2331L);
            aVar.e("Retry=" + z + ", Scene=" + dVar.getClass().getName());
            c.a.p0.a.j2.p.d dVar2 = new c.a.p0.a.j2.p.d();
            dVar2.q(k.m(i2));
            dVar2.p(aVar);
            if (dVar instanceof c.a.p0.a.h0.m.g) {
                dVar2.r(((c.a.p0.a.h0.m.g) dVar).G0());
            }
            b(dVar2);
            if (f7005a) {
                String str = "Statis: Retry=" + z + ", Scene=" + dVar.getClass().getSimpleName();
            }
        }
    }

    public static void b(c.a.p0.a.j2.p.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            if (dVar == null) {
                boolean z = f7005a;
            } else {
                q.j(new a(dVar), "SwanStabilityUBC");
            }
        }
    }
}
