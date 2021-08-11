package com.baidu.android.common.security;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
/* loaded from: classes4.dex */
public final class RSAUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALGORITHM_RSA = "RSA";
    public static final int BYTE_IN_BITS = 8;
    public static final String PRIVATE_KEY = "PrivateKey";
    public static final int PT_MAXLEN_OFFSET = 11;
    public static final String PUBLIC_KEY = "PublicKey";
    public transient /* synthetic */ FieldHolder $fh;

    public RSAUtil() {
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

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, str)) == null) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(2, generatePrivate);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(2, generatePublic);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] decryptLongByPrivateKey(byte[] bArr, String str, int i2) throws Exception {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, bArr, str, i2)) == null) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(2, generatePrivate);
            int i3 = i2 / 8;
            StringBuilder sb = new StringBuilder();
            int length = bArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = length - i4;
                if (i3 < i5) {
                    i5 = i3;
                }
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, i4, bArr2, 0, i5);
                i4 += i5;
                sb.append(new String(cipher.doFinal(bArr2)));
            }
            return sb.toString().getBytes();
        }
        return (byte[]) invokeLLI.objValue;
    }

    public static byte[] encryptByPrivateKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str)) == null) {
            PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(1, generatePrivate);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, str)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(1, generatePublic);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] encryptLongByPublicKey(byte[] bArr, String str, int i2) throws Exception {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, bArr, str, i2)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
            cipher.init(1, generatePublic);
            int i3 = i2 / 8;
            int i4 = i3 - 11;
            int length = bArr.length;
            byte[] bArr2 = new byte[(((length + i4) - 1) / i4) * i3];
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = length - i5;
                if (i4 < i7) {
                    i7 = i4;
                }
                byte[] bArr3 = new byte[i7];
                System.arraycopy(bArr, i5, bArr3, 0, i7);
                i5 += i7;
                System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, i6, i3);
                i6 += i3;
            }
            return bArr2;
        }
        return (byte[]) invokeLLI.objValue;
    }

    public static Map<String, Object> generateKey(int i2) throws NoSuchAlgorithmException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(i2);
            KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
            HashMap hashMap = new HashMap(2);
            hashMap.put(PUBLIC_KEY, (RSAPublicKey) generateKeyPair.getPublic());
            hashMap.put(PRIVATE_KEY, (RSAPrivateKey) generateKeyPair.getPrivate());
            return hashMap;
        }
        return (Map) invokeI.objValue;
    }

    public static RSAPrivateKey generateRSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, bigInteger, bigInteger2)) == null) {
            try {
                try {
                    return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
                } catch (InvalidKeySpecException e2) {
                    throw new Exception(e2.getMessage());
                }
            } catch (NoSuchAlgorithmException e3) {
                throw new Exception(e3.getMessage());
            }
        }
        return (RSAPrivateKey) invokeLL.objValue;
    }

    public static RSAPublicKey generateRSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bigInteger, bigInteger2)) == null) {
            try {
                try {
                    return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
                } catch (InvalidKeySpecException e2) {
                    throw new Exception(e2.getMessage());
                }
            } catch (NoSuchAlgorithmException e3) {
                throw new Exception(e3.getMessage());
            }
        }
        return (RSAPublicKey) invokeLL.objValue;
    }

    public static String getPrivateKey(Map<String, Object> map) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, map)) == null) ? Base64.encode(((Key) map.get(PRIVATE_KEY)).getEncoded(), "utf-8") : (String) invokeL.objValue;
    }

    public static String getPublicKey(Map<String, Object> map) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) ? Base64.encode(((Key) map.get(PUBLIC_KEY)).getEncoded(), "utf-8") : (String) invokeL.objValue;
    }
}
