package com.baidu.crashpad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import java.io.File;
/* loaded from: classes11.dex */
public class ZwCrashpad {
    private static boolean t;
    private static boolean u;
    private static boolean v;
    private static boolean w;
    private static String a = "0";
    private static String b = "0";
    private static String c = "";
    private static String d = "0";
    private static String e = "";
    private static String f = "0";
    private static String g = "0";
    private static int h = -1;
    private static String i = "0";
    private static String j = "0";
    private static String k = "0";
    private static String l = "0";
    private static String m = "0";
    private static String n = "0";
    private static String o = "0";
    private static String p = "-1";
    private static String q = "true";
    private static String r = "0";
    private static String s = "0";
    private static final Object x = new Object();
    private static boolean y = true;

    public static synchronized void RecordUrl(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && u) {
                nativeRecordUrl(str);
            }
        }
    }

    private static String[] a() {
        try {
            return new String[]{f, g, Integer.toString(h), i, j, n, k, Build.MODEL.replace(' ', '_').replace('-', '_'), Build.VERSION.RELEASE, d, b, e, a, c, " ", " ", l, m, Build.DISPLAY, o, p, q, r, String.valueOf(Build.VERSION.SDK_INT), Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128))};
        } catch (Exception e2) {
            Log.e("ZwCrashpad CRASHPAD", "newInfos error maybe BUILD get errors");
            com.a.a.a.a.a.a.a.a(e2);
            return new String[0];
        }
    }

    public static void clearCrashKey(String str) {
        if (y && u && str != null) {
            nativeClearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i2) {
        if (i2 == 1) {
            if (u) {
                nativeCrashIntentionally(i2);
            }
        } else if (i2 == 2) {
            setCrashKeyValue("JavaExceptionInfo", "only for test add JavaExceptionInfo for JNI crash");
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static void doInit(Context context, String[] strArr) {
        String str;
        boolean z;
        boolean z2 = true;
        if (!y || context == null || t) {
            return;
        }
        s = strArr[10];
        try {
            if (s == null || s.isEmpty() || s.equals("0")) {
                str = context.getFilesDir().getAbsolutePath() + "/zeus/libs/libcrashpad_client.so";
                if (new File(str).exists()) {
                    z = true;
                }
                str = null;
                z = false;
            } else {
                str = s + "/libcrashpad_client.so";
                if (new File(str).exists()) {
                    z = true;
                }
                str = null;
                z = false;
            }
            if (!z || str == null || str.equals("0")) {
                System.loadLibrary("crashpad_client");
                u = true;
                Log.i("ZwCrashpad CRASHPAD", "loadlibrary crashpad_client sucess");
            } else {
                System.load(str);
                u = true;
                Log.i("ZwCrashpad CRASHPAD", "load crashpad_client from custom path sucess");
            }
        } catch (Throwable th) {
            Log.e("ZwCrashpad CRASHPAD", "failed to load crashpad_client library ");
        }
        ZwDebugExtra.init(context);
        j = strArr[0];
        w = true;
        d = strArr[1];
        b = strArr[2];
        a = strArr[3];
        c = strArr[4];
        l = strArr[5];
        if (strArr[6] != null && !strArr[6].isEmpty() && !TextUtils.equals(strArr[6], "-1")) {
            o = strArr[6];
        }
        q = strArr[7];
        i = strArr[9];
        r = strArr[11];
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            g = packageInfo.versionName;
            h = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            com.a.a.a.a.a.a.a.a(e2);
        }
        try {
            f = context.getPackageName();
        } catch (Exception e3) {
            com.a.a.a.a.a.a.a.a(e3);
        }
        n = context.getFilesDir().getAbsolutePath() + "/zeuslogs/";
        File file = new File(n);
        if (file.exists() || file.mkdirs()) {
            synchronized (ZwCrashpad.class) {
                v = true;
            }
        } else {
            n = context.getFilesDir().getAbsolutePath();
        }
        String radioVersion = Build.getRadioVersion();
        m = radioVersion;
        if (radioVersion == null) {
            m = "no message";
        }
        String[] a2 = a();
        synchronized (ZwCrashpad.class) {
            if (u) {
                nativeInit(a2);
                t = true;
            }
        }
        setCrashKeyValue("USER", Build.USER);
        b.a(strArr[8]);
        if (strArr[7] != null && !Boolean.valueOf(strArr[7]).booleanValue()) {
            z2 = false;
        }
        b.b(z2);
        b.b(getEncryptKey());
        b.a(context.getFilesDir().getAbsolutePath() + "/zeuslogs/", ZeusLogUploader.CRASH_LOG);
    }

    public static synchronized String getEncryptKey() {
        String nativeGetEncryptKey;
        synchronized (ZwCrashpad.class) {
            nativeGetEncryptKey = (y && u) ? nativeGetEncryptKey() : "";
        }
        return nativeGetEncryptKey;
    }

    public static String[] getInfos() {
        String[] a2 = a();
        synchronized (ZwCrashpad.class) {
            u = true;
        }
        return a2;
    }

    public static boolean isCyberVersionReady() {
        boolean z;
        synchronized (x) {
            z = w;
        }
        return z;
    }

    private static native void nativeClearCrashKey(String str);

    private static native void nativeCrashIntentionally(int i2);

    private static native String nativeGetEncryptKey();

    private static native void nativeInit(String[] strArr);

    private static native void nativeRecordUrl(String str);

    private static native void nativeSetCallback(String str);

    private static native void nativeSetCrashKeyValue(String str, String str2);

    private static native void nativeSetCuid(String str);

    private static native void nativeSetCyberVersion(String str);

    private static native void nativeSetEmulator(String str);

    private static native void nativeSetHandlerSoDir(String str);

    private static native void nativeSetProcessType(String str);

    private static native void nativeSetStatisticParam(String str);

    private static native void nativeSetUploadCrashLogFailedEncrypt(boolean z);

    private static native void nativeSetWebviewNumber(String str);

    private static native void nativeSetZeusVersion(String str);

    public static synchronized void setCallback(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, c)) {
                c = str;
                if (u) {
                    nativeSetCallback(c);
                }
            }
        }
    }

    public static synchronized void setClientSoDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, s)) {
                s = str;
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        if (y && u && str != null) {
            nativeSetCrashKeyValue(str, str2);
        }
    }

    public static synchronized void setCuid(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, b)) {
                b = str;
                if (u) {
                    nativeSetCuid(b);
                }
            }
        }
    }

    public static boolean setCyberVersion(String str) {
        if (y && str != null && !str.equals("0")) {
            synchronized (x) {
                if (j == null || !j.equals(str)) {
                    j = str;
                    w = true;
                    if (u) {
                        nativeSetCyberVersion(j);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static synchronized void setEmulator(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, a)) {
                a = str;
                if (u) {
                    nativeSetEmulator(str);
                }
            }
        }
    }

    public static void setEnabled(boolean z) {
        y = z;
        b.a(z);
    }

    public static synchronized void setHandlerSoDir(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, r)) {
                r = str;
                if (u) {
                    nativeSetHandlerSoDir(str);
                }
            }
        }
    }

    public static synchronized void setProcessType(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, o)) {
                o = str;
                if (u) {
                    nativeSetProcessType(o);
                }
            }
        }
    }

    public static synchronized void setStatisticParam(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, e)) {
                e = str;
                if (u) {
                    nativeSetStatisticParam(e);
                }
            }
        }
    }

    public static synchronized void setUploadCrashLogFailedEncrypt(boolean z) {
        synchronized (ZwCrashpad.class) {
            if (y) {
                q = z ? "true" : "false";
                if (u) {
                    nativeSetUploadCrashLogFailedEncrypt(z);
                }
            }
        }
    }

    public static synchronized void setWebviewNumber(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, p)) {
                p = str;
                if (u) {
                    nativeSetWebviewNumber(p);
                }
            }
        }
    }

    public static synchronized void setZeusVersion(String str) {
        synchronized (ZwCrashpad.class) {
            if (y && !TextUtils.equals(str, i)) {
                i = str;
                if (u) {
                    nativeSetZeusVersion(i);
                }
            }
        }
    }
}
