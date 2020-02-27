package com.baidu.swan.apps.j;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.setting.oauth.g;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import java.util.List;
/* loaded from: classes11.dex */
public class c extends g {
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
        if (list != null && list.size() > 0) {
            try {
                for (String str2 : list) {
                    CookieManager.getInstance().setCookie(str, str2);
                }
                MK();
            } catch (Exception e) {
            }
        }
    }

    public void MK() {
        if (com.baidu.swan.apps.as.a.hasLollipop()) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.getInstance().sync();
        }
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
