package com.baidu.searchbox.network.support.cookie;

import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.searchbox.network.outback.core.UrlWrapper;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.cookie.Cookie;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CookieJarImpl implements CookieJar {
    public CookieManager cookieManager;

    public CookieJarImpl(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    @Override // com.baidu.searchbox.network.support.cookie.CookieJar
    public List<Cookie> loadForRequest(UrlWrapper urlWrapper) {
        ArrayList arrayList = new ArrayList();
        CookieManager cookieManager = this.cookieManager;
        if (cookieManager != null) {
            String cookie = cookieManager.getCookie(urlWrapper.toString());
            if (!Util.isTextEmpty(cookie)) {
                arrayList.addAll(getCookies(urlWrapper, cookie));
            }
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
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            } else {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
        }
        return sb.toString();
    }

    private List<Cookie> getCookies(UrlWrapper urlWrapper, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = Util.delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
            int delimiterOffset2 = Util.delimiterOffset(str, i, delimiterOffset, '=');
            String trimSubstring = Util.trimSubstring(str, i, delimiterOffset2);
            if (delimiterOffset2 < delimiterOffset) {
                str2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
            } else {
                str2 = "";
            }
            if (str2.startsWith("\"") && str2.endsWith("\"")) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
            String encodeIllegalInfo2 = encodeIllegalInfo(str2);
            if (!Util.isTextEmpty(encodeIllegalInfo) && this.cookieManager.shouldSendCookie(urlWrapper.toString(), encodeIllegalInfo)) {
                arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(urlWrapper.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }

    @Override // com.baidu.searchbox.network.support.cookie.CookieJar
    public void saveFromResponse(UrlWrapper urlWrapper, List<Cookie> list) {
        if (this.cookieManager != null) {
            ArrayList arrayList = new ArrayList();
            String urlWrapper2 = urlWrapper.toString();
            for (Cookie cookie : list) {
                String cookie2 = cookie.toString();
                if (!Util.isTextEmpty(cookie2) && this.cookieManager.shouldAcceptCookie(urlWrapper2, cookie2)) {
                    arrayList.add(cookie2);
                }
            }
            this.cookieManager.storeCookie(urlWrapper.toString(), arrayList);
        }
    }
}
