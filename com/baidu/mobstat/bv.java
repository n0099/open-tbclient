package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes2.dex */
public class bv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            try {
                return bo.b(a(false, bq.a(), bArr));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static RSAKey a(boolean z, byte[] bArr) throws Exception {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, null, z, bArr)) == null) {
            KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
            if (z) {
                return (RSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr));
            }
            return (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(bArr));
        }
        return (RSAKey) invokeZL.objValue;
    }

    public static byte[] a(int i, Key key, int i2, byte[] bArr) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), key, Integer.valueOf(i2), bArr})) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(i, key);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (i3 < bArr.length) {
                int length = bArr.length - i3;
                if (length > i2) {
                    length = i2;
                }
                byteArrayOutputStream.write(cipher.doFinal(bArr, i3, length));
                i3 += i2;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] a(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), bArr, bArr2})) == null) {
            RSAKey a = a(z, bArr);
            return a(1, (Key) a, ((a.getModulus().bitLength() + 1) / 8) - 11, bArr2);
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] b(boolean z, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), bArr, bArr2})) == null) {
            RSAKey a = a(z, bArr);
            return a(2, (Key) a, (a.getModulus().bitLength() + 1) / 8, bArr2);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
