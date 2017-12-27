package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes2.dex */
class b {
    private static Method Bf;
    private static Method Bg;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                Bg = cls.getMethod("getScript", String.class);
                Bf = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e) {
            Bg = null;
            Bf = null;
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
            if (Bg != null) {
                return (String) Bg.invoke(null, str);
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
            if (Bf != null) {
                return (String) Bf.invoke(null, locale2);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
