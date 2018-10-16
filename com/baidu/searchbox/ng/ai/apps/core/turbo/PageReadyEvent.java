package com.baidu.searchbox.ng.ai.apps.core.turbo;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public final class PageReadyEvent {
    private static final String EVENT_DATA_APP_PATH = "appPath";
    private static final String EVENT_DATA_DEBUG_SCONSOLE = "devhook";
    private static final String EVENT_DATA_PAGE_PATH = "pagePath";
    private static final String EVENT_NAME_PAGE_READY = "PageReady";
    private static final String EVENT_ON_REACH_BOTTOM_DISTANCE = "onReachBottomDistance";
    public String appPath;
    public String onReachBottomDistance;
    public String pagePath;
    public String sConsole;

    public static AiAppsCommonMessage createPageReadyMessage(PageReadyEvent pageReadyEvent) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(EVENT_DATA_APP_PATH, pageReadyEvent.appPath);
        treeMap.put(EVENT_DATA_PAGE_PATH, pageReadyEvent.pagePath);
        treeMap.put(EVENT_DATA_DEBUG_SCONSOLE, pageReadyEvent.sConsole);
        if (!TextUtils.isEmpty(pageReadyEvent.onReachBottomDistance)) {
            treeMap.put(EVENT_ON_REACH_BOTTOM_DISTANCE, pageReadyEvent.onReachBottomDistance);
        }
        return new AiAppsCommonMessage(EVENT_NAME_PAGE_READY, treeMap);
    }

    public String toString() {
        return "PageReadyEvent{appPath='" + this.appPath + "', pagePath='" + this.pagePath + "', onReachBottomDistance='" + this.onReachBottomDistance + "'}";
    }
}
