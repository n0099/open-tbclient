package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ICommonLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HaokanCommonLogger implements ICommonLogger {
    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doTestLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GIFT);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put(LogConfig.LOG_VID, "1000");
            jSONObject.put("tag", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGusetNumLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_AUDIENCE_NUMBER);
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tag", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickTopRightAuthorLog(String str, int i, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_AUDIENCE_HEAD);
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("pos", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplaySpeakGuideLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_GUIDE);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put(LogConfig.LOG_VID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickSpeakGuideButtonLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_GUIDE_BUTTON);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("ext", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickLiveAuthorRankSupportLog(String str, String str2, String str3) {
        AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_RANK_SUPPORT);
        alaStaticItem.addParams("other_params", str3);
        AlaStaticsManager.getInst().onStatic(alaStaticItem);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doIMLongLinkLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10) {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayBuyTBeanPageLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_ZONE);
            jSONObject.put("from", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickBuyTBeanListLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_ZONE);
            jSONObject.put(LogConfig.LOG_AMOUNT, str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayBuyTBeanResourceLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_BANNER);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickBuyTBeanResourceLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_BANNER);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickBuyTBeanCustomLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_RECHARGE_ZONE_INPUT);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImHiLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_HI_BUTTON);
            jSONObject.put(LogConfig.LOG_VID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImListLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_HI_TOOLTIP);
            jSONObject.put("name", str3);
            jSONObject.put("pos", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImMoreLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_MORE_BUTTON);
            jSONObject.put(LogConfig.LOG_VID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImToolLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_UP_TOOLTIP);
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("name", str3);
            jSONObject.put("pos", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayQuickImPanelLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_MORE_TOOLTIP);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickQuickImPanelLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SPEAK_MORE_TOOLTIP);
            jSONObject.put("name", str3);
            jSONObject.put("pos", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayGuideFollowFloatLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_WATCH_FOLLOW_GUIDE);
            jSONObject.put(LogConfig.LOG_VID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGuideFollowFloatConfirmLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", LogConfig.KEY_FOLLOW_CLICK);
            jSONObject.put("v", "follow");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("tag", "");
            jSONObject.put("loc", LogConfig.VALUE_LIVE_NOW_FOLLOW_ZONE);
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("live_id", str2);
            jSONObject.put("name", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayGuideFollowPopLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_EXIT_FOLLOW_GUIDE);
            jSONObject.put(LogConfig.LOG_VID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGuideFollowPopConfirmLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", LogConfig.KEY_FOLLOW_CLICK);
            jSONObject.put("v", "follow");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("tag", "");
            jSONObject.put("loc", LogConfig.VALUE_LIVE_LEAVE_FOLLOW_ZONE);
            jSONObject.put(LogConfig.LOG_VID, str);
            jSONObject.put("live_id", str2);
            jSONObject.put("name", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickGuideFollowPopCancelLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", LogConfig.KEY_LEAVE_CLICK);
            jSONObject.put("v", LogConfig.VALUE_LIVE_EXIT_FOLLOW_GUIDE);
            jSONObject.put(LogConfig.LOG_VID, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankEntryLog(String str, String str2, String str3) {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankRuleIconLog(String str, String str2) {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankConfirmNoticeLog(String str, String str2) {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doDisplayHourRankLog(String str, String str2, String str3) {
    }

    @Override // com.baidu.live.tbadk.log.ICommonLogger
    public void doClickHourRankItemLog(String str, String str2, String str3, String str4, String str5) {
    }
}
