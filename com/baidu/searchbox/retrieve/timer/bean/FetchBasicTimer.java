package com.baidu.searchbox.retrieve.timer.bean;

import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FetchBasicTimer {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String EXPIRED = "expiredTime";
    public static final String INFO = "info";
    public static final String JOB_ID = "jobId";
    public static final String TAG = "FetchTimerData";
    public static final String TYPE = "type";
    public static final String VERSION = "version";

    public static FetchTimerBasicBean parseJsonContent(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("jobId");
        String optString3 = jSONObject.optString("version");
        try {
            long parseLong = Long.parseLong(jSONObject.optString("expiredTime")) * 1000;
            if (parseLong < System.currentTimeMillis()) {
                reportTaskCheckFail(optString, optString2, optString2, jSONObject);
                return null;
            }
            return new FetchTimerBasicBean(optString2, optString, optString3, parseLong);
        } catch (Exception e) {
            reportTaskCheckFail(optString, optString2, optString3, jSONObject);
            if (DEBUG) {
                Log.d(TAG, e.getMessage());
            }
            reportTaskCheckFail(optString, optString2, optString3, jSONObject);
            return null;
        }
    }

    public static void reportTaskCheckFail(String str, String str2, String str3, JSONObject jSONObject) {
        ((IFetchTask) ServiceManager.getService(IFetchTask.SERVICE_REFERENCE)).reportTaskCheckFail(str, str2, str3, jSONObject);
    }
}
