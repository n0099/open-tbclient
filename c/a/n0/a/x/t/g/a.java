package c.a.n0.a.x.t.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e0.d.c;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.q0.d;
import c.a.n0.a.t1.e;
import c.a.n0.a.t1.n.g;
import c.a.n0.a.u.d;
import c.a.n0.a.w0.f;
import c.a.n0.a.x.t.g.b;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f7461b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.x.t.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0574a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.f.e.b a;

        public RunnableC0574a(c.a.n0.a.f.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1221997623, "Lc/a/n0/a/x/t/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1221997623, "Lc/a/n0/a/x/t/g/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        c.a.n0.a.s0.a.g0().getSwitch("swan_next_page_res_load", 0);
        f7461b = false;
        d.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + f7461b);
        l();
    }

    public static boolean a(@NonNull c.a.n0.a.f.e.b<?> bVar, @NonNull c.a.n0.a.c1.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bVar, bVar2)) == null) {
            g f2 = f.U().f(bVar2.f3949d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + bVar2.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + bVar2.f3949d);
            }
            return q0.S(bVar, f2.r);
        }
        return invokeLL.booleanValue;
    }

    public static b.a b(@NonNull e eVar, @NonNull c.a.n0.a.f.e.b<?> bVar, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, eVar, bVar, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = d.e.i(str, valueOf).getPath() + File.separator;
                    b bVar2 = new b();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            c.a.n0.a.c1.b d2 = c.a.n0.a.c1.b.d(o0.g(str3), str2);
                            if (q0.b(eVar.P(), d2, true) && a(bVar, d2)) {
                                bVar2.a(f(bVar, d2));
                            }
                        }
                    }
                    return bVar2.b();
                }
            }
            return null;
        }
        return (b.a) invokeLLL.objValue;
    }

    public static c.a.n0.a.c1.b c() {
        InterceptResult invokeV;
        SwanAppActivity x;
        c.a.n0.a.x.g.f H;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            e a0 = e.a0();
            if (a0 == null || (x = a0.x()) == null || x.isFinishing() || x.isDestroyed() || (H = f.U().H()) == null) {
                return null;
            }
            return H.k3();
        }
        return (c.a.n0.a.c1.b) invokeV.objValue;
    }

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static b.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (b.a) invokeL.objValue;
    }

    public static c f(c.a.n0.a.f.e.b<?> bVar, c.a.n0.a.c1.b bVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bVar, bVar2)) == null) ? c.a.n0.a.x.u.d.a(c.a.n0.a.v1.f.o0.a.a(bVar, bVar2, "")) : (c) invokeLL.objValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) ? c.a.n0.a.c1.d.d.g().k(pMSAppInfo) : (JSONObject) invokeL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) ? c.a.n0.a.q0.d.C(str, str2) : invokeLL.booleanValue;
    }

    public static void i(c.a.n0.a.f.e.b<?> bVar) {
        PMSAppInfo f0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, bVar) == null) && f7461b && bVar != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            e a0 = e.a0();
            if (a0 == null || (f0 = a0.V().f0()) == null) {
                return;
            }
            b.a e2 = e(f0);
            if (e2 == null) {
                e2 = b(a0, bVar, f0);
                d(f0, e2);
            }
            if (e2 != null) {
                c.a.n0.a.x.u.g.U().V0(bVar.c(), e2);
            }
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static void j(c.a.n0.a.f.e.b<?> bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, bVar) == null) && f7461b && bVar != null) {
            long currentTimeMillis = a ? System.currentTimeMillis() : 0L;
            ExecutorUtilsExt.postOnElastic(new RunnableC0574a(bVar), "SwanAppSlaveTopPages", 2);
            if (a) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg async cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
            }
        }
    }

    public static Set<String> k(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject.length() <= 0) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashSet.add(next);
                }
            }
            if (a) {
                Log.d("SwanAppSlaveTopPages", "get top pages - " + linkedHashSet);
            }
            return linkedHashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
        }
    }

    public static Set<String> m(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (a) {
                c.a.n0.a.c1.b c2 = c();
                Log.d("SwanAppSlaveTopPages", "current page - " + c2);
            }
            JSONObject g2 = g(pMSAppInfo);
            if (g2 == null || g2.length() <= 0) {
                return null;
            }
            if (a) {
                Log.d("SwanAppSlaveTopPages", "pages info - " + g2);
            }
            return k(g2);
        }
        return (Set) invokeL.objValue;
    }
}
