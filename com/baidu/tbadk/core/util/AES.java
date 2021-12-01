package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes9.dex */
public class AES {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ENCODING = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;

    public AES() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String bytesToHex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            int length = bArr.length;
            String str = "";
            for (int i2 = 0; i2 < length; i2++) {
                str = (bArr[i2] & 255) < 16 ? str + "0" + Integer.toHexString(bArr[i2] & 255) : str + Integer.toHexString(bArr[i2] & 255);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bArr, str, str2)) == null) {
            if (bArr != null && bArr.length != 0) {
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes("UTF-8"));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(bArr);
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (NoSuchPaddingException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            throw new Exception("Empty string");
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] encrypt(String str, String str2, String str3) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (str != null && str.length() != 0) {
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(padString(str).getBytes());
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (NoSuchPaddingException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            throw new Exception("Empty string");
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] hexToBytes(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null && str.length() >= 2) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
                }
                return bArr;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String padString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            int length = 16 - (str.length() % 16);
            for (int i2 = 0; i2 < length; i2++) {
                str = str + ' ';
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
