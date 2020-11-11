package cn.com.chinatelecom.account.api.a;

import android.support.v4.view.InputDeviceCompat;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f971a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f971a[(bArr[i] >> 4) & 15]).append(f971a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int digit = (Character.digit(charArray[i * 2], 16) << 4) | Character.digit(charArray[(i * 2) + 1], 16);
            if (digit > 127) {
                digit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = (byte) digit;
        }
        return bArr;
    }
}
