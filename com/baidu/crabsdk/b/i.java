package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale ZH;

    public static String getCountry() {
        return ZH.getCountry();
    }

    public static String getLanguage() {
        return ZH.getLanguage();
    }

    public static void w() {
        ZH = Locale.getDefault();
    }

    public static String x() {
        return ZH.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + ZH.getCountry();
    }
}
