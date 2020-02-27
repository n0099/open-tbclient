package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveIMLogger;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class HaokanLiveIMLogger implements ILiveIMLogger {
    @Override // com.baidu.live.tbadk.log.ILiveIMLogger
    public void doIMLongLinkLog(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10, String str11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", LogConfig.KEY_NOTICE);
            jSONObject.put("v", LogConfig.VALUE_IM_STATUS);
            jSONObject.put("tab", str2);
            jSONObject.put("tag", str3);
            jSONObject.put(LogConfig.LOG_PRETAB, str4);
            jSONObject.put(LogConfig.LOG_PRETAG, str5);
            jSONObject.put("name", str6);
            jSONObject.put("room_id", str7);
            jSONObject.put("mcast_id", str8);
            jSONObject.put("code", i);
            jSONObject.put("message", str9);
            jSONObject.put("session_id", System.currentTimeMillis());
            jSONObject.put(LogConfig.LOG_EXT_LOG, str11);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, true);
    }

    @Override // com.baidu.live.tbadk.log.ILiveIMLogger
    public void doGiftIMLog(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject.put("k", LogConfig.KEY_NOTICE);
            jSONObject.put("v", LogConfig.VALUE_IM_GIFT);
            jSONObject.put("tab", "");
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_PRETAB, "");
            jSONObject.put(LogConfig.LOG_PRETAG, "");
            jSONObject.put("name", str);
            jSONObject.put(LogConfig.LOG_GIFT_ID, str4);
            jSONObject.put("room_id", str2);
            jSONObject.put("mcast_id", str3);
            jSONObject.put("code", -1);
            jSONObject.put("message", str5);
            jSONObject.put("session_id", System.currentTimeMillis());
            jSONObject.put(LogConfig.LOG_EXT_LOG, "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, false);
    }
}
