package com.baidu.live.tbadk.log.qmimpl;

import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.IYuyinLiveLogger;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class QuanminYuyinLiveLogger implements IYuyinLiveLogger {
    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doShowYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_VIDEO_SHOW);
            jSONObject.put("vid", str3);
            jSONObject.put("tag", "");
            jSONObject.put("pos_int", i);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject.put("type", "live");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, true, true);
            if (!z) {
                jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doClickYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", LogConfig.KEY_VIDEO_READ);
            jSONObject.put("tag", "");
            jSONObject.put("pos_int", i);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject.put("vid", str3);
            jSONObject.put("type", "live");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, true, true);
            if (!z) {
                jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doStartPlayYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "action");
            jSONObject.put("v", "playstart");
            jSONObject.put("tag", "");
            jSONObject.put("pos_int", i);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject.put("type", "live");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put("vid", str3);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, true, true);
            if (!z) {
                jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doPlayYuyinLiveStayTimeLog(String str, String str2, int i, boolean z, String str3, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "notice");
            jSONObject.put("v", "playtime");
            jSONObject.put("tag", "");
            jSONObject.put("pos_int", i);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject.put("time", j);
            jSONObject.put("type", "live");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put("vid", str3);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, true, true);
            if (!z) {
                jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }

    @Override // com.baidu.live.tbadk.log.IYuyinLiveLogger
    public void doAccessPlayYuyinLiveGuestLog(String str, String str2, int i, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tab", "liveroom");
            jSONObject.put("k", "access");
            jSONObject.put("tag", "");
            jSONObject.put("pos_int", i);
            jSONObject.put("type", "live");
            jSONObject.put(LogConfig.LOG_OTHER_ID, str);
            jSONObject.put("type", "live");
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put("vid", str3);
            jSONObject.put(LogConfig.LOG_VIDEOTYPE, "live");
            jSONObject = LogManager.addOtherParamsToJson(jSONObject, str2, true, true);
            if (!z) {
                jSONObject.put(LogConfig.LOG_PRETAB, "liveroom");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExtraParamsManager.doLog(jSONObject, 0);
    }
}
