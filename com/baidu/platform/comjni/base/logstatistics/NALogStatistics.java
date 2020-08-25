package com.baidu.platform.comjni.base.logstatistics;

import com.baidu.platform.comjni.NativeComponent;
/* loaded from: classes20.dex */
public class NALogStatistics extends NativeComponent {
    public NALogStatistics() {
        create();
    }

    public static native boolean nativeAddLog(long j, int i, int i2, String str, String str2, String str3);

    public static native long nativeCreate();

    public static native int nativeRelease(long j);

    public static native boolean nativeSave(long j);

    public boolean a(int i, int i2, String str, String str2, String str3) {
        return false;
    }

    @Override // com.baidu.platform.comjni.NativeComponent
    public long create() {
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
