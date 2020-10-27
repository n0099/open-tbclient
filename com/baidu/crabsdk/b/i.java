package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class i {
    private static Locale aoD;

    public static void A() {
        aoD = Locale.getDefault();
    }

    public static String B() {
        return aoD.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoD.getCountry();
    }

    public static String getCountry() {
        return aoD.getCountry();
    }

    public static String getLanguage() {
        return aoD.getLanguage();
    }
}
