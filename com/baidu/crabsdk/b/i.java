package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale akY;

    public static void A() {
        akY = Locale.getDefault();
    }

    public static String B() {
        return akY.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + akY.getCountry();
    }

    public static String getCountry() {
        return akY.getCountry();
    }

    public static String getLanguage() {
        return akY.getLanguage();
    }
}
