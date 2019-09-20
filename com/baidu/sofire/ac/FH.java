package com.baidu.sofire.ac;

import android.content.Context;
import android.util.Pair;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.core.e;
import com.baidu.sofire.core.g;
import java.util.List;
/* loaded from: classes2.dex */
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
        return com.baidu.sofire.b.e.a(i);
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
                    com.baidu.sofire.b.e.a();
                    return "";
                }
            default:
                return "";
        }
    }

    public static String getVersion(Context context) {
        return "3.3.9";
    }

    public static String gzfi(Context context, String str, int i, String str2) {
        return e.a(context, str, i, str2);
    }

    public static String gzfi(Context context, String str, int i) {
        return e.a(context, str, i, (String) null);
    }

    public static String gz(Context context) {
        return e.b(context);
    }

    public static String gd(Context context) {
        return e.a(context);
    }

    public static String gt(Context context, String str, String str2, int i, String str3) {
        return e.a(context, str, str2, i, str3);
    }

    public static String xgz(Context context, String str) {
        return e.a(context, str);
    }

    public static void bc(Context context, boolean z) {
        e.a(context, z);
    }
}
