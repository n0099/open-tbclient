package com.baidu.searchbox.ng.ai.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class AppReadyEvent {
    private static final String EVENT_DATA_APP_CONFIG = "appConfig";
    private static final String EVENT_DATA_APP_PATH = "appPath";
    private static final String EVENT_DATA_DEBUG_SCONSOLE = "devhook";
    private static final String EVENT_DATA_EXTRA_DATA = "extraData";
    private static final String EVENT_DATA_PAGE_URL = "pageUrl";
    private static final String EVENT_DATA_WEBVIEW_ID = "wvID";
    private static final String EVENT_NAME_APP_READY = "AppReady";
    public String appConfig;
    public String appPath;
    public String extraData;
    public String pageUrl;
    public String sConsole;
    public String webviewId;

    public static AiAppsCommonMessage createAppReadyMessage(AppReadyEvent appReadyEvent) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(EVENT_DATA_APP_CONFIG, appReadyEvent.appConfig);
        treeMap.put(EVENT_DATA_APP_PATH, appReadyEvent.appPath);
        treeMap.put("wvID", appReadyEvent.webviewId);
        treeMap.put(EVENT_DATA_PAGE_URL, appReadyEvent.pageUrl);
        treeMap.put(EVENT_DATA_DEBUG_SCONSOLE, appReadyEvent.sConsole);
        if (!TextUtils.isEmpty(appReadyEvent.extraData)) {
            treeMap.put("extraData", appReadyEvent.extraData);
        }
        return new AiAppsCommonMessage(EVENT_NAME_APP_READY, treeMap);
    }
}
