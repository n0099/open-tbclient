package com.baidu.pass.http;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9671a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9672b = "Set-Cookie";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9673c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";

    /* renamed from: d  reason: collision with root package name */
    public static final String f9674d = "Cookie";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9675e = "https://";

    public static String a(String str, String str2, String str3, long j, boolean z) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        sb.append(";domain=");
        sb.append(str);
        sb.append(";path=/;expires=");
        sb.append(simpleDateFormat.format(calendar.getTime()));
        sb.append(";httponly");
        sb.append(z ? ";secure" : "");
        return sb.toString();
    }

    @TargetApi(9)
    public static void b(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        HttpCookie httpCookie;
        try {
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            URI uri = new URI(passHttpParamDTO.url);
            StringBuilder sb = new StringBuilder();
            sb.append("https://");
            sb.append(uri.getHost());
            String cookie = cookieManager.getCookie(sb.toString());
            String str = f9671a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("asyncCookie");
            sb2.append(passHttpParamDTO.asyncCookie);
            e.a(str, sb2.toString());
            String str2 = f9671a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("webviewCookies");
            sb3.append(cookie);
            e.a(str2, sb3.toString());
            if (!passHttpParamDTO.asyncCookie) {
                cookie = null;
            }
            List<HttpCookie> list = passHttpParamDTO.cookie;
            if (TextUtils.isEmpty(cookie) && (list == null || list.isEmpty())) {
                return;
            }
            String str3 = "";
            String[] split = TextUtils.isEmpty(cookie) ? null : cookie.split(";");
            if (split != null && split.length > 0) {
                for (String str4 : split) {
                    if (!TextUtils.isEmpty(str4)) {
                        List<HttpCookie> parse = HttpCookie.parse(str4);
                        if (!parse.isEmpty() && (httpCookie = parse.get(0)) != null && !httpCookie.hasExpired()) {
                            if (list != null) {
                                for (HttpCookie httpCookie2 : list) {
                                    if (httpCookie.getName().equals(httpCookie2.getName()) && a(passHttpParamDTO.url, httpCookie)) {
                                        httpCookie = httpCookie2;
                                    }
                                }
                            }
                            if (!httpCookie.hasExpired()) {
                                str3 = str3 + httpCookie.getName() + "=" + httpCookie.getValue() + ";";
                            }
                            String str5 = f9671a;
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("httpCookie webview item name:");
                            sb4.append(httpCookie.getName());
                            sb4.append(",value:");
                            sb4.append(httpCookie.getValue());
                            e.a(str5, sb4.toString());
                        }
                    }
                }
            }
            if (list != null) {
                for (HttpCookie httpCookie3 : list) {
                    if (a(passHttpParamDTO.url, httpCookie3)) {
                        str3 = str3 + httpCookie3.getName() + "=" + httpCookie3.getValue() + ";";
                    }
                }
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            String substring = str3.substring(0, str3.length() - 1);
            String str6 = f9671a;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cookieStr");
            sb5.append(substring);
            e.a(str6, sb5.toString());
            httpURLConnection.setRequestProperty("Cookie", substring);
        } catch (Exception e2) {
            e.a(f9671a, "asyncWebviewCookie2NA:" + e2.toString());
        }
    }

    @TargetApi(9)
    public static void a(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        Map<String, List<String>> headerFields;
        List<String> list;
        try {
            String str = f9671a;
            StringBuilder sb = new StringBuilder();
            sb.append("asyncCookie");
            sb.append(passHttpParamDTO.asyncCookie);
            e.a(str, sb.toString());
            if (passHttpParamDTO.asyncCookie && (headerFields = httpURLConnection.getHeaderFields()) != null && !headerFields.isEmpty() && (list = headerFields.get("Set-Cookie")) != null && !list.isEmpty()) {
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                if (cookieManager.acceptCookie()) {
                    for (String str2 : list) {
                        if (!TextUtils.isEmpty(str2)) {
                            List<HttpCookie> parse = HttpCookie.parse(str2);
                            if (!parse.isEmpty()) {
                                HttpCookie httpCookie = parse.get(0);
                                if (a(passHttpParamDTO.url, httpCookie)) {
                                    String str3 = f9671a;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("httpcookie:");
                                    sb2.append(httpCookie.toString());
                                    Log.e(str3, sb2.toString());
                                    String a2 = a(httpCookie.getDomain(), httpCookie.getName(), httpCookie.getValue(), (httpCookie.getMaxAge() * 1000) + System.currentTimeMillis(), httpCookie.getSecure());
                                    String str4 = f9671a;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("httpcookie build:");
                                    sb3.append(a2);
                                    Log.e(str4, sb3.toString());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("https://");
                                    sb4.append(httpCookie.getDomain());
                                    cookieManager.setCookie(sb4.toString(), a2);
                                }
                            }
                        }
                    }
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        cookieManager.flush();
                    }
                }
            }
        } catch (Exception e2) {
            String str5 = f9671a;
            e.a(str5, "asyncNaCookie2Webview:" + e2.toString());
        }
    }

    @TargetApi(9)
    public static boolean a(String str, HttpCookie httpCookie) {
        try {
            URL url = new URL(str);
            if (!httpCookie.getDiscard() && !httpCookie.hasExpired() && a(url.getHost(), httpCookie.getDomain()) && b(url.getPath(), httpCookie.getPath())) {
                if (a(str, httpCookie.getSecure())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (str.startsWith(str2)) {
            return str2.endsWith("/") || str.charAt(str2.length()) == '/';
        }
        return false;
    }

    public static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !z || str.startsWith("https://");
    }

    public static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return (str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !e.b(str)) || str.endsWith(str2) || str2.startsWith(".") || !e.b(str);
    }
}
