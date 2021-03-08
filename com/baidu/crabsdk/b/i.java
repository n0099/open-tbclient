package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class i {
    private static Locale aqz;

    public static void A() {
        aqz = Locale.getDefault();
    }

    public static String B() {
        return aqz.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aqz.getCountry();
    }

    public static String getCountry() {
        return aqz.getCountry();
    }

    public static String getLanguage() {
        return aqz.getLanguage();
    }
}
