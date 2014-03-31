package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public final class f {
    static String[] a = {"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"};

    public static String a(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        char[] charArray = a[0].toCharArray();
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i2 = length - 3;
        while (i <= i2) {
            int i3 = ((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | (bArr[i + 2] & 255);
            stringBuffer.append(charArray[(i3 >> 18) & 63]);
            stringBuffer.append(charArray[(i3 >> 12) & 63]);
            stringBuffer.append(charArray[(i3 >> 6) & 63]);
            stringBuffer.append(charArray[i3 & 63]);
            i += 3;
        }
        if (i == (length + 0) - 2) {
            int i4 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
            stringBuffer.append(charArray[(i4 >> 18) & 63]);
            stringBuffer.append(charArray[(i4 >> 12) & 63]);
            stringBuffer.append(charArray[(i4 >> 6) & 63]);
        } else if (i == (length + 0) - 1) {
            int i5 = (bArr[i] & 255) << 16;
            stringBuffer.append(charArray[(i5 >> 18) & 63]);
            stringBuffer.append(charArray[(i5 >> 12) & 63]);
        }
        return stringBuffer.toString();
    }
}
