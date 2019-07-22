package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale aab;

    public static String getCountry() {
        return aab.getCountry();
    }

    public static String getLanguage() {
        return aab.getLanguage();
    }

    public static void w() {
        aab = Locale.getDefault();
    }

    public static String x() {
        return aab.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aab.getCountry();
    }
}
