package com.alipay.security.mobile.module.a.a;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import io.flutter.plugin.common.StandardMessageCodec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f2080a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f2081b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007c, code lost:
        if (r2 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007e, code lost:
        r0.append((char) (r2 | ((r6 & 3) << 6)));
        r2 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i4 = 0;
        loop0: while (i4 < length) {
            while (true) {
                i = i4 + 1;
                b2 = f2081b[bytes[i4]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i4 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = f2081b[bytes[i]];
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
                byte b5 = bytes[i2];
                if (b5 == 61) {
                    break loop0;
                }
                b4 = f2081b[b5];
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
                int i5 = i3 + 1;
                byte b6 = bytes[i3];
                if (b6 == 61) {
                    break loop0;
                }
                byte b7 = f2081b[b6];
                if (i5 >= length || b7 != -1) {
                    break;
                }
                i3 = i5;
            }
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
