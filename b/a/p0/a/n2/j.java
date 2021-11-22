package b.a.p0.a.n2;

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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7307a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.n2.s.d f7308e;

        public a(b.a.p0.a.n2.s.d dVar) {
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
            this.f7308e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.k("671", this.f7308e.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1330166598, "Lb/a/p0/a/n2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1330166598, "Lb/a/p0/a/n2/j;");
                return;
            }
        }
        f7307a = b.a.p0.a.k.f6863a;
    }

    public static void a(b.a.p0.q.f.f fVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (fVar == null) {
                boolean z2 = f7307a;
                return;
            }
            b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
            aVar.k(11L);
            aVar.i(2331L);
            aVar.f("Retry=" + z + ", Scene=" + fVar.getClass().getName());
            b.a.p0.a.n2.s.d dVar = new b.a.p0.a.n2.s.d();
            dVar.q(n.n(i2));
            dVar.p(aVar);
            if (fVar instanceof b.a.p0.a.h0.m.h) {
                dVar.r(((b.a.p0.a.h0.m.h) fVar).I0());
            }
            b(dVar);
            if (f7307a) {
                String str = "Statis: Retry=" + z + ", Scene=" + fVar.getClass().getSimpleName();
            }
        }
    }

    public static void b(b.a.p0.a.n2.s.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            if (dVar == null) {
                boolean z = f7307a;
            } else {
                b.a.p0.a.z2.q.k(new a(dVar), "SwanStabilityUBC");
            }
        }
    }
}
