package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveRecordLogger;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HaokanLiveRecordLogger implements ILiveRecordLogger {
    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickFunctionButtonLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.TAB_LIVE_RECORD);
            jSONObject.put("k", "click");
            jSONObject.put("v", str3);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveRecordCloseButtonLog(String str) {
        doClickFunctionButtonLog("", str, "close_click");
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveAddCoverButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_ADD_COVER);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveChangeCoverButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_CHANGE_COVER);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveLocationAllowButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_LOCATION_ALLOW);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveLocationAlreadyButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_LOCATION_ALREADY);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveChangeTitleButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_CHANGE_TITLE);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareToWeiboButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.LIVE_SHARE_HK_WEIBO);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareToQQButtonLog(String str) {
        doClickFunctionButtonLog("", str, "qq");
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareWeixinButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveShareToTimeLineButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.LIVE_SHARE_HK_WEIXIN_TIMELINE);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveStoreIconButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_STORE_ICON);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveBeautyButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_BEAUTY);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveRecordStartButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_RECORD_START);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveRulesButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_RULES);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveCameraFlipButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_CAMERA_FLIP);
    }

    @Override // com.baidu.live.tbadk.log.ILiveRecordLogger
    public void doClickLiveSplashButtonLog(String str) {
        doClickFunctionButtonLog("", str, LogConfig.VALUE_LIVE_HK_SPLASH);
    }
}
