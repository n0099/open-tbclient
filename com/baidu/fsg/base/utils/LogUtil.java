package com.baidu.fsg.base.utils;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.fsg.base.ApollonConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes16.dex */
public final class LogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1514a = "apollon_rest";
    public static final boolean DEBUG = ApollonConstants.DEBUG;
    private static final boolean b = ApollonConstants.DEBUG;
    private static final boolean c = ApollonConstants.DEBUG;
    private static final boolean d = ApollonConstants.DEBUG;
    private static final boolean e = ApollonConstants.DEBUG;
    private static final boolean f = ApollonConstants.DEBUG;

    private LogUtil() {
    }

    public static void v(String str, String str2) {
        if (b) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.v("apollon_rest", str2);
            } else {
                Log.v("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (c) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.d("apollon_rest", str2);
            } else {
                Log.d("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
            }
        }
    }

    public static void d(String str) {
        if (d) {
            Log.d("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void i(String str, String str2) {
        if (d) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.i("apollon_rest", str2);
            } else {
                Log.i("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
            }
        }
    }

    public static void i(String str) {
        if (d) {
            Log.i("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void w(String str, String str2) {
        if (e) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.w("apollon_rest", str2);
            } else {
                Log.w("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
            }
        }
    }

    public static void w(String str) {
        if (e) {
            Log.w("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void e(String str) {
        if (f) {
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void e(String str, String str2) {
        if (f) {
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.e("apollon_rest", str2, th);
            } else {
                Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
            }
        }
    }

    public static void logd(String str) {
        if (ApollonConstants.DEBUG) {
            Log.i("apollon_rest", getTAG() + "---" + str + "#pid=" + Process.myPid());
        }
    }

    public static void logd(String str, String str2) {
        if (ApollonConstants.DEBUG) {
            Log.i(str, getTAG() + "---" + str2);
        }
    }

    public static void errord(String str) {
        if (ApollonConstants.DEBUG) {
            Log.e("apollon_rest", getTAG() + "---" + str);
        }
    }

    public static void errord(String str, String str2) {
        if (ApollonConstants.DEBUG) {
            Log.e(str, getTAG() + "---" + str2);
        }
    }

    public static void mark() {
        if (ApollonConstants.DEBUG) {
            Log.w("apollon_rest", getTAG());
        }
    }

    public static void mark(String str) {
        if (ApollonConstants.DEBUG) {
            Log.w("apollon_rest", getTAG() + "---" + str);
        }
    }

    public static void traces() {
        if (ApollonConstants.DEBUG) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[3];
                sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "#line=" + stackTraceElement.getLineNumber() + "的调用：\n");
                for (int i = 4; i < stackTrace.length && i < 15; i++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    sb.append((i - 4) + "--" + stackTraceElement2.getClassName() + "." + stackTraceElement2.getMethodName() + "(...)#line:" + stackTraceElement2.getLineNumber() + "\n");
                }
            }
            Log.w("apollon_rest", getTAG() + "--" + sb.toString());
        }
    }

    public static String getTAG() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[4];
                sb.append(((Object) stackTraceElement.getFileName().subSequence(0, stackTraceElement.getFileName().length() - 5)) + "." + stackTraceElement.getMethodName() + "#" + stackTraceElement.getLineNumber());
            }
            return sb.toString();
        } catch (NullPointerException e2) {
            return "PROGUARDED";
        }
    }

    public static void saveLog(String str) {
        if (c) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS    ", Locale.ENGLISH).format(new Date()) + str + "\n";
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(String.valueOf(Environment.getExternalStorageDirectory()) + "/wallet.log"), true);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static StackTraceElement a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            boolean equals = stackTraceElement.getClassName().equals(LogUtil.class.getName());
            if (!z || equals) {
                i++;
                z = equals;
            } else {
                return stackTraceElement;
            }
        }
        return null;
    }
}
