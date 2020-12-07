package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IYuyinLiveLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class QuanminYuyinLiveLogger implements IYuyinLiveLogger {
    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doShowYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("tab", "liveroom");
            jSONObject2.put("k", LogConfig.KEY_VIDEO_SHOW);
            jSONObject2.put("vid", str3);
            jSONObject2.put("tag", "");
            jSONObject2.put("pos_int", i);
            jSONObject2.put("type", "live");
            jSONObject2.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject2.put("type", "live");
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject2.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject2, str2, true, true);
            if (!z) {
                try {
                    jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    ExtraParamsManager.doLog(jSONObject, 0);
                }
            }
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e = e3;
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doClickYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("tab", "liveroom");
            jSONObject2.put("k", LogConfig.KEY_VIDEO_READ);
            jSONObject2.put("tag", "");
            jSONObject2.put("pos_int", i);
            jSONObject2.put("type", "live");
            jSONObject2.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject2.put("vid", str3);
            jSONObject2.put("type", "live");
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject2.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject2, str2, true, true);
            if (!z) {
                try {
                    jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    ExtraParamsManager.doLog(jSONObject, 0);
                }
            }
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e = e3;
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doStartPlayYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("tab", "liveroom");
            jSONObject2.put("k", "action");
            jSONObject2.put("v", "playstart");
            jSONObject2.put("tag", "");
            jSONObject2.put("pos_int", i);
            jSONObject2.put("type", "live");
            jSONObject2.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject2.put("type", "live");
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject2.put("vid", str3);
            jSONObject2.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject2, str2, true, true);
            if (!z) {
                try {
                    jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    ExtraParamsManager.doLog(jSONObject, 0);
                }
            }
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e = e3;
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doPlayYuyinLiveStayTimeLog(String str, String str2, int i, boolean z, String str3, long j) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("tab", "liveroom");
            jSONObject2.put("k", "notice");
            jSONObject2.put("v", "playtime");
            jSONObject2.put("tag", "");
            jSONObject2.put("pos_int", i);
            jSONObject2.put("type", "live");
            jSONObject2.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject2.put("time", j);
            jSONObject2.put("type", "live");
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject2.put("vid", str3);
            jSONObject2.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject2, str2, true, true);
            if (!z) {
                try {
                    jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    ExtraParamsManager.doLog(jSONObject, 0);
                }
            }
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e = e3;
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doAccessPlayYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject;
        JSONException e;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("tab", "liveroom");
            jSONObject2.put("k", "access");
            jSONObject2.put("tag", "");
            jSONObject2.put("pos_int", i);
            jSONObject2.put("type", "live");
            jSONObject2.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject2.put("type", "live");
            jSONObject2.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject2.put("vid", str3);
            jSONObject2.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject2, str2, true, true);
            if (!z) {
                try {
                    jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    ExtraParamsManager.doLog(jSONObject, 0);
                }
            }
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e = e3;
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }
}
