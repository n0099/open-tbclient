package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class i {
    private static Locale Vs;

    public static String getCountry() {
        return Vs.getCountry();
    }

    public static String getLanguage() {
        return Vs.getLanguage();
    }

    public static void x() {
        Vs = Locale.getDefault();
    }

    public static String y() {
        return Vs.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Vs.getCountry();
    }
}
