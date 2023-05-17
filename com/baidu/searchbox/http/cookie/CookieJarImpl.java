package com.baidu.searchbox.http.cookie;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
/* loaded from: classes3.dex */
public class CookieJarImpl implements CookieJar {
    public CookieManager cookieManager;

    public CookieJarImpl(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
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

    public static int delimiterOffset(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
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

    private List<Cookie> getCookies(HttpUrl httpUrl, String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = delimiterOffset(str, i, length, (char) WebvttCueParser.CHAR_SEMI_COLON);
            int delimiterOffset2 = delimiterOffset(str, i, delimiterOffset, '=');
            String trimSubstring = trimSubstring(str, i, delimiterOffset2);
            if (delimiterOffset2 < delimiterOffset) {
                str2 = trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
            } else {
                str2 = "";
            }
            if (str2.startsWith("\"") && str2.endsWith("\"")) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            String encodeIllegalInfo = encodeIllegalInfo(trimSubstring);
            String encodeIllegalInfo2 = encodeIllegalInfo(str2);
            if (!TextUtils.isEmpty(encodeIllegalInfo) && this.cookieManager.shouldSendCookie(httpUrl.toString(), encodeIllegalInfo)) {
                arrayList.add(new Cookie.Builder().name(encodeIllegalInfo).value(encodeIllegalInfo2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String trimSubstring(String str, int i, int i2) {
        int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, i, i2);
        return str.substring(skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, i2));
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
