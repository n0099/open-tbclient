package c.a.r0.t.e;

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
    public static Map<String, String> f13864b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13865c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13866d;

    /* renamed from: e  reason: collision with root package name */
    public static int f13867e;

    /* renamed from: f  reason: collision with root package name */
    public static int f13868f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13869g;

    /* renamed from: h  reason: collision with root package name */
    public static String f13870h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f13871i;

    /* renamed from: j  reason: collision with root package name */
    public static int f13872j;

    /* renamed from: k  reason: collision with root package name */
    public static int f13873k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-135130140, "Lc/a/r0/t/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-135130140, "Lc/a/r0/t/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f13865c) {
                return c.a.r0.s.g0.b.j().k("video_report_config_upload_number", 5);
            }
            return f13868f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f13865c) {
                return c.a.r0.s.g0.b.j().k("video_report_config_upload_type", 0);
            }
            return f13867e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f13865c) {
                return c.a.r0.s.g0.b.j().g("video_report_config_switch", true);
            }
            return f13866d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f13865c = true;
        f13866d = jSONObject.optInt("switch", 1) != 0;
        c.a.r0.s.g0.b.j().t("video_report_config_switch", f13866d);
        f13867e = jSONObject.optInt("upload_type", 0);
        c.a.r0.s.g0.b.j().v("video_report_config_upload_type", f13867e);
        f13868f = jSONObject.optInt("upload_number", 5);
        c.a.r0.s.g0.b.j().v("video_report_config_upload_number", f13868f);
        f13872j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.r0.s.g0.b.j().v("video_report_prepare_max_wait_time", f13872j);
        f13873k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.r0.s.g0.b.j().v("video_report_prepare_max_loading_time", f13873k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.r0.s.g0.b.j().t("video_report_is_open_prepare_time", l);
        f13869g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.r0.s.g0.b.j().t("video_report_config_moov_check", f13869g);
        String optString = jSONObject.optString("android_debug_type");
        f13870h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.r0.s.g0.b.j().x("video_report_config_debug_type", f13870h);
            e(f13870h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.r0.s.g0.b.j().x("video_report_config_step_cache_strategy", a);
        f(a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f13871i == null) {
            f13871i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f13871i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f13871i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f13871i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f13864b == null) {
            f13864b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f13864b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f13864b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f13864b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f13864b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f13864b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
