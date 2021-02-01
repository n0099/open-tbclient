package com.baidu.swan.apps.t.a;

import com.baidu.searchbox.http.cookie.CookieManager;
/* loaded from: classes9.dex */
public class c implements com.baidu.swan.config.a {
    private static int dfu = -1;

    @Override // com.baidu.swan.config.a
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.config.a
    public CookieManager ayn() {
        return com.baidu.swan.apps.t.a.axv().aiy();
    }
}
