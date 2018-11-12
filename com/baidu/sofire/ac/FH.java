package com.baidu.sofire.ac;

import android.content.Context;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.g;
import java.util.List;
/* loaded from: classes.dex */
public class FH {
    public static final int TYPE_VERSION = 1;

    private FH() {
    }

    public static void init(Context context, String str, String str2, int... iArr) {
        e.a(context, 0, str, str2, iArr);
    }

    public static void initDelay(Context context, int i, String str, String str2, int... iArr) {
        e.a(context, i, str, str2, iArr);
    }

    public static boolean call(int i, String str) {
        return call(i, str, null);
    }

    public static Pair<Integer, Object> callSync(int i, String str) {
        return callSync(i, str, null, new Object[0]);
    }

    public static Pair<Integer, Object> callSync(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return e.a(i, str, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback) {
        return call(i, str, callback, null, new Object[0]);
    }

    public static boolean call(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return call(i, str, null, clsArr, objArr);
    }

    public static boolean call(int i, String str, Callback callback, Class<?>[] clsArr, Object... objArr) {
        return e.a(i, str, callback, clsArr, objArr);
    }

    public static boolean isInitSuc(int i) {
        ApkInfo a;
        g a2;
        try {
            a a3 = a.a();
            if (a3 == null || (a = a3.a(i)) == null || a.initStatus != 1 || (a2 = g.a()) == null) {
                return false;
            }
            return a2.d(a.packageName) != null;
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
            return false;
        }
    }

    public static Object getPInfo(int i, int i2) {
        switch (i2) {
            case 1:
                if (i <= 0) {
                    return "";
                }
                try {
                    g a = g.a();
                    if (a == null) {
                        return "";
                    }
                    List<ApkInfo> b = a.b();
                    if (b == null || b.size() <= 0) {
                        return "";
                    }
                    for (ApkInfo apkInfo : b) {
                        if (apkInfo.key == i) {
                            if (apkInfo.versionName == null) {
                                return "";
                            }
                            return apkInfo.versionName;
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                    return "";
                }
            default:
                return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.1.8";
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        return e.a(context, str, i, str2);
    }

    public static String gzfi(Context context, String str, int i) {
        return e.a(context, str, i, (String) null);
    }

    public static String gz(Context context) {
        return e.a(context);
    }
}
