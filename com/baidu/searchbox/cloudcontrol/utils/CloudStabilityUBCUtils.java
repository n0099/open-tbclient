package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudStabilityUBCUtils {
    public static final int CSS_CODE_ERROR = 2;
    public static final int CSS_DATA_ERROR = 5;
    public static final int CSS_DISPATCH = 0;
    public static final int CSS_ERRNO = 4;
    public static final int CSS_FAIL = 3;
    public static final int CSS_NET_ERROR = 6;
    public static final int ERRNO_NULL = -100;
    public static final String KEY_DURATION = "duration";
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_ERROR_MSG = "errorMsg";
    public static final String KEY_EXT = "ext";
    public static final String KEY_RESPONSE_CODE = "responseCode";
    public static final String KEY_SOURCE = "source";
    public static final String KEY_TRACE_ID = "traceid";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final String TAG = "CloudStabilityUBCUtils";
    public static final String UBC_CLOUD_STABILITY_REQUEST_ID = "1929";
    public static final String UBC_CLOUD_STABILITY_RESPONSE_ID = "1928";
    public static final String VALUE_TYPE = "stability";

    public static void doRequestStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", VALUE_TYPE);
            jSONObject.put("source", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("traceid", str2);
            jSONObject.put("ext", jSONObject2);
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent(UBC_CLOUD_STABILITY_REQUEST_ID, jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doRequestStatistics 1929:" + jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doRequestStatistics error" + e2.toString());
                e2.printStackTrace();
            }
        }
    }

    public static void doResponseStatistics(String str, int i, String str2, int i2, int i3, String str3, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", VALUE_TYPE);
            jSONObject.put("source", str);
            jSONObject.put("value", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("traceid", str2);
            jSONObject2.put(KEY_RESPONSE_CODE, i2);
            jSONObject2.put("duration", j);
            if (i3 != -100) {
                jSONObject2.put("errorCode", i3);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("errorMsg", str3);
            }
            jSONObject.put("ext", jSONObject2);
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent(UBC_CLOUD_STABILITY_RESPONSE_ID, jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doResponseStatistics 1928:" + jSONObject.toString());
            }
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doResponseStatistics error" + e2.toString());
                e2.printStackTrace();
            }
        }
    }
}
