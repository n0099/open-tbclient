package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler;
import com.baidu.searchbox.perfframe.PerfFrame;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ExceptionHandlerImpl implements ExceptionHandler {
    public static final String EXCEPTION_TYPE_JAVA = "java";
    public static final String KEY_CUSTOM = "custom";
    public static final String KEY_EXTRA_STACKTRACE = "extra_stacktrace";
    public static final String KEY_STACKTRACE = "stacktrace";
    public static final String TAG = "ExceptionHandler";
    public static final String UBC_ID = "1768";
    public boolean mForce;

    public ExceptionHandlerImpl(boolean z) {
        this.mForce = false;
        this.mForce = z;
    }

    @Override // com.baidu.searchbox.logsystem.exceptionhandler.api.ExceptionHandler
    public void onException(Exception exc, String str, String str2, Map<String, String> map) {
        if (exc == null) {
            return;
        }
        if (AppConfig.isDebug() && !this.mForce) {
            throw new RuntimeException(exc);
        }
        PerfFrame create = new PerfFrame.Builder().setNeedPageTrace(true).setNeedDynamicperf(true).setNeedStaticperf(true).create();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stacktrace", Log.getStackTraceString(exc));
            if (map != null) {
                JSONObject jSONObject2 = new JSONObject();
                for (String str3 : map.keySet()) {
                    if (str3 != null) {
                        if (str3.equals("stacktrace")) {
                            jSONObject2.put(KEY_EXTRA_STACKTRACE, map.get(str3));
                        } else {
                            jSONObject2.put(str3, map.get(str3));
                        }
                    }
                }
                jSONObject.put(KEY_CUSTOM, jSONObject2.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        create.submitPerformanceData(UBC_ID, EXCEPTION_TYPE_JAVA, System.currentTimeMillis(), new ExceptionHandlerComponent().exceptionHandlerContext.get().getAppLaunchStartTimeStamp(), exc.getMessage(), str2, jSONObject.toString());
    }
}
