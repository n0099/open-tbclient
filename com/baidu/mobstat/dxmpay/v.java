package com.baidu.mobstat.dxmpay;

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
/* loaded from: classes4.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            try {
                return p.b(a(false, r.a(), bArr));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
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

    public static RSAKey a(boolean z, byte[] bArr) throws Exception {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65537, null, z, bArr)) == null) {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            if (z) {
                return (RSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr));
            }
            return (RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(bArr));
        }
        return (RSAKey) invokeZL.objValue;
    }

    public static byte[] a(int i2, Key key, int i3, byte[] bArr) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), key, Integer.valueOf(i3), bArr})) == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(i2, key);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i4 = 0;
            while (i4 < bArr.length) {
                int length = bArr.length - i4;
                if (length > i3) {
                    length = i3;
                }
                byteArrayOutputStream.write(cipher.doFinal(bArr, i4, length));
                i4 += i3;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeCommon.objValue;
    }
}
