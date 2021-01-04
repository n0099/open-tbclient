package com.baidu.platform.comjni.map.cloudcontrol;

import com.baidu.platform.comjni.NativeComponent;
/* loaded from: classes15.dex */
public class NACloudControl extends NativeComponent {
    public NACloudControl() {
        create();
    }

    private static native boolean nativeAdd(long j, String str, String str2);

    private static native long nativeCreate();

    private static native boolean nativeDoCallback(long j, String str);

    private static native String nativeGetCloudData(long j, long j2);

    private static native String nativeGetValue(long j, String str);

    private static native boolean nativeInit(long j, String str, boolean z);

    private static native boolean nativeIsExist(long j, String str);

    public static native boolean nativeRegCloudControlListener(long j, String str);

    private static native int nativeRelease(long j);

    private static native boolean nativeRemove(long j, String str);

    private static native boolean nativeStartup(long j);

    private static native boolean nativeSynCloudData(long j, String str, String str2);

    public static native boolean nativeUnRegCloudControlListener(long j, String str);

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
        this.mNativePointer = nativeCreate();
        return this.mNativePointer;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public int dispose() {
        if (this.mNativePointer != 0) {
            int nativeRelease = nativeRelease(this.mNativePointer);
            this.mNativePointer = 0L;
            return nativeRelease;
        }
        return 0;
    }
}
