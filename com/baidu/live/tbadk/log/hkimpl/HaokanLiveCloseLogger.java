package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveCloseLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HaokanLiveCloseLogger implements ILiveCloseLogger {
    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doAccessLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_CLOSE_GUEST);
            jSONObject.put("k", LogConfig.KEY_ACCESS);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doFollowClickLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", LogConfig.KEY_FOLLOW_CLICK);
            jSONObject.put("v", "follow");
            jSONObject.put("tab", LogConfig.TAB_LIVE_CLOSE_GUEST);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("loc", LogConfig.LOG_LIVE_END_ZONE);
            jSONObject.put("vid", str3);
            jSONObject.put("live_id", str);
            jSONObject.put("name", "关注");
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doClickNoFollowLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_CLOSE_GUEST);
            jSONObject.put("k", "click");
            jSONObject.put("v", "no_longer_follow");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("vid", str3);
            jSONObject.put("live_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doClickChangeSomeLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_CLOSE_GUEST);
            jSONObject.put("k", "click");
            jSONObject.put("v", "change_some");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("vid", str3);
            jSONObject.put("live_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doShowRecommendLiveCloseGuestLog(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", "show");
            jSONObject.put("tab", LogConfig.TAB_LIVE_CLOSE_GUEST);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("author", str4);
            jSONObject.put("type", "");
            jSONObject.put("style", "");
            jSONObject.put(LogConfig.LOG_ISHAND, "");
            jSONObject.put("vtime", "");
            jSONObject.put(LogConfig.LOG_REC_TYPE, "");
            jSONObject.put(LogConfig.LOG_POSTINDEX, str5);
            jSONObject.put("index", str6);
            jSONObject.put("vid", str3);
            jSONObject.put("live_id", str);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str7);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 2);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doReadRecommendLiveCloseGuestLog(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", "read");
            jSONObject.put("tab", LogConfig.TAB_LIVE_CLOSE_GUEST);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("author", str4);
            jSONObject.put("type", "");
            jSONObject.put("style", "");
            jSONObject.put(LogConfig.LOG_ISHAND, "");
            jSONObject.put("vtime", "");
            jSONObject.put(LogConfig.LOG_REC_TYPE, "");
            jSONObject.put(LogConfig.LOG_POSTINDEX, str5);
            jSONObject.put("index", str6);
            jSONObject.put("vid", str3);
            jSONObject.put("live_id", str);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str7);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doClickShowOffLiveCloseLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "live_close");
            jSONObject.put("k", "click");
            jSONObject.put("v", "show_off");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("vid", str3);
            jSONObject.put("live_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doNoticeStaytimeLiveCloseGuestLog(String str, String str2, String str3, long j, String str4) {
    }
}
