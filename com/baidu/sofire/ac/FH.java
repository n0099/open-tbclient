package com.baidu.sofire.ac;

import android.content.Context;
import android.util.Pair;
import com.baidu.sofire.a.a;
import com.baidu.sofire.b.e;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.c;
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
        Pair<Integer, Object> a;
        try {
            c a2 = c.a();
            if (a2 == null) {
                a = new Pair<>(3, null);
            } else {
                a = a2.a(i, str, clsArr, objArr);
            }
            return a;
        } catch (Throwable th) {
            e.a(th);
            return new Pair<>(3, null);
        }
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

    public static Object getPInfo(int i, int i2) {
        switch (i2) {
            case 1:
                if (i <= 0) {
                    return "";
                }
                try {
                    com.baidu.sofire.core.e a = com.baidu.sofire.core.e.a();
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
                    e.a(th);
                    return "";
                }
            default:
                return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.1.3.2";
    }

    public static String gzfi(Context context, String str, int i) {
        if (i != 0) {
            call(1, "ice", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i));
        }
        return e.m(context);
    }

    public static String gz(Context context) {
        return e.m(context);
    }

    public static boolean isInitSuc(int i) {
        ApkInfo a;
        com.baidu.sofire.core.e a2;
        try {
            a aVar = a.d;
            if (aVar == null || (a = aVar.a(i)) == null || a.initStatus != 1 || (a2 = com.baidu.sofire.core.e.a()) == null) {
                return false;
            }
            return a2.d(a.packageName) != null;
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }
}
