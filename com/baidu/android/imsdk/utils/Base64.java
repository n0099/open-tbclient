package com.baidu.android.imsdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
/* loaded from: classes.dex */
public class Base64 {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] legalChars;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797414361, "Lcom/baidu/android/imsdk/utils/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-797414361, "Lcom/baidu/android/imsdk/utils/Base64;");
                return;
            }
        }
        legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    }

    public Base64() {
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

    public static int decode(char c2) throws RuntimeException {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < 'A' || c2 > 'Z') {
                if (c2 >= 'a' && c2 <= 'z') {
                    i2 = c2 - 'a';
                } else if (c2 < '0' || c2 > '9') {
                    if (c2 != '+') {
                        if (c2 != '/') {
                            if (c2 == '=') {
                                return 0;
                            }
                            throw new RuntimeException("unexpected code: " + c2);
                        }
                        return 63;
                    }
                    return 62;
                } else {
                    i2 = (c2 - '0') + 26;
                }
                return i2 + 26;
            }
            return c2 - 'A';
        }
        return invokeCommon.intValue;
    }

    public static String encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            int length = bArr.length;
            StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
            int i2 = length - 3;
            int i3 = 0;
            loop0: while (true) {
                int i4 = 0;
                while (i3 <= i2) {
                    int i5 = ((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8) | (bArr[i3 + 2] & 255);
                    stringBuffer.append(legalChars[(i5 >> 18) & 63]);
                    stringBuffer.append(legalChars[(i5 >> 12) & 63]);
                    stringBuffer.append(legalChars[(i5 >> 6) & 63]);
                    stringBuffer.append(legalChars[i5 & 63]);
                    i3 += 3;
                    int i6 = i4 + 1;
                    if (i4 >= 14) {
                        break;
                    }
                    i4 = i6;
                }
                stringBuffer.append(" ");
            }
            int i7 = 0 + length;
            if (i3 == i7 - 2) {
                int i8 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
                stringBuffer.append(legalChars[(i8 >> 18) & 63]);
                stringBuffer.append(legalChars[(i8 >> 12) & 63]);
                stringBuffer.append(legalChars[(i8 >> 6) & 63]);
                stringBuffer.append("=");
            } else if (i3 == i7 - 1) {
                int i9 = (bArr[i3] & 255) << 16;
                stringBuffer.append(legalChars[(i9 >> 18) & 63]);
                stringBuffer.append(legalChars[(i9 >> 12) & 63]);
                stringBuffer.append("==");
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                decode(str, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    PrintStream printStream = System.err;
                    printStream.println("Error while decoding BASE64: " + e2.toString());
                }
                return byteArray;
            } catch (IOException unused) {
                throw new RuntimeException();
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static void decode(String str, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, str, outputStream) != null) {
            return;
        }
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 < length && str.charAt(i2) <= ' ') {
                i2++;
            } else if (i2 == length) {
                return;
            } else {
                int i3 = i2 + 2;
                int i4 = i2 + 3;
                int decode = (decode(str.charAt(i2)) << 18) + (decode(str.charAt(i2 + 1)) << 12) + (decode(str.charAt(i3)) << 6) + decode(str.charAt(i4));
                outputStream.write((decode >> 16) & 255);
                if (str.charAt(i3) == '=') {
                    return;
                }
                outputStream.write((decode >> 8) & 255);
                if (str.charAt(i4) == '=') {
                    return;
                }
                outputStream.write(decode & 255);
                i2 += 4;
            }
        }
    }
}
