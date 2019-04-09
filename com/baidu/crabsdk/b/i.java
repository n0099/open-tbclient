package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale abR;

    public static String getCountry() {
        return abR.getCountry();
    }

    public static String getLanguage() {
        return abR.getLanguage();
    }

    public static void w() {
        abR = Locale.getDefault();
    }

    public static String x() {
        return abR.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + abR.getCountry();
    }
}
