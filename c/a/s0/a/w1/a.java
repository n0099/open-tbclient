package c.a.s0.a.w1;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.s0.a.c2.b.f.e;
import c.a.s0.a.e0.d;
import c.a.s0.a.k;
import c.a.s0.a.p0.f.b;
import c.a.s0.a.z2.w;
import c.a.s0.q.i.i;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(243349077, "Lc/a/s0/a/w1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(243349077, "Lc/a/s0/a/w1/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<c.a.s0.a.w1.g.a> e2 = swanAppConfigData.e();
        if (e2 != null && !e2.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e2, jSONObject, jSONObject2);
            if (b.k()) {
                boolean z = false;
                for (c.a.s0.a.w1.g.a aVar : e2) {
                    String h2 = b.h(aVar.f9787e);
                    if (!TextUtils.isEmpty(h2) && new File(h2).exists()) {
                        aVar.f9791i = h2;
                        c(jSONObject, jSONObject2, aVar);
                        z = true;
                        d.i("Module-Plugin", "use debug dependencies，name=" + aVar.f9787e + " path=" + aVar.f9791i);
                    } else {
                        d.o("Module-Plugin", "debug dependencies not exist，name=" + aVar.f9787e + " path=" + aVar.f9791i);
                    }
                }
                if (!z) {
                    e.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    d.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            c.a.s0.a.w1.h.b.c("dependenciesPath", jSONObject3);
            c.a.s0.a.w1.h.b.c("dependenciesConfig", jSONObject4);
            return;
        }
        c.a.s0.a.w1.h.b.c("dependenciesPath", null);
        c.a.s0.a.w1.h.b.c("dependenciesConfig", null);
        if (a) {
            c.a.s0.a.w1.e.a.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<c.a.s0.a.w1.g.a> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (c.a.s0.a.w1.g.a aVar : list) {
            if (aVar != null) {
                if (aVar.k) {
                    c(jSONObject, jSONObject2, aVar);
                } else {
                    i q = c.a.s0.q.g.a.i().q(aVar.f9787e, aVar.l, aVar.m);
                    if (q == null) {
                        c.a.s0.a.w1.e.a.a(Log.getStackTraceString(new Throwable(aVar.f9787e + " query db fail")));
                    } else {
                        File t = c.a.s0.a.a1.d.t(aVar.f9787e, String.valueOf(q.f11738i));
                        if (t != null && t.exists()) {
                            aVar.f9791i = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, aVar);
                        } else {
                            c.a.s0.a.w1.e.a.a(Log.getStackTraceString(new Throwable(aVar.f9787e + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull c.a.s0.a.w1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, aVar) == null) {
            String str = aVar.f9791i;
            String str2 = aVar.f9792j;
            if (a) {
                c.a.s0.a.w1.e.a.b("apply dep path, name = " + aVar.f9787e + "; inline = " + aVar.k + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                c.a.s0.a.w1.e.a.b(Log.getStackTraceString(new Throwable(aVar.f9787e + " path is empty")));
                return;
            }
            w.f(jSONObject, aVar.f9787e, str);
            if (TextUtils.isEmpty(aVar.f9792j)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                w.f(jSONObject2, aVar.f9787e, w.d(c.a.s0.w.d.E(file)));
            }
        }
    }
}
