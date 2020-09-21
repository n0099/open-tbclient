package com.baidu.swan.apps.ap;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes3.dex */
public class ao {
    public static void aGd() {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.ap.ao.1
            @Override // java.lang.Runnable
            public void run() {
                CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "SP_FW_VER", com.baidu.swan.apps.swancore.b.jN(0), 2937600L));
                CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "SG_FW_VER", com.baidu.swan.apps.swancore.b.jN(1), 2937600L));
                ao.aGe();
            }
        }, "SwanJsVersionCookieManager");
    }

    public static void aGe() {
        if (c.hasLollipop()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
