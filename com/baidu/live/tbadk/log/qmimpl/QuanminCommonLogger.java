package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ICommonLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class QuanminCommonLogger implements ICommonLogger {
    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doTestLog() {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGusetNumLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GUESTS_NUM);
            jSONObject.put("vid", str);
            jSONObject.put("tag", "");
            jSONObject.put("name", str2);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str3, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickTopRightAuthorLog(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_TOP_RIGHT_AUTHOR);
            jSONObject.put("vid", str);
            jSONObject.put("tag", "");
            jSONObject.put("pos", i);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplaySpeakGuideLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vid", str);
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_MSG_GUIDE);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("name", str3);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickSpeakGuideButtonLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_MSG_GUIDE_SEND);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("name", str3);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickLiveAuthorRankSupportLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("v", LogConfig.VALUE_LIVE_AUTHOR_RANK_SUPPORT);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("type", str2);
            LogManager.addOtherParamsToJson(jSONObject, str3, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doIMLongLinkLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", str);
            jSONObject.put("tab", str2);
            jSONObject.put("tag", str3);
            jSONObject.put(LogConfig.LOG_PRETAB, str4);
            jSONObject.put(LogConfig.LOG_PRETAG, str5);
            jSONObject.put("name", str6);
            jSONObject.put("mcast_id", str7);
            jSONObject.put("code", i);
            jSONObject.put("message", str8);
            jSONObject.put("session_id", str9);
            jSONObject.put(LogConfig.LOG_EXT_LOG, str10);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayBuyTBeanPageLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_PANEL);
            jSONObject.put("tab", "");
            jSONObject.put("tag", "");
            jSONObject.put("loc", str3);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickBuyTBeanListLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_CHOOSE);
            jSONObject.put("tab", "");
            jSONObject.put("tag", "");
            jSONObject.put("type", str3);
            jSONObject.put("loc", str);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayBuyTBeanResourceLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_BANNER);
            jSONObject.put("tab", "");
            jSONObject.put("tag", "");
            jSONObject.put("loc", LogConfig.VALUE_LOC_RECHARGE_PANEL);
            jSONObject.put("name", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickBuyTBeanResourceLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_BANNER);
            jSONObject.put("tab", "");
            jSONObject.put("tag", "");
            jSONObject.put("loc", LogConfig.VALUE_LOC_RECHARGE_PANEL);
            jSONObject.put("name", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickBuyTBeanCustomLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_INPUT);
            jSONObject.put("tab", "");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImHiLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_INPUT_HI);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImListLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_QUICK_TEXT);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("name", str3);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImMoreLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_PROMPT_MORE);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImToolLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_PROMPT_TEXT);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("name", str3);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayQuickImPanelLog(String str, String str2) {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImPanelLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_PROMPT_MORE_TEXT);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("name", str3);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayGuideFollowFloatLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_WATCH_FOLLOW_GUIDE);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGuideFollowFloatConfirmLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", "follow");
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("loc", LogConfig.VALUE_WATCH_GUIDE);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayGuideFollowPopLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LEAVE_FOLLOW_GUIDE);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGuideFollowPopConfirmLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", "follow");
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("loc", LogConfig.VALUE_LEAVE_GUIDE);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGuideFollowPopCancelLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_QUIT_CONFIRM);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankEntryLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_HOUR_RANK);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("type", str2);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str3, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankRuleIconLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RANK_RULE);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankConfirmNoticeLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RANK_NOTICE);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayHourRankLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_HOUR_RANK_LAYER);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("type", str2);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str3, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankItemLog(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("vid", str);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_HOUR_RANK_AUTHOR);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("type", str2);
            jSONObject.put("pos", str4);
            jSONObject.put("loc", str3);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str5, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }
}
