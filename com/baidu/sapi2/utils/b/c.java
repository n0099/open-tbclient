package com.baidu.sapi2.utils.b;

import android.support.v4.view.MotionEventCompat;
import com.baidu.sapi2.utils.L;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class c {
    static String[] a = {"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length, null).toString();
    }

    private static StringBuffer a(byte[] bArr, int i, int i2, StringBuffer stringBuffer) {
        char[] charArray = a[0].toCharArray();
        if (stringBuffer == null) {
            stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        }
        int i3 = i2 - 3;
        int i4 = i;
        while (i4 <= i3) {
            int i5 = ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8) | (bArr[i4 + 2] & 255);
            stringBuffer.append(charArray[(i5 >> 18) & 63]);
            stringBuffer.append(charArray[(i5 >> 12) & 63]);
            stringBuffer.append(charArray[(i5 >> 6) & 63]);
            stringBuffer.append(charArray[i5 & 63]);
            i4 += 3;
        }
        if (i4 == (i + i2) - 2) {
            int i6 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
            stringBuffer.append(charArray[(i6 >> 18) & 63]);
            stringBuffer.append(charArray[(i6 >> 12) & 63]);
            stringBuffer.append(charArray[(i6 >> 6) & 63]);
        } else if (i4 == (i + i2) - 1) {
            int i7 = (bArr[i4] & 255) << 16;
            stringBuffer.append(charArray[(i7 >> 18) & 63]);
            stringBuffer.append(charArray[(i7 >> 12) & 63]);
        }
        return stringBuffer;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    public static byte[] a(String str) {
        byte[] bArr = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (str != null) {
            try {
                try {
                    a(str, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                    L.e(e);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        L.e(e2);
                    }
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    L.e(e3);
                }
            }
        }
        return bArr;
    }

    private static void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        int length = str.length();
        int length2 = str.length() % 4;
        if (length2 > 0) {
            length2 = 4 - length2;
        }
        while (length2 > 0) {
            str = str + '=';
            length2--;
        }
        int i = 0;
        while (true) {
            if (i < length && str.charAt(i) <= ' ') {
                i++;
            } else if (i != length) {
                int a2 = (a(str.charAt(i), 0) << 18) + (a(str.charAt(i + 1), 0) << 12) + (a(str.charAt(i + 2), 0) << 6) + a(str.charAt(i + 3), 0);
                byteArrayOutputStream.write((a2 >> 16) & MotionEventCompat.ACTION_MASK);
                if (str.charAt(i + 2) != '=') {
                    byteArrayOutputStream.write((a2 >> 8) & MotionEventCompat.ACTION_MASK);
                    if (str.charAt(i + 3) != '=') {
                        byteArrayOutputStream.write(a2 & MotionEventCompat.ACTION_MASK);
                        i += 4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static int a(char c, int i) {
        int i2 = 0;
        char[] charArray = a[i].toCharArray();
        if (c != '=') {
            while (i2 < 64) {
                if (charArray[i2] != c) {
                    i2++;
                }
            }
            throw new RuntimeException("unexpected code: " + c);
        }
        return i2;
    }
}
