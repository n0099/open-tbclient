package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale apB;

    public static void A() {
        apB = Locale.getDefault();
    }

    public static String B() {
        return apB.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apB.getCountry();
    }

    public static String getCountry() {
        return apB.getCountry();
    }

    public static String getLanguage() {
        return apB.getLanguage();
    }
}
