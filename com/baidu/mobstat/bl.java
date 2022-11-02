package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.retrieve.file.util.AESUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class bl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                try {
                    return b(a(), b(), bArr);
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }

        public static byte[] a() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128, new SecureRandom());
                return keyGenerator.generateKey().getEncoded();
            }
            return (byte[]) invokeV.objValue;
        }

        public static byte[] b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                byte[] bArr = new byte[16];
                new SecureRandom().nextBytes(bArr);
                return bArr;
            }
            return (byte[]) invokeV.objValue;
        }

        @SuppressLint({"TrulyRandom"})
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, bArr, bArr2, bArr3)) == null) {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr3);
            }
            return (byte[]) invokeLLL.objValue;
        }

        public static String b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, bArr, bArr2, bArr3)) == null) {
                try {
                    byte[] a = a(bArr, bArr2, br.a(bArr3));
                    return bo.b(a) + "|" + bv.a(bArr) + "|" + bv.a(bArr2);
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeLLL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static byte[] a(int i, byte[] bArr) throws Exception {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, bArr)) == null) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    String[] strArr = bq.a;
                    if (strArr.length > i2) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i2].getBytes(), "AES");
                        Cipher cipher = Cipher.getInstance(AESUtil.ECB_TRANSFORMATION);
                        cipher.init(1, secretKeySpec);
                        return cipher.doFinal(bArr);
                    }
                }
                return new byte[0];
            }
            return (byte[]) invokeIL.objValue;
        }

        public static byte[] b(int i, byte[] bArr) throws Exception {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, bArr)) == null) {
                int i2 = i - 1;
                if (i2 >= 0) {
                    String[] strArr = bq.a;
                    if (strArr.length > i2) {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i2].getBytes(), "AES");
                        Cipher cipher = Cipher.getInstance(AESUtil.ECB_TRANSFORMATION);
                        cipher.init(2, secretKeySpec);
                        return cipher.doFinal(bArr);
                    }
                }
                return new byte[0];
            }
            return (byte[]) invokeIL.objValue;
        }

        public static String d(int i, byte[] bArr) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, bArr)) == null) {
                String c = c(i, bArr);
                if (TextUtils.isEmpty(c)) {
                    return "";
                }
                return c + "|" + i;
            }
            return (String) invokeIL.objValue;
        }

        public static String c(int i, byte[] bArr) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, bArr)) == null) {
                try {
                    return bo.b(a(i, bArr));
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeIL.objValue;
        }
    }
}
