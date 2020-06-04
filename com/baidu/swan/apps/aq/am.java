package com.baidu.swan.apps.aq;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes11.dex */
public class am {
    public static void atV() {
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.aq.am.1
            @Override // java.lang.Runnable
            public void run() {
                CookieManager.getInstance().setCookie(".baidu.com", ah.getCookieStr(".baidu.com", "SP_FW_VER", com.baidu.swan.apps.swancore.b.hb(0), 2937600L));
                am.atW();
            }
        }, "SwanJsVersionCookieManager");
    }

    public static void atW() {
        if (b.hasLollipop()) {
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager.createInstance(AppRuntime.getAppContext());
        CookieSyncManager.getInstance().sync();
    }
}
