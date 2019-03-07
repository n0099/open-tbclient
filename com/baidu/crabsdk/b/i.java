package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale abP;

    public static String getCountry() {
        return abP.getCountry();
    }

    public static String getLanguage() {
        return abP.getLanguage();
    }

    public static void x() {
        abP = Locale.getDefault();
    }

    public static String y() {
        return abP.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + abP.getCountry();
    }
}
