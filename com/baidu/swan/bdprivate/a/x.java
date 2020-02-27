package com.baidu.swan.bdprivate.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.ag;
import com.baidu.webkit.internal.ETAG;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
/* loaded from: classes11.dex */
public class x {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String cbg = "cookieMap";
    public static String cbh = "ptokenDomains";
    public static String cbi = "bdussDomains";

    public static void dg(Context context) {
        dh(context);
    }

    public static void dh(Context context) {
        if (context != null) {
            String cS = a.cS(context);
            String cZ = a.cZ(context);
            b(context, cS, ahP());
            c(context, cZ, ahP());
        }
    }

    private static void b(Context context, String str, List<String> list) {
        String buildBDUSSCookie;
        if (list == null) {
            if (DEBUG) {
                Log.w("SwanAppCookieUtils", "bduss domains is invalid");
                return;
            }
            return;
        }
        for (String str2 : list) {
            if (TextUtils.isEmpty(str)) {
                buildBDUSSCookie = ag.getCookieStr(str2, "BDUSS", "deleted", 0L);
            } else {
                buildBDUSSCookie = buildBDUSSCookie(str2, str);
            }
            o("http://www." + str2, buildBDUSSCookie, false);
        }
    }

    private static String buildBDUSSCookie(String str, String str2) {
        return K(str, "BDUSS", str2);
    }

    private static String buildPtokenCookie(String str, String str2) {
        return K(str, "PTOKEN", str2);
    }

    private static String K(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return b(str, str2, str3, calendar.getTime(), false);
    }

    private static String b(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + ETAG.EQUAL + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(date) + ";httponly" + (z ? ";secure" : "");
    }

    private static void c(Context context, String str, List<String> list) {
        String buildPtokenCookie;
        if (list == null) {
            if (DEBUG) {
                Log.w("SwanAppCookieUtils", "ptoken domains is invalid");
                return;
            }
            return;
        }
        for (String str2 : list) {
            if (TextUtils.isEmpty(str)) {
                buildPtokenCookie = ag.getCookieStr(str2, "PTOKEN", "deleted", 0L);
            } else {
                buildPtokenCookie = buildPtokenCookie(str2, str);
            }
            o("http://www." + str2, buildPtokenCookie, false);
        }
    }

    private static void o(String str, String str2, boolean z) {
        CookieManager.getInstance().setCookie(str, str2);
        if (z) {
            CookieSyncManager.getInstance().sync();
        }
    }

    private static List<String> ahP() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }
}
