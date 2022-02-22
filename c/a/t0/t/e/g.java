package c.a.t0.t.e;

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
    public static Map<String, String> f14428b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14429c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14430d;

    /* renamed from: e  reason: collision with root package name */
    public static int f14431e;

    /* renamed from: f  reason: collision with root package name */
    public static int f14432f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f14433g;

    /* renamed from: h  reason: collision with root package name */
    public static String f14434h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f14435i;

    /* renamed from: j  reason: collision with root package name */
    public static int f14436j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(544928230, "Lc/a/t0/t/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(544928230, "Lc/a/t0/t/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f14429c) {
                return c.a.t0.s.j0.b.k().l("video_report_config_upload_number", 5);
            }
            return f14432f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f14429c) {
                return c.a.t0.s.j0.b.k().l("video_report_config_upload_type", 0);
            }
            return f14431e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f14429c) {
                return c.a.t0.s.j0.b.k().h("video_report_config_switch", true);
            }
            return f14430d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f14429c = true;
        f14430d = jSONObject.optInt("switch", 1) != 0;
        c.a.t0.s.j0.b.k().u("video_report_config_switch", f14430d);
        f14431e = jSONObject.optInt("upload_type", 0);
        c.a.t0.s.j0.b.k().w("video_report_config_upload_type", f14431e);
        f14432f = jSONObject.optInt("upload_number", 5);
        c.a.t0.s.j0.b.k().w("video_report_config_upload_number", f14432f);
        f14436j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.t0.s.j0.b.k().w("video_report_prepare_max_wait_time", f14436j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.t0.s.j0.b.k().w("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.t0.s.j0.b.k().u("video_report_is_open_prepare_time", l);
        f14433g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.t0.s.j0.b.k().u("video_report_config_moov_check", f14433g);
        String optString = jSONObject.optString("android_debug_type");
        f14434h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.t0.s.j0.b.k().y("video_report_config_debug_type", f14434h);
            e(f14434h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.t0.s.j0.b.k().y("video_report_config_step_cache_strategy", a);
        f(a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14435i == null) {
            f14435i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14435i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f14435i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f14435i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14428b == null) {
            f14428b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14428b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f14428b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f14428b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f14428b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f14428b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
