package com.baidu.searchbox.ng.ai.apps.console.debugger;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class RemoteDebugger {
    private static final String APP_JSON_PATH = "/app/app.json";
    public static final String EXTRA_REMOTE_DEBUG_URL = "remoteDebugUrl";
    private static final String MASTER_PATH = "/swan-core/master/master.html";
    private static final String SLAVE_PATH = "/swan-core/slaves/slaves.html";
    private static String sWebUrl;

    public static boolean isRemoteDebug() {
        return !TextUtils.isEmpty(sWebUrl);
    }

    public static String getMasterWebViewUrl() {
        return sWebUrl + MASTER_PATH;
    }

    public static String getSlaveWebViewUrl() {
        return sWebUrl + SLAVE_PATH;
    }

    public static void setWebUrl(String str) {
        sWebUrl = str;
    }

    public static String getWebUrl() {
        return sWebUrl;
    }
}
