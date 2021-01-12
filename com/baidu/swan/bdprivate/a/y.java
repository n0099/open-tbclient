package com.baidu.swan.bdprivate.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ai;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;
/* loaded from: classes8.dex */
public class y {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static String dRm = "cookieMap";
    public static String dRn = "ptokenDomains";
    public static String dRo = "bdussDomains";

    public static void ek(Context context) {
        el(context);
    }

    public static void el(Context context) {
        if (context != null) {
            String dW = a.dW(context);
            String ed = a.ed(context);
            b(context, dW, aPd());
            c(context, ed, aPd());
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
                buildBDUSSCookie = ai.getCookieStr(str2, "BDUSS", "deleted", 0L);
            } else {
                buildBDUSSCookie = buildBDUSSCookie(str2, str);
            }
            t("http://www." + str2, buildBDUSSCookie, false);
        }
    }

    private static String buildBDUSSCookie(String str, String str2) {
        return ae(str, "BDUSS", str2);
    }

    private static String buildPtokenCookie(String str, String str2) {
        return ae(str, "PTOKEN", str2);
    }

    private static String ae(String str, String str2, String str3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(str3) ? -8 : 8);
        return b(str, str2, str3, calendar.getTime(), false);
    }

    private static String b(String str, String str2, String str3, Date date, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;expires=" + simpleDateFormat.format(date) + ";httponly" + (z ? ";secure" : "");
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
                buildPtokenCookie = ai.getCookieStr(str2, "PTOKEN", "deleted", 0L);
            } else {
                buildPtokenCookie = buildPtokenCookie(str2, str);
            }
            t("http://www." + str2, buildPtokenCookie, false);
        }
    }

    private static void t(String str, String str2, boolean z) {
        CookieManager.getInstance().setCookie(str, str2);
        if (z) {
            CookieSyncManager.getInstance().sync();
        }
    }

    private static List<String> aPd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("baidu.com");
        arrayList.add("hao123.com");
        arrayList.add("nuomi.com");
        arrayList.add("baifubao.com");
        return arrayList;
    }
}
