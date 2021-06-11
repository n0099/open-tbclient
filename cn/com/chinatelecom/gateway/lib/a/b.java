package cn.com.chinatelecom.gateway.lib.a;

import cn.com.chinatelecom.gateway.lib.CtAuth;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f1520a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static char[] f1521b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: c  reason: collision with root package name */
    public static byte[] f1522c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(byte[] bArr) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f1521b[i4 >>> 2]);
                stringBuffer.append(f1521b[(i4 & 3) << 4]);
                str = "==";
            } else {
                int i5 = i3 + 1;
                int i6 = bArr[i3] & 255;
                if (i5 == length) {
                    stringBuffer.append(f1521b[i4 >>> 2]);
                    stringBuffer.append(f1521b[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                    stringBuffer.append(f1521b[(i6 & 15) << 2]);
                    str = "=";
                } else {
                    int i7 = i5 + 1;
                    int i8 = bArr[i5] & 255;
                    stringBuffer.append(f1521b[i4 >>> 2]);
                    stringBuffer.append(f1521b[((i4 & 3) << 4) | ((i6 & 240) >>> 4)]);
                    stringBuffer.append(f1521b[((i6 & 15) << 2) | ((i8 & 192) >>> 6)]);
                    stringBuffer.append(f1521b[i8 & 63]);
                    i2 = i7;
                }
            }
            stringBuffer.append(str);
            break;
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (Throwable th) {
            CtAuth.warn(f1520a, "When decode() ,throws exception", th);
            return new byte[0];
        }
    }

    public static byte[] b(String str) {
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        int i5;
        byte b5;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i6 = 0;
        loop0: while (i6 < length) {
            while (true) {
                i2 = i6 + 1;
                b2 = f1522c[bytes[i6]];
                if (i2 >= length || b2 != -1) {
                    break;
                }
                i6 = i2;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i3 = i2 + 1;
                b3 = f1522c[bytes[i2]];
                if (i3 >= length || b3 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b3 == -1) {
                break;
            }
            stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
            while (true) {
                i4 = i3 + 1;
                byte b6 = bytes[i3];
                if (b6 == 61) {
                    break loop0;
                }
                b4 = f1522c[b6];
                if (i4 >= length || b4 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b4 == -1) {
                break;
            }
            stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
            while (true) {
                i5 = i4 + 1;
                byte b7 = bytes[i4];
                if (b7 == 61) {
                    break loop0;
                }
                b5 = f1522c[b7];
                if (i5 >= length || b5 != -1) {
                    break;
                }
                i4 = i5;
            }
            if (b5 == -1) {
                break;
            }
            stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
            i6 = i5;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
