package com.baidu.fsg.base.restnet.beans.business.core.utils;
/* loaded from: classes16.dex */
public class StringUtil {
    private static final char[] sNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String memToStr(byte b) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sNum[(b >> 4) & 15]);
        stringBuffer.append(sNum[b & 15]);
        return stringBuffer.toString();
    }

    public static String arrayToString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        i = (i < 0 || bArr.length < i) ? 0 : 0;
        int i3 = i + i2;
        if (i3 > bArr.length) {
            i3 = bArr.length;
        }
        while (i < i3) {
            stringBuffer.append(memToStr(bArr[i]));
            i++;
        }
        return stringBuffer.toString();
    }
}
