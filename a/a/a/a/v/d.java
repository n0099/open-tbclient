package a.a.a.a.v;

import android.util.Log;
import com.fun.ad.sdk.FunAdSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f1361a = Pattern.compile("(\\$\\d+)+$");

    public static void a() {
        a(null, 3, null, new Object[0]);
    }

    public static void a(String str, Object... objArr) {
        a(null, 3, str, objArr);
    }

    public static void a(Throwable th) {
        a(th, 6, "", new Object[0]);
    }

    public static void a(Throwable th, int i, String str, Object... objArr) {
        if (FunAdSdk.isLogEnabled()) {
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                StackTraceElement stackTraceElement = stackTrace[2];
                if (str == null) {
                    str = stackTraceElement.getMethodName();
                } else if (objArr != null && objArr.length != 0) {
                    str = String.format(str, objArr);
                }
                String className = stackTrace[2].getClassName();
                Matcher matcher = f1361a.matcher(className);
                String str2 = "";
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = className.substring(className.lastIndexOf(46) + 1);
                objArr2[1] = str;
                if (th != null) {
                    str2 = "\n" + Log.getStackTraceString(th);
                }
                objArr2[2] = str2;
                Log.println(i, "FunAdSdk", String.format("[%s] %s%s", objArr2));
            } catch (Exception e2) {
                a(e2);
            }
        }
    }

    public static void b() {
        a(null, 6, null, new Object[0]);
    }

    public static void b(String str, Object... objArr) {
        a(null, 6, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        a(null, 2, str, objArr);
    }
}
