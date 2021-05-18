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
/* loaded from: classes2.dex */
public final class LogUtil {
    public static final boolean DEBUG;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5399a = "apollon_rest";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f5400b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f5401c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5402d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5403e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f5404f;

    static {
        boolean z = ApollonConstants.DEBUG;
        DEBUG = z;
        f5400b = z;
        f5401c = z;
        f5402d = z;
        f5403e = z;
        f5404f = z;
    }

    public static StackTraceElement a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            boolean equals = stackTraceElement.getClassName().equals(LogUtil.class.getName());
            if (z && !equals) {
                return stackTraceElement;
            }
            i2++;
            z = equals;
        }
        return null;
    }

    public static void d(String str, String str2) {
        if (f5401c) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.d("apollon_rest", str2);
                return;
            }
            Log.d("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }

    public static void e(String str) {
        if (f5404f) {
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void errord(String str) {
        if (ApollonConstants.DEBUG) {
            Log.e("apollon_rest", getTAG() + "---" + str);
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
        } catch (NullPointerException unused) {
            return "PROGUARDED";
        }
    }

    public static void i(String str, String str2) {
        if (f5402d) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.i("apollon_rest", str2);
                return;
            }
            Log.i("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }

    public static void logd(String str) {
        if (ApollonConstants.DEBUG) {
            Log.i("apollon_rest", getTAG() + "---" + str + "#pid=" + Process.myPid());
        }
    }

    public static void mark() {
        if (ApollonConstants.DEBUG) {
            Log.w("apollon_rest", getTAG());
        }
    }

    public static void saveLog(String str) {
        if (f5401c) {
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

    public static void traces() {
        if (ApollonConstants.DEBUG) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[3];
                sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "#line=" + stackTraceElement.getLineNumber() + "的调用：\n");
                for (int i2 = 4; i2 < stackTrace.length && i2 < 15; i2++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2 - 4);
                    sb2.append("--");
                    sb2.append(stackTraceElement2.getClassName());
                    sb2.append(".");
                    sb2.append(stackTraceElement2.getMethodName());
                    sb2.append("(...)#line:");
                    sb2.append(stackTraceElement2.getLineNumber());
                    sb2.append("\n");
                    sb.append(sb2.toString());
                }
            }
            Log.w("apollon_rest", getTAG() + "--" + sb.toString());
        }
    }

    public static void v(String str, String str2) {
        if (f5400b) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.v("apollon_rest", str2);
                return;
            }
            Log.v("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (f5403e) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.w("apollon_rest", str2);
                return;
            }
            Log.w("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }

    public static void errord(String str, String str2) {
        if (ApollonConstants.DEBUG) {
            Log.e(str, getTAG() + "---" + str2);
        }
    }

    public static void logd(String str, String str2) {
        if (ApollonConstants.DEBUG) {
            Log.i(str, getTAG() + "---" + str2);
        }
    }

    public static void mark(String str) {
        if (ApollonConstants.DEBUG) {
            Log.w("apollon_rest", getTAG() + "---" + str);
        }
    }

    public static void e(String str, String str2) {
        if (f5404f) {
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }

    public static void d(String str) {
        if (f5402d) {
            Log.d("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void i(String str) {
        if (f5402d) {
            Log.i("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void w(String str) {
        if (f5403e) {
            Log.w("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]", str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f5404f) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                Log.e("apollon_rest", str2, th);
                return;
            }
            Log.e("(" + a().getFileName() + ":" + a().getLineNumber() + ")[" + a().getMethodName() + "]" + str, str2);
        }
    }
}
