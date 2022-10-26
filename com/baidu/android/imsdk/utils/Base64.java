package com.baidu.android.imsdk.utils;

import androidx.core.view.InputDeviceCompat;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int decode(char c) throws RuntimeException {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Character.valueOf(c)})) == null) {
            if (c >= 'A' && c <= 'Z') {
                return c - 'A';
            }
            if (c >= 'a' && c <= 'z') {
                i = c - 'a';
            } else if (c >= '0' && c <= '9') {
                i = (c - '0') + 26;
            } else if (c != '+') {
                if (c != '/') {
                    if (c == '=') {
                        return 0;
                    }
                    throw new RuntimeException("unexpected code: " + c);
                }
                return 63;
            } else {
                return 62;
            }
            return i + 26;
        }
        return invokeCommon.intValue;
    }

    public static void decode(String str, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, outputStream) == null) {
            int length = str.length();
            int i = 0;
            while (true) {
                if (i < length && str.charAt(i) <= ' ') {
                    i++;
                } else if (i != length) {
                    int i2 = i + 2;
                    int i3 = i + 3;
                    int decode = (decode(str.charAt(i)) << 18) + (decode(str.charAt(i + 1)) << 12) + (decode(str.charAt(i2)) << 6) + decode(str.charAt(i3));
                    outputStream.write((decode >> 16) & 255);
                    if (str.charAt(i2) != '=') {
                        outputStream.write((decode >> 8) & 255);
                        if (str.charAt(i3) == '=') {
                            return;
                        }
                        outputStream.write(decode & 255);
                        i += 4;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
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
                } catch (IOException e) {
                    PrintStream printStream = System.err;
                    printStream.println("Error while decoding BASE64: " + e.toString());
                }
                return byteArray;
            } catch (IOException unused) {
                throw new RuntimeException();
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            int length = bArr.length;
            StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
            int i = length - 3;
            int i2 = 0;
            loop0: while (true) {
                int i3 = 0;
                while (i2 <= i) {
                    int i4 = ((bArr[i2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8) | (bArr[i2 + 2] & 255);
                    stringBuffer.append(legalChars[(i4 >> 18) & 63]);
                    stringBuffer.append(legalChars[(i4 >> 12) & 63]);
                    stringBuffer.append(legalChars[(i4 >> 6) & 63]);
                    stringBuffer.append(legalChars[i4 & 63]);
                    i2 += 3;
                    int i5 = i3 + 1;
                    if (i3 >= 14) {
                        break;
                    }
                    i3 = i5;
                }
                stringBuffer.append(" ");
            }
            int i6 = 0 + length;
            if (i2 == i6 - 2) {
                int i7 = ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2] & 255) << 16);
                stringBuffer.append(legalChars[(i7 >> 18) & 63]);
                stringBuffer.append(legalChars[(i7 >> 12) & 63]);
                stringBuffer.append(legalChars[(i7 >> 6) & 63]);
                stringBuffer.append("=");
            } else if (i2 == i6 - 1) {
                int i8 = (bArr[i2] & 255) << 16;
                stringBuffer.append(legalChars[(i8 >> 18) & 63]);
                stringBuffer.append(legalChars[(i8 >> 12) & 63]);
                stringBuffer.append("==");
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
