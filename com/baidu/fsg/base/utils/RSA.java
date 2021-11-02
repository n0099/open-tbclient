package com.baidu.fsg.base.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes7.dex */
public class RSA {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37598a = "RSA";
    public transient /* synthetic */ FieldHolder $fh;

    public RSA() {
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

    public static PrivateKey a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (PrivateKey) invokeL.objValue;
    }

    public static byte[] a(PrivateKey privateKey, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, privateKey, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(2, privateKey);
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] a(PublicKey publicKey, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, publicKey, bArr)) == null) {
            try {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static PublicKey b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            try {
                return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (PublicKey) invokeL.objValue;
    }
}
