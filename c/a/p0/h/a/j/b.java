package c.a.p0.h.a.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.h.a.k.f;
import c.a.p0.h.a.k.h;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Map<String, String> a(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (z || c.a.p0.h.a.f.a.b() == null) {
                return null;
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put("ver", h.l());
            treeMap.put("host", c.a.p0.h.a.f.a.b().a());
            treeMap.put(UrlOcrConfig.IdCardKey.OS, "android");
            int c2 = NetworkUtils.c(false);
            treeMap.put("net", c2 + "");
            treeMap.put("phone", h.e());
            treeMap.put("osV", h.f());
            treeMap.put("slot", str);
            treeMap.put("flow", str2);
            treeMap.put("appid", str3);
            treeMap.put("apid", str4);
            treeMap.put("sdk", c.a.p0.h.a.f.a.b().getSdkVersion());
            treeMap.put("time", "" + System.currentTimeMillis());
            return treeMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public static String b(String str, @Nullable Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (map != null) {
                map.put("name", str);
                return f.b("https://mobads-logs.baidu.com/dz.zb?type=mnp&", map);
            }
            return "https://mobads-logs.baidu.com/dz.zb?type=mnp&";
        }
        return (String) invokeLL.objValue;
    }

    public static String c(@NonNull Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) ? map.get("flow") : (String) invokeL.objValue;
    }

    public static void d(String str, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, hVar) == null) {
            hVar.e(str);
        }
    }

    public static String e(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3)) == null) {
            String replaceAll = str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0");
            String replaceAll2 = replaceAll.replaceAll("%25%25cur_time%25%25", "" + i2);
            return replaceAll2.replaceAll("%25%25start_time%25%25", "" + i3).replaceAll("%25%25area%25%25", ThreadAchievementShareDialogView.HOT_LIST_VIEW_TYPE);
        }
        return (String) invokeLII.objValue;
    }

    public static void f(String str, String str2, String str3, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, null, str, str2, str3, hVar) == null) || c.a.p0.h.a.f.a.b() == null || h.o()) {
            return;
        }
        String a = c.a.p0.h.a.f.a.b().a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bizId", 10003);
            jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
            jSONObject.put("containerAppName", a);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("distribute_channel", 38);
            jSONObject2.put("CTK", str3);
            jSONObject2.put("logtype", 2);
            jSONObject2.put("media_id", str);
            jSONObject2.put("PVID", str3);
            jSONObject2.put("tuid", str2);
            jSONObject2.put("time", h.j());
            jSONObject2.put("page_type", 1);
            jSONObject2.put("traffic_type", 1);
            jSONObject.put("content", jSONObject2);
            hVar.d(jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void g(AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            d(e(str, 0, 0), hVar);
        }
    }

    public static void h(AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String a = f.a(f.a(f.c(str, hashSet), BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE"), "da_type", TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY);
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), hVar);
        }
        d(adElementInfo.getClickUrl(), hVar);
    }

    public static void i(AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getThirdClickTrackingUrls()) {
            HashSet hashSet = new HashSet();
            hashSet.add(BdVideoAd.AD_VIDEO_DAPAGE);
            hashSet.add("da_type");
            String c2 = f.c(str, hashSet);
            if (!TextUtils.isEmpty(adElementInfo.getEndFrameUrl())) {
                c2 = f.a(c2, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL_PLAYABLE");
            } else if (!TextUtils.isEmpty(adElementInfo.getEndFrameHtml())) {
                c2 = f.a(c2, BdVideoAd.AD_VIDEO_DAPAGE, "NAVIDEO_TAIL");
            }
            String a = f.a(c2, "da_type", TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY);
            d(a.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), hVar);
        }
    }

    public static void j(AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getImpressionUrls()) {
            d(e(str, 0, 0), hVar);
        }
        for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
            d(e(str2, 0, 0), hVar);
        }
    }

    public static void k(@Nullable Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, map, str) == null) {
            l(map, str, new c.a.p0.h.a.h.c(AppRuntime.getAppContext()));
        }
    }

    public static void l(@Nullable Map<String, String> map, String str, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, map, str, hVar) == null) || map == null) {
            return;
        }
        TreeMap treeMap = new TreeMap(map);
        if (!TextUtils.isEmpty(str)) {
            treeMap.put("errCode", str);
            treeMap.put(StatConstants.KEY_EXT_ERR_MSG, c.a.p0.h.a.k.b.a(str));
        }
        n("error", treeMap, hVar);
    }

    public static void m(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            n(str, map, new c.a.p0.h.a.h.c(AppRuntime.getAppContext()));
        }
    }

    public static void n(String str, Map<String, String> map, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65549, null, str, map, hVar) == null) || map == null) {
            return;
        }
        d(b(str, map), hVar);
    }

    public static void o(int i2, int i3, AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), adElementInfo, hVar}) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getCloseTrackers()) {
            d(e(str, i2, i3), hVar);
        }
    }

    public static void p(AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getSkipTrackers()) {
            d(e(str, 0, 0), hVar);
        }
    }

    public static void q(AdElementInfo adElementInfo, c.a.p0.h.a.e.h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, adElementInfo, hVar) == null) || adElementInfo == null) {
            return;
        }
        for (String str : adElementInfo.getStartTrackers()) {
            d(e(str, 0, 0), hVar);
        }
    }
}
