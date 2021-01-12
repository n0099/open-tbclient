package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
/* loaded from: classes14.dex */
public final class NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3624a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f3625b;

    private static native void nativeException();

    private static native void nativeInit(String str);

    private static native void nativeProcess(String str);

    private static native void nativeUnint();

    static {
        f3624a = false;
        try {
            System.loadLibrary("crash_analysis");
            f3624a = true;
        } catch (Throwable th) {
        }
    }

    private NativeCrashHandler() {
    }

    public static void doNativeCrash() {
        if (f3624a) {
            try {
                nativeException();
            } catch (Throwable th) {
            }
        }
    }

    public static void init(Context context) {
        if (context != null) {
            f3625b = context;
            if (f3624a) {
                File cacheDir = context.getCacheDir();
                if (cacheDir.exists() && cacheDir.isDirectory()) {
                    try {
                        nativeInit(cacheDir.getAbsolutePath());
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    public static void uninit() {
        if (f3624a) {
            try {
                nativeUnint();
            } catch (Throwable th) {
            }
        }
    }

    public static void process(String str) {
        if (str != null && str.length() != 0 && f3624a) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                try {
                    nativeProcess(str);
                } catch (Throwable th) {
                }
            }
        }
    }

    public static void onCrashCallbackFromNative(String str) {
        ExceptionAnalysis.getInstance().saveCrashInfo(f3625b, System.currentTimeMillis(), str, "NativeException", 1, 0);
    }
}
