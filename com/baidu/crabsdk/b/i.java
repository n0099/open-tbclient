package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale ZG;

    public static String getCountry() {
        return ZG.getCountry();
    }

    public static String getLanguage() {
        return ZG.getLanguage();
    }

    public static void w() {
        ZG = Locale.getDefault();
    }

    public static String x() {
        return ZG.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ZG.getCountry();
    }
}
