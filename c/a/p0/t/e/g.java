package c.a.p0.t.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f14878a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f14879b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14880c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14881d;

    /* renamed from: e  reason: collision with root package name */
    public static int f14882e;

    /* renamed from: f  reason: collision with root package name */
    public static int f14883f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f14884g;

    /* renamed from: h  reason: collision with root package name */
    public static String f14885h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f14886i;

    /* renamed from: j  reason: collision with root package name */
    public static int f14887j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-815188510, "Lc/a/p0/t/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-815188510, "Lc/a/p0/t/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f14880c) {
                return c.a.p0.s.d0.b.j().k("video_report_config_upload_number", 5);
            }
            return f14883f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f14880c) {
                return c.a.p0.s.d0.b.j().k("video_report_config_upload_type", 0);
            }
            return f14882e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f14880c) {
                return c.a.p0.s.d0.b.j().g("video_report_config_switch", true);
            }
            return f14881d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f14880c = true;
        f14881d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        c.a.p0.s.d0.b.j().t("video_report_config_switch", f14881d);
        f14882e = jSONObject.optInt("upload_type", 0);
        c.a.p0.s.d0.b.j().v("video_report_config_upload_type", f14882e);
        f14883f = jSONObject.optInt("upload_number", 5);
        c.a.p0.s.d0.b.j().v("video_report_config_upload_number", f14883f);
        f14887j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.p0.s.d0.b.j().v("video_report_prepare_max_wait_time", f14887j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.p0.s.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.p0.s.d0.b.j().t("video_report_is_open_prepare_time", l);
        f14884g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.p0.s.d0.b.j().t("video_report_config_moov_check", f14884g);
        String optString = jSONObject.optString("android_debug_type");
        f14885h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.p0.s.d0.b.j().x("video_report_config_debug_type", f14885h);
            e(f14885h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f14878a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.p0.s.d0.b.j().x("video_report_config_step_cache_strategy", f14878a);
        f(f14878a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14886i == null) {
            f14886i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14886i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f14886i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f14886i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14879b == null) {
            f14879b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14879b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f14879b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f14879b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f14879b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f14879b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
