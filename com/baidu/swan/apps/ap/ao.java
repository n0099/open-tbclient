package com.baidu.swan.apps.ap;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes25.dex */
public class ao {
    public static void aPE() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.ap.ao.1
            @Override // java.lang.Runnable
            public void run() {
                CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "SP_FW_VER", com.baidu.swan.apps.swancore.b.kZ(0), 2937600L));
                CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "SG_FW_VER", com.baidu.swan.apps.swancore.b.kZ(1), 2937600L));
                ao.aPF();
            }
        }, "SwanJsVersionCookieManager");
    }

    public static void aPF() {
        if (c.hasLollipop()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
