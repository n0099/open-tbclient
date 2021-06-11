package com.baidu.searchbox.http.cookie;

import android.text.TextUtils;
import com.alipay.sdk.encrypt.a;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public class CookieJarImpl implements CookieJar {
    public CookieManager cookieManager;

    public CookieJarImpl(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    private String encodeIllegalInfo(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    private List<Cookie> getCookies(HttpUrl httpUrl, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int delimiterOffset = Util.delimiterOffset(str, i2, length, ';');
            int delimiterOffset2 = Util.delimiterOffset(str, i2, delimiterOffset, (char) a.f1886h);
            String trimSubstring = Util.trimSubstring(str, i2, delimiterOffset2);
            String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
            if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
            }
            String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
            String encodeIllegalInfo2 = encodeIllegalInfo(trimSubstring2);
            if (!TextUtils.isEmpty(encodeIllegalInfo) && this.cookieManager.shouldSendCookie(httpUrl.toString(), encodeIllegalInfo)) {
                arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(httpUrl.host()).build());
            }
            i2 = delimiterOffset + 1;
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        ArrayList arrayList = new ArrayList();
        CookieManager cookieManager = this.cookieManager;
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(httpUrl.toString());
            if (!TextUtils.isEmpty(cookie)) {
                arrayList.addAll(getCookies(httpUrl, cookie));
            }
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.cookieManager != null) {
            ArrayList arrayList = new ArrayList();
            String httpUrl2 = httpUrl.toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!TextUtils.isEmpty(cookie2) && this.cookieManager.shouldAcceptCookie(httpUrl2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            this.cookieManager.storeCookie(httpUrl.toString(), arrayList);
        }
    }
}
