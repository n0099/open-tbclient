package com.alipay.security.mobile.module.a.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f2059a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-228193682, "Lcom/alipay/security/mobile/module/a/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-228193682, "Lcom/alipay/security/mobile/module/a/a/c;");
                return;
            }
        }
        f2059a = new String("idnjfhncnsfuobcnt847y929o449u474w7j3h22aoddc98euk#%&&)*&^%#");
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = new String();
            for (int i2 = 0; i2 < f2059a.length() - 1; i2 += 4) {
                str = str + f2059a.charAt(i2);
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
                try {
                    PBEKeySpec a2 = a(str);
                    byte[] bytes = str2.getBytes();
                    SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(a2).getEncoded(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                    byte[] salt = a2.getSalt();
                    ByteBuffer allocate = ByteBuffer.allocate(salt.length + cipher.getOutputSize(bytes.length));
                    allocate.put(salt);
                    cipher.doFinal(ByteBuffer.wrap(bytes), allocate);
                    return b(allocate.array());
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return b(a(a(str.getBytes()), str2.getBytes()));
            }
        }
        return (String) invokeLL.objValue;
    }

    public static PBEKeySpec a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            Class<?> cls = Class.forName(new String(a.a("amF2YS5zZWN1cml0eS5TZWN1cmVSYW5kb20=")));
            Object invoke = cls.getMethod("getInstance", String.class, String.class).invoke(null, "SHA1PRNG", "Crypto");
            Method method = cls.getMethod("setSeed", bArr.getClass());
            method.setAccessible(true);
            method.invoke(invoke, bArr);
            KeyGenerator.class.getMethod("init", Integer.TYPE, cls).invoke(keyGenerator, 128, invoke);
            return keyGenerator.generateKey().getEncoded();
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, bArr2)) == null) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                return cipher.doFinal(bArr2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        byte[] doFinal;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            try {
                PBEKeySpec a2 = a(str);
                byte[] b2 = b(str2);
                if (b2.length <= 16) {
                    doFinal = null;
                } else {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(a2.getPassword(), Arrays.copyOf(b2, 16), 10, 128)).getEncoded(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
                    doFinal = cipher.doFinal(b2, 16, b2.length - 16);
                }
            } catch (Exception unused) {
            }
            if (doFinal != null) {
                String str4 = new String(doFinal);
                if (com.alipay.security.mobile.module.a.a.c(str4)) {
                    return str4;
                }
                try {
                    byte[] a3 = a(str.getBytes());
                    byte[] b3 = b(str2);
                    SecretKeySpec secretKeySpec2 = new SecretKeySpec(a3, "AES");
                    Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher2.init(2, secretKeySpec2, new IvParameterSpec(new byte[cipher2.getBlockSize()]));
                    str3 = new String(cipher2.doFinal(b3));
                } catch (Exception unused2) {
                }
                if (com.alipay.security.mobile.module.a.a.c(str3)) {
                    return str3;
                }
                return null;
            }
            throw new Exception();
        }
        return (String) invokeLL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
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

    public static byte[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
