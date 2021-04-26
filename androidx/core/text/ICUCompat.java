package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes.dex */
public final class ICUCompat {
    public static final String TAG = "ICUCompat";
    public static Method sAddLikelySubtagsMethod;
    public static Method sGetScriptMethod;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                sGetScriptMethod = cls.getMethod("getScript", String.class);
                sAddLikelySubtagsMethod = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e3) {
            sGetScriptMethod = null;
            sAddLikelySubtagsMethod = null;
            Log.w(TAG, e3);
        }
    }

    public static String addLikelySubtags(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (sAddLikelySubtagsMethod != null) {
                return (String) sAddLikelySubtagsMethod.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w(TAG, e2);
        } catch (InvocationTargetException e3) {
            Log.w(TAG, e3);
        }
        return locale2;
    }

    public static String getScript(String str) {
        try {
            if (sGetScriptMethod != null) {
                return (String) sGetScriptMethod.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w(TAG, e2);
        } catch (InvocationTargetException e3) {
            Log.w(TAG, e3);
        }
        return null;
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 >= 21) {
            try {
                return ((Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e2) {
                Log.w(TAG, e2);
                return locale.getScript();
            } catch (InvocationTargetException e3) {
                Log.w(TAG, e3);
                return locale.getScript();
            }
        }
        String addLikelySubtags = addLikelySubtags(locale);
        if (addLikelySubtags != null) {
            return getScript(addLikelySubtags);
        }
        return null;
    }
}
