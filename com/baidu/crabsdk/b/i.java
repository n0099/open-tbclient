package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale Ke;

    public static String getCountry() {
        return Ke.getCountry();
    }

    public static String getLanguage() {
        return Ke.getLanguage();
    }

    public static void w() {
        Ke = Locale.getDefault();
    }

    public static String x() {
        return Ke.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Ke.getCountry();
    }
}
