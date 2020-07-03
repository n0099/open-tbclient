package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale ams;

    public static void A() {
        ams = Locale.getDefault();
    }

    public static String B() {
        return ams.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ams.getCountry();
    }

    public static String getCountry() {
        return ams.getCountry();
    }

    public static String getLanguage() {
        return ams.getLanguage();
    }
}
