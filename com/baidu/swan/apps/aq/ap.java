package com.baidu.swan.apps.aq;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes7.dex */
public class ap {
    public static void axk() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.aq.ap.1
            @Override // java.lang.Runnable
            public void run() {
                CookieManager.getInstance().setCookie(".baidu.com", aj.getCookieStr(".baidu.com", "SP_FW_VER", com.baidu.swan.apps.swancore.b.hv(0), 2937600L));
                CookieManager.getInstance().setCookie(".baidu.com", aj.getCookieStr(".baidu.com", "SG_FW_VER", com.baidu.swan.apps.swancore.b.hv(1), 2937600L));
                ap.axl();
            }
        }, "SwanJsVersionCookieManager");
    }

    public static void axl() {
        if (c.hasLollipop()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
