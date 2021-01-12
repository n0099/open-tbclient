package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.ab;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class CloudControlUBCUtils {
    private static final String KEY_CONTROL = "control";
    public static final String KEY_EXT = "ext";
    public static final String KEY_K = "product";
    private static final String KEY_LOGID = "logid";
    private static final String KEY_SERVICE = "service";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_TRACE_ID = "traceid";
    public static final String KEY_V = "version";
    public static final String KEY_VALID = "valid";
    private static final String TAG = "CloudControlUBCUtils";
    private static final String UBC_CLOUD_CTROL_ID = "944";

    public void doStatistics(CloudControlUBCData cloudControlUBCData) {
        if (cloudControlUBCData != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("source", cloudControlUBCData.getRunType());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("logid", cloudControlUBCData.getLogId());
                JSONObject serviceJsonObject = cloudControlUBCData.getServiceJsonObject();
                if (serviceJsonObject != null && serviceJsonObject.length() != 0) {
                    jSONObject2.put("service", serviceJsonObject);
                }
                JSONObject controlJsonObject = cloudControlUBCData.getControlJsonObject();
                if (controlJsonObject != null && controlJsonObject.length() != 0) {
                    jSONObject2.put(KEY_CONTROL, controlJsonObject);
                }
                if (!TextUtils.isEmpty(cloudControlUBCData.getTraceId())) {
                    jSONObject.put(KEY_TRACE_ID, cloudControlUBCData.getTraceId());
                }
                jSONObject.put("ext", jSONObject2);
                ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
                if (abVar != null) {
                    abVar.onEvent(UBC_CLOUD_CTROL_ID, jSONObject);
                }
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "cloud control ubc is 944:" + jSONObject.toString());
                }
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "cloud control doStatistics error" + e.toString());
                    e.printStackTrace();
                }
            }
        }
    }
}
