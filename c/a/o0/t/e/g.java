package c.a.o0.t.e;

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
    public static String f14567a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f14568b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14569c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14570d;

    /* renamed from: e  reason: collision with root package name */
    public static int f14571e;

    /* renamed from: f  reason: collision with root package name */
    public static int f14572f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f14573g;

    /* renamed from: h  reason: collision with root package name */
    public static String f14574h;

    /* renamed from: i  reason: collision with root package name */
    public static Map<String, String> f14575i;

    /* renamed from: j  reason: collision with root package name */
    public static int f14576j;
    public static int k;
    public static boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(992265953, "Lc/a/o0/t/e/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(992265953, "Lc/a/o0/t/e/g;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f14569c) {
                return c.a.o0.s.d0.b.j().k("video_report_config_upload_number", 5);
            }
            return f14572f;
        }
        return invokeV.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!f14569c) {
                return c.a.o0.s.d0.b.j().k("video_report_config_upload_type", 0);
            }
            return f14571e;
        }
        return invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!f14569c) {
                return c.a.o0.s.d0.b.j().g("video_report_config_switch", true);
            }
            return f14570d;
        }
        return invokeV.booleanValue;
    }

    public static void d(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        f14569c = true;
        f14570d = jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 1) != 0;
        c.a.o0.s.d0.b.j().t("video_report_config_switch", f14570d);
        f14571e = jSONObject.optInt("upload_type", 0);
        c.a.o0.s.d0.b.j().v("video_report_config_upload_type", f14571e);
        f14572f = jSONObject.optInt("upload_number", 5);
        c.a.o0.s.d0.b.j().v("video_report_config_upload_number", f14572f);
        f14576j = jSONObject.optInt("prepare_max_wait_time", 10000);
        c.a.o0.s.d0.b.j().v("video_report_prepare_max_wait_time", f14576j);
        k = jSONObject.optInt("prepare_max_loading_time", 3000);
        c.a.o0.s.d0.b.j().v("video_report_prepare_max_loading_time", k);
        l = jSONObject.optInt("is_open_prepare_time", 0) == 1;
        c.a.o0.s.d0.b.j().t("video_report_is_open_prepare_time", l);
        f14573g = jSONObject.optInt("moov_check", 0) != 0;
        c.a.o0.s.d0.b.j().t("video_report_config_moov_check", f14573g);
        String optString = jSONObject.optString("android_debug_type");
        f14574h = optString;
        if (!StringUtils.isNull(optString)) {
            c.a.o0.s.d0.b.j().x("video_report_config_debug_type", f14574h);
            e(f14574h);
        }
        String optString2 = jSONObject.optString("step_cache_strategy");
        f14567a = optString2;
        if (StringUtils.isNull(optString2)) {
            return;
        }
        c.a.o0.s.d0.b.j().x("video_report_config_step_cache_strategy", f14567a);
        f(f14567a);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14575i == null) {
            f14575i = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14575i.put("debug_avformat_open_input", jSONObject.optString("debug_avformat_open_input"));
            f14575i.put("debug_dns_strategy", jSONObject.optString("debug_dns_strategy"));
            f14575i.put("debug_url_null_strategy", jSONObject.optString("debug_url_null_strategy"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        if (f14568b == null) {
            f14568b = new HashMap();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f14568b.put("step_cache_force_use_proxy", jSONObject.optString("step_cache_force_use_proxy"));
            f14568b.put("step_cache_switch", jSONObject.optString("step_cache_switch"));
            f14568b.put("step_cache_rush_hour", jSONObject.optString("step_cache_rush_hour"));
            f14568b.put("step_cache_rush_hour_cache_duration", jSONObject.optString("step_cache_rush_hour_cache_duration"));
            f14568b.put("step_cache_normol_cache_duration", jSONObject.optString("step_cache_normol_cache_duration"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
