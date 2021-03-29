package com.baidu.crashpad;
/* loaded from: classes.dex */
public class RC4 {
    public static final String LOGTAG = "RC4 CRASHPAD";
    public static final int STATE_LENGTH = 256;
    public byte[] engineState;
    public byte[] workingKey;
    public int x;
    public int y;

    public RC4(String str) {
        this.workingKey = str.getBytes();
    }

    private void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 <= bArr.length) {
            if (i3 + i2 > bArr2.length) {
                throw new RuntimeException("output buffer too short");
            }
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = (this.x + 1) & 255;
                this.x = i5;
                byte[] bArr3 = this.engineState;
                int i6 = (bArr3[i5] + this.y) & 255;
                this.y = i6;
                byte b2 = bArr3[i5];
                bArr3[i5] = bArr3[i6];
                bArr3[i6] = b2;
                bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + bArr3[i6]) & 255] ^ bArr[i4 + i]);
            }
            return;
        }
        throw new RuntimeException("input buffer too short");
    }

    private void reset() {
        setKey(this.workingKey);
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
            byte[] bArr2 = this.engineState;
            i3 = ((bArr[i2] & 255) + bArr2[i4] + i3) & 255;
            byte b2 = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
            i2 = (i2 + 1) % bArr.length;
        }
    }

    public byte[] decrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }

    public byte[] encrypt(byte[] bArr) {
        reset();
        byte[] bArr2 = new byte[bArr.length];
        processBytes(bArr, 0, bArr.length, bArr2, 0);
        return bArr2;
    }
}
