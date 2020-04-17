package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale akm;

    public static void A() {
        akm = Locale.getDefault();
    }

    public static String B() {
        return akm.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + akm.getCountry();
    }

    public static String getCountry() {
        return akm.getCountry();
    }

    public static String getLanguage() {
        return akm.getLanguage();
    }
}
