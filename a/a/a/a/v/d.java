package a.a.a.a.v;

import android.util.Log;
import com.fun.ad.sdk.FunAdSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f1007a = Pattern.compile("(\\$\\d+)+$");

    public static void a() {
        a(null, 3, null, new Object[0]);
    }

    public static void a(String str, Object... objArr) {
        a(null, 3, str, objArr);
    }

    public static void a(Throwable th) {
        a(th, 6, "", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: Exception -> 0x0081, TryCatch #0 {Exception -> 0x0081, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0019, B:10:0x002c, B:11:0x0033, B:13:0x0046, B:17:0x0054, B:23:0x0068, B:20:0x0060, B:22:0x0063), top: B:27:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: Exception -> 0x0081, TRY_LEAVE, TryCatch #0 {Exception -> 0x0081, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0019, B:10:0x002c, B:11:0x0033, B:13:0x0046, B:17:0x0054, B:23:0x0068, B:20:0x0060, B:22:0x0063), top: B:27:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Throwable th, int i, String str, Object... objArr) {
        String format;
        Matcher matcher;
        if (FunAdSdk.isLogEnabled()) {
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                StackTraceElement stackTraceElement = stackTrace[2];
                if (str != null) {
                    if (objArr != null && objArr.length != 0) {
                        format = String.format(str, objArr);
                    }
                    String className = stackTrace[2].getClassName();
                    matcher = f1007a.matcher(className);
                    if (matcher.find()) {
                        className = matcher.replaceAll("");
                    }
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = className.substring(className.lastIndexOf(46) + 1);
                    objArr2[1] = str;
                    objArr2[2] = th != null ? "" : "\n" + Log.getStackTraceString(th);
                    Log.println(i, "FunAdSdk", String.format("[%s] %s%s", objArr2));
                }
                format = stackTraceElement.getMethodName();
                str = format;
                String className2 = stackTrace[2].getClassName();
                matcher = f1007a.matcher(className2);
                if (matcher.find()) {
                }
                Object[] objArr22 = new Object[3];
                objArr22[0] = className2.substring(className2.lastIndexOf(46) + 1);
                objArr22[1] = str;
                objArr22[2] = th != null ? "" : "\n" + Log.getStackTraceString(th);
                Log.println(i, "FunAdSdk", String.format("[%s] %s%s", objArr22));
            } catch (Exception e) {
                a(e);
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
