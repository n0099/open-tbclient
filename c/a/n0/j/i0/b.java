package c.a.n0.j.i0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.d2.n;
import c.a.n0.a.f1.m;
import c.a.n0.a.t1.e;
import c.a.n0.a.v0.e.b;
import c.a.n0.j.g0.h;
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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends c.a.n0.a.o1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.j.i0.a f8781c;

        public a(c.a.n0.j.i0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8781c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.o1.a.b.c.b, c.a.n0.a.o1.a.b.c.c, c.a.n0.a.o1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.o1.a.b.a.b bVar) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
                } else {
                    i = -2;
                }
                if (b.a) {
                    Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
                }
                c.a.n0.j.i0.a aVar = this.f8781c;
                aVar.m = i;
                n.x("976", aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(610556085, "Lc/a/n0/j/i0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(610556085, "Lc/a/n0/j/i0/b;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static void b(c.a.n0.j.i0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        c.a.n0.a.o1.c.e.a.P().W(null, m.class, new a(aVar));
    }

    public static void c(c.a.j0.a.d.b bVar) {
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
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(c.a.n0.j.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= c.a.n0.j.q.c.b.a()) {
            return;
        }
        c.a.n0.j.i0.a aVar = new c.a.n0.j.i0.a();
        aVar.f4188b = "stuck";
        aVar.f4191e = "jserror";
        aVar.f4192f = e.f0();
        if (e.L() != null && e.L().X() != null) {
            b.a X = e.L().X();
            aVar.f4189c = X.T();
            aVar.a = n.n(X.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = c.a.n0.j.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
