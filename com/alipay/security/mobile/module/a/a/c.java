package com.alipay.security.mobile.module.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-228193682, "Lcom/alipay/security/mobile/module/a/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-228193682, "Lcom/alipay/security/mobile/module/a/a/c;");
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = new String();
            for (int i2 = 0; i2 < a.length() - 1; i2 += 4) {
                str = str + a.charAt(i2);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                PBEKeySpec a2 = a(str);
                byte[] bytes = str2.getBytes();
                byte[] b2 = b();
                SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(a2).getEncoded(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec(b2));
                byte[] salt = a2.getSalt();
                ByteBuffer allocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
                allocate.put(salt);
                cipher.doFinal(ByteBuffer.wrap(bytes), allocate);
                return a(allocate.array());
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
            for (byte b2 : bArr) {
                stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
                stringBuffer.append("0123456789ABCDEF".charAt(b2 & 15));
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static PBEKeySpec a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
            Object newInstance = cls.newInstance();
            byte[] bArr = new byte[16];
            Method method = cls.getMethod("nextBytes", bArr.getClass());
            method.setAccessible(true);
            method.invoke(newInstance, bArr);
            return new PBEKeySpec(str.toCharArray(), bArr, 10, 128);
        }
        return (PBEKeySpec) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        byte[] doFinal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                PBEKeySpec a2 = a(str);
                int length = str2.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = Integer.valueOf(str2.substring(i3, i3 + 2), 16).byteValue();
                }
                byte[] b2 = b();
                if (length <= 16) {
                    doFinal = null;
                } else {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a2.getPassword(), Arrays.copyOf(bArr, 16), 10, 128)).getEncoded(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, new IvParameterSpec(b2));
                    doFinal = cipher.doFinal(bArr, 16, length - 16);
                }
            } catch (Exception unused) {
            }
            if (doFinal != null) {
                String str3 = new String(doFinal);
                if (com.alipay.security.mobile.module.a.a.c(str3)) {
                    return str3;
                }
                return null;
            }
            throw new Exception();
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < 48; i2 += 2) {
                    sb.append("AsAgAtA5A6AdAgABABACADAfAsAdAfAsAgAaAgA3A5A6=8=0".charAt(i2));
                }
                return a.a(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
