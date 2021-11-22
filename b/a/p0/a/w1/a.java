package b.a.p0.a.w1;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.a.p0.a.c2.b.f.e;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.p0.f.b;
import b.a.p0.a.z2.w;
import b.a.p0.q.i.i;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9193a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1338448217, "Lb/a/p0/a/w1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1338448217, "Lb/a/p0/a/w1/a;");
                return;
            }
        }
        f9193a = k.f6863a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<b.a.p0.a.w1.g.a> e2 = swanAppConfigData.e();
        if (e2 != null && !e2.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e2, jSONObject, jSONObject2);
            if (b.k()) {
                boolean z = false;
                for (b.a.p0.a.w1.g.a aVar : e2) {
                    String h2 = b.h(aVar.f9250e);
                    if (!TextUtils.isEmpty(h2) && new File(h2).exists()) {
                        aVar.f9254i = h2;
                        c(jSONObject, jSONObject2, aVar);
                        z = true;
                        d.i("Module-Plugin", "use debug dependencies，name=" + aVar.f9250e + " path=" + aVar.f9254i);
                    } else {
                        d.o("Module-Plugin", "debug dependencies not exist，name=" + aVar.f9250e + " path=" + aVar.f9254i);
                    }
                }
                if (!z) {
                    e.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    d.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            b.a.p0.a.w1.h.b.c("dependenciesPath", jSONObject3);
            b.a.p0.a.w1.h.b.c("dependenciesConfig", jSONObject4);
            return;
        }
        b.a.p0.a.w1.h.b.c("dependenciesPath", null);
        b.a.p0.a.w1.h.b.c("dependenciesConfig", null);
        if (f9193a) {
            b.a.p0.a.w1.e.a.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<b.a.p0.a.w1.g.a> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (b.a.p0.a.w1.g.a aVar : list) {
            if (aVar != null) {
                if (aVar.k) {
                    c(jSONObject, jSONObject2, aVar);
                } else {
                    i q = b.a.p0.q.g.a.i().q(aVar.f9250e, aVar.l, aVar.m);
                    if (q == null) {
                        b.a.p0.a.w1.e.a.a(Log.getStackTraceString(new Throwable(aVar.f9250e + " query db fail")));
                    } else {
                        File t = b.a.p0.a.a1.d.t(aVar.f9250e, String.valueOf(q.f11776i));
                        if (t != null && t.exists()) {
                            aVar.f9254i = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, aVar);
                        } else {
                            b.a.p0.a.w1.e.a.a(Log.getStackTraceString(new Throwable(aVar.f9250e + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull b.a.p0.a.w1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, aVar) == null) {
            String str = aVar.f9254i;
            String str2 = aVar.j;
            if (f9193a) {
                b.a.p0.a.w1.e.a.b("apply dep path, name = " + aVar.f9250e + "; inline = " + aVar.k + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                b.a.p0.a.w1.e.a.b(Log.getStackTraceString(new Throwable(aVar.f9250e + " path is empty")));
                return;
            }
            w.f(jSONObject, aVar.f9250e, str);
            if (TextUtils.isEmpty(aVar.j)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                w.f(jSONObject2, aVar.f9250e, w.d(b.a.p0.w.d.E(file)));
            }
        }
    }
}
