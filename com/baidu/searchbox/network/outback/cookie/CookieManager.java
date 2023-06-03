package com.baidu.searchbox.network.outback.cookie;

import android.webkit.CookieSyncManager;
import java.util.List;
/* loaded from: classes4.dex */
public interface CookieManager {
    public static final CookieManager WEBKIT_COOKIES = new CookieManager() { // from class: com.baidu.searchbox.network.outback.cookie.CookieManager.1
        @Override // com.baidu.searchbox.network.outback.cookie.CookieManager
        public boolean shouldAcceptCookie(String str, String str2) {
            return true;
        }

        @Override // com.baidu.searchbox.network.outback.cookie.CookieManager
        public boolean shouldSendCookie(String str, String str2) {
            return true;
        }

        @Override // com.baidu.searchbox.network.outback.cookie.CookieManager
        public String getCookie(String str) {
            try {
                return android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // com.baidu.searchbox.network.outback.cookie.CookieManager
        public void storeCookie(String str, List<String> list) {
            if (list != null && list.size() > 0) {
                try {
                    android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
                    for (String str2 : list) {
                        cookieManager.setCookie(str, str2);
                    }
                    CookieSyncManager.getInstance().sync();
                } catch (Exception unused) {
                }
            }
        }
    };

    String getCookie(String str);

    boolean shouldAcceptCookie(String str, String str2);

    boolean shouldSendCookie(String str, String str2);

    void storeCookie(String str, List<String> list);
}
