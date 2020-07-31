package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes12.dex */
public final class i {
    private static Locale amn;

    public static void A() {
        amn = Locale.getDefault();
    }

    public static String B() {
        return amn.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + amn.getCountry();
    }

    public static String getCountry() {
        return amn.getCountry();
    }

    public static String getLanguage() {
        return amn.getLanguage();
    }
}
