package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale RQ;

    public static String getCountry() {
        return RQ.getCountry();
    }

    public static String getLanguage() {
        return RQ.getLanguage();
    }

    public static void w() {
        RQ = Locale.getDefault();
    }

    public static String x() {
        return RQ.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + RQ.getCountry();
    }
}
