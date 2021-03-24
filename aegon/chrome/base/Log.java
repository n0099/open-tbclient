package aegon.chrome.base;

import java.util.Locale;
/* loaded from: classes.dex */
public class Log {
    public static void e(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        String normalizeTag = normalizeTag(str);
        if (throwableToLog != null) {
            android.util.Log.e(normalizeTag, formatLog, throwableToLog);
        } else {
            android.util.Log.e(normalizeTag, formatLog);
        }
    }

    public static String formatLog(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    public static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        return null;
    }

    public static void i(String str, String str2, Object... objArr) {
        String formatLog = formatLog(str2, objArr);
        Throwable throwableToLog = getThrowableToLog(objArr);
        String normalizeTag = normalizeTag(str);
        if (throwableToLog != null) {
            android.util.Log.i(normalizeTag, formatLog, throwableToLog);
        } else {
            android.util.Log.i(normalizeTag, formatLog);
        }
    }

    public static String normalizeTag(String str) {
        if (str.startsWith("cr_")) {
            return str;
        }
        int i = str.startsWith("cr.") ? 3 : 0;
        return "cr_" + str.substring(i, str.length());
    }
}
