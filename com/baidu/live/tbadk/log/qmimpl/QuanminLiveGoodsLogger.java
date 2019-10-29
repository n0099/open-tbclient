package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class QuanminLiveGoodsLogger implements ILiveGoodsLogger {
    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doDisplayStoreIconLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", LogConfig.VALUE_LIVE_STORE_ICON);
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doDisplayGoodsListLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", "live_goods_list");
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doDisplayGoodsGuideLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_DISPLAY);
            jSONObject.put("v", "live_goods_guide_card");
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.ILiveGoodsLogger
    public void doClickGoodsGuideLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "click");
            jSONObject.put("v", "live_goods_guide_card");
            jSONObject.put(LogConfig.LOG_VID, str3);
            jSONObject.put("tag", "");
            jSONObject.put(LogConfig.LOG_VIDEO_TYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str4, false, false);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
