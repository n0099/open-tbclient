package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.v8engine.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import okio.Buffer;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c < '0' || c > '9') {
                char c2 = 'a';
                if (c < 'a' || c > 'f') {
                    c2 = 'A';
                    if (c < 'A' || c > 'F') {
                        return -1;
                    }
                }
                return (c - c2) + 10;
            }
            return c - '0';
        }
        return invokeCommon.intValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        InetAddress a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str.contains(":")) {
                if (str.startsWith(PreferencesUtil.LEFT_MOUNT) && str.endsWith(PreferencesUtil.RIGHT_MOUNT)) {
                    a = a(str, 1, str.length() - 1);
                } else {
                    a = a(str, 0, str.length());
                }
                if (a == null) {
                    return null;
                }
                byte[] address = a.getAddress();
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
                if (e(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                return b(HttpUrl.c(str).f().build().toString(), d(str2));
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, strArr)) == null) {
            try {
                return b(HttpUrl.c(str).f().build().toString(), a(strArr));
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4 && i6 >= 4) {
                    i2 = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i2) {
                    buffer.writeByte(58);
                    i += i4;
                    if (i == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return buffer.readUtf8();
        }
        return (String) invokeL.objValue;
    }

    public static String a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, strArr)) == null) {
            try {
                Uri.Builder builder = new Uri.Builder();
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i2 < strArr.length) {
                        builder.appendQueryParameter(strArr[i], strArr[i2]);
                        i += 2;
                    } else {
                        return builder.build().toString();
                    }
                }
            } catch (Exception unused) {
                return "";
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InetAddress a(String str, int i, int i2) {
        InterceptResult invokeLII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, str, i, i2)) == null) {
            byte[] bArr = new byte[16];
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            while (true) {
                if (i < i2) {
                    if (i4 == 16) {
                        return null;
                    }
                    int i7 = i + 2;
                    if (i7 <= i2 && str.regionMatches(i, "::", 0, 2)) {
                        if (i5 != -1) {
                            return null;
                        }
                        i4 += 2;
                        i5 = i4;
                        if (i7 != i2) {
                            i6 = i7;
                            i = i6;
                            int i8 = 0;
                            while (i < i2) {
                            }
                            i3 = i - i6;
                            if (i3 == 0) {
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    if (i4 != 0) {
                        if (str.regionMatches(i, ":", 0, 1)) {
                            i++;
                        } else if (!str.regionMatches(i, ".", 0, 1) || !a(str, i6, i2, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i;
                    i = i6;
                    int i82 = 0;
                    while (i < i2) {
                        int a = a(str.charAt(i));
                        if (a == -1) {
                            break;
                        }
                        i82 = (i82 << 4) + a;
                        i++;
                    }
                    i3 = i - i6;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i9 = i4 + 1;
                    bArr[i4] = (byte) ((i82 >>> 8) & 255);
                    i4 = i9 + 1;
                    bArr[i9] = (byte) (i82 & 255);
                } else {
                    break;
                }
            }
            if (i4 != 16) {
                if (i5 == -1) {
                    return null;
                }
                int i10 = i4 - i5;
                System.arraycopy(bArr, i5, bArr, 16 - i10, i10);
                Arrays.fill(bArr, i5, (16 - i4) + i5, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
        return (InetAddress) invokeLII.objValue;
    }

    public static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), bArr, Integer.valueOf(i3)})) == null) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            if (i4 != i3 + 4) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (charArray[i] > 127) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                return str;
            }
            return a(str);
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.contains("?")) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("&");
                sb.append(str2.substring(1));
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str2);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    StringBuilder sb = new StringBuilder();
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        sb.append(next);
                        sb.append("=");
                        sb.append(jSONObject.get(next));
                        sb.append("&");
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            try {
                Uri.Builder builder = new Uri.Builder();
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        builder.appendQueryParameter(next, jSONObject.get(next).toString());
                    }
                }
                return builder.build().toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
