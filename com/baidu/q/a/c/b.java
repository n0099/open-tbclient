package com.baidu.q.a.c;

import java.io.ByteArrayOutputStream;
/* loaded from: classes25.dex */
public class b {
    private String axu;
    private boolean axv;
    private boolean axw;

    public b(String str, boolean z, boolean z2) {
        this.axu = str;
        this.axv = z;
        this.axw = z2;
    }

    private static int dt(int i) {
        switch (i) {
            case 1:
                return 6;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 1;
            case 5:
                return 0;
            default:
                return -1;
        }
    }

    public String encode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < (bArr.length + 4) / 5; i++) {
            short[] sArr = new short[5];
            int[] iArr = new int[8];
            int i2 = 5;
            for (int i3 = 0; i3 < 5; i3++) {
                if ((i * 5) + i3 < bArr.length) {
                    sArr[i3] = (short) (bArr[(i * 5) + i3] & 255);
                } else {
                    sArr[i3] = 0;
                    i2--;
                }
            }
            int dt = dt(i2);
            iArr[0] = (byte) ((sArr[0] >> 3) & 31);
            iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
            iArr[2] = (byte) ((sArr[1] >> 1) & 31);
            iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
            iArr[4] = (byte) (((sArr[2] & 15) << 1) | ((sArr[3] >> 7) & 1));
            iArr[5] = (byte) ((sArr[3] >> 2) & 31);
            iArr[6] = (byte) (((sArr[3] & 3) << 3) | ((sArr[4] >> 5) & 7));
            iArr[7] = (byte) (sArr[4] & 31);
            for (int i4 = 0; i4 < iArr.length - dt; i4++) {
                char charAt = this.axu.charAt(iArr[i4]);
                if (this.axw) {
                    charAt = Character.toLowerCase(charAt);
                }
                byteArrayOutputStream.write(charAt);
            }
            if (this.axv) {
                for (int length = iArr.length - dt; length < iArr.length; length++) {
                    byteArrayOutputStream.write(61);
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
