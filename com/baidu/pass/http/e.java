package com.baidu.pass.http;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
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
/* loaded from: classes5.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2845a = "e";
    private static final String b = "Set-Cookie";
    private static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    private static final String d = "Cookie";
    private static final String e = "https://";

    e() {
    }

    static String a(String str, String str2, String str3, long j, boolean z) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c, Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(calendar.getTime()) + ";httponly" + (z ? ";secure" : "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    public static void b(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        String str;
        HttpCookie httpCookie;
        try {
            CookieSyncManager.createInstance(context);
            String cookie = CookieManager.getInstance().getCookie("https://" + new URI(passHttpParamDTO.url).getHost());
            f.a(f2845a, "asyncCookie" + passHttpParamDTO.asyncCookie);
            f.a(f2845a, "webviewCookies" + cookie);
            String str2 = !passHttpParamDTO.asyncCookie ? null : cookie;
            List<HttpCookie> list = passHttpParamDTO.cookie;
            if (!TextUtils.isEmpty(str2) || (list != null && !list.isEmpty())) {
                String str3 = "";
                String[] split = TextUtils.isEmpty(str2) ? null : str2.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                if (split != null && split.length > 0) {
                    int length = split.length;
                    int i = 0;
                    String str4 = "";
                    while (i < length) {
                        String str5 = split[i];
                        if (TextUtils.isEmpty(str5)) {
                            str = str4;
                        } else {
                            List<HttpCookie> parse = HttpCookie.parse(str5);
                            if (parse.isEmpty()) {
                                str = str4;
                            } else {
                                HttpCookie httpCookie2 = parse.get(0);
                                if (httpCookie2 == null) {
                                    str = str4;
                                } else if (httpCookie2.hasExpired()) {
                                    str = str4;
                                } else {
                                    if (list != null) {
                                        httpCookie = httpCookie2;
                                        for (HttpCookie httpCookie3 : list) {
                                            if (!httpCookie.getName().equals(httpCookie3.getName()) || !a(passHttpParamDTO.url, httpCookie)) {
                                                httpCookie3 = httpCookie;
                                            }
                                            httpCookie = httpCookie3;
                                        }
                                    } else {
                                        httpCookie = httpCookie2;
                                    }
                                    str = !httpCookie.hasExpired() ? str4 + httpCookie.getName() + "=" + httpCookie.getValue() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR : str4;
                                    f.a(f2845a, "httpCookie webview item name:" + httpCookie.getName() + ",value:" + httpCookie.getValue());
                                }
                            }
                        }
                        i++;
                        str4 = str;
                    }
                    str3 = str4;
                }
                if (list != null) {
                    String str6 = str3;
                    for (HttpCookie httpCookie4 : list) {
                        if (a(passHttpParamDTO.url, httpCookie4)) {
                            str6 = str6 + httpCookie4.getName() + "=" + httpCookie4.getValue() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
                        }
                    }
                    str3 = str6;
                }
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, str3.length() - 1);
                    f.a(f2845a, "cookieStr" + substring);
                    httpURLConnection.setRequestProperty("Cookie", substring);
                }
            }
        } catch (Exception e2) {
            f.a(f2845a, "asyncWebviewCookie2NA:" + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    public static void a(Context context, HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) {
        Map<String, List<String>> headerFields;
        List<String> list;
        try {
            f.a(f2845a, "asyncCookie" + passHttpParamDTO.asyncCookie);
            if (passHttpParamDTO.asyncCookie && (headerFields = httpURLConnection.getHeaderFields()) != null && !headerFields.isEmpty() && (list = headerFields.get("Set-Cookie")) != null && !list.isEmpty()) {
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                if (cookieManager.acceptCookie()) {
                    for (String str : list) {
                        if (!TextUtils.isEmpty(str)) {
                            List<HttpCookie> parse = HttpCookie.parse(str);
                            if (!parse.isEmpty()) {
                                HttpCookie httpCookie = parse.get(0);
                                if (a(passHttpParamDTO.url, httpCookie)) {
                                    Log.e(f2845a, "httpcookie:" + httpCookie.toString());
                                    String a2 = a(httpCookie.getDomain(), httpCookie.getName(), httpCookie.getValue(), System.currentTimeMillis() + (httpCookie.getMaxAge() * 1000), httpCookie.getSecure());
                                    Log.e(f2845a, "httpcookie build:" + a2);
                                    cookieManager.setCookie("https://" + httpCookie.getDomain(), a2);
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
            f.a(f2845a, "asyncNaCookie2Webview:" + e2.toString());
        }
    }

    @TargetApi(9)
    private static boolean a(String str, HttpCookie httpCookie) {
        try {
            URL url = new URL(str);
            if (httpCookie.getDiscard() || httpCookie.hasExpired() || !a(url.getHost(), httpCookie.getDomain()) || !b(url.getPath(), httpCookie.getPath())) {
                return false;
            }
            return a(str, httpCookie.getSecure());
        } catch (Exception e2) {
            return false;
        }
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.startsWith(str2) && (str2.endsWith("/") || str.charAt(str2.length()) == '/');
    }

    private static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !z || str.startsWith("https://");
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return (str.endsWith(str2) && str.charAt((str.length() - str2.length()) + (-1)) == '.' && !f.b(str)) || str.endsWith(str2) || str2.startsWith(".") || !f.b(str);
    }
}
