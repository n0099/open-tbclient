package com.baidu.platform.comjni.map.aime;

import com.baidu.platform.comapi.a.a;
import com.baidu.platform.comjni.NativeComponent;
/* loaded from: classes7.dex */
public class NAAimeControl extends NativeComponent {
    public NAAimeControl() {
        create();
    }

    public static native boolean nativeAttachUDCObserver(long j, String[] strArr, long j2);

    public static native boolean nativeCloseDebugInfo(long j);

    public static native long nativeContentRefresh(long j, a aVar, int i, String str, String str2);

    private static native long nativeCreate();

    public static native long nativeCreateNAObserver(long j);

    public static native void nativeDelDebugDomain(long j);

    public static native void nativeDelNAObserver(long j, long j2);

    public static native void nativeDelTestAddr(long j, String str);

    public static native boolean nativeDetachUDCObserver(long j, long j2);

    private static native void nativeFindClass();

    public static native long nativeGetContentAsync(long j, a aVar, String str, String str2);

    public static native String nativeGetContentSync(long j, String str, String str2);

    public static native int nativeGetCurrentPosture(long j);

    public static native String nativeGetUDCDataSync(long j, String[] strArr);

    public static native String nativeGetUDCLinkData(long j, String[] strArr);

    private static native boolean nativeInit(long j, String str, String str2, int i, int i2, int i3);

    public static native boolean nativeIsOutOfLocalCity(long j, int i);

    public static native boolean nativeOpenDebugInfo(long j);

    public static native long nativeRegAimeListener(long j, a aVar, String str, String str2);

    private static native int nativeRelease(long j);

    public static native boolean nativeSendMonitorAck(long j, int i);

    public static native boolean nativeSendMonitorFile(long j, int i, String str);

    public static native boolean nativeSendMonitorFileLink(long j, int i, String str);

    public static native boolean nativeSendMonitorFinish(long j, int i, String str);

    public static native boolean nativeSendMonitorLog(long j, int i, String str);

    public static native boolean nativeSendMonitorReply(long j, int i, String str);

    public static native boolean nativeSetCollectInfo(long j, String str);

    public static native void nativeSetTestAddr(long j, String str, String str2);

    public static native void nativeSetTestAddress(long j, String str);

    public static native void nativeSetUDCDataAsync(long j, String str, long j2, int i);

    public static native boolean nativeSetUDCDataSync(long j, String str, int i);

    public static native boolean nativeSetUDCLinkData(long j, String str);

    public static native boolean nativeStartUDCSync(long j, long j2);

    public static native boolean nativeUnRegAimeListener(long j, long j2, String str, String str2);

    @Override // com.baidu.platform.comjni.NativeComponent
    public synchronized long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public synchronized int dispose() {
        int i;
        if (this.mNativePointer != 0) {
            i = nativeRelease(this.mNativePointer);
            this.mNativePointer = 0L;
        } else {
            i = 0;
        }
        return i;
    }
}
