package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class i {
    private static Locale Ye;

    public static String getCountry() {
        return Ye.getCountry();
    }

    public static String getLanguage() {
        return Ye.getLanguage();
    }

    public static void x() {
        Ye = Locale.getDefault();
    }

    public static String y() {
        return Ye.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Ye.getCountry();
    }
}
