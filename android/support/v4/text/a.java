package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
class a {
    private static Method ke;
    private static Method kf;

    static {
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                ke = cls.getMethod("getScript", String.class);
                kf = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e) {
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String getScript(String str) {
        try {
            if (ke != null) {
                return (String) ke.invoke(null, str);
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
            if (kf != null) {
                return (String) kf.invoke(null, str);
            }
        } catch (IllegalAccessException e) {
            Log.w("ICUCompatIcs", e);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return str;
    }
}
