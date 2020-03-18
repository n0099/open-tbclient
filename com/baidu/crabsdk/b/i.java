package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes8.dex */
public final class i {
    private static Locale RT;

    public static void A() {
        RT = Locale.getDefault();
    }

    public static String B() {
        return RT.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + RT.getCountry();
    }

    public static String getCountry() {
        return RT.getCountry();
    }

    public static String getLanguage() {
        return RT.getLanguage();
    }
}
