package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class i {
    private static Locale SS;

    public static String getCountry() {
        return SS.getCountry();
    }

    public static String getLanguage() {
        return SS.getLanguage();
    }

    public static void x() {
        SS = Locale.getDefault();
    }

    public static String y() {
        return SS.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + SS.getCountry();
    }
}
