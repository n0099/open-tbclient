package com.baidu.searchbox.logsystem.util;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AppExtraUtil {
    public static volatile AppExtraCall sAppExtraCall;

    /* loaded from: classes4.dex */
    public interface AppExtraCall {
        JSONObject getAppExtraInfo();
    }

    public static String getAppExtra() {
        JSONObject appExtraInfo;
        if (sAppExtraCall != null && (appExtraInfo = sAppExtraCall.getAppExtraInfo()) != null) {
            return appExtraInfo.toString();
        }
        return null;
    }

    public static void setAppExtraCall(AppExtraCall appExtraCall) {
        sAppExtraCall = appExtraCall;
    }
}
