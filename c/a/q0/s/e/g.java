package c.a.q0.s.e;

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
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static String a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f13823b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13824c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13825d;

    /* renamed from: e  reason: collision with root package name */
    public static int f13826e;

    /* renamed from: f  reason: collision with root package name */
    public static int f13827f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13828g;

    /* renamed from: h  reason: collision with root package name */
    public static String f13829h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f13830i;

    /* renamed from: j  reason: collision with root package name */
    public static int f13831j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1643695172, "Lc/a/q0/s/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1643695172, "Lc/a/q0/s/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f13824c) {
                return c.a.q0.r.j0.b.k().l("video_report_config_upload_number", 5);
            }
            return f13827f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f13824c) {
                return c.a.q0.r.j0.b.k().l("video_report_config_upload_type", 0);
            }
            return f13826e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f13824c) {
                return c.a.q0.r.j0.b.k().h("video_report_config_switch", true);
            }
            return f13825d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f13824c = true;
        f13825d = jSONObject.optInt("switch", 1) != 0;
        c.a.q0.r.j0.b.k().u("video_report_config_switch", f13825d);
        f13826e = jSONObject.optInt("upload_type", 0);
        c.a.q0.r.j0.b.k().w("video_report_config_upload_type", f13826e);
        f13827f = jSONObject.optInt("upload_number", 5);
        c.a.q0.r.j0.b.k().w("video_report_config_upload_number", f13827f);
        f13831j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.q0.r.j0.b.k().w("video_report_prepare_max_wait_time", f13831j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.q0.r.j0.b.k().w("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.q0.r.j0.b.k().u("video_report_is_open_prepare_time", l);
        f13828g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.q0.r.j0.b.k().u("video_report_config_moov_check", f13828g);
        String optString = jSONObject.optString("android_debug_type");
        f13829h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.q0.r.j0.b.k().y("video_report_config_debug_type", f13829h);
            e(f13829h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.q0.r.j0.b.k().y("video_report_config_step_cache_strategy", a);
        f(a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f13830i == null) {
            f13830i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f13830i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f13830i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f13830i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f13823b == null) {
            f13823b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f13823b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f13823b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f13823b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f13823b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f13823b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
