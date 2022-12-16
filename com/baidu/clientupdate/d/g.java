package com.baidu.clientupdate.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1147890124, "Lcom/baidu/clientupdate/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1147890124, "Lcom/baidu/clientupdate/d/g;");
                return;
            }
        }
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) ? a(file, 131072) : (String) invokeL.objValue;
    }

    public static String a(File file, int i) {
        MessageDigest messageDigest;
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65538, null, file, i)) != null) {
            return (String) invokeLI.objValue;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read <= 0) {
                fileInputStream.close();
                try {
                    return a(messageDigest.digest());
                } catch (Exception e) {
                    throw new IOException(e.toString());
                }
            }
            messageDigest.update(bArr, 0, read);
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) ? a(bArr, 0, bArr.length) : (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            StringBuffer stringBuffer = new StringBuffer(i2 * 2);
            int i3 = i2 + i;
            while (i < i3) {
                a(bArr[i], stringBuffer);
                i++;
            }
            return stringBuffer.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static void a(byte b, StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Byte.valueOf(b), stringBuffer}) == null) {
            char[] cArr = a;
            char c = cArr[(b & 240) >> 4];
            char c2 = cArr[b & 15];
            stringBuffer.append(c);
            stringBuffer.append(c2);
        }
    }
}
