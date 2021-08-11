package c.a.n0.h.h0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.a2.e;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.k;
import c.a.n0.a.n1.m;
import c.a.n0.h.f0.h;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10983a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends c.a.n0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.h.h0.a f10984c;

        public a(c.a.n0.h.h0.a aVar) {
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
            this.f10984c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v1.a.b.c.b, c.a.n0.a.v1.a.b.c.c, c.a.n0.a.v1.a.b.c.a
        public void onEvent(@NonNull c.a.n0.a.v1.a.b.a.b bVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
                } else {
                    i2 = -2;
                }
                if (b.f10983a) {
                    String str = "get NetworkQuality: " + i2;
                }
                c.a.n0.h.h0.a aVar = this.f10984c;
                aVar.m = i2;
                k.u("976", aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1165374798, "Lc/a/n0/h/h0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1165374798, "Lc/a/n0/h/h0/b;");
                return;
            }
        }
        f10983a = c.a.n0.a.k.f6803a;
    }

    public static void b(c.a.n0.h.h0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        c.a.n0.a.v1.c.e.a.E().L(null, m.class, new a(aVar));
    }

    public static void c(c.a.i0.a.d.b bVar) {
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
        if (f10983a) {
            String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(c.a.n0.h.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime));
        }
        if (a2.exceptionTime >= c.a.n0.h.q.c.b.a()) {
            return;
        }
        c.a.n0.h.h0.a aVar = new c.a.n0.h.h0.a();
        aVar.f6790b = "stuck";
        aVar.f6793e = "jserror";
        aVar.f6794f = e.V();
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            aVar.f6791c = N.T();
            aVar.f6789a = k.m(N.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = c.a.n0.h.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
