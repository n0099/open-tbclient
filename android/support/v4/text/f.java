package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class f {
    private static Method ms;
    private static Method mt;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                ms = cls.getMethod("getScript", String.class);
                mt = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e) {
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String getScript(String str) {
        try {
            if (ms != null) {
                return (String) ms.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String addLikelySubtags(String str) {
        try {
            if (mt != null) {
                return (String) mt.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return str;
    }
}
