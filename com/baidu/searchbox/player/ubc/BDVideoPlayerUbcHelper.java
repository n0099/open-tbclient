package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.helper.NetUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BDVideoPlayerUbcHelper {
    public static float sPlayerCurrentSpreed = 1.0f;

    public static String getNetType() {
        String networkClass = NetUtils.getNetworkClass();
        return (networkClass.equals("no") || networkClass.equals("unknown")) ? "other" : networkClass;
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
        jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
        jSONObject.put("network", getNetType());
        JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
        extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
        extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
        jSONObject.put("ext", extStatisticsLog.toString());
        return jSONObject.toString();
    }

    public static int positive(int i) {
        return Math.max(i, 0);
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable String str) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
        if (TextUtils.isEmpty(str)) {
            jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
        } else {
            jSONObject.put("page", str);
        }
        jSONObject.put("network", getNetType());
        JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
        extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
        extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
        jSONObject.put("ext", extStatisticsLog.toString());
        return jSONObject.toString();
    }

    @NonNull
    public static String getUbcContent(@NonNull JSONObject jSONObject, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        jSONObject2.put("from", bDVideoPlayerUbcContent.getFrom());
        jSONObject2.put("page", bDVideoPlayerUbcContent.getPage());
        jSONObject2.put("network", getNetType());
        jSONObject.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
        jSONObject.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
        float launchSpeedScore = bDVideoPlayerUbcContent.getPlayerFetcher().getLaunchSpeedScore();
        if (launchSpeedScore >= 0.0f) {
            jSONObject.put("launchScore", launchSpeedScore);
        }
        float staticDeviceScore = bDVideoPlayerUbcContent.getPlayerFetcher().getStaticDeviceScore();
        if (staticDeviceScore >= 0.0f) {
            jSONObject.put("staticScore", staticDeviceScore);
        }
        jSONObject2.put("ext", jSONObject.toString());
        return jSONObject2.toString();
    }
}
