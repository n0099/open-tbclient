package c.a.q0.a.n2;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
            return new a(g() ? c.a.q0.a.c1.a.A0().beginFlow(str) : null, c.a.q0.u.e.d(str));
        }
        return (a) invokeL.objValue;
    }

    public static void b(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().b(aVar.b());
            }
            Flow a = aVar.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().c(aVar.b());
            }
            Flow a = aVar.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull a aVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, aVar, str, str2) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().a(aVar.b(), str, str2);
            }
            Flow a = aVar.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void e(@NonNull a aVar, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{aVar, str, str2, Long.valueOf(j2)}) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().g(aVar.b(), str, str2, j2);
            }
            Flow a = aVar.a();
            if (a != null) {
                a.addEvent(str, str2, j2);
            }
        }
    }

    public static void f(@NonNull a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, aVar, str) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().h(aVar.b(), str);
            }
            Flow a = aVar.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a.q0.a.c1.a.A0().e() : invokeV.booleanValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().i(str, str2);
            }
            c.a.q0.u.e.h(str, str2);
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().f(str, jSONObject);
            }
            c.a.q0.u.e.l(str2, jSONObject);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().d(str, map);
            }
            c.a.q0.u.e.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                c.a.q0.a.c1.a.A0().f(str, jSONObject);
            }
            c.a.q0.u.e.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            c.a.q0.a.c1.a.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            c.a.q0.a.c1.a.A0().f(str, jSONObject);
        }
    }
}
