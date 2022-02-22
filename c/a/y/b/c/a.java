package c.a.y.b.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.y.g.g.j;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveStatInfo;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final UBCManager a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1621885551, "Lc/a/y/b/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1621885551, "Lc/a/y/b/c/a;");
                return;
            }
        }
        a = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public static void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
            jSONObject.put("page", "main_page");
            if (j.a(str)) {
                return;
            }
            jSONObject.put("source", str);
        } catch (JSONException e2) {
            LiveFeedPageSdk.m(e2.getMessage());
        }
    }

    public static void b(Context context, String str, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, str, jSONObject) == null) || jSONObject == null) {
            return;
        }
        jSONObject.put("host_suzhu", l());
        if (!j.a(str)) {
            jSONObject.put("position_changjing", str);
        }
        String h2 = LiveFeedPageSdk.f().h(context);
        if (!TextUtils.isEmpty(h2)) {
            jSONObject.put("hdid", h2);
        }
        String b2 = LiveFeedPageSdk.f().b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        jSONObject.put("yonghuid", b2);
    }

    public static void c(String str, String str2, int i2, String str3, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, Integer.valueOf(i2), str3, jSONObject}) == null) || jSONObject == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("roomid", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put("nid", str2);
        }
        String str4 = i2 == 0 ? "preview" : i2 == 1 ? "live" : i2 == 3 ? BundleOpProvider.METHOD_BUNDLE_RECORD : "";
        if (!TextUtils.isEmpty(str4)) {
            jSONObject.put("status", str4);
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        jSONObject.put("bduid", str3);
    }

    public static void d(LiveStatInfo liveStatInfo, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, liveStatInfo, jSONObject) == null) || jSONObject == null || liveStatInfo == null) {
            return;
        }
        try {
            jSONObject.put(TiebaStatic.YYParams.YYSID, liveStatInfo.sid);
            jSONObject.put(TiebaStatic.YYParams.YYSSID, liveStatInfo.ssid);
            jSONObject.put(TiebaStatic.YYParams.YYUID, liveStatInfo.yyuid);
            if (liveStatInfo.isYY) {
                jSONObject.put("isyylive", "1");
            }
            jSONObject.put("yytpl_id", liveStatInfo.tpl);
            jSONObject.put("template_id", liveStatInfo.templateId);
        } catch (JSONException e2) {
            LiveFeedPageSdk.m(e2.getMessage());
        }
    }

    public static void e(Context context, String str, int i2, String str2, String str3, int i3, String str4, String str5, String str6, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), str4, str5, str6, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "zhibopindao_page");
                if (!j.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos_banner", i2);
                if (!j.a(str2)) {
                    jSONObject2.put("roomid", str2);
                }
                if (!j.a(str3)) {
                    jSONObject2.put("nid", str3);
                }
                jSONObject2.put("huodong", i3);
                if (!j.a(str6)) {
                    jSONObject2.put("mtr_id", str6);
                }
                b(context, str5, jSONObject2);
                jSONObject2.put("bduid", str4);
                d(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4222", jSONObject.toString());
        }
    }

    public static void f(Context context, String str, int i2, String str2, String str3, int i3, String str4, String str5, String str6, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, str, Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), str4, str5, str6, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "zhibopindao_page");
                if (!j.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("pos_banner", i2);
                if (!j.a(str2)) {
                    jSONObject2.put("roomid", str2);
                }
                if (!j.a(str3)) {
                    jSONObject2.put("nid", str3);
                }
                jSONObject2.put("huodong", i3);
                if (!j.a(str6)) {
                    jSONObject2.put("mtr_id", str6);
                }
                b(context, str5, jSONObject2);
                jSONObject2.put("bduid", str4);
                d(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4221", jSONObject.toString());
        }
    }

    public static void g(Context context, String str, String str2, int i2, String str3, String str4, String str5, String str6, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, str2, Integer.valueOf(i2), str3, str4, str5, str6, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", l());
                jSONObject2.put("request_result_code", i2);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_erjitab", str4);
                jSONObject2.put("request_sanjisubtab", str5);
                jSONObject2.put("request_session_id", str6);
                jSONObject2.put("response_feed_real_num", i4);
                jSONObject2.put("response_feed_num", i3);
                jSONObject2.put("page_type", str2);
                jSONObject2.put("refresh_type", i5);
                jSONObject2.put("refresh_index", i6);
                if (context != null) {
                    jSONObject2.put("net_status", NetWorkUtils.b(context) ? "0" : "1");
                }
                if (LiveFeedPageSdk.f().g() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.f().g().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.f().g().b());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4358", jSONObject.toString());
        }
    }

    public static void h(Context context, String str, String str2, String str3, int i2, String str4, String str5, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2), str4, str5, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "follow_page");
                if (!j.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                b(context, str3, jSONObject2);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("roomid", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("nid", str5);
                }
                jSONObject2.put("pos", i2);
                jSONObject2.put("bduid", str2);
                d(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4223", jSONObject.toString());
        }
    }

    public static void i(Context context, String str, String str2, String str3, int i2, String str4, String str5, LiveStatInfo liveStatInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{context, str, str2, str3, Integer.valueOf(i2), str4, str5, liveStatInfo}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "follow_page");
                if (!j.a(str)) {
                    jSONObject.put("source", str);
                }
                JSONObject jSONObject2 = new JSONObject();
                b(context, str3, jSONObject2);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("roomid", str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("nid", str5);
                }
                jSONObject2.put("pos", i2);
                jSONObject2.put("bduid", str2);
                d(liveStatInfo, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4224", jSONObject.toString());
        }
    }

    public static void j(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "click");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "main_page");
                if (!j.a(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject.put("value", "follow_more");
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void k(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "main_page");
                if (!j.a(str)) {
                    jSONObject.put("source", str);
                }
                jSONObject.put("value", "follow_more");
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? "baidu".equals(LiveFeedPageSdk.f().e()) ? "shoubai" : "haokan".equals(LiveFeedPageSdk.f().e()) ? "haokan" : "quanmin".equals(LiveFeedPageSdk.f().e()) ? "quanmin" : "tieba".equals(LiveFeedPageSdk.f().e()) ? "tieba" : "" : (String) invokeV.objValue;
    }

    public static String m(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65549, null, z)) == null) ? z ? "chenjinshi" : "zhibopindao" : (String) invokeZ.objValue;
    }

    public static String n(LiveRoomEntity liveRoomEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, liveRoomEntity)) == null) {
            if (liveRoomEntity == null) {
                return "";
            }
            if (liveRoomEntity.isDateLive()) {
                int i2 = liveRoomEntity.showTpl;
                if (i2 == 1 || i2 == 2) {
                    return "x-1";
                }
                if (i2 == 3) {
                    return "x-2";
                }
            } else if (liveRoomEntity.isYYShow() && liveRoomEntity.isHorizontalScreen()) {
                int i3 = liveRoomEntity.showTpl;
                if (i3 == 1 || i3 == 2) {
                    return "y-1";
                }
                if (i3 == 3) {
                    return "y-2";
                }
            } else if (liveRoomEntity.isHorizontalScreen()) {
                int i4 = liveRoomEntity.showTpl;
                if (i4 == 1 || i4 == 2) {
                    return "h-1";
                }
                if (i4 == 3) {
                    return "h-2";
                }
            } else {
                int i5 = liveRoomEntity.showTpl;
                if (i5 == 1 || i5 == 2) {
                    return "v-1";
                }
                if (i5 == 3) {
                    return "v-2";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static void o(Context context, String str, String str2, int i2, String str3, String str4, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{context, str, str2, Integer.valueOf(i2), str3, str4, liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                if (liveRoomEntity != null) {
                    c(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "", jSONObject2);
                    d(liveRoomEntity.statInfo, jSONObject2);
                    jSONObject2.put("id", liveRoomEntity.nid);
                    JSONObject jSONObject3 = new JSONObject();
                    String str5 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str5)) {
                        jSONObject3.put("gr_ext", new JSONObject(str5));
                    }
                    jSONObject2.put("ext", jSONObject3);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            LiveFeedPageSdk.m("grLog clk      " + jSONObject.toString());
            a.onEvent("4384", jSONObject.toString());
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            a.onEvent(str);
        }
    }

    public static void p(Context context, String str, String str2, int i2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, long j2, long j3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, str, str2, Integer.valueOf(i2), str3, str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", l());
                jSONObject2.put("page_type", str2);
                jSONObject2.put("request_result_code", i2);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_erjitab", str6);
                jSONObject2.put("request_sanjisubtab", str7);
                jSONObject2.put("request_session_id", str8);
                jSONObject2.put("resp_logid", str4);
                jSONObject2.put("resource", str5);
                jSONObject2.put("cache_item", str9);
                jSONObject2.put("cache_cause", i3);
                jSONObject2.put("cache_time", j2);
                jSONObject2.put("cache_read_time", j3);
                jSONObject2.put("cache_availability", i4);
                if (context != null) {
                    jSONObject2.put("net_status", NetWorkUtils.b(context) ? "0" : "1");
                }
                if (LiveFeedPageSdk.f().g() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.f().g().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.f().g().b());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4359", jSONObject.toString());
        }
    }

    public static Flow q(Context context, boolean z, String str, String str2, String str3, String str4, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65554, null, new Object[]{context, Boolean.valueOf(z), str, str2, str3, str4, flow})) == null) {
            if (z) {
                return a.beginFlow("3327");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a(str, jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    b(context, str2, jSONObject2);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("erjitab", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.put("sanjitab", str4);
                    }
                    jSONObject.put("ext", jSONObject2.toString());
                } catch (JSONException e2) {
                    LiveFeedPageSdk.m(e2.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void r(Context context, String str, String str2, long j2, int i2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{context, str, str2, Long.valueOf(j2), Integer.valueOf(i2), str3, str4, str5, str6, str7, str8, str9}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("source", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host_suzhu", l());
                jSONObject2.put("request_time", j2);
                jSONObject2.put("page_type", str2);
                jSONObject2.put("request_result_code", i2);
                jSONObject2.put("request_result_msg", str3);
                jSONObject2.put("request_logid", str4);
                jSONObject2.put("request_resource", str5);
                jSONObject2.put("request_erjitab", str6);
                jSONObject2.put("request_sanjisubtab", str7);
                jSONObject2.put("request_session_id", str8);
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("response_tab_availability", str9);
                }
                if (context != null) {
                    jSONObject2.put("net_status", NetWorkUtils.b(context) ? "0" : "1");
                }
                if (LiveFeedPageSdk.f().g() != null) {
                    jSONObject2.put("cuid", LiveFeedPageSdk.f().g().getCuid());
                    jSONObject2.put("uk", LiveFeedPageSdk.f().g().b());
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4298", jSONObject.toString());
        }
    }

    public static void s(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, context, str, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4261", jSONObject.toString());
        }
    }

    public static Flow t(Context context, boolean z, String str, String str2, int i2, String str3, String str4, LiveRoomEntity liveRoomEntity, Flow flow) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{context, Boolean.valueOf(z), str, str2, Integer.valueOf(i2), str3, str4, liveRoomEntity, flow})) == null) {
            if (z) {
                return a.beginFlow("4912");
            }
            if (flow != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "show");
                    a(str, jSONObject);
                    JSONObject jSONObject2 = new JSONObject();
                    b(context, str2, jSONObject2);
                    jSONObject2.put("pos", i2);
                    jSONObject2.put("kapianshipei", n(liveRoomEntity));
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("erjitab", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.put("sanjitab", str4);
                    }
                    if (liveRoomEntity != null) {
                        c(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "", jSONObject2);
                        d(liveRoomEntity.statInfo, jSONObject2);
                        jSONObject2.put("id", liveRoomEntity.nid);
                        JSONObject jSONObject3 = new JSONObject();
                        String str5 = liveRoomEntity.grExt;
                        if (!TextUtils.isEmpty(str5)) {
                            jSONObject3.put("gr_ext", new JSONObject(str5));
                        }
                        jSONObject2.put("ext", jSONObject3);
                    }
                    jSONObject.put("ext", jSONObject2.toString());
                } catch (JSONException e2) {
                    LiveFeedPageSdk.m(e2.getMessage());
                }
                a.flowSetValueWithDuration(flow, jSONObject.toString());
                a.flowEnd(flow);
            }
            return flow;
        }
        return (Flow) invokeCommon.objValue;
    }

    public static void u(Context context, String str, String str2, int i2, String str3, String str4, LiveRoomEntity liveRoomEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, str, str2, Integer.valueOf(i2), str3, str4, liveRoomEntity}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "display");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                jSONObject2.put("pos", i2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                if (liveRoomEntity != null) {
                    c(liveRoomEntity.roomId, liveRoomEntity.nid, liveRoomEntity.liveStatus, liveRoomEntity.hostInfo != null ? liveRoomEntity.hostInfo.uk : "", jSONObject2);
                    d(liveRoomEntity.statInfo, jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id", liveRoomEntity.nid);
                    JSONObject jSONObject4 = new JSONObject();
                    String str5 = liveRoomEntity.grExt;
                    if (!TextUtils.isEmpty(str5)) {
                        jSONObject4.put("gr_ext", new JSONObject(str5));
                    }
                    jSONObject3.put("ext", jSONObject4);
                    jSONObject3.put("position_changjing ", str2);
                    jSONObject3.put("pos", i2);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject3);
                    jSONObject2.put("item", jSONArray);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            LiveFeedPageSdk.m("grLog display      " + jSONObject.toString());
            a.onEvent("4383", jSONObject.toString());
        }
    }

    public static void v(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65559, null, context, str, str2, str3, str4) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                a(str, jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                b(context, str2, jSONObject2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("erjitab", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("sanjitab", str4);
                }
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("3326", jSONObject.toString());
        }
    }

    public static void w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "clk");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "main_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4792", jSONObject.toString());
        }
    }

    public static void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "show");
                jSONObject.put("from", AccountConstants.LOGIN_TYPE_NATIVE_SRC_LIVESHOW);
                jSONObject.put("page", "main_page");
                jSONObject.put("source", "yijitabzhibo");
                JSONObject jSONObject2 = new JSONObject();
                b(context, null, jSONObject2);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                LiveFeedPageSdk.m(e2.getMessage());
            }
            a.onEvent("4793", jSONObject.toString());
        }
    }
}
