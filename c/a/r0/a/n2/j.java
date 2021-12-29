package c.a.r0.a.n2;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.n2.s.d f8085e;

        public a(c.a.r0.a.n2.s.d dVar) {
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
            this.f8085e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("671", this.f8085e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(431580963, "Lc/a/r0/a/n2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(431580963, "Lc/a/r0/a/n2/j;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
    }

    public static void a(c.a.r0.q.f.f fVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (fVar == null) {
                boolean z2 = a;
                return;
            }
            c.a.r0.a.u2.a aVar = new c.a.r0.a.u2.a();
            aVar.k(11L);
            aVar.i(2331L);
            aVar.f("Retry=" + z + ", Scene=" + fVar.getClass().getName());
            c.a.r0.a.n2.s.d dVar = new c.a.r0.a.n2.s.d();
            dVar.q(n.n(i2));
            dVar.p(aVar);
            if (fVar instanceof c.a.r0.a.h0.m.h) {
                dVar.r(((c.a.r0.a.h0.m.h) fVar).J0());
            }
            b(dVar);
            if (a) {
                String str = "Statis: Retry=" + z + ", Scene=" + fVar.getClass().getSimpleName();
            }
        }
    }

    public static void b(c.a.r0.a.n2.s.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            if (dVar == null) {
                boolean z = a;
            } else {
                c.a.r0.a.z2.q.k(new a(dVar), "SwanStabilityUBC");
            }
        }
    }
}
