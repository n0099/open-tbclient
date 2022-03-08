package com.baidu.pass.face.platform.utils;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class EncodeUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public EncodeUtil() {
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

    public static String aesDecrypt(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return aesDecryptByBytes(base64Decode(str), str2);
        }
        return (String) invokeLL.objValue;
    }

    public static String aesDecryptByBytes(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, new SecretKeySpec(base64Decode(str), "AES"));
            return new String(cipher.doFinal(bArr));
        }
        return (String) invokeLL.objValue;
    }

    public static String aesEncrypt(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? base64Encode(aesEncryptToBytes(str, str2)) : (String) invokeLL.objValue;
    }

    public static byte[] aesEncryptToBytes(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, new SecretKeySpec(base64Decode(str2), "AES"));
            return cipher.doFinal(str.getBytes("utf-8"));
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] base64Decode(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return Base64.decode(str, 2);
        }
        return (byte[]) invokeL.objValue;
    }

    public static String base64Encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? Base64.encodeToString(bArr, 2) : (String) invokeL.objValue;
    }
}
