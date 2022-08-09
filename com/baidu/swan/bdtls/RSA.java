package com.baidu.swan.bdtls;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.StandardCharsets;
@Keep
/* loaded from: classes3.dex */
public class RSA {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RSA() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Keep
    public static native byte[] decrypt(byte[] bArr);

    @Keep
    public static native byte[] encrypt(byte[] bArr);

    @Keep
    public static native byte[] privateDecrypt(byte[] bArr);

    @Keep
    public static native byte[] privateEncrypt(byte[] bArr);

    public static String privateKeyDecrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr == null || bArr.length < 1) {
                return "null content";
            }
            byte[] privateDecrypt = privateDecrypt(bArr);
            return (privateDecrypt == null || privateDecrypt.length < 1) ? "result is null" : new String(privateDecrypt, StandardCharsets.UTF_8);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] privateKeyEncrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] privateEncrypt = privateEncrypt(str.getBytes(StandardCharsets.UTF_8));
            return (privateEncrypt == null || privateEncrypt.length < 1) ? new byte[]{-1} : privateEncrypt;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String rsaDecrypt(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (bArr == null || bArr.length < 1) {
                return "null content";
            }
            byte[] decrypt = decrypt(bArr);
            return (decrypt == null || decrypt.length < 1) ? "result is null" : new String(decrypt, StandardCharsets.UTF_8);
        }
        return (String) invokeL.objValue;
    }

    public static byte[] rsaEncrypt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return encrypt(str.getBytes(StandardCharsets.UTF_8));
        }
        return (byte[]) invokeL.objValue;
    }
}
