package com.baidu.android.common.security;
/* loaded from: classes5.dex */
public class RC4 {
    private static final int STATE_LENGTH = 256;
    private byte[] workingKey;
    private byte[] engineState = null;
    private int x = 0;
    private int y = 0;

    public RC4(String str) {
        this.workingKey = null;
        this.workingKey = str.getBytes();
    }

    private void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new RuntimeException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new RuntimeException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.x = (this.x + 1) & 255;
            this.y = (this.engineState[this.x] + this.y) & 255;
            byte b = this.engineState[this.x];
            this.engineState[this.x] = this.engineState[this.y];
            this.engineState[this.y] = b;
            bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ this.engineState[(this.engineState[this.x] + this.engineState[this.y]) & 255]);
        }
    }

    private void setKey(byte[] bArr) {
        this.x = 0;
        this.y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i = 0; i < 256; i++) {
            this.engineState[i] = (byte) i;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i2 = (i2 + (bArr[i3] & 255) + this.engineState[i4]) & 255;
            byte b = this.engineState[i4];
            this.engineState[i4] = this.engineState[i2];
            this.engineState[i2] = b;
            i3 = (i3 + 1) % bArr.length;
        }
    }

    private void reset() {
        setKey(this.workingKey);
    }

    public byte[] encrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public byte[] decrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }
}
