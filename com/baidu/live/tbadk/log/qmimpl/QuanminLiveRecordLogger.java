package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveRecordLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QuanminLiveRecordLogger implements ILiveRecordLogger {
    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickFunctionButtonLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_RECORD);
            jSONObject.put("k", "click");
            jSONObject.put("v", str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveRecordCloseButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_RECORD_CLOSE);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveAddCoverButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_ADD_COVER);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveChangeCoverButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_CHANGE_COVER);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveLocationAllowButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_LOCATION_ALLOW);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveLocationAlreadyButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_LOCATION_ALREADY);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveChangeTitleButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_CHANGE_TITLE);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareToWeiboButtonLog(String str) {
        doClickLiveShareToButtonLog(str, LogConfig.LIVE_SHARE_WEIBO);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareToQQButtonLog(String str) {
        doClickLiveShareToButtonLog(str, LogConfig.LIVE_SHARE_QQ_FRIEND);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareWeixinButtonLog(String str) {
        doClickLiveShareToButtonLog(str, LogConfig.LIVE_SHARE_WEIXIN_FRIEND);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareToTimeLineButtonLog(String str) {
        doClickLiveShareToButtonLog(str, LogConfig.LIVE_SHARE_WEIXIN_TIMELINE);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveStoreIconButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_STORE_ICON);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveBeautyButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_BEAUTY);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveRecordStartButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_RECORD_START);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveRulesButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_RULES);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveCameraFlipButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_CAMERA_FLIP);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveSplashButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_SPLASH);
    }

    public void doClickLiveShareToButtonLog(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_RECORD);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_SHARE_TO);
            jSONObject.put("tag", "");
            jSONObject.put("type", "");
            jSONObject.put("name", str2);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    public void doDisplayStoreIconLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_STORE_ICON);
            jSONObject.put("vid", str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    public void doDisplayGoodsListLog(String str, String str2, String str3, int i, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "display");
            jSONObject.put("v", "live_goods_list");
            jSONObject.put("vid", str3);
            jSONObject.put("tag", "");
            jSONObject.put("type", i + "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    public void doDisplayGoodsGuideLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "display");
            jSONObject.put("v", "live_goods_guide_card");
            jSONObject.put("vid", str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    public void doClickGoodsGuideLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", "live_goods_guide_card");
            jSONObject.put("vid", str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
