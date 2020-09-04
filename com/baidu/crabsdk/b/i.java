package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class i {
    private static Locale anr;

    public static void A() {
        anr = Locale.getDefault();
    }

    public static String B() {
        return anr.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + anr.getCountry();
    }

    public static String getCountry() {
        return anr.getCountry();
    }

    public static String getLanguage() {
        return anr.getLanguage();
    }
}
