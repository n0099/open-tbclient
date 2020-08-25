package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HaokanLiveGoodsLogger implements ILiveGoodsLogger {
    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doDisplayStoreIconLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "display");
            jSONObject.put("v", "shopping_car_icon");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
            jSONObject.put("vid", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doDisplayGoodsListLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "display");
            jSONObject.put("v", "shopping_list_tooltip");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doDisplayGoodsGuideLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "display");
            jSONObject.put("v", "shopping_guide");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doClickGoodsGuideLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("k", "click");
            jSONObject.put("v", "shopping_guide");
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("live_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
