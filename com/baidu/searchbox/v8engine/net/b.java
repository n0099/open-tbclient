package com.baidu.searchbox.v8engine.net;

import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f10122a = Charset.forName("UTF-8");

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress c(String str, int i2, int i3) {
        int i4;
        byte[] bArr = new byte[16];
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i2 < i3) {
                if (i5 != 16) {
                    int i8 = i2 + 2;
                    if (i8 <= i3 && str.regionMatches(i2, "::", 0, 2)) {
                        if (i6 == -1) {
                            i5 += 2;
                            i6 = i5;
                            if (i8 != i3) {
                                i7 = i8;
                                i2 = i7;
                                int i9 = 0;
                                while (i2 < i3) {
                                }
                                i4 = i2 - i7;
                                if (i4 == 0) {
                                    break;
                                }
                                break;
                            }
                            break;
                        }
                        return null;
                    }
                    if (i5 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !a(str, i7, i3, bArr, i5 - 2)) {
                            return null;
                        } else {
                            i5 += 2;
                        }
                    }
                    i7 = i2;
                    i2 = i7;
                    int i92 = 0;
                    while (i2 < i3) {
                        int a2 = a(str.charAt(i2));
                        if (a2 == -1) {
                            break;
                        }
                        i92 = (i92 << 4) + a2;
                        i2++;
                    }
                    i4 = i2 - i7;
                    if (i4 == 0 || i4 > 4) {
                        break;
                    }
                    int i10 = i5 + 1;
                    bArr[i5] = (byte) ((i92 >>> 8) & 255);
                    i5 = i10 + 1;
                    bArr[i10] = (byte) (i92 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        if (i5 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i11 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i11, i11);
            Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean b(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress c2;
        if (str.contains(":")) {
            if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                c2 = c(str, 1, str.length() - 1);
            } else {
                c2 = c(str, 0, str.length());
            }
            if (c2 == null) {
                return null;
            }
            byte[] address = c2.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (b(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    public static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        com.baidu.searchbox.v8engine.net.io.a aVar = new com.baidu.searchbox.v8engine.net.io.a();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                aVar.b(58);
                i2 += i5;
                if (i2 == 16) {
                    aVar.b(58);
                }
            } else {
                if (i2 > 0) {
                    aVar.b(58);
                }
                aVar.b(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return aVar.c();
    }
}
