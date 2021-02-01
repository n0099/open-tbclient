package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IGuardClubLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class QuanminGuardClubLogger implements IGuardClubLogger {
    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doAccessLiveGuardMemberLog(String str, String str2, String str3, String str4) {
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doStayTimeLiveGuardMemberLog(String str, String str2, String str3, long j, String str4) {
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doAccessLiveJoinGuardLog(String str, String str2, String str3, String str4) {
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doStayTimeLiveJoinGuardLog(String str, String str2, String str3, long j, String str4) {
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doDisplayLiveGuardLog(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUARD);
            jSONObject.put("tag", "");
            jSONObject.put("type", str4);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str5, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveRuleLog(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RULE);
            jSONObject.put("tag", "");
            jSONObject.put("type", str4);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str5, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doDisplayLiveGuardButtonLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUARD_BUTTON);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveGuardButtonLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUARD_BUTTON);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveGuardJoinLog(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUARD_JOIN);
            jSONObject.put("tag", "");
            jSONObject.put("loc", str4);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str5, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickFollowLog(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", "follow");
            jSONObject.put("tab", str4);
            jSONObject.put("tag", "");
            jSONObject.put("loc", str5);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str6, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doDisplayLiveGiftPopupLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GIFT_POPUP);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doDisplayLiveLeaveGuardLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LEAVE_GUARD);
            jSONObject.put("tab", LogConfig.TAB_LIVE_JOIN_GUARD);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_PRETAB, "webview");
            jSONObject.put(LogConfig.LOG_PRETAG, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveLeaveGuardLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LEAVE_GUARD);
            jSONObject.put("tab", LogConfig.TAB_LIVE_JOIN_GUARD);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_PRETAB, "webview");
            jSONObject.put(LogConfig.LOG_PRETAG, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }
}
