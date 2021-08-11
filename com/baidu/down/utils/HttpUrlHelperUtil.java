package com.baidu.down.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLEncoder;
import java.util.Locale;
/* loaded from: classes5.dex */
public class HttpUrlHelperUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] DIGITS;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1713595935, "Lcom/baidu/down/utils/HttpUrlHelperUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1713595935, "Lcom/baidu/down/utils/HttpUrlHelperUtil;");
                return;
            }
        }
        DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, com.baidu.android.imsdk.internal.Constants.SHORT_PING_CMD_TYPE, 102};
    }

    public HttpUrlHelperUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int decodeHexDigit(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c2)})) == null) {
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
        return invokeCommon.intValue;
    }

    public static int delimiterOffset(String str, int i2, int i3, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), str2})) == null) {
            while (i2 < i3) {
                if (str2.indexOf(str.charAt(i2)) != -1) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }

    public static String domainToAscii(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i2, i3)) == null) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i2, i3)) == null) {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                char charAt = str.charAt(i4);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i4 + 1;
                }
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static String writeByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) ? new String(new byte[]{(byte) i2}) : (String) invokeI.objValue;
    }

    public static String writeHexadecimalUnsignedLong(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j2)) == null) {
            if (j2 == 0) {
                return writeByte(48);
            }
            int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
            byte[] bArr = new byte[numberOfTrailingZeros];
            for (int i2 = numberOfTrailingZeros - 1; i2 >= 0; i2--) {
                bArr[i2] = DIGITS[(int) (15 & j2)];
                j2 >>>= 4;
            }
            try {
                return URLEncoder.encode(new String(bArr), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String writeUtf8CodePoint(int i2) {
        InterceptResult invokeI;
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 < 128) {
                bArr2 = new byte[]{(byte) i2};
            } else {
                if (i2 < 2048) {
                    bArr = new byte[]{(byte) ((i2 >> 6) | 192), (byte) ((i2 & 63) | 128)};
                } else if (i2 < 65536) {
                    if (i2 >= 55296 && i2 <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                    }
                    bArr = new byte[]{(byte) ((i2 >> 12) | 224), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
                } else if (i2 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                } else {
                    bArr = new byte[]{(byte) ((i2 >> 18) | 240), (byte) (((i2 >> 12) & 63) | 128), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
                }
                bArr2 = bArr;
            }
            return new String(bArr2);
        }
        return (String) invokeI.objValue;
    }

    public static byte[] writeUtf8CodePoint2(int i2) {
        InterceptResult invokeI;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            if (i2 < 128) {
                return new byte[]{(byte) i2};
            }
            if (i2 < 2048) {
                bArr = new byte[]{(byte) ((i2 >> 6) | 192), (byte) ((i2 & 63) | 128)};
            } else if (i2 < 65536) {
                if (i2 >= 55296 && i2 <= 57343) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
                }
                bArr = new byte[]{(byte) ((i2 >> 12) | 224), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
            } else if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            } else {
                bArr = new byte[]{(byte) ((i2 >> 18) | 240), (byte) (((i2 >> 12) & 63) | 128), (byte) (((i2 >> 6) & 63) | 128), (byte) ((i2 & 63) | 128)};
            }
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public static int delimiterOffset(String str, int i2, int i3, char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(c2)})) == null) {
            while (i2 < i3) {
                if (str.charAt(i2) == c2) {
                    return i2;
                }
                i2++;
            }
            return i3;
        }
        return invokeCommon.intValue;
    }
}
