package com.baidu.fsg.base.utils;

import android.os.Build;
import android.util.Base64;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class Crypto {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f5354a = 16;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5355b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5356c = 128;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5357d = 64;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5358e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5359f = 1000;

    /* renamed from: g  reason: collision with root package name */
    public static SecureRandom f5360g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1135743201, "Lcom/baidu/fsg/base/utils/Crypto;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1135743201, "Lcom/baidu/fsg/base/utils/Crypto;");
                return;
            }
        }
        f5360g = new SecureRandom();
    }

    public Crypto() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static byte[] a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65540, null, i2)) == null) {
            byte[] bArr = new byte[i2];
            f5360g.nextBytes(bArr);
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public static byte[] aesDecrypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bArr, str)) == null) {
            if (bArr == null || bArr.length < 24) {
                return null;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 8);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 8, 24);
            SecretKey a2 = a(str, copyOf);
            if (a2 == null) {
                return null;
            }
            try {
                Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
                cipher.init(2, a2, new IvParameterSpec(copyOfRange));
                int length = copyOf.length + copyOfRange.length;
                return cipher.doFinal(bArr, length, bArr.length - length);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] aesEncrypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bArr, str)) == null) {
            byte[] a2 = a(8);
            SecretKey a3 = a(str, a2);
            if (a3 == null) {
                return null;
            }
            try {
                Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
                cipher.init(1, a3);
                return a(a2, cipher.getIV(), cipher.doFinal(bArr));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static SecretKey b(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, bArr)) == null) {
            if (str == null) {
                str = "";
            }
            try {
                return new SecretKeySpec(SecretKeyFactory.getInstance(a()).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 64)).getEncoded(), Coder.KEY_DES);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (SecretKey) invokeLL.objValue;
    }

    public static byte[] desDecrypt(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, bArr, str)) == null) {
            if (bArr == null || bArr.length < 16) {
                return null;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 8);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 8, 16);
            SecretKey b2 = b(str, copyOf);
            if (b2 == null) {
                return null;
            }
            try {
                Cipher cipher = Cipher.getInstance("DES/CTR/NoPadding");
                cipher.init(2, b2, new IvParameterSpec(copyOfRange));
                int length = copyOf.length + copyOfRange.length;
                return cipher.doFinal(bArr, length, bArr.length - length);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] desEncrypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, bArr, str)) == null) {
            byte[] a2 = a(8);
            SecretKey b2 = b(str, a2);
            try {
                Cipher cipher = Cipher.getInstance("DES/CTR/NoPadding");
                cipher.init(1, b2);
                return a(a2, cipher.getIV(), cipher.doFinal(bArr));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] rsaDecrypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bArr, str)) == null) ? RSA.a(RSA.b(Base64.decode(str, 2)), bArr) : (byte[]) invokeLL.objValue;
    }

    public static byte[] rsaEncrypt(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, bArr, str)) == null) ? RSA.a(RSA.a(Base64.decode(str, 2)), bArr) : (byte[]) invokeLL.objValue;
    }

    public static String sha1(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, bArr)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        stringBuffer.append(0);
                    }
                    stringBuffer.append(hexString);
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.VERSION.SDK_INT >= 19 ? "PBKDF2WithHmacSHA1And8bit" : "PBKDF2withHmacSHA1" : (String) invokeV.objValue;
    }

    public static SecretKey a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bArr)) == null) {
            if (str == null) {
                str = "";
            }
            try {
                return new SecretKeySpec(SecretKeyFactory.getInstance(a()).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 128)).getEncoded(), "AES");
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (SecretKey) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, bArr2)) == null) {
            if (bArr == null) {
                return bArr2;
            }
            if (bArr2 == null) {
                return bArr;
            }
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String sha1(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(str.getBytes());
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        stringBuffer.append(0);
                    }
                    stringBuffer.append(hexString);
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, bArr, bArr2, bArr3)) == null) {
            if (bArr == null) {
                return a(bArr2, bArr3);
            }
            if (bArr2 == null) {
                return a(bArr, bArr3);
            }
            if (bArr3 == null) {
                return a(bArr, bArr2);
            }
            byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
            System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
            return bArr4;
        }
        return (byte[]) invokeLLL.objValue;
    }
}
