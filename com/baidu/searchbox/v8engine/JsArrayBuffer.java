package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes4.dex */
public class JsArrayBuffer {
    public byte[] mBuffer;
    public int mLength;

    public JsArrayBuffer(byte[] bArr, int i) {
        this.mBuffer = bArr;
        this.mLength = i;
    }

    public byte[] buffer() {
        return this.mBuffer;
    }

    public int length() {
        return this.mLength;
    }
}
