package com.baidu.swan.apps.t.a;

import com.baidu.searchbox.http.cookie.CookieManager;
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.config.a {
    private static int dhV = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public CookieManager aBI() {
        return com.baidu.swan.apps.t.a.aAQ().alT();
    }
}
