package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes2.dex */
class b {
    private static Method Be;
    private static Method Bf;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                Bf = cls.getMethod("getScript", String.class);
                Be = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e) {
            Bf = null;
            Be = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String maximizeAndGetScript(Locale locale) {
        String c = c(locale);
        if (c != null) {
            return getScript(c);
        }
        return null;
    }

    private static String getScript(String str) {
        try {
            if (Bf != null) {
                return (String) Bf.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String c(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (Be != null) {
                return (String) Be.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
