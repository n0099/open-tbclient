package com.baidu.searchbox.cloudcontrol.data;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CloudControlUBCData {
    public static final String KEY_COUNT = "count";
    public static final String KEY_ITEMS = "items";
    private static final String TAG = "CloudControlUBCData";
    private String logId;
    private String mTraceId;
    private String runType;
    private JSONObject serviceJsonObject = new JSONObject();
    private JSONObject controlJsonObject = new JSONObject();

    public void setRunType(String str) {
        this.runType = str;
    }

    public void setLogId(String str) {
        this.logId = str;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    public void collectServiceInfo(JSONObject jSONObject) {
        this.serviceJsonObject = jSONObject;
    }

    public void collectDegradegInfo(int i, int i2, int i3, JSONArray jSONArray) {
        try {
            this.controlJsonObject.put("count", i + "," + i2 + "," + i3);
            this.controlJsonObject.put("items", jSONArray);
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "collectDegradegInfo is error" + e.toString());
            }
        }
    }

    public JSONObject getServiceJsonObject() {
        return this.serviceJsonObject;
    }

    public JSONObject getControlJsonObject() {
        return this.controlJsonObject;
    }

    public String getRunType() {
        return this.runType;
    }

    public String getLogId() {
        return this.logId;
    }
}
