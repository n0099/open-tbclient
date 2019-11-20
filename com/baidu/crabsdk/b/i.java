package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale JE;

    public static String getCountry() {
        return JE.getCountry();
    }

    public static String getLanguage() {
        return JE.getLanguage();
    }

    public static void w() {
        JE = Locale.getDefault();
    }

    public static String x() {
        return JE.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + JE.getCountry();
    }
}
