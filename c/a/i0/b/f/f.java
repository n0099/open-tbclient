package c.a.i0.b.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.i0.a.c.i.c("hot_splash_max_count", 3) : invokeV.intValue;
    }

    public static float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.i0.a.c.i.b("hot_background_time", 5.0f) : invokeV.floatValue;
    }

    public static float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.i0.a.c.i.b("hot_update_split_time", 5.0f) : invokeV.floatValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.i0.a.c.i.c("md5_check_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.i0.a.c.i.c("query_time_out_advance", 100) : invokeV.intValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a.i0.a.c.i.c("request_count", 10) : invokeV.intValue;
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i2) == null) {
            c.a.i0.a.c.i.h("open_bes_switch", i2);
        }
    }

    public static void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) {
            k((float) jSONObject.optDouble("hot_background_time", 5.0d));
            i(jSONObject.optInt("hot_splash_max_count", 3));
            j(jSONObject.optInt("hot_switch", 1));
        }
    }

    public static void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            c.a.i0.a.c.i.h("hot_splash_max_count", i2);
        }
    }

    public static void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, null, i2) == null) {
            c.a.i0.a.c.i.h("hot_switch", 1);
        }
    }

    public static void k(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65546, null, f2) == null) {
            c.a.i0.a.c.i.g("hot_background_time", f2);
        }
    }

    public static void l(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65547, null, f2) == null) {
            c.a.i0.a.c.i.g("hot_update_split_time", f2);
        }
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i2) == null) {
            c.a.i0.a.c.i.h("md5_check_switch", i2);
        }
    }

    public static void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, null, i2) == null) {
            c.a.i0.a.c.i.h("query_time_out_advance", i2);
        }
    }

    public static void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i2) == null) {
            c.a.i0.a.c.i.h("request_count", i2);
        }
    }

    public static void p(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                h(optJSONObject);
            }
            n(jSONObject.optInt("query_time_out_advance", 100));
            l((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            g(jSONObject.optInt("open_bes_switch", 0));
            m(jSONObject.optInt("md5_check_switch", 0));
            o(jSONObject.optInt("request_count", 10));
        } catch (JSONException unused) {
        }
    }
}
