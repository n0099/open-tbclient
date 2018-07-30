package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class i {
    private static Locale SO;

    public static String getCountry() {
        return SO.getCountry();
    }

    public static String getLanguage() {
        return SO.getLanguage();
    }

    public static void x() {
        SO = Locale.getDefault();
    }

    public static String y() {
        return SO.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + SO.getCountry();
    }
}
