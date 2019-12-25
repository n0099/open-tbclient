package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IYuanPackageLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class QuanminYuanPackageLogger implements IYuanPackageLogger {
    @Override // com.baidu.live.tbadk.log.IYuanPackageLogger
    public void doDisplayOneGiftBagLog(String str, String str2, String str3, String str4, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_ONERMB_GIFTBAG);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put("type", j);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IYuanPackageLogger
    public void doClickOneGiftBagLog(String str, String str2, String str3, String str4, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_ONERMB_GIFTBAG);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put("type", j);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IYuanPackageLogger
    public void doCloseClickOneGiftBagLog(String str, String str2, String str3, String str4, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_LIVE_ONERMB_GIFTBAG_CLOSE);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put("type", j);
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
