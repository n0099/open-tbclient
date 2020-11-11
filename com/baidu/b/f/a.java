package com.baidu.b.f;

import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f1267a;
    private boolean b;
    private boolean c;

    public a(String str, boolean z, boolean z2) {
        this.f1267a = str;
        this.b = z;
        this.c = z2;
    }

    private static int a(int i) {
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

    public String a(byte[] bArr) {
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
            int a2 = a(i2);
            iArr[0] = (byte) ((sArr[0] >> 3) & 31);
            iArr[1] = (byte) (((sArr[0] & 7) << 2) | ((sArr[1] >> 6) & 3));
            iArr[2] = (byte) ((sArr[1] >> 1) & 31);
            iArr[3] = (byte) (((sArr[1] & 1) << 4) | ((sArr[2] >> 4) & 15));
            iArr[4] = (byte) (((sArr[2] & 15) << 1) | ((sArr[3] >> 7) & 1));
            iArr[5] = (byte) ((sArr[3] >> 2) & 31);
            iArr[6] = (byte) (((sArr[3] & 3) << 3) | ((sArr[4] >> 5) & 7));
            iArr[7] = (byte) (sArr[4] & 31);
            for (int i4 = 0; i4 < iArr.length - a2; i4++) {
                char charAt = this.f1267a.charAt(iArr[i4]);
                if (this.c) {
                    charAt = Character.toLowerCase(charAt);
                }
                byteArrayOutputStream.write(charAt);
            }
            if (this.b) {
                for (int length = iArr.length - a2; length < iArr.length; length++) {
                    byteArrayOutputStream.write(61);
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
}
