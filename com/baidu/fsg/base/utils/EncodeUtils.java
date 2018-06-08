package com.baidu.fsg.base.utils;

import android.util.Base64;
import com.baidu.ar.util.IoUtils;
import java.lang.Character;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public final class EncodeUtils {
    private EncodeUtils() {
    }

    public static String gbk2utf8(String str) {
        return unicodeToUtf8(gbk2Unicode(str));
    }

    public static String utf82gbk(String str) {
        return unicode2GBK(utf8ToUnicode(str));
    }

    public static String gbk2Unicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!a(charAt)) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append("\\u" + Integer.toHexString(charAt));
            }
        }
        return stringBuffer.toString();
    }

    public static String unicode2GBK(String str) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        while (i < length) {
            if (i >= length - 1 || !"\\u".equals(str.substring(i, i + 2))) {
                stringBuffer.append(str.charAt(i));
                i++;
            } else {
                stringBuffer.append((char) Integer.parseInt(str.substring(i + 2, i + 6), 16));
                i += 6;
            }
        }
        return stringBuffer.toString();
    }

    private static boolean a(char c) {
        return (c & 255) != c;
    }

    public static String utf8ToUnicode(String str) {
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            Character.UnicodeBlock of = Character.UnicodeBlock.of(charArray[i]);
            if (of == Character.UnicodeBlock.BASIC_LATIN) {
                stringBuffer.append(charArray[i]);
            } else if (of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
                stringBuffer.append((char) (charArray[i] - 65248));
            } else {
                stringBuffer.append(("\\u" + Integer.toHexString((short) charArray[i])).toLowerCase());
            }
        }
        return stringBuffer.toString();
    }

    public static String unicodeToUtf8(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                int i3 = i2 + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'u') {
                    int i4 = 0;
                    i = i3;
                    int i5 = 0;
                    while (i5 < 4) {
                        int i6 = i + 1;
                        char charAt3 = str.charAt(i);
                        switch (charAt3) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                i4 = ((i4 << 4) + charAt3) - 48;
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                i4 = (((i4 << 4) + 10) + charAt3) - 65;
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                i4 = (((i4 << 4) + 10) + charAt3) - 97;
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                        i5++;
                        i = i6;
                    }
                    stringBuffer.append((char) i4);
                } else {
                    if (charAt2 == 't') {
                        charAt2 = '\t';
                    } else if (charAt2 == 'r') {
                        charAt2 = '\r';
                    } else if (charAt2 == 'n') {
                        charAt2 = '\n';
                    } else if (charAt2 == 'f') {
                        charAt2 = '\f';
                    }
                    stringBuffer.append(charAt2);
                    i = i3;
                }
            } else {
                stringBuffer.append(charAt);
                i = i2;
            }
        }
        return stringBuffer.toString();
    }

    public static String encodeCommParms(String str) {
        String str2 = "";
        try {
            try {
                str2 = URLEncoder.encode(new String(Base64.encode(str.getBytes(), 0)), IoUtils.UTF_8);
            } catch (Exception e) {
                LogUtil.e("EncodeUtils", "encodeCommParms failed", e);
            }
        } catch (Throwable th) {
        }
        return str2;
    }
}
