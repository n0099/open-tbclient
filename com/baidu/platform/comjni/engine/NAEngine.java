package com.baidu.platform.comjni.engine;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comapi.longlink.LongLinkClient;
import com.baidu.platform.comjni.NativeComponent;
/* loaded from: classes15.dex */
public class NAEngine extends NativeComponent {

    /* renamed from: a  reason: collision with root package name */
    private static LongLinkClient f4716a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4717b = false;

    public NAEngine() {
        create();
    }

    public static void a() {
        nativeInitClass(new Bundle(), 0);
        f4717b = true;
    }

    public static void a(String str, int i) {
        nativeSetProxyInfo(str, i);
    }

    public static boolean a(Context context, String str) {
        if (!f4717b) {
            a();
        }
        try {
            return nativeInitEngine(context, str);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b() {
        try {
            if (f4716a != null) {
                f4716a.unRegister(null);
                f4716a.release();
                f4716a = null;
            }
            return nativeUninitEngine();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c() {
        return nativeStartSocketProc();
    }

    public static String getIP(String str) {
        return nativeGetIP(str);
    }

    private native long nativeCreate();

    private static native void nativeEnableMonitor(boolean z);

    private static native boolean nativeGetFlaxLength(Bundle bundle);

    private static native String nativeGetIP(String str);

    private static native void nativeInitCVLogFilePath(String str);

    private static native int nativeInitClass(Object obj, int i);

    private static native boolean nativeInitEngine(Object obj, String str);

    private static native void nativeMonitorAddLog(int i, String str);

    private static native void nativeMonitorSetLogPriority(int i);

    private native int nativeRelease(long j);

    private static native void nativeSetHttpsEnable(boolean z);

    private static native void nativeSetNewDomainEnable(boolean z);

    private static native void nativeSetProxyInfo(String str, int i);

    private static native void nativeStartRunningRequest();

    private static native boolean nativeStartSocketProc();

    private static native boolean nativeStartSocketProcByCache(String str);

    private static native void nativeSyncAppRuntime(String str);

    private static native void nativeUninitCVLogFilePath();

    private static native boolean nativeUninitEngine();

    public static void restartLongLink() {
        if (f4716a != null) {
            try {
                f4716a.start();
            } catch (Exception e) {
            }
        }
    }

    public static void startRunningRequest() {
        nativeStartRunningRequest();
    }

    public static void stopLongLink() {
        if (f4716a != null) {
            try {
                f4716a.stop();
            } catch (Exception e) {
            }
        }
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        return nativeRelease(this.mNativePointer);
    }
}
