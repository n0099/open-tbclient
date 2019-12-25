package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class i {
    private static Locale Qh;

    public static String getCountry() {
        return Qh.getCountry();
    }

    public static String getLanguage() {
        return Qh.getLanguage();
    }

    public static void w() {
        Qh = Locale.getDefault();
    }

    public static String x() {
        return Qh.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Qh.getCountry();
    }
}
