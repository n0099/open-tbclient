package b.a.p0.h.j;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a2.e;
import b.a.p0.a.k;
import b.a.p0.a.k2.g.h;
import b.a.p0.h.m0.c;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10483a;

    /* renamed from: b  reason: collision with root package name */
    public static long f10484b;

    /* renamed from: c  reason: collision with root package name */
    public static String f10485c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865186546, "Lb/a/p0/h/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-865186546, "Lb/a/p0/h/j/a;");
                return;
            }
        }
        f10483a = k.f6397a;
        f10484b = 86400000L;
        f10485c = "duration_permission_list";
    }

    public static void a(JsObject jsObject) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jsObject) == null) {
            e i2 = e.i();
            b.a.p0.a.y.b.a aVar = null;
            if (jsObject == null || i2 == null || !b(i2)) {
                bVar = null;
            } else {
                if (f10483a) {
                    r0 = "params is " + jsObject.toString();
                }
                b.a.p0.a.y.b.a F = b.a.p0.a.y.b.a.F(jsObject);
                String B = F.B("swanGameId");
                if (TextUtils.isEmpty(B)) {
                    bVar = null;
                } else {
                    b.a.p0.a.k2.g.b a2 = h.a();
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
            String string = h.a().getString(f10485c, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (e.U().contains(jSONArray.optString(i2))) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    if (f10483a) {
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 <= j || e.i() == null || TextUtils.isEmpty(e.U())) {
            return;
        }
        String U = e.U();
        b.a.p0.a.k2.g.b a2 = h.a();
        long j3 = a2.getLong(U + "_LastPause", 0L);
        long j4 = a2.getLong(U + "_Duration", 0L);
        if (c(Long.valueOf(j), Long.valueOf(j2))) {
            if (c(Long.valueOf(j3), Long.valueOf(j))) {
                a2.putLong(U + "_Duration", (j4 + j2) - j);
            } else {
                a2.putLong(U + "_Duration", j2 - j);
            }
        } else {
            a2.putLong(U + "_Duration", j2 % f10484b);
        }
        a2.putLong(U + "_LastPause", System.currentTimeMillis());
    }
}
