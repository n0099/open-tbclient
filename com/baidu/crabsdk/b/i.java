package com.baidu.crabsdk.b;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class i {
    private static Locale abQ;

    public static String getCountry() {
        return abQ.getCountry();
    }

    public static String getLanguage() {
        return abQ.getLanguage();
    }

    public static void x() {
        abQ = Locale.getDefault();
    }

    public static String y() {
        return abQ.getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + abQ.getCountry();
    }
}
