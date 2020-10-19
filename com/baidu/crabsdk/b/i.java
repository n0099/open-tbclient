package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes11.dex */
public final class i {
    private static Locale aoC;

    public static void A() {
        aoC = Locale.getDefault();
    }

    public static String B() {
        return aoC.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aoC.getCountry();
    }

    public static String getCountry() {
        return aoC.getCountry();
    }

    public static String getLanguage() {
        return aoC.getLanguage();
    }
}
