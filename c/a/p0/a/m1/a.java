package c.a.p0.a.m1;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.p0.a.f0.f.b;
import c.a.p0.a.p2.w;
import c.a.p0.a.s1.b.f.e;
import c.a.p0.a.u.d;
import c.a.p0.q.h.i;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(823654382, "Lc/a/p0/a/m1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(823654382, "Lc/a/p0/a/m1/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<c.a.p0.a.m1.g.a> e2 = swanAppConfigData.e();
        if (e2 != null && !e2.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e2, jSONObject, jSONObject2);
            if (b.k()) {
                boolean z = false;
                for (c.a.p0.a.m1.g.a aVar : e2) {
                    String h2 = b.h(aVar.f6515e);
                    if (!TextUtils.isEmpty(h2) && new File(h2).exists()) {
                        aVar.f6519i = h2;
                        c(jSONObject, jSONObject2, aVar);
                        z = true;
                        d.i("Module-Plugin", "use debug dependencies，name=" + aVar.f6515e + " path=" + aVar.f6519i);
                    } else {
                        d.o("Module-Plugin", "debug dependencies not exist，name=" + aVar.f6515e + " path=" + aVar.f6519i);
                    }
                }
                if (!z) {
                    e.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    d.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            c.a.p0.a.m1.h.b.c("dependenciesPath", jSONObject3);
            c.a.p0.a.m1.h.b.c("dependenciesConfig", jSONObject4);
            return;
        }
        c.a.p0.a.m1.h.b.c("dependenciesPath", null);
        c.a.p0.a.m1.h.b.c("dependenciesConfig", null);
        if (a) {
            c.a.p0.a.m1.e.a.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<c.a.p0.a.m1.g.a> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (c.a.p0.a.m1.g.a aVar : list) {
            if (aVar != null) {
                if (aVar.k) {
                    c(jSONObject, jSONObject2, aVar);
                } else {
                    i q = c.a.p0.q.f.a.i().q(aVar.f6515e, aVar.l, aVar.m);
                    if (q == null) {
                        c.a.p0.a.m1.e.a.a(Log.getStackTraceString(new Throwable(aVar.f6515e + " query db fail")));
                    } else {
                        File t = c.a.p0.a.q0.d.t(aVar.f6515e, String.valueOf(q.f10963i));
                        if (t != null && t.exists()) {
                            aVar.f6519i = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, aVar);
                        } else {
                            c.a.p0.a.m1.e.a.a(Log.getStackTraceString(new Throwable(aVar.f6515e + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull c.a.p0.a.m1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, aVar) == null) {
            String str = aVar.f6519i;
            String str2 = aVar.f6520j;
            if (a) {
                c.a.p0.a.m1.e.a.b("apply dep path, name = " + aVar.f6515e + "; inline = " + aVar.k + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                c.a.p0.a.m1.e.a.b(Log.getStackTraceString(new Throwable(aVar.f6515e + " path is empty")));
                return;
            }
            w.f(jSONObject, aVar.f6515e, str);
            if (TextUtils.isEmpty(aVar.f6520j)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                w.f(jSONObject2, aVar.f6515e, w.d(c.a.p0.w.d.E(file)));
            }
        }
    }
}
