package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class i {
    private static Locale Yn;

    public static String getCountry() {
        return Yn.getCountry();
    }

    public static String getLanguage() {
        return Yn.getLanguage();
    }

    public static void x() {
        Yn = Locale.getDefault();
    }

    public static String y() {
        return Yn.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Yn.getCountry();
    }
}
