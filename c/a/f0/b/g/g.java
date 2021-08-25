package c.a.f0.b.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? c.a.f0.a.c.j.c("open_bes_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c.a.f0.a.c.j.c("hot_splash_max_count", 3) : invokeV.intValue;
    }

    public static float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a.f0.a.c.j.b("hot_background_time", 5.0f) : invokeV.floatValue;
    }

    public static float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.f0.a.c.j.b("hot_update_split_time", 5.0f) : invokeV.floatValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.f0.a.c.j.c("md5_check_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? c.a.f0.a.c.j.c("query_time_out_advance", 100) : invokeV.intValue;
    }

    public static void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2) == null) {
            c.a.f0.a.c.j.h("open_bes_switch", i2);
        }
    }

    public static void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) {
            j((float) jSONObject.optDouble("hot_background_time", 5.0d));
            i(jSONObject.optInt("hot_splash_max_count", 3));
        }
    }

    public static void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, null, i2) == null) {
            c.a.f0.a.c.j.h("hot_splash_max_count", i2);
        }
    }

    public static void j(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65545, null, f2) == null) {
            c.a.f0.a.c.j.g("hot_background_time", f2);
        }
    }

    public static void k(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65546, null, f2) == null) {
            c.a.f0.a.c.j.g("hot_update_split_time", f2);
        }
    }

    public static void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65547, null, i2) == null) {
            c.a.f0.a.c.j.h("md5_check_switch", i2);
        }
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65548, null, i2) == null) {
            c.a.f0.a.c.j.h("query_time_out_advance", i2);
        }
    }

    public static void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("freq");
            if (optJSONObject != null) {
                h(optJSONObject);
            }
            m(jSONObject.optInt("query_time_out_advance", 100));
            k((float) jSONObject.optDouble("hot_update_split_time", 5.0d));
            g(jSONObject.optInt("open_bes_switch", 0));
            l(jSONObject.optInt("md5_check_switch", 0));
        } catch (JSONException e2) {
            if (c.a.f0.a.a.a.f3344a) {
                e2.printStackTrace();
            }
        }
    }
}
