package com.baidu.browser.core.util;

import android.os.Environment;
import android.util.Log;
import com.baidu.android.util.io.PathUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes.dex */
public final class BdLog {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4286a = true;

    /* renamed from: b  reason: collision with root package name */
    public static FileOutputStream f4287b = null;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f4288c = false;

    /* renamed from: d  reason: collision with root package name */
    public static String f4289d = Environment.getExternalStorageDirectory() + File.separator + PathUtils.DIRCTORY_BAIDU + File.separator + "flyflow" + File.separator + TbConfig.TMP_LOG_DIR_NAME + File.separator;

    /* renamed from: e  reason: collision with root package name */
    public static String f4290e;

    /* loaded from: classes.dex */
    public enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4291a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            f4291a = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4291a[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4291a[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4291a[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4291a[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f4289d);
        sb.append("baiduliulanqi_log.txt");
        f4290e = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f4289d);
        sb2.append("baiduliulanqi_lasttime_log.txt");
        sb2.toString();
    }

    public static void a(String str, String str2) {
    }

    public static void b(LogLevel logLevel, String str, String str2, Throwable th) {
        if (str2 == null) {
            str2 = "";
        }
        int i2 = a.f4291a[logLevel.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            if (th == null) {
                                Log.w(str, str2);
                            } else {
                                Log.w(str, str2, th);
                            }
                        }
                    } else if (th == null) {
                        Log.v(str, str2);
                    } else {
                        Log.v(str, str2, th);
                    }
                } else if (th == null) {
                    Log.i(str, str2);
                } else {
                    Log.i(str, str2, th);
                }
            } else if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        } else if (th == null) {
            Log.d(str, str2);
        } else {
            Log.d(str, str2, th);
        }
        if (f4288c) {
            d(str, str2);
        }
    }

    public static void c(String str, Throwable th) {
        b(LogLevel.ERROR, "FlyFlow", str, th);
    }

    public static void d(String str, String str2) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                File file = new File(f4289d);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (f4287b == null) {
                    f4287b = new FileOutputStream(f4290e);
                }
                f4287b.write((str + ZeusCrashHandler.NAME_SEPERATOR + str2).getBytes("UTF-8"));
                f4287b.write("\n".getBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean e() {
        return f4286a;
    }

    public static void f(boolean z) {
        f4286a = z;
    }
}
