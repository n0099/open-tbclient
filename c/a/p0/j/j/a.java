package c.a.p0.j.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.e2.g.h;
import c.a.p0.a.t1.e;
import c.a.p0.j.n0.c;
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
    public static long f10502b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10503c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1101331251, "Lc/a/p0/j/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1101331251, "Lc/a/p0/j/j/a;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f10502b = 86400000L;
        f10503c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            e L = e.L();
            c.a.p0.a.o.b.a aVar = null;
            if (jsObject == null || L == null || !b(L)) {
                bVar = null;
            } else {
                if (a) {
                    r0 = "params is " + jsObject.toString();
                }
                c.a.p0.a.o.b.a F = c.a.p0.a.o.b.a.F(jsObject);
                String B = F.B("swanGameId");
                if (TextUtils.isEmpty(B)) {
                    bVar = null;
                } else {
                    c.a.p0.a.e2.g.b a2 = h.a();
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
            String string = h.a().getString(f10503c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (e.f0().contains(jSONArray.optString(i2))) {
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

    public static void d(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || j3 <= j2 || e.L() == null || TextUtils.isEmpty(e.f0())) {
            return;
        }
        String f0 = e.f0();
        c.a.p0.a.e2.g.b a2 = h.a();
        long j4 = a2.getLong(f0 + "_LastPause", 0L);
        long j5 = a2.getLong(f0 + "_Duration", 0L);
        if (c(Long.valueOf(j2), Long.valueOf(j3))) {
            if (c(Long.valueOf(j4), Long.valueOf(j2))) {
                a2.putLong(f0 + "_Duration", (j5 + j3) - j2);
            } else {
                a2.putLong(f0 + "_Duration", j3 - j2);
            }
        } else {
            a2.putLong(f0 + "_Duration", j3 % f10502b);
        }
        a2.putLong(f0 + "_LastPause", System.currentTimeMillis());
    }
}
