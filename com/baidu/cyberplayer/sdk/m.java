package com.baidu.cyberplayer.sdk;

import com.baidu.android.imsdk.internal.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes17.dex */
public class m {

    /* loaded from: classes17.dex */
    private static class a extends GZIPOutputStream {
        public a(OutputStream outputStream) throws IOException {
            super(outputStream);
        }

        public void a(int i) {
            this.def.setLevel(i);
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        if (CyberPlayerManager.duplayerEncrypt(bArr, bArr.length, bArr2)) {
            return bArr2;
        }
        byte[] bArr3 = {26, 31, -22, -104, 118, 81, -16, 6, 90, -75, Byte.MIN_VALUE, -40, 85, 92, 106, 114, -20, 34, 116, 13, -70, -77, 122, -71, -84, -25, -42, 99, 42, 100, 19, -37, -99, 32, -17, 70, -124, -24, -114, -120, 24, 73, -103, 3, -44, 1, 52, 91, 17, 40, -21, 66, -91, 21, 16, -59, 80, 49, 12, -123, 123, -92, 68, 102, Constants.SHORT_PING_CMD_TYPE, -6, -72, -89, -107, 10, 126, -102, -98, -52, -64, 120, -32, -55, -80, 98, 55, -85, 36, 47, -101, 84, -90, 121, 125, -28, 46, -63, 83, -113, 61, -67, -57, -15, 22, -19, 94, 28, -46, 97, 43, Byte.MAX_VALUE, -9, 20, 112, -54, Constants.GZIP_CAST_TYPE, -68, -2, -112, -79, -47, -13, 109, 27, -116, -96, -115, -18, -100, 5, 35, 67, 48, 82, -23, 88, -66, -38, 50, 23, -4, -48, -58, -51, -29, -78, 115, -122, 69, -34, -86, 74, -50, -87, -1, -121, 124, 71, -126, 7, 62, 56, -94, 77, -110, -27, 30, -83, -62, 0, 18, 39, 104, 29, 78, 25, -41, 2, -65, -8, -3, 89, 41, -56, 58, -45, 79, 14, 96, 72, -26, -14, -82, 15, 108, -30, -97, -108, -109, 54, -73, -11, 38, -61, -33, 59, -49, 117, -95, 9, 87, 110, -125, -105, 86, 45, 60, -81, -39, -43, -31, -53, 63, -88, 76, -10, 8, 53, 93, 75, -60, 111, 105, -127, 103, -111, -93, 95, 64, -69, -106, -7, 113, 4, -5, -74, 44, -117, -12, -35, 51, 119, 65, 33, -36, 107, -119, 57, -118, -76, 37};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 = (i2 + 1) & 255;
            i = (i + bArr3[i2]) & 255;
            byte b = bArr3[i2];
            bArr3[i2] = bArr3[i];
            bArr3[i] = b;
            bArr2[i3] = (byte) (bArr[i3] ^ bArr3[(bArr3[i2] + bArr3[i]) & 255]);
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a aVar = new a(byteArrayOutputStream);
        aVar.a(9);
        aVar.write(bArr);
        aVar.close();
        return byteArrayOutputStream.toByteArray();
    }
}
