package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class i {
    private static Locale SQ;

    public static String getCountry() {
        return SQ.getCountry();
    }

    public static String getLanguage() {
        return SQ.getLanguage();
    }

    public static void x() {
        SQ = Locale.getDefault();
    }

    public static String y() {
        return SQ.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + SQ.getCountry();
    }
}
