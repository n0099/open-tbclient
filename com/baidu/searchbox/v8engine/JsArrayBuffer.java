package com.baidu.searchbox.v8engine;
@NotProguard
/* loaded from: classes9.dex */
public class JsArrayBuffer {
    private byte[] mBuffer;
    private int mLength;

    public JsArrayBuffer(byte[] bArr, int i) {
        this.mBuffer = bArr;
        this.mLength = i;
    }

    public int length() {
        return this.mLength;
    }

    public byte[] buffer() {
        return this.mBuffer;
    }
}
