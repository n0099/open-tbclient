package c.a.n0.j.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.t1.e;
import c.a.n0.j.n0.c;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static long f8782b;

    /* renamed from: c  reason: collision with root package name */
    public static String f8783c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781389621, "Lc/a/n0/j/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781389621, "Lc/a/n0/j/j/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
        f8782b = 86400000L;
        f8783c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            e L = e.L();
            c.a.n0.a.o.b.a aVar = null;
            if (jsObject == null || L == null || !b(L)) {
                bVar = null;
            } else {
                if (a) {
                    Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
                }
                c.a.n0.a.o.b.a F = c.a.n0.a.o.b.a.F(jsObject);
                String B = F.B("swanGameId");
                if (TextUtils.isEmpty(B)) {
                    bVar = null;
                } else {
                    c.a.n0.a.e2.g.b a2 = h.a();
                    if (!c(Long.valueOf(a2.getLong(B + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                        a2.putLong(B + "_Duration", 0L);
                    }
                    bVar = new b();
                    bVar.duration = a2.getLong(B + "_Duration", 0L);
                }
                aVar = F;
            }
            c.call(aVar, true, bVar);
        }
    }

    public static boolean b(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            String string = h.a().getString(f8783c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (e.f0().contains(jSONArray.optString(i))) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, l, l2)) == null) ? l.longValue() / 86400000 == l2.longValue() / 86400000 : invokeLL.booleanValue;
    }

    public static void d(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= j || e.L() == null || TextUtils.isEmpty(e.f0())) {
            return;
        }
        String f0 = e.f0();
        c.a.n0.a.e2.g.b a2 = h.a();
        long j3 = a2.getLong(f0 + "_LastPause", 0L);
        long j4 = a2.getLong(f0 + "_Duration", 0L);
        if (c(Long.valueOf(j), Long.valueOf(j2))) {
            if (c(Long.valueOf(j3), Long.valueOf(j))) {
                a2.putLong(f0 + "_Duration", (j4 + j2) - j);
            } else {
                a2.putLong(f0 + "_Duration", j2 - j);
            }
        } else {
            a2.putLong(f0 + "_Duration", j2 % f8782b);
        }
        a2.putLong(f0 + "_LastPause", System.currentTimeMillis());
    }
}
