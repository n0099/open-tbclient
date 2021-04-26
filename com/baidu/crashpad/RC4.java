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

    private void processBytes(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (i2 + i3 <= bArr.length) {
            if (i4 + i3 > bArr2.length) {
                throw new RuntimeException("output buffer too short");
            }
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = (this.x + 1) & 255;
                this.x = i6;
                byte[] bArr3 = this.engineState;
                int i7 = (bArr3[i6] + this.y) & 255;
                this.y = i7;
                byte b2 = bArr3[i6];
                bArr3[i6] = bArr3[i7];
                bArr3[i7] = b2;
                bArr2[i5 + i4] = (byte) (bArr3[(bArr3[i6] + bArr3[i7]) & 255] ^ bArr[i5 + i2]);
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
        for (int i2 = 0; i2 < 256; i2++) {
            this.engineState[i2] = (byte) i2;
        }
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 256; i5++) {
            byte[] bArr2 = this.engineState;
            i4 = ((bArr[i3] & 255) + bArr2[i5] + i4) & 255;
            byte b2 = bArr2[i5];
            bArr2[i5] = bArr2[i4];
            bArr2[i4] = b2;
            i3 = (i3 + 1) % bArr.length;
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
