package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale anT;

    public static void A() {
        anT = Locale.getDefault();
    }

    public static String B() {
        return anT.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + anT.getCountry();
    }

    public static String getCountry() {
        return anT.getCountry();
    }

    public static String getLanguage() {
        return anT.getLanguage();
    }
}
