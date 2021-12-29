package c.a.t0.a2;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final List<c.a.t0.a2.k.a> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(969901739, "Lc/a/t0/a2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(969901739, "Lc/a/t0/a2/a;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            c.a.t0.e2.a.j().D(context, "");
        }
    }

    public static void b(Context context, String str, HashMap<String, Object> hashMap) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, hashMap) == null) {
            if (hashMap != null) {
                String str3 = (String) hashMap.get("enterroom_type");
                String str4 = (String) hashMap.get("live_activity_type");
                String str5 = (String) hashMap.get("extra");
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("live_activity_type", str4);
                    jSONObject.put("extra", str5);
                    str2 = jSONObject.toString();
                } catch (JSONException unused) {
                    str2 = "";
                }
                if ("1".equals(str3)) {
                    c.a.t0.e2.a.j().H(context, str2);
                    return;
                } else {
                    c.a.t0.e2.a.j().D(context, "");
                    return;
                }
            }
            c.a.t0.e2.a.j().D(context, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, String str, Map<String, Object> map) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, map) == null) {
            String str3 = (String) map.get("enterroom_type");
            String str4 = (String) map.get("room_id");
            String str5 = (String) map.get("live_id");
            String str6 = (String) map.get("username");
            String str7 = (String) map.get("userrec");
            String str8 = (String) map.get(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            String str9 = (String) map.get(AlaLiveRoomActivityConfig.SDK_LIVE_URL_KEY);
            String str10 = (String) map.get("screen_direction");
            String str11 = (String) map.get("open_giftlist");
            String str12 = (String) map.get("tab");
            String str13 = (String) map.get("tag");
            String str14 = (String) map.get("source");
            String str15 = (String) map.get("from");
            String str16 = (String) map.get("extra");
            String str17 = (String) map.get("audioUrl");
            String str18 = (String) map.get("audio_bg");
            String str19 = (String) map.get("chat_mcast_id");
            String str20 = (String) map.get("open_msgpanel");
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str12)) {
                    jSONObject.put("tab", str12);
                }
                if (!TextUtils.isEmpty(str13)) {
                    jSONObject.put("tag", str13);
                }
                if (!TextUtils.isEmpty(str14)) {
                    jSONObject.put("source", str14);
                }
                if (!TextUtils.isEmpty(str15)) {
                    jSONObject.put("from", str15);
                }
                if (!TextUtils.isEmpty(str8)) {
                    jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, str8);
                }
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_URL_KEY, str9);
                }
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject.put("screen_direction", str10);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_ENTER_ROOM_ID_KEY, str4);
                }
                if (TextUtils.isEmpty(str5)) {
                    str2 = str5;
                } else {
                    str2 = str5;
                    try {
                        jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_ENTER_LIVE_ID_KEY, str2);
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (!"1".equals(str3)) {
                        }
                    }
                }
                if (!TextUtils.isEmpty(str16)) {
                    jSONObject.put("extra", str16);
                }
                if (!TextUtils.isEmpty(str17)) {
                    jSONObject.put("audioUrl", str17);
                }
                if (!TextUtils.isEmpty(str18)) {
                    jSONObject.put("audio_bg", str18);
                }
                if (!TextUtils.isEmpty(str19)) {
                    jSONObject.put("chat_mcast_id", str19);
                }
                if (!TextUtils.isEmpty(str20)) {
                    jSONObject.put("open_msgpanel", str20);
                }
            } catch (JSONException e3) {
                e = e3;
                str2 = str5;
            }
            if (!"1".equals(str3)) {
                c.a.t0.e2.a.j().y(context, str, jSONObject.toString(), map);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("user_name", str6);
                jSONObject2.put("open_giftlist", str11);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("live_id", str2);
                jSONObject3.put("useRecommend", true);
                jSONObject3.put("otherParams", jSONObject);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
            c.a.t0.e2.a.j().x(context, jSONObject3.toString());
        }
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            c.a.t0.e2.a.j().h(context, str);
        }
    }

    public static void e(Context context, c.a.t0.a2.n.a aVar, c.a.t0.a2.k.a aVar2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, context, aVar, aVar2) == null) || context == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            try {
                if (!TextUtils.isEmpty(aVar.a)) {
                    jSONObject.put("callback", aVar.a);
                    if (aVar2 != null) {
                        a.add(aVar2);
                    }
                }
                jSONObject.put("isTranslucent", aVar.f15432b);
                if (!TextUtils.isEmpty(aVar.f15433c)) {
                    jSONObject.put("from", aVar.f15433c);
                }
            } catch (JSONException unused) {
            }
        }
        c.a.t0.e2.a.j().B(context, jSONObject.toString());
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            c.a.t0.e2.a.j().q(context);
        }
    }

    public static void g(Context context, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            c.a.t0.e2.a.j().v(context, j2, i2);
        }
    }

    public static void h(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65544, null, context, str, i2) == null) {
            c.a.t0.e2.a.j().s(context, str, i2);
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            c.a.t0.e2.a.j().t(context);
        }
    }

    public static void j(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            c.a.t0.e2.a.j().u(context, str, str2);
        }
    }

    public static void k(Context context, String str, AlaLiveInfoCoreData alaLiveInfoCoreData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, context, str, alaLiveInfoCoreData) == null) || alaLiveInfoCoreData == null) {
            return;
        }
        long j2 = alaLiveInfoCoreData.liveID;
        String str2 = alaLiveInfoCoreData.userName;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str);
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, alaLiveInfoCoreData.liveCover);
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_ENTER_LIVE_ID_KEY, j2);
            jSONObject.put("user_name", str2);
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_LIVE_URL_KEY, alaLiveInfoCoreData.rtmpUrl);
            jSONObject.put("screen_direction", alaLiveInfoCoreData.screenDirection);
            jSONObject.put("open_giftlist", "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("live_id", j2);
            jSONObject2.put("useRecommend", true);
            jSONObject2.put("otherParams", jSONObject);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        c.a.t0.e2.a.j().x(context, jSONObject2.toString());
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            c.a.t0.e2.a.j().z(context);
        }
    }

    public static void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) {
            c.a.t0.e2.a.j().A(context, str);
        }
    }

    public static void n(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, context, str, str2) == null) {
            c.a.t0.e2.a.j().C(context, str, str2);
        }
    }

    public static void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, jSONObject) == null) {
            for (int i2 = 0; i2 < a.size(); i2++) {
                a.get(i2).onCallback(jSONObject);
            }
            a.clear();
        }
    }

    public static void p(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65552, null, str, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("uid", str);
            hashMap.put("isSubscribe", Boolean.valueOf(z));
            c.a.t0.e2.a.j().g(TbadkCoreApplication.getInst(), "setAttentionChanged", hashMap);
        }
    }

    public static void q(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65553, null, j2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("uid", Long.valueOf(j2));
            c.a.t0.e2.a.j().g(TbadkCoreApplication.getInst(), "shareSuccess", hashMap);
        }
    }

    public static void r(Application application, String str, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, application, str, uri) == null) {
            c.a.t0.e2.a.j().r(application, str, uri);
        }
    }
}
