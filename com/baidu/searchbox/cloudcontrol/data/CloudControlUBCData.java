package com.baidu.searchbox.cloudcontrol.data;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlUBCData {
    public static final String KEY_COUNT = "count";
    public static final String KEY_ITEMS = "items";
    public static final String TAG = "CloudControlUBCData";
    public String logId;
    public String mTraceId;
    public String runType;
    public JSONObject serviceJsonObject = new JSONObject();
    public JSONObject controlJsonObject = new JSONObject();

    public void collectDegradegInfo(int i, int i2, int i3, JSONArray jSONArray) {
        try {
            this.controlJsonObject.put("count", i + "," + i2 + "," + i3);
            this.controlJsonObject.put("items", jSONArray);
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "collectDegradegInfo is error" + e2.toString());
            }
        }
    }

    public void collectServiceInfo(JSONObject jSONObject) {
        this.serviceJsonObject = jSONObject;
    }

    public JSONObject getControlJsonObject() {
        return this.controlJsonObject;
    }

    public String getLogId() {
        return this.logId;
    }

    public String getRunType() {
        return this.runType;
    }

    public JSONObject getServiceJsonObject() {
        return this.serviceJsonObject;
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public void setLogId(String str) {
        this.logId = str;
    }

    public void setRunType(String str) {
        this.runType = str;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }
}
