package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes5.dex */
public final class i {
    private static Locale aoY;

    public static void A() {
        aoY = Locale.getDefault();
    }

    public static String B() {
        return aoY.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoY.getCountry();
    }

    public static String getCountry() {
        return aoY.getCountry();
    }

    public static String getLanguage() {
        return aoY.getLanguage();
    }
}
