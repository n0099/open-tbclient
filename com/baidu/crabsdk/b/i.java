package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale aks;

    public static void A() {
        aks = Locale.getDefault();
    }

    public static String B() {
        return aks.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + aks.getCountry();
    }

    public static String getCountry() {
        return aks.getCountry();
    }

    public static String getLanguage() {
        return aks.getLanguage();
    }
}
