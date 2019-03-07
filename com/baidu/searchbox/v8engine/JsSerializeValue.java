package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes2.dex */
public class JsSerializeValue {
    private long mNativeObject;

    private native void nativeRelease(long j);

    public JsSerializeValue(long j) {
        this.mNativeObject = 0L;
        this.mNativeObject = j;
    }

    long nativePtr() {
        return this.mNativeObject;
    }

    public void release() {
        if (this.mNativeObject != 0) {
            nativeRelease(this.mNativeObject);
            this.mNativeObject = 0L;
        }
    }
}
