package com.baidu.searchbox.ng.ai.apps.core.console;

import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.core.AiAppsWebViewManager;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class ConsoleMessageHelper {
    private static final boolean DEBUG = false;
    private static final String EVENT_DATA = "data";
    private static final String EVENT_FULL = "sanFullData2Console";
    private static final String EVENT_INC = "sanIncData2Console";
    private static final String TAG = "ConsoleMessageHelper";

    public static void requestFullSanData() {
        AiAppsWebViewManager webViewManager = AiAppsController.getInstance().getWebViewManager(AiAppsController.getInstance().getSlaveWebViewId());
        if (webViewManager != null) {
            AiAppsLog.i(TAG, "send full San request");
            webViewManager.handleSchemeDispatchCallback("window.__san_devtool__.retrieveData", null);
        }
    }

    public static void sendFullSan2Console(String str) {
        dispatchMessage2Console(EVENT_FULL, str);
    }

    public static void sendIncSan2Console(String str) {
        dispatchMessage2Console(EVENT_INC, str);
    }

    private static void dispatchMessage2Console(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("data", str2);
        AiAppsController.getInstance().sendJSMessage(AiAppsController.getInstance().getConsoleManager().getWebViewId(), new AiAppsCommonMessage(str, hashMap));
    }
}
