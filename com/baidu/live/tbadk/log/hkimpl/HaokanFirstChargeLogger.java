package com.baidu.live.tbadk.log.hkimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IFirstChargeLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HaokanFirstChargeLogger implements IFirstChargeLogger {
    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doDisplayLiveFirstChargePopupLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_FIRSTCHARGE_POP);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("vid", str3);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doClickLiveFirstChargePopupLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_FIRSTCHARGE_POP);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("room_id", str2);
            jSONObject.put("vid", str3);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doClickLiveFirstChargePopupCloseLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_FIRSTCHARGE_CLOSE);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("room_id", str2);
            jSONObject.put("vid", str3);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doDisplayLiveFirstChargeQuickLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_QUICK_FIRSTCHARGE);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("room_id", str2);
            jSONObject.put("vid", str3);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doClickLiveFirstChargeQuickLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_QUICK_FIRSTCHARGE);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("room_id", str2);
            jSONObject.put("vid", str3);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doDisplayLiveFirstChargePanelEntryLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "display");
            jSONObject.put("v", LogConfig.VALUE_FIRSTCHARGE_DOOR);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("room_id", str2);
            jSONObject.put("vid", str3);
            jSONObject.put("loc", LogConfig.VALUE_LIVE_RECHARGE_ZONE);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }

    @Override // com.baidu.live.tbadk.log.IFirstChargeLogger
    public void doClickLiveFirstChargePanelEntryLog(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject.put("k", "click");
            jSONObject.put("v", LogConfig.VALUE_FIRSTCHARGE_DOOR);
            jSONObject.put("tab", LogConfig.VALUE_LIVE_DETAIL);
            jSONObject.put("live_id", str);
            jSONObject.put("room_id", str2);
            jSONObject.put("vid", str3);
            jSONObject.put("loc", LogConfig.VALUE_LIVE_RECHARGE_ZONE);
            LogManager.attachHaoKanLiveOtherParams(jSONObject, str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 1);
    }
}
