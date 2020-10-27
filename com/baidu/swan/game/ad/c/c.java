package com.baidu.swan.game.ad.c;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.game.ad.d.e;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c {
    public static void a(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.aOj()) {
                a(n(str, 0, 0), bVar);
            }
            for (String str2 : adElementInfo.getThirdImpressionTrackingUrls()) {
                a(n(str2, 0, 0), bVar);
            }
        }
    }

    public static void b(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getThirdClickTrackingUrls()) {
                HashSet hashSet = new HashSet();
                hashSet.add("da_page");
                hashSet.add("da_type");
                String deleteParam = ai.deleteParam(str, hashSet);
                if (!TextUtils.isEmpty(adElementInfo.aOc())) {
                    deleteParam = ai.addParam(deleteParam, "da_page", "NAVIDEO_TAIL_PLAYABLE");
                } else if (!TextUtils.isEmpty(adElementInfo.aOi())) {
                    deleteParam = ai.addParam(deleteParam, "da_page", "NAVIDEO_TAIL");
                }
                a(ai.addParam(deleteParam, "da_type", TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), bVar);
            }
        }
    }

    public static void c(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getThirdClickTrackingUrls()) {
                HashSet hashSet = new HashSet();
                hashSet.add("da_page");
                hashSet.add("da_type");
                a(ai.addParam(ai.addParam(ai.deleteParam(str, hashSet), "da_page", "NAVIDEO_TAIL_PLAYABLE"), "da_type", TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY).replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()), bVar);
            }
            a(adElementInfo.aOe(), bVar);
        }
    }

    public static void d(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getThirdClickTrackingUrls()) {
                a(n(str, 0, 0), bVar);
            }
        }
    }

    public static void e(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getStartTrackers()) {
                a(n(str, 0, 0), bVar);
            }
        }
    }

    public static void f(AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getSkipTrackers()) {
                a(n(str, 0, 0), bVar);
            }
        }
    }

    public static void a(int i, int i2, AdElementInfo adElementInfo, com.baidu.swan.game.ad.a.b bVar) {
        if (adElementInfo != null) {
            for (String str : adElementInfo.getCloseTrackers()) {
                a(n(str, i, i2), bVar);
            }
        }
    }

    private static String n(String str, int i, int i2) {
        return str.replaceAll("%25%25origin_time%25%25", "" + System.currentTimeMillis()).replaceAll("%25%25play_mode%25%25", "0").replaceAll("%25%25cur_time%25%25", "" + i).replaceAll("%25%25start_time%25%25", "" + i2).replaceAll("%25%25area%25%25", "hot");
    }

    private static void a(String str, com.baidu.swan.game.ad.a.b bVar) {
        bVar.vp(str);
    }

    public static void a(String str, String str2, String str3, com.baidu.swan.game.ad.a.b bVar) {
        if (!ak.aKA()) {
            String hostName = com.baidu.swan.apps.t.a.auM().getHostName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizId", 10003);
                jSONObject.put(TbEnum.SystemMessage.KEY_GROUP_ID, 10003);
                jSONObject.put("containerAppName", hostName);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("distribute_channel", 38);
                jSONObject2.put("CTK", str3);
                jSONObject2.put(TiebaInitialize.LogFields.LOG_TYPE, 2);
                jSONObject2.put("media_id", str);
                jSONObject2.put("PVID", str3);
                jSONObject2.put("tuid", str2);
                jSONObject2.put("time", e.aOD());
                jSONObject2.put("page_type", 1);
                jSONObject2.put("traffic_type", 1);
                jSONObject.put("content", jSONObject2);
                bVar.vq(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
