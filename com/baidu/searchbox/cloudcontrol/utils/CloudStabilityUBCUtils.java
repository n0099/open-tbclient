package com.baidu.searchbox.cloudcontrol.utils;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.ab;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class CloudStabilityUBCUtils {
    public static final int CSS_CODE_ERROR = 2;
    public static final int CSS_DATA_ERROR = 5;
    public static final int CSS_DISPATCH = 0;
    public static final int CSS_ERRNO = 4;
    public static final int CSS_FAIL = 3;
    public static final int CSS_NET_ERROR = 6;
    public static final int ERRNO_NULL = -100;
    private static final String KEY_DURATION = "duration";
    private static final String KEY_ERROR_CODE = "errorCode";
    private static final String KEY_ERROR_MSG = "errorMsg";
    public static final String KEY_EXT = "ext";
    private static final String KEY_RESPONSE_CODE = "responseCode";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_TRACE_ID = "traceid";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VALUE = "value";
    private static final String TAG = "CloudStabilityUBCUtils";
    private static final String UBC_CLOUD_STABILITY_REQUEST_ID = "1929";
    private static final String UBC_CLOUD_STABILITY_RESPONSE_ID = "1928";
    public static final String VALUE_TYPE = "stability";

    public static void doRequestStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", VALUE_TYPE);
            jSONObject.put("source", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_TRACE_ID, str2);
            jSONObject.put("ext", jSONObject2);
            ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
            if (abVar != null) {
                abVar.onEvent(UBC_CLOUD_STABILITY_REQUEST_ID, jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doRequestStatistics 1929:" + jSONObject.toString());
            }
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doRequestStatistics error" + e.toString());
                e.printStackTrace();
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
            jSONObject2.put(KEY_TRACE_ID, str2);
            jSONObject2.put(KEY_RESPONSE_CODE, i2);
            jSONObject2.put("duration", j);
            if (i3 != -100) {
                jSONObject2.put("errorCode", i3);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("errorMsg", str3);
            }
            jSONObject.put("ext", jSONObject2);
            ab abVar = (ab) c.a(ab.SERVICE_REFERENCE);
            if (abVar != null) {
                abVar.onEvent(UBC_CLOUD_STABILITY_RESPONSE_ID, jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doResponseStatistics 1928:" + jSONObject.toString());
            }
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doResponseStatistics error" + e.toString());
                e.printStackTrace();
            }
        }
    }
}
