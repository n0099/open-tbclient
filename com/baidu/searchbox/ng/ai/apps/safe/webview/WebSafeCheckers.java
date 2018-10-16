package com.baidu.searchbox.ng.ai.apps.safe.webview;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class WebSafeCheckers {
    public static final boolean DEBUG = false;
    public static final String TAG = "WebSafeCheckers";
    private static final String WILDCARD = "*.";

    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkWebDomain(String str) {
        boolean z;
        String host;
        AiApp aiApp;
        boolean z2 = false;
        System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            host = new URL(str).getHost();
            aiApp = AiApp.get();
        } catch (MalformedURLException e) {
            z = z2;
        }
        if (aiApp == null) {
            return false;
        }
        ArrayList<String> webDomains = aiApp.getWebSafe().getWebDomains(AiApp.getAiAppId(), true);
        if (!TextUtils.isEmpty(host) && webDomains != null) {
            Iterator<String> it = webDomains.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next != null) {
                    if (next.startsWith(WILDCARD)) {
                        if (host.endsWith(next.substring(WILDCARD.length()))) {
                            z2 = true;
                            break;
                        }
                    } else if (TextUtils.equals(next, host)) {
                        z2 = true;
                        break;
                    }
                    z = z2;
                    if (!z) {
                        AiAppsLog.d(TAG, "domain is not in white list");
                    }
                    System.currentTimeMillis();
                    return z;
                }
            }
        }
        AiAppsLog.d(TAG, "domain: " + host);
        z = z2;
        if (!z) {
        }
        System.currentTimeMillis();
        return z;
    }

    public static boolean checkWebAction(String str) {
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.d(TAG, "action is not in white list: action=" + str);
            return false;
        }
        ArrayList<String> webActions = AiApp.get().getWebSafe().getWebActions(true);
        if (webActions == null || !webActions.contains(str)) {
            AiAppsLog.d(TAG, "action is not in white list: action=" + str);
            return false;
        }
        return true;
    }

    public static boolean checkAdLandingWebAction(String str) {
        if (TextUtils.isEmpty(str)) {
            AiAppsLog.d(TAG, "action is not in white list: action=" + str);
            return false;
        }
        ArrayList<String> adLandingWebActions = AiApp.get().getWebSafe().getAdLandingWebActions();
        if (adLandingWebActions != null && adLandingWebActions.contains(str)) {
            return true;
        }
        AiAppsLog.d(TAG, "action is not in adLanding white list: action=" + str);
        return false;
    }
}
