package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
/* loaded from: classes2.dex */
public final class NativeCrashHandler {
    public static boolean a;
    public static Context b;

    public static native void nativeException();

    public static native void nativeInit(String str);

    public static native void nativeProcess(String str);

    public static native void nativeUnint();

    static {
        try {
            System.loadLibrary("crash_analysis");
            a = true;
        } catch (Throwable unused) {
        }
    }

    public static void doNativeCrash() {
        if (a) {
            try {
                nativeException();
            } catch (Throwable unused) {
            }
        }
    }

    public static void uninit() {
        if (a) {
            try {
                nativeUnint();
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        b = context;
        if (a) {
            File cacheDir = context.getCacheDir();
            if (cacheDir.exists() && cacheDir.isDirectory()) {
                try {
                    nativeInit(cacheDir.getAbsolutePath());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void onCrashCallbackFromNative(String str) {
        ExceptionAnalysis.getInstance().saveCrashInfo(b, System.currentTimeMillis(), str, "NativeException", 1, 0);
    }

    public static void process(String str) {
        if (str != null && str.length() != 0 && a) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    nativeProcess(str);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
