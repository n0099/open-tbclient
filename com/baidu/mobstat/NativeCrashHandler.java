package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
public final class NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3627a;

    /* renamed from: b  reason: collision with root package name */
    private static Context f3628b;

    private static native void nativeException();

    private static native void nativeInit(String str);

    private static native void nativeProcess(String str);

    private static native void nativeUnint();

    static {
        f3627a = false;
        try {
            System.loadLibrary("crash_analysis");
            f3627a = true;
        } catch (Throwable th) {
        }
    }

    private NativeCrashHandler() {
    }

    public static void doNativeCrash() {
        if (f3627a) {
            try {
                nativeException();
            } catch (Throwable th) {
            }
        }
    }

    public static void init(Context context) {
        if (context != null) {
            f3628b = context;
            if (f3627a) {
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
        if (f3627a) {
            try {
                nativeUnint();
            } catch (Throwable th) {
            }
        }
    }

    public static void process(String str) {
        if (str != null && str.length() != 0 && f3627a) {
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
        ExceptionAnalysis.getInstance().saveCrashInfo(f3628b, System.currentTimeMillis(), str, "NativeException", 1, 0);
    }
}
