package com.baidu.searchbox.player.ubc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.helper.NetUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BDVideoPlayerUbcHelper {
    public static String getNetType() {
        String networkClass = NetUtils.getNetworkClass();
        if (networkClass.equals("no") || networkClass.equals("unknown")) {
            return "other";
        }
        return networkClass;
    }

    public static void appendSessionContent(@NonNull JSONObject jSONObject, @NonNull IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
        String sessionId = iUbcPlayerStatusFetcher.getSessionId();
        String kernelLogId = iUbcPlayerStatusFetcher.getKernelLogId();
        String traceId = iUbcPlayerStatusFetcher.getTraceId();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("plogid", sessionId);
            jSONObject2.put("klogid", kernelLogId);
            jSONObject2.put("traceid", traceId);
            jSONObject.put("player_log", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void appendUrlContent(@NonNull JSONObject jSONObject, @NonNull IUbcPlayerStatusFetcher iUbcPlayerStatusFetcher) {
        if (!TextUtils.isEmpty(jSONObject.optString("url"))) {
            return;
        }
        try {
            jSONObject.put("url", iUbcPlayerStatusFetcher.getPlayUrl());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
        jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
        if (!TextUtils.isEmpty(bDVideoPlayerUbcContent.getType())) {
            jSONObject.put("type", bDVideoPlayerUbcContent.getType());
        }
        jSONObject.put("network", getNetType());
        JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
        extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
        extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
        extStatisticsLog.put("enterPathWay", bDVideoPlayerUbcContent.getPlayerFetcher().getVideoInfoEnterFlag());
        float launchSpeedScore = bDVideoPlayerUbcContent.getPlayerFetcher().getLaunchSpeedScore();
        if (launchSpeedScore >= 0.0f) {
            extStatisticsLog.put(PlayerStatConstants.STAT_KEY_LAUNCH_SCORE, launchSpeedScore);
        }
        float staticDeviceScore = bDVideoPlayerUbcContent.getPlayerFetcher().getStaticDeviceScore();
        if (staticDeviceScore >= 0.0f) {
            extStatisticsLog.put(PlayerStatConstants.STAT_KEY_STATIC_SCORE, staticDeviceScore);
        }
        extStatisticsLog.put(PlayerStatConstants.STAT_KEY_KERNEL_TYPE, bDVideoPlayerUbcContent.getKernelType());
        appendSessionContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
        appendUrlContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
        jSONObject.put("ext", extStatisticsLog.toString());
        return jSONObject.toString();
    }

    @NonNull
    public static String getUbcContent(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject, @Nullable String str) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject.put("from", bDVideoPlayerUbcContent.getFrom());
        if (TextUtils.isEmpty(str)) {
            jSONObject.put("page", bDVideoPlayerUbcContent.getPage());
        } else {
            jSONObject.put("page", str);
        }
        if (!TextUtils.isEmpty(bDVideoPlayerUbcContent.getType())) {
            jSONObject.put("type", bDVideoPlayerUbcContent.getType());
        }
        jSONObject.put("network", getNetType());
        JSONObject extStatisticsLog = bDVideoPlayerUbcContent.getExtStatisticsLog();
        extStatisticsLog.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
        extStatisticsLog.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
        extStatisticsLog.put(PlayerStatConstants.STAT_KEY_KERNEL_TYPE, bDVideoPlayerUbcContent.getKernelType());
        appendSessionContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
        appendUrlContent(extStatisticsLog, bDVideoPlayerUbcContent.getPlayerFetcher());
        jSONObject.put("ext", extStatisticsLog.toString());
        return jSONObject.toString();
    }

    @NonNull
    public static String getUbcContent(@NonNull JSONObject jSONObject, @NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, @Nullable JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jSONObject2.put("from", bDVideoPlayerUbcContent.getFrom());
        jSONObject2.put("page", bDVideoPlayerUbcContent.getPage());
        jSONObject2.put("network", getNetType());
        if (!TextUtils.isEmpty(bDVideoPlayerUbcContent.getType())) {
            jSONObject2.put("type", bDVideoPlayerUbcContent.getType());
        }
        jSONObject.put("currentPosition", positive(bDVideoPlayerUbcContent.getPlayerFetcher().getCurrentPosition()));
        jSONObject.put("auto_play", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayType());
        float launchSpeedScore = bDVideoPlayerUbcContent.getPlayerFetcher().getLaunchSpeedScore();
        if (launchSpeedScore >= 0.0f) {
            jSONObject.put(PlayerStatConstants.STAT_KEY_LAUNCH_SCORE, launchSpeedScore);
        }
        float staticDeviceScore = bDVideoPlayerUbcContent.getPlayerFetcher().getStaticDeviceScore();
        if (staticDeviceScore >= 0.0f) {
            jSONObject.put(PlayerStatConstants.STAT_KEY_STATIC_SCORE, staticDeviceScore);
        }
        jSONObject.put("play_phase", bDVideoPlayerUbcContent.getPlayerFetcher().getPlayErrorPart());
        jSONObject.put(PlayerStatConstants.STAT_KEY_KERNEL_TYPE, bDVideoPlayerUbcContent.getKernelType());
        appendSessionContent(jSONObject, bDVideoPlayerUbcContent.getPlayerFetcher());
        appendUrlContent(jSONObject, bDVideoPlayerUbcContent.getPlayerFetcher());
        jSONObject2.put("ext", jSONObject.toString());
        return jSONObject2.toString();
    }

    public static int positive(int i) {
        return Math.max(i, 0);
    }
}
