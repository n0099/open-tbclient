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
    public static Map<String, String> f14346b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14347c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14348d;

    /* renamed from: e  reason: collision with root package name */
    public static int f14349e;

    /* renamed from: f  reason: collision with root package name */
    public static int f14350f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f14351g;

    /* renamed from: h  reason: collision with root package name */
    public static String f14352h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f14353i;

    /* renamed from: j  reason: collision with root package name */
    public static int f14354j;

    /* renamed from: k  reason: collision with root package name */
    public static int f14355k;
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
            if (!f14347c) {
                return c.a.s0.s.g0.b.j().k("video_report_config_upload_number", 5);
            }
            return f14350f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f14347c) {
                return c.a.s0.s.g0.b.j().k("video_report_config_upload_type", 0);
            }
            return f14349e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f14347c) {
                return c.a.s0.s.g0.b.j().g("video_report_config_switch", true);
            }
            return f14348d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f14347c = true;
        f14348d = jSONObject.optInt("switch", 1) != 0;
        c.a.s0.s.g0.b.j().t("video_report_config_switch", f14348d);
        f14349e = jSONObject.optInt("upload_type", 0);
        c.a.s0.s.g0.b.j().v("video_report_config_upload_type", f14349e);
        f14350f = jSONObject.optInt("upload_number", 5);
        c.a.s0.s.g0.b.j().v("video_report_config_upload_number", f14350f);
        f14354j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.s0.s.g0.b.j().v("video_report_prepare_max_wait_time", f14354j);
        f14355k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.s0.s.g0.b.j().v("video_report_prepare_max_loading_time", f14355k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.s0.s.g0.b.j().t("video_report_is_open_prepare_time", l);
        f14351g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.s0.s.g0.b.j().t("video_report_config_moov_check", f14351g);
        String optString = jSONObject.optString("android_debug_type");
        f14352h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.s0.s.g0.b.j().x("video_report_config_debug_type", f14352h);
            e(f14352h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.s0.s.g0.b.j().x("video_report_config_step_cache_strategy", a);
        f(a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14353i == null) {
            f14353i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14353i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f14353i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f14353i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14346b == null) {
            f14346b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14346b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f14346b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f14346b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f14346b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f14346b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
