package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes14.dex */
public final class i {
    private static Locale api;

    public static void A() {
        api = Locale.getDefault();
    }

    public static String B() {
        return api.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + api.getCountry();
    }

    public static String getCountry() {
        return api.getCountry();
    }

    public static String getLanguage() {
        return api.getLanguage();
    }
}
