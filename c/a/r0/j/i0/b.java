package c.a.r0.j.i0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.d2.e;
import c.a.r0.a.f1.e.b;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.p1.m;
import c.a.r0.j.g0.h;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends c.a.r0.a.y1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j.i0.a f11176c;

        public a(c.a.r0.j.i0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11176c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.y1.a.b.c.b, c.a.r0.a.y1.a.b.c.c, c.a.r0.a.y1.a.b.c.a
        public void onEvent(@NonNull c.a.r0.a.y1.a.b.a.b bVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
                } else {
                    i2 = -2;
                }
                if (b.a) {
                    String str = "get NetworkQuality: " + i2;
                }
                c.a.r0.j.i0.a aVar = this.f11176c;
                aVar.m = i2;
                n.x("976", aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-175497935, "Lc/a/r0/j/i0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-175497935, "Lc/a/r0/j/i0/b;");
                return;
            }
        }
        a = k.a;
    }

    public static void b(c.a.r0.j.i0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        c.a.r0.a.y1.c.e.a.P().W(null, m.class, new a(aVar));
    }

    public static void c(c.a.n0.a.d.b bVar) {
        V8ExceptionInfo a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bVar) == null) || bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (a) {
            String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(c.a.r0.j.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime));
        }
        if (a2.exceptionTime >= c.a.r0.j.q.c.b.a()) {
            return;
        }
        c.a.r0.j.i0.a aVar = new c.a.r0.j.i0.a();
        aVar.f8119b = "stuck";
        aVar.f8122e = "jserror";
        aVar.f8123f = e.f0();
        if (e.L() != null && e.L().X() != null) {
            b.a X = e.L().X();
            aVar.f8120c = X.T();
            aVar.a = n.n(X.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = c.a.r0.j.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
