package com.baidu.live.tbadk.log.hkimpl;

import android.text.TextUtils;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IGuardClubLogger;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HaokanGuardClubLogger implements IGuardClubLogger {
    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doAccessLiveGuardMemberLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GROUP_MEMBER_TOOLTIP);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
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
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            if (TextUtils.equals(str4, "guard")) {
                jSONObject.put("status", "1");
            } else {
                jSONObject.put("status", "0");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveRuleLog(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_GUARDIAN_RULES_TOOLTIP);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doDisplayLiveGuardButtonLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_GUARDIAN_BUTTON);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveGuardButtonLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_GUARDIAN_BUTTON);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveGuardJoinLog(String str, String str2, String str3, String str4, String str5) {
        String str6;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", LogConfig.KEY_GUARDIAN_CLICK);
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUARDIAN_TOOLTIP);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            if ("guard".equals(str4)) {
                str6 = "tooltip";
            } else {
                str6 = "pop";
            }
            jSONObject.put("from", str6);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickFollowLog(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", LogConfig.KEY_FOLLOW_CLICK);
            jSONObject.put("v", "follow");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("tag", "");
            jSONObject.put("loc", str5);
            jSONObject.put("name", "关注");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doDisplayLiveGiftPopupLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_JOIN_GROUP_POP);
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
            jSONObject.put("v", LogConfig.VALUE_LEAVE_GUARD_HK);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IGuardClubLogger
    public void doClickLiveLeaveGuardLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", LogConfig.KEY_LEAVE_CLICK);
            jSONObject.put("v", LogConfig.VALUE_LEAVE_GUARD_HK);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
