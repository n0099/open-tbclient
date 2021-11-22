package com.baidu.mobstat.dxmpay;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a(int i2, byte[] bArr) throws Exception {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, bArr)) == null) {
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    String[] strArr = r.f42424a;
                    if (strArr.length > i3) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), "AES");
                        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                        cipher.init(1, secretKeySpec);
                        return cipher.doFinal(bArr);
                    }
                }
                return new byte[0];
            }
            return (byte[]) invokeIL.objValue;
        }

        public static byte[] b(int i2, byte[] bArr) throws Exception {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, bArr)) == null) {
                int i3 = i2 - 1;
                if (i3 >= 0) {
                    String[] strArr = r.f42424a;
                    if (strArr.length > i3) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), "AES");
                        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                        cipher.init(2, secretKeySpec);
                        return cipher.doFinal(bArr);
                    }
                }
                return new byte[0];
            }
            return (byte[]) invokeIL.objValue;
        }

        public static String c(int i2, byte[] bArr) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, bArr)) == null) {
                try {
                    return p.b(a(i2, bArr));
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @SuppressLint({"TrulyRandom"})
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bArr, bArr2, bArr3)) == null) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr3);
            }
            return (byte[]) invokeLLL.objValue;
        }

        public static byte[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                return bArr;
            }
            return (byte[]) invokeV.objValue;
        }

        public static byte[] a() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128, new SecureRandom());
                return keyGenerator.generateKey().getEncoded();
            }
            return (byte[]) invokeV.objValue;
        }
    }
}
