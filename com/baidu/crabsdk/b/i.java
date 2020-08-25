package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes6.dex */
public final class i {
    private static Locale anp;

    public static void A() {
        anp = Locale.getDefault();
    }

    public static String B() {
        return anp.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + anp.getCountry();
    }

    public static String getCountry() {
        return anp.getCountry();
    }

    public static String getLanguage() {
        return anp.getLanguage();
    }
}
