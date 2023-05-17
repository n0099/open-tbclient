package com.baidu.down.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLEncoder;
import java.util.Locale;
/* loaded from: classes3.dex */
public class HttpUrlHelperUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] DIGITS;
    public transient /* synthetic */ FieldHolder $fh;

    public static int decodeHexDigit(char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Character.valueOf(c)})) == null) {
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
            return c - TransactionIdCreater.FILL_BYTE;
        }
        return invokeCommon.intValue;
    }

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean containsInvalidHostnameAsciiCodes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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

    public static int delimiterOffset(String str, int i, int i2, char c) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Character.valueOf(c)})) == null) {
            while (i < i2) {
                if (str.charAt(i) == c) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static int delimiterOffset(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            while (i < i2) {
                if (str2.indexOf(str.charAt(i)) != -1) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public static String domainToAscii(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
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

    public static String writeByte(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            return new String(new byte[]{(byte) i});
        }
        return (String) invokeI.objValue;
    }

    public static int skipLeadingAsciiWhitespace(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, str, i, i2)) == null) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    public static int skipTrailingAsciiWhitespace(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, str, i, i2)) == null) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }
        return invokeLII.intValue;
    }

    public static String writeHexadecimalUnsignedLong(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65546, null, j)) == null) {
            if (j == 0) {
                return writeByte(48);
            }
            int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
            byte[] bArr = new byte[numberOfTrailingZeros];
            for (int i = numberOfTrailingZeros - 1; i >= 0; i--) {
                bArr[i] = DIGITS[(int) (15 & j)];
                j >>>= 4;
            }
            try {
                return URLEncoder.encode(new String(bArr), IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeJ.objValue;
    }

    public static String writeUtf8CodePoint(int i) {
        InterceptResult invokeI;
        byte[] bArr;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i < 128) {
                bArr2 = new byte[]{(byte) i};
            } else {
                if (i < 2048) {
                    bArr = new byte[]{(byte) ((i >> 6) | 192), (byte) ((i & 63) | 128)};
                } else if (i < 65536) {
                    if (i >= 55296 && i <= 57343) {
                        throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                    }
                    bArr = new byte[]{(byte) ((i >> 12) | 224), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
                } else if (i > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                } else {
                    bArr = new byte[]{(byte) ((i >> 18) | 240), (byte) (((i >> 12) & 63) | 128), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
                }
                bArr2 = bArr;
            }
            return new String(bArr2);
        }
        return (String) invokeI.objValue;
    }

    public static byte[] writeUtf8CodePoint2(int i) {
        InterceptResult invokeI;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if (i < 128) {
                return new byte[]{(byte) i};
            }
            if (i < 2048) {
                bArr = new byte[]{(byte) ((i >> 6) | 192), (byte) ((i & 63) | 128)};
            } else if (i < 65536) {
                if (i >= 55296 && i <= 57343) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
                }
                bArr = new byte[]{(byte) ((i >> 12) | 224), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
            } else if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            } else {
                bArr = new byte[]{(byte) ((i >> 18) | 240), (byte) (((i >> 12) & 63) | 128), (byte) (((i >> 6) & 63) | 128), (byte) ((i & 63) | 128)};
            }
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }
}
