package c.a.q0.a.n2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f1.e.b;
import c.a.q0.a.z2.o0;
import c.a.q0.a.z2.w;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628094561, "Lc/a/q0/a/n2/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(628094561, "Lc/a/q0/a/n2/m;");
                return;
            }
        }
        boolean z = c.a.q0.a.k.a;
        a = 0;
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        b.a V = c.a.q0.a.d2.d.J().r().V();
        String i2 = c.a.q0.a.q2.b.i(V.j0(), V.G());
        if (!jSONObject.has("appid")) {
            w.f(jSONObject, "appid", V.H());
        }
        if (!jSONObject.has("swan")) {
            w.f(jSONObject, "swan", i2);
        }
        if (!jSONObject.has("appversion")) {
            w.f(jSONObject, "appversion", V.v1());
        }
        if (!jSONObject.has("swanNativeVersion")) {
            w.f(jSONObject, "swanNativeVersion", c.a.q0.a.l.a());
        }
        if (!jSONObject.has("thirdversion")) {
            w.f(jSONObject, "thirdversion", V.w1());
        }
        if (!c.a.q0.a.d2.d.J().r().x0() || jSONObject.has("isWebDowngrade")) {
            return;
        }
        w.f(jSONObject, "isWebDowngrade", "1");
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = o0.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i2 = o0.i(o, hashSet);
            String f2 = o0.f(str);
            return f2 + "?" + i2;
        }
        return (String) invokeL.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : invokeV.intValue;
    }

    public static void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) {
            a = i2;
        }
    }

    public static <EvenT extends c.a.q0.a.n2.s.e> EvenT e(EvenT event, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, event, str, obj)) == null) {
            if (event != null && !TextUtils.isEmpty(str)) {
                event.a(str, obj);
            }
            return event;
        }
        return (EvenT) invokeLLL.objValue;
    }

    public static <EvenT extends c.a.q0.a.n2.s.e> EvenT f(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, event)) == null) {
            e(event, "isDownloading", String.valueOf(c.a.q0.a.d2.d.J().r().E0() ? 1 : 0));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends c.a.q0.a.n2.s.e> EvenT g(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, event)) == null) {
            e(event, "launchType", c() == 2 ? "2" : "1");
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends c.a.q0.a.n2.s.e> EvenT h(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, event)) == null) {
            e(event, "packageState", String.valueOf(c.a.q0.a.d2.d.J().r().D0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends c.a.q0.a.n2.s.e> EvenT i(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, event)) == null) {
            e(event, "coreState", String.valueOf(c.a.q0.a.h0.u.g.B0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }
}
