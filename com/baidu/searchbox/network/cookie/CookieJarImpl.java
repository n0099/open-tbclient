package com.baidu.searchbox.network.cookie;

import android.text.TextUtils;
import com.baidu.searchbox.network.core.Cookie;
import com.baidu.searchbox.network.core.CookieJar;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.internal.Util;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class CookieJarImpl implements CookieJar {
    @Override // com.baidu.searchbox.network.core.CookieJar
    public void saveFromResponse(Request request, List<Cookie> list) {
        CookieManager cookieManager = request.httpRequest().getCookieManager();
        if (cookieManager != null) {
            ArrayList arrayList = new ArrayList();
            String httpUrl = request.url().toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!TextUtils.isEmpty(cookie2) && cookieManager.shouldAcceptCookie(httpUrl, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            cookieManager.storeCookie(request.url().toString(), arrayList);
        }
    }

    @Override // com.baidu.searchbox.network.core.CookieJar
    public List<Cookie> loadForRequest(Request request) {
        CookieManager cookieManager = request.httpRequest().getCookieManager();
        ArrayList arrayList = new ArrayList();
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(request.url().toString());
            if (!TextUtils.isEmpty(cookie)) {
                arrayList.addAll(getCookies(cookieManager, request, cookie));
            }
        }
        return arrayList;
    }

    private List<Cookie> getCookies(CookieManager cookieManager, Request request, String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int length = str.length();
        while (i < length) {
            int delimiterOffset = Util.delimiterOffset(str, i, length, ';');
            int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
            String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
            String trimSubstring2 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
            if (trimSubstring2.startsWith("\"") && trimSubstring2.endsWith("\"")) {
                trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
            }
            String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
            String encodeIllegalInfo2 = encodeIllegalInfo(trimSubstring2);
            if (!TextUtils.isEmpty(encodeIllegalInfo) && cookieManager.shouldSendCookie(request.url().toString(), encodeIllegalInfo)) {
                arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(request.url().host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }

    private String encodeIllegalInfo(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
