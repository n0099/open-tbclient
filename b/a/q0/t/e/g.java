package b.a.q0.t.e;

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
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f14762a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f14763b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14764c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14765d;

    /* renamed from: e  reason: collision with root package name */
    public static int f14766e;

    /* renamed from: f  reason: collision with root package name */
    public static int f14767f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f14768g;

    /* renamed from: h  reason: collision with root package name */
    public static String f14769h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f14770i;
    public static int j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1965727330, "Lb/a/q0/t/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1965727330, "Lb/a/q0/t/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f14764c) {
                return b.a.q0.s.e0.b.j().k("video_report_config_upload_number", 5);
            }
            return f14767f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f14764c) {
                return b.a.q0.s.e0.b.j().k("video_report_config_upload_type", 0);
            }
            return f14766e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f14764c) {
                return b.a.q0.s.e0.b.j().g("video_report_config_switch", true);
            }
            return f14765d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f14764c = true;
        f14765d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        b.a.q0.s.e0.b.j().t("video_report_config_switch", f14765d);
        f14766e = jSONObject.optInt("upload_type", 0);
        b.a.q0.s.e0.b.j().v("video_report_config_upload_type", f14766e);
        f14767f = jSONObject.optInt("upload_number", 5);
        b.a.q0.s.e0.b.j().v("video_report_config_upload_number", f14767f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        b.a.q0.s.e0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        b.a.q0.s.e0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        b.a.q0.s.e0.b.j().t("video_report_is_open_prepare_time", l);
        f14768g = jSONObject.optInt("moov_check", 0) != 0;
        b.a.q0.s.e0.b.j().t("video_report_config_moov_check", f14768g);
        String optString = jSONObject.optString("android_debug_type");
        f14769h = optString;
        if (!StringUtils.isNull(optString)) {
            b.a.q0.s.e0.b.j().x("video_report_config_debug_type", f14769h);
            e(f14769h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f14762a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        b.a.q0.s.e0.b.j().x("video_report_config_step_cache_strategy", f14762a);
        f(f14762a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14770i == null) {
            f14770i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14770i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f14770i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f14770i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14763b == null) {
            f14763b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14763b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f14763b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f14763b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f14763b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f14763b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
