package b.a.p0.j.i0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.d2.e;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.k;
import b.a.p0.a.n2.n;
import b.a.p0.a.p1.m;
import b.a.p0.j.g0.h;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f11182a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends b.a.p0.a.y1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.j.i0.a f11183c;

        public a(b.a.p0.j.i0.a aVar) {
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
            this.f11183c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.y1.a.b.c.b, b.a.p0.a.y1.a.b.c.c, b.a.p0.a.y1.a.b.c.a
        public void onEvent(@NonNull b.a.p0.a.y1.a.b.a.b bVar) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (SwanAppNetworkUtils.i(null)) {
                    i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
                } else {
                    i2 = -2;
                }
                if (b.f11182a) {
                    String str = "get NetworkQuality: " + i2;
                }
                b.a.p0.j.i0.a aVar = this.f11183c;
                aVar.m = i2;
                n.x("976", aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(723087700, "Lb/a/p0/j/i0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(723087700, "Lb/a/p0/j/i0/b;");
                return;
            }
        }
        f11182a = k.f6863a;
    }

    public static void b(b.a.p0.j.i0.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, aVar) == null) || aVar == null) {
            return;
        }
        b.a.p0.a.y1.c.e.a.P().W(null, m.class, new a(aVar));
    }

    public static void c(b.a.k0.a.d.b bVar) {
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
        if (f11182a) {
            String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(b.a.p0.j.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime));
        }
        if (a2.exceptionTime >= b.a.p0.j.q.c.b.a()) {
            return;
        }
        b.a.p0.j.i0.a aVar = new b.a.p0.j.i0.a();
        aVar.f7380b = "stuck";
        aVar.f7383e = "jserror";
        aVar.f7384f = e.f0();
        if (e.L() != null && e.L().X() != null) {
            b.a X = e.L().X();
            aVar.f7381c = X.T();
            aVar.f7379a = n.n(X.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = b.a.p0.j.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
