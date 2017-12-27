package android.support.v4.text;

import android.text.TextUtils;
import java.util.Locale;
/* loaded from: classes2.dex */
class c {
    public static String htmlEncode(String str) {
        return TextUtils.htmlEncode(str);
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
