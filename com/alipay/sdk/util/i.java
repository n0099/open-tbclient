package com.alipay.sdk.util;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2006a = "pref_trade_token";

    /* renamed from: b  reason: collision with root package name */
    public static final String f2007b = ";";

    /* renamed from: c  reason: collision with root package name */
    public static final String f2008c = "result={";

    /* renamed from: d  reason: collision with root package name */
    public static final String f2009d = "}";

    /* renamed from: e  reason: collision with root package name */
    public static final String f2010e = "trade_token=\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f2011f = "\"";

    /* renamed from: g  reason: collision with root package name */
    public static final String f2012g = "trade_token=";

    public static void a(Context context, String str) {
        try {
            String a2 = a(str);
            c.b("", "PayResultUtil::saveTradeToken > tradeToken:" + a2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            j.a(context, f2006a, a2);
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
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith(f2008c) && split[i].endsWith("}")) {
                String[] split2 = split[i].substring(8, split[i].length() - 1).split("&");
                int i2 = 0;
                while (true) {
                    if (i2 >= split2.length) {
                        break;
                    } else if (split2[i2].startsWith(f2010e) && split2[i2].endsWith("\"")) {
                        str2 = split2[i2].substring(13, split2[i2].length() - 1);
                        break;
                    } else if (split2[i2].startsWith(f2012g)) {
                        str2 = split2[i2].substring(12);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return str2;
    }

    public static String a(Context context) {
        String b2 = j.b(context, f2006a, "");
        c.b("", "PayResultUtil::fetchTradeToken > tradeToken:" + b2);
        return b2;
    }
}
