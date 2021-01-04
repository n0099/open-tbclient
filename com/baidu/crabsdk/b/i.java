package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale apX;

    public static void A() {
        apX = Locale.getDefault();
    }

    public static String B() {
        return apX.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + apX.getCountry();
    }

    public static String getCountry() {
        return apX.getCountry();
    }

    public static String getLanguage() {
        return apX.getLanguage();
    }
}
