package com.baidu.pass.biometrics.base.debug;
/* loaded from: classes6.dex */
public final class Log {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3943a = "SAPI_BIOMETRIC";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3944b;

    private Log() {
    }

    private static String a(String str, Object[] objArr) {
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = objArr.length;
                    for (int i = 0; i < length; i++) {
                        Object obj = objArr[i];
                        if (obj != null) {
                            if (i != 0) {
                                stringBuffer.append("|");
                            }
                            try {
                                if (obj instanceof Throwable) {
                                    stringBuffer.append(android.util.Log.getStackTraceString((Throwable) obj));
                                } else {
                                    stringBuffer.append(obj.toString());
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                    return stringBuffer.toString();
                }
            } catch (Throwable th) {
                android.util.Log.e(str, "converArrayToString t: " + th.toString());
                return "converArrayToString null";
            }
        }
        return "";
    }

    public static void d(String str, Object... objArr) {
        if (!f3944b) {
            return;
        }
        android.util.Log.d(str, a(str, objArr));
    }

    public static void e(Throwable th) {
        e(f3943a, th);
    }

    public static void enable(boolean z) {
        f3944b = z;
    }

    public static void i(String str, Object... objArr) {
        if (!f3944b) {
            return;
        }
        android.util.Log.i(str, a(str, objArr));
    }

    public static void w(String str, Object... objArr) {
        if (!f3944b) {
            return;
        }
        android.util.Log.w(str, a(str, objArr));
    }

    public static void e(String str, Throwable th) {
        e(str, th);
    }

    public static void d(Object... objArr) {
        d(f3943a, objArr);
    }

    public static void e(String str, Object... objArr) {
        if (!f3944b) {
            return;
        }
        android.util.Log.e(str, a(str, objArr));
    }

    public static void i(Object... objArr) {
        i(f3943a, objArr);
    }

    public static void w(Object... objArr) {
        w(f3943a, objArr);
    }
}
