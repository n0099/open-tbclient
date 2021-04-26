package com.baidu.pass.common;

import com.baidu.tbadk.core.util.FieldBuilder;
/* loaded from: classes2.dex */
public class Log implements com.baidu.pass.a {
    public static final String TAG = "PASSPORT";
    public static boolean enabled = false;

    public static String a(String str, Object[] objArr) {
        if (objArr != null) {
            try {
                if (objArr.length == 0) {
                    return "";
                }
                StringBuffer stringBuffer = new StringBuffer();
                int length = objArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Object obj = objArr[i2];
                    if (obj != null) {
                        if (i2 != 0) {
                            stringBuffer.append(FieldBuilder.SE);
                        }
                        try {
                            if (obj instanceof Throwable) {
                                stringBuffer.append(android.util.Log.getStackTraceString((Throwable) obj));
                            } else {
                                stringBuffer.append(obj.toString());
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                return stringBuffer.toString();
            } catch (Throwable th) {
                android.util.Log.e(str, "converArrayToString t: " + th.toString());
                return "converArrayToString null";
            }
        }
        return "";
    }

    public static void d(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.d(str, a(str, objArr));
        }
    }

    public static void e(Throwable th) {
        e(TAG, th);
    }

    public static void enable(boolean z) {
        enabled = z;
    }

    public static void i(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.i(str, a(str, objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.w(str, a(str, objArr));
        }
    }

    public static void e(String str, Throwable th) {
        e(str, th);
    }

    public static void d(Object... objArr) {
        d(TAG, objArr);
    }

    public static void e(String str, Object... objArr) {
        if (enabled) {
            android.util.Log.e(str, a(str, objArr));
        }
    }

    public static void i(Object... objArr) {
        i(TAG, objArr);
    }

    public static void w(Object... objArr) {
        w(TAG, objArr);
    }
}
