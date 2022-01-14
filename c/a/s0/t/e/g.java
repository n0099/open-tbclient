package c.a.s0.t.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f14014b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14015c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14016d;

    /* renamed from: e  reason: collision with root package name */
    public static int f14017e;

    /* renamed from: f  reason: collision with root package name */
    public static int f14018f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f14019g;

    /* renamed from: h  reason: collision with root package name */
    public static String f14020h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f14021i;

    /* renamed from: j  reason: collision with root package name */
    public static int f14022j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1942584603, "Lc/a/s0/t/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1942584603, "Lc/a/s0/t/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f14015c) {
                return c.a.s0.s.h0.b.k().l("video_report_config_upload_number", 5);
            }
            return f14018f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f14015c) {
                return c.a.s0.s.h0.b.k().l("video_report_config_upload_type", 0);
            }
            return f14017e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f14015c) {
                return c.a.s0.s.h0.b.k().h("video_report_config_switch", true);
            }
            return f14016d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f14015c = true;
        f14016d = jSONObject.optInt("switch", 1) != 0;
        c.a.s0.s.h0.b.k().u("video_report_config_switch", f14016d);
        f14017e = jSONObject.optInt("upload_type", 0);
        c.a.s0.s.h0.b.k().w("video_report_config_upload_type", f14017e);
        f14018f = jSONObject.optInt("upload_number", 5);
        c.a.s0.s.h0.b.k().w("video_report_config_upload_number", f14018f);
        f14022j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.s0.s.h0.b.k().w("video_report_prepare_max_wait_time", f14022j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.s0.s.h0.b.k().w("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.s0.s.h0.b.k().u("video_report_is_open_prepare_time", l);
        f14019g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.s0.s.h0.b.k().u("video_report_config_moov_check", f14019g);
        String optString = jSONObject.optString("android_debug_type");
        f14020h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.s0.s.h0.b.k().y("video_report_config_debug_type", f14020h);
            e(f14020h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.s0.s.h0.b.k().y("video_report_config_step_cache_strategy", a);
        f(a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14021i == null) {
            f14021i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14021i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f14021i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f14021i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14014b == null) {
            f14014b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14014b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f14014b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f14014b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f14014b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f14014b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
