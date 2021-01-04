package cn.com.chinatelecom.account.api.a;

import com.baidu.android.imsdk.internal.Constants;
import java.io.UnsupportedEncodingException;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f1099a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f1100b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] b(String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        byte b5;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i4 = 0;
        while (i4 < length) {
            while (true) {
                i = i4 + 1;
                b2 = f1100b[bytes[i4]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i4 = i;
            }
            if (b2 != -1) {
                while (true) {
                    i2 = i + 1;
                    b3 = f1100b[bytes[i]];
                    if (i2 >= length || b3 != -1) {
                        break;
                    }
                    i = i2;
                }
                if (b3 == -1) {
                    break;
                }
                stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
                while (true) {
                    i3 = i2 + 1;
                    byte b6 = bytes[i2];
                    if (b6 == 61) {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                    b4 = f1100b[b6];
                    if (i3 >= length || b4 != -1) {
                        break;
                    }
                    i2 = i3;
                }
                if (b4 == -1) {
                    break;
                }
                stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
                while (true) {
                    i4 = i3 + 1;
                    byte b7 = bytes[i3];
                    if (b7 == 61) {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                    b5 = f1100b[b7];
                    if (i4 >= length || b5 != -1) {
                        break;
                    }
                    i3 = i4;
                }
                if (b5 == -1) {
                    break;
                }
                stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
            } else {
                break;
            }
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
