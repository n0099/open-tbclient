package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IGiftLogger;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HaokanGiftLogger implements IGiftLogger {
    @Override // com.baidu.live.tbadk.log.IGiftLogger
    public void doDisplayGiftTabLog(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("tag", str3);
            jSONObject.put("loc", LogConfig.VALUE_LOC_GIFT_ZONE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.IGiftLogger
    public void doNoticeLiveGiftSendRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
    }
}
