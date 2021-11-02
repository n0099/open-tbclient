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
    public static String f13989a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f13990b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13991c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13992d;

    /* renamed from: e  reason: collision with root package name */
    public static int f13993e;

    /* renamed from: f  reason: collision with root package name */
    public static int f13994f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f13995g;

    /* renamed from: h  reason: collision with root package name */
    public static String f13996h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f13997i;
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
            if (!f13991c) {
                return b.a.q0.s.e0.b.j().k("video_report_config_upload_number", 5);
            }
            return f13994f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f13991c) {
                return b.a.q0.s.e0.b.j().k("video_report_config_upload_type", 0);
            }
            return f13993e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f13991c) {
                return b.a.q0.s.e0.b.j().g("video_report_config_switch", true);
            }
            return f13992d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f13991c = true;
        f13992d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        b.a.q0.s.e0.b.j().t("video_report_config_switch", f13992d);
        f13993e = jSONObject.optInt("upload_type", 0);
        b.a.q0.s.e0.b.j().v("video_report_config_upload_type", f13993e);
        f13994f = jSONObject.optInt("upload_number", 5);
        b.a.q0.s.e0.b.j().v("video_report_config_upload_number", f13994f);
        j = jSONObject.optInt("prepare_max_wait_time", 10000);
        b.a.q0.s.e0.b.j().v("video_report_prepare_max_wait_time", j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        b.a.q0.s.e0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        b.a.q0.s.e0.b.j().t("video_report_is_open_prepare_time", l);
        f13995g = jSONObject.optInt("moov_check", 0) != 0;
        b.a.q0.s.e0.b.j().t("video_report_config_moov_check", f13995g);
        String optString = jSONObject.optString("android_debug_type");
        f13996h = optString;
        if (!StringUtils.isNull(optString)) {
            b.a.q0.s.e0.b.j().x("video_report_config_debug_type", f13996h);
            e(f13996h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f13989a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        b.a.q0.s.e0.b.j().x("video_report_config_step_cache_strategy", f13989a);
        f(f13989a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f13997i == null) {
            f13997i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f13997i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f13997i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f13997i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f13990b == null) {
            f13990b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f13990b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f13990b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f13990b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f13990b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f13990b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
