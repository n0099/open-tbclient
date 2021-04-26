package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1963a = "pref_trade_token";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1964b = ";";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1965c = "result={";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1966d = "}";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1967e = "trade_token=\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1968f = "\"";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1969g = "trade_token=";

    public static void a(Context context, String str) {
        try {
            String a2 = a(str);
            c.b("", "PayResultUtil::saveTradeToken > tradeToken:" + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            j.a(context, f1963a, a2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.B, th);
            c.a(th);
        }
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].startsWith(f1965c) && split[i2].endsWith("}")) {
                String[] split2 = split[i2].substring(8, split[i2].length() - 1).split("&");
                int i3 = 0;
                while (true) {
                    if (i3 >= split2.length) {
                        break;
                    } else if (split2[i3].startsWith(f1967e) && split2[i3].endsWith("\"")) {
                        str2 = split2[i3].substring(13, split2[i3].length() - 1);
                        break;
                    } else if (split2[i3].startsWith(f1969g)) {
                        str2 = split2[i3].substring(12);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(Context context) {
        String b2 = j.b(context, f1963a, "");
        c.b("", "PayResultUtil::fetchTradeToken > tradeToken:" + b2);
        return b2;
    }
}
