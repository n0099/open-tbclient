package com.baidu.swan.apps.ao;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes9.dex */
public class ao {
    public static void aOw() {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.ao.ao.1
            @Override // java.lang.Runnable
            public void run() {
                CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "SP_FW_VER", com.baidu.swan.apps.swancore.b.jB(0), 2937600L));
                CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "SG_FW_VER", com.baidu.swan.apps.swancore.b.jB(1), 2937600L));
                ao.aOx();
            }
        }, "SwanJsVersionCookieManager");
    }

    public static void aOx() {
        if (c.hasLollipop()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
