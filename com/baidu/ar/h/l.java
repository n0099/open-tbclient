package com.baidu.ar.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static char[] ye;
    public static MessageDigest yf;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1921142950, "Lcom/baidu/ar/h/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1921142950, "Lcom/baidu/ar/h/l;");
                return;
            }
        }
        ye = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            yf = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            PrintStream printStream = System.err;
            printStream.println(l.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e2.printStackTrace();
        }
    }

    public l() {
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

    public static void a(byte b2, StringBuffer stringBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), stringBuffer}) == null) {
            char[] cArr = ye;
            char c2 = cArr[(b2 & 240) >> 4];
            char c3 = cArr[b2 & 15];
            stringBuffer.append(c2);
            stringBuffer.append(c3);
        }
    }

    public static synchronized String aT(String str) {
        InterceptResult invokeL;
        String h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (l.class) {
                h2 = h(str.getBytes(Charset.forName("utf-8")));
            }
            return h2;
        }
        return (String) invokeL.objValue;
    }

    public static String aU(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[charArray.length];
                for (int i2 = 0; i2 < charArray.length; i2++) {
                    bArr[i2] = (byte) charArray[i2];
                }
                byte[] digest = messageDigest.digest(bArr);
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    int i3 = b2 & 255;
                    if (i3 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i3));
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bArr, i2, i3)) == null) {
            StringBuffer stringBuffer = new StringBuffer(i3 * 2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                a(bArr[i2], stringBuffer);
                i2++;
            }
            return stringBuffer.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static String h(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            yf.update(bArr);
            return i(yf.digest());
        }
        return (String) invokeL.objValue;
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) ? e(bArr, 0, bArr.length) : (String) invokeL.objValue;
    }
}
