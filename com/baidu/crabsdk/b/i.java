package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes7.dex */
public final class i {
    private static Locale aoJ;

    public static void A() {
        aoJ = Locale.getDefault();
    }

    public static String B() {
        return aoJ.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoJ.getCountry();
    }

    public static String getCountry() {
        return aoJ.getCountry();
    }

    public static String getLanguage() {
        return aoJ.getLanguage();
    }
}
