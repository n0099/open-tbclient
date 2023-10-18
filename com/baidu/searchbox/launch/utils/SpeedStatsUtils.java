package com.baidu.searchbox.launch.utils;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SpeedStatsUtils {
    public static final String IS_NIGHT_MODE = "isNightMode";
    public static final int LAUNCH_TYPE_NEWINSTALL = 2;
    public static final int LAUNCH_TYPE_NORMAL = 0;
    public static final int LAUNCH_TYPE_UPGRADE = 1;
    public static final int START_TYPE_INVALID = -1;
    public static final int START_TYPE_NEW_INSTALL_DIRECT = 0;
    public static final int START_TYPE_NEW_INSTALL_INDIRECT = 1;
    public static final int START_TYPE_NORMAL_DIRECT = 4;
    public static final int START_TYPE_NORMAL_INDIRECT = 5;
    public static final int START_TYPE_PUSH = 9;
    public static final int START_TYPE_REENTER_FROM_EXTERNAL = 7;
    public static final int START_TYPE_REENTER_FROM_LAUNCHER = 6;
    public static final int START_TYPE_SCHEME = 8;
    public static final int START_TYPE_UPGRADE_DIRECT = 2;
    public static final int START_TYPE_UPGRADE_INDIRECT = 3;
    public static final String UBC_FROM_MAINLINE = "mainline";
    public static final String UBC_FROM_OEM = "oem";
    public static final String UBC_FROM_OEM_DATAFLOW = "oemdataflow";
    public static final String UBC_KEY_CPU = "cpu";
    public static final String UBC_KEY_DATA_VERSION = "version";
    public static final String UBC_KEY_DEBUG = "debug";
    public static final String UBC_KEY_DEVICE_SCORE = "device_score";
    public static final String UBC_KEY_DRAW_COUNT = "drawcount";
    public static final String UBC_KEY_OPTION = "option";
    public static final String UBC_KEY_SID = "sid";
    public static final String UBC_KEY_STAGE = "stage";
    public static final String UBC_KEY_USER_PERCEPTION_COST = "userPerceptionCost";
    public static final String UBC_PAGE_ALLCACHE = "allcache";
    public static final String UBC_PAGE_ALLNET = "allnet";
    public static final String UBC_PAGE_ERROR = "error";
    public static final String UBC_PAGE_FEED_CACHE = "feedcache";
    public static final String UBC_PAGE_HOTWORD_CACHE = "hotwordcache";
    public static final String UBC_TYPE_COLD_DIRECT = "coldDirect";
    public static final String UBC_TYPE_COLD_INDIRECT = "coldIndirect";
    public static final String UBC_TYPE_HOT_LAUNCH = "hotlaunch";
    public static final String UBC_TYPE_NEW_INSTALL_DIRECT = "newInstallDirect";
    public static final String UBC_TYPE_NEW_INSTALL_INDIRECT = "newInstallIndirect";
    public static final String UBC_TYPE_PUSH = "push";
    public static final String UBC_TYPE_SCHEME = "scheme";
    public static final String UBC_TYPE_UPGRADE_DIRECT = "upgradeDirect";
    public static final String UBC_TYPE_UPGRADE_INDIRECT = "upgradeIndirect";
    public static final String UBC_VALUE_BANNER = "banner";
    public static final String UBC_VALUE_BANNER_SKIN = "bannerSkin";
    public static final String UBC_VALUE_INTRODUCTION = "introduction";
    public static final String UBC_VALUE_INTRO_BANNER = "introductionBanner";
    public static final String UBC_VALUE_INTRO_BANNER_SKIN = "introductionBannerSkin";
    public static final String UBC_VALUE_INTRO_SKIN = "introductionSkin";
    public static final String UBC_VALUE_NONE = "none";
    public static final String UBC_VALUE_SKIN = "skin";
    public static final String UBC_VALUE_SPLASH = "splash";
    public static final String UBC_VALUE_SPLASH_BANNER = "splashBanner";
    public static final String UBC_VALUE_SPLASH_BANNER_SKIN = "splashBannerSkin";
    public static final String UBC_VALUE_SPLASH_SKIN = "splashSkin";
    public static final String WRITE_EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";

    public static JSONObject getJsonData(long j, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", j);
            if (map != null && map.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(entry.getKey(), entry.getValue());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("part", jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static boolean hasPermission(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }
}
