package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
/* loaded from: classes2.dex */
public final class NativeCrashHandler {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8489a = false;

    /* renamed from: b  reason: collision with root package name */
    public static Context f8490b;

    static {
        try {
            System.loadLibrary("crash_analysis");
            f8489a = true;
        } catch (Throwable unused) {
        }
    }

    public static void doNativeCrash() {
        if (f8489a) {
            try {
                nativeException();
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        f8490b = context;
        if (f8489a) {
            File cacheDir = context.getCacheDir();
            if (cacheDir.exists() && cacheDir.isDirectory()) {
                try {
                    nativeInit(cacheDir.getAbsolutePath());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static native void nativeException();

    public static native void nativeInit(String str);

    public static native void nativeProcess(String str);

    public static native void nativeUnint();

    public static void onCrashCallbackFromNative(String str) {
        ExceptionAnalysis.getInstance().saveCrashInfo(f8490b, System.currentTimeMillis(), str, "NativeException", 1, 0);
    }

    public static void process(String str) {
        if (str == null || str.length() == 0 || !f8489a) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                nativeProcess(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void uninit() {
        if (f8489a) {
            try {
                nativeUnint();
            } catch (Throwable unused) {
            }
        }
    }
}
