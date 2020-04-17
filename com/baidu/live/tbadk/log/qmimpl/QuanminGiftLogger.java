package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IGiftLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class QuanminGiftLogger implements IGiftLogger {
    @Override // com.baidu.live.tbadk.log.IGiftLogger
    public void doDisplayGiftTabLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_LIVE_GIFT_PANEL);
            jSONObject.put("tab", "liveroom");
            jSONObject.put("tag", "");
            jSONObject.put("type", str3);
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGiftLogger
    public void doNoticeLiveGiftSendRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_NOTICE);
            jSONObject.put("v", "live_gift_send_request");
            jSONObject.put("name", str4);
            jSONObject.put(LogConfig.LOG_OTHER_ID, str2);
            jSONObject.put(LogConfig.LOG_GIFT_ID, str5);
            jSONObject.put(LogConfig.LOG_GIFT_VALUE, str6);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str7, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
