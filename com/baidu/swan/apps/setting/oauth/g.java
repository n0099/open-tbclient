package com.baidu.swan.apps.setting.oauth;

import com.baidu.searchbox.http.cookie.CookieManager;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class g implements CookieManager {
    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public abstract String getCookie(String str);

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        return false;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
    }
}
