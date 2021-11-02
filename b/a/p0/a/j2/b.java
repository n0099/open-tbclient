package b.a.p0.a.j2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return new a(g() ? b.a.p0.a.c1.a.q0().beginFlow(str) : null, b.a.p0.r.e.d(str));
        }
        return (a) invokeL.objValue;
    }

    public static void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().b(aVar.b());
            }
            Flow a2 = aVar.a();
            if (a2 != null) {
                a2.cancel();
            }
        }
    }

    public static void c(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().c(aVar.b());
            }
            Flow a2 = aVar.a();
            if (a2 != null) {
                a2.end();
            }
        }
    }

    public static void d(@NonNull a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, aVar, str, str2) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().a(aVar.b(), str, str2);
            }
            Flow a2 = aVar.a();
            if (a2 != null) {
                a2.addEvent(str, str2);
            }
        }
    }

    public static void e(@NonNull a aVar, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{aVar, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().g(aVar.b(), str, str2, j);
            }
            Flow a2 = aVar.a();
            if (a2 != null) {
                a2.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, aVar, str) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().h(aVar.b(), str);
            }
            Flow a2 = aVar.a();
            if (a2 != null) {
                a2.setValueWithDuration(str);
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? b.a.p0.a.c1.a.q0().e() : invokeV.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().i(str, str2);
            }
            b.a.p0.r.e.h(str, str2);
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().f(str, jSONObject);
            }
            b.a.p0.r.e.l(str2, jSONObject);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().d(str, map);
            }
            b.a.p0.r.e.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                b.a.p0.a.c1.a.q0().f(str, jSONObject);
            }
            b.a.p0.r.e.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            b.a.p0.a.c1.a.q0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            b.a.p0.a.c1.a.q0().f(str, jSONObject);
        }
    }
}
