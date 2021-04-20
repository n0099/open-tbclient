package com.baidu.mobads.sdk.internal;

import android.util.Log;
/* loaded from: classes2.dex */
public class XAdLogger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final String TAG = "logger";
    public static final int UNLOGGABLE = -1;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static volatile XAdLogger mLogger;

    public static XAdLogger getInstance() {
        if (mLogger == null) {
            synchronized (XAdLogger.class) {
                if (mLogger == null) {
                    mLogger = new XAdLogger();
                }
            }
        }
        return mLogger;
    }

    private String join(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(' ');
        }
        return sb.toString();
    }

    public int d(Object... objArr) {
        if (isLoggable(3)) {
            return d(join(objArr));
        }
        return -1;
    }

    public int e(Object... objArr) {
        if (isLoggable(6)) {
            return e(join(objArr));
        }
        return -1;
    }

    public int i(String str) {
        return i(TAG, str);
    }

    public boolean isLoggable(String str, int i) {
        return i >= XAdSDKPorxyConfig.LOG_LEVEL;
    }

    public int w(String str) {
        if (isLoggable(5)) {
            try {
                return Log.w(TAG, str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int i(String str, String str2) {
        if (isLoggable(4)) {
            try {
                return Log.i(str, str2);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public boolean isLoggable(int i) {
        return isLoggable(TAG, i);
    }

    public int d(String str) {
        return d(TAG, str);
    }

    public int e(String str) {
        if (isLoggable(6)) {
            try {
                return Log.e(TAG, str);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int w(Object... objArr) {
        if (isLoggable(5)) {
            return w(join(objArr));
        }
        return -1;
    }

    public int d(String str, String str2) {
        if (isLoggable(3)) {
            try {
                return Log.d(str, str2);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int i(Object... objArr) {
        if (isLoggable(4)) {
            return i(join(objArr));
        }
        return -1;
    }

    public int e(Throwable th) {
        return e("", th);
    }

    public int w(String str, Throwable th) {
        if (isLoggable(5)) {
            try {
                return Log.w(TAG, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int d(Throwable th) {
        return d("", th);
    }

    public int e(String str, Throwable th) {
        if (isLoggable(6)) {
            try {
                return Log.e(TAG, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int i(String str, Throwable th) {
        if (isLoggable(4)) {
            try {
                return Log.i(TAG, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int d(String str, Throwable th) {
        if (isLoggable(3)) {
            try {
                return Log.d(TAG, str, th);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public int w(Throwable th) {
        return w("", th);
    }
}
