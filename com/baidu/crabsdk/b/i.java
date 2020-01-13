package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class i {
    private static Locale Ql;

    public static String getCountry() {
        return Ql.getCountry();
    }

    public static String getLanguage() {
        return Ql.getLanguage();
    }

    public static void w() {
        Ql = Locale.getDefault();
    }

    public static String x() {
        return Ql.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Ql.getCountry();
    }
}
