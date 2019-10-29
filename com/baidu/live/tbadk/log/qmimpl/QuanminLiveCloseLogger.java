package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveCloseLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QuanminLiveCloseLogger implements ILiveCloseLogger {
    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doAccessLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_END);
            jSONObject.put("k", LogConfig.KEY_ACCESS);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doFollowClickLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", "follow");
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("loc", LogConfig.TAB_LIVE_END);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doClickNoFollowLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_END);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_FOLLOW_CANCEL);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("loc", LogConfig.TAB_LIVE_END);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doClickChangeSomeLiveCloseGuestLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_END);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_VIDEO_REFRESH);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doShowRecommendLiveCloseGuestLog(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_END);
            jSONObject.put("k", LogConfig.KEY_VIDEO_SHOW);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put("pos", str6);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str2);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str7, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doReadRecommendLiveCloseGuestLog(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_END);
            jSONObject.put("k", LogConfig.KEY_VIDEO_READ);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put("pos", str6);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str2);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str7, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doClickShowOffLiveCloseLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "live_close");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SHOWOFF);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str2);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveCloseLogger
    public void doNoticeStaytimeLiveCloseGuestLog(String str, String str2, String str3, long j, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_END);
            jSONObject.put("k", LogConfig.KEY_NOTICE);
            jSONObject.put("v", LogConfig.VALUE_STAYTIME);
            jSONObject.put("tag", "");
            jSONObject.put("time", j + "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }
}
