package com.baidu.fsg.base.restnet.beans.business.core.utils;
/* loaded from: classes2.dex */
public class StringUtil {
    public static final char[] sNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String arrayToString(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        i2 = (i2 < 0 || bArr.length < i2) ? 0 : 0;
        int i4 = i3 + i2;
        if (i4 > bArr.length) {
            i4 = bArr.length;
        }
        while (i2 < i4) {
            stringBuffer.append(memToStr(bArr[i2]));
            i2++;
        }
        return stringBuffer.toString();
    }

    public static String memToStr(byte b2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sNum[(b2 >> 4) & 15]);
        stringBuffer.append(sNum[b2 & 15]);
        return stringBuffer.toString();
    }
}
