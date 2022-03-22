package com.baidu.sofire.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes4.dex */
public class RandomKeyUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static String CHAR_LIST = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2134439330, "Lcom/baidu/sofire/core/RandomKeyUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2134439330, "Lcom/baidu/sofire/core/RandomKeyUtil;");
        }
    }

    public RandomKeyUtil() {
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

    public static String binarytoHexString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int length = bArr.length - 1; length >= 0; length--) {
                int i = (bArr[length] & 255) >> 4;
                sb.append((char) (i < 10 ? i + 48 : (i + 97) - 10));
                int i2 = bArr[length] & 15;
                sb.append((char) (i2 < 10 ? i2 + 48 : (i2 + 97) - 10));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static byte[] getRandomKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            char[] charArray = CHAR_LIST.toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[new Random().nextInt(62)];
            }
            return new String(cArr).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    public static void reverse(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr) == null) {
            int length = bArr.length / 2;
            for (int i = 0; i < length; i++) {
                byte b2 = bArr[i];
                bArr[i] = bArr[(bArr.length - i) - 1];
                bArr[(bArr.length - i) - 1] = b2;
            }
        }
    }

    public static byte[] toByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            String lowerCase = str.toLowerCase();
            int length = lowerCase.length() / 2;
            byte[] bArr = new byte[length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                bArr[i2] = (byte) ((((byte) (Character.digit(lowerCase.charAt(i), 16) & 255)) << 4) | ((byte) (Character.digit(lowerCase.charAt(i + 1), 16) & 255)));
                i += 2;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
