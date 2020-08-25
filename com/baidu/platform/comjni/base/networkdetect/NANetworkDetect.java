package com.baidu.platform.comjni.base.networkdetect;

import com.baidu.platform.comjni.NativeComponent;
/* loaded from: classes20.dex */
public class NANetworkDetect extends NativeComponent {
    public NANetworkDetect() {
        create();
    }

    private native long nativeCreate();

    private native boolean nativeNetworkDetect(long j, String str);

    private native int nativeRelease(long j);

    public boolean a(String str) {
        return nativeNetworkDetect(this.mNativePointer, str);
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
