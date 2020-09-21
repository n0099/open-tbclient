package com.baidu.swan.bdprivate.c;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.g;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    static {
        try {
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (DEBUG) {
            Log.d("RealCookieManager", "storeCookie httpUrl: " + str);
            Log.d("RealCookieManager", "storeCookie cookies: " + list);
        }
        try {
            for (String str2 : list) {
                CookieManager.getInstance().setCookie(str, str2);
            }
            aGe();
        } catch (Exception e) {
        }
    }

    public void aGe() {
        if (com.baidu.swan.apps.ap.c.hasLollipop()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        String str2 = "";
        try {
            str2 = CookieManager.getInstance().getCookie(str);
            if (DEBUG) {
                Log.d("RealCookieManager", "RealCookieManager:" + str2);
            }
        } catch (Exception e) {
        }
        return str2;
    }
}
