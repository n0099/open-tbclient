package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IYuanPackageLogger;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HaokanYuanPackageLogger implements IYuanPackageLogger {
    @Override // com.baidu.live.tbadk.log.IYuanPackageLogger
    public void doDisplayOneGiftBagLog(String str, String str2, String str3, String str4, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_ONE_GIFT_BAG);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
            jSONObject.put("type", j);
            jSONObject.put("vid", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IYuanPackageLogger
    public void doClickOneGiftBagLog(String str, String str2, String str3, String str4, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_ONE_GIFT_BAG);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
            jSONObject.put("type", j);
            jSONObject.put("vid", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IYuanPackageLogger
    public void doCloseClickOneGiftBagLog(String str, String str2, String str3, String str4, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_ONE_GIFT_CLOSE);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
            jSONObject.put("type", j);
            jSONObject.put("vid", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
