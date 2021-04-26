package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes2.dex */
public class JsArrayBuffer {
    public byte[] mBuffer;
    public int mLength;

    public JsArrayBuffer(byte[] bArr, int i2) {
        this.mBuffer = bArr;
        this.mLength = i2;
    }

    public byte[] buffer() {
        return this.mBuffer;
    }

    public int length() {
        return this.mLength;
    }
}
