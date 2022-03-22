package com.baidu.android.common.security;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bArr, str)) == null) {
            PrivateKey generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePrivate);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] decryptByPublicKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, str)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePublic);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] decryptLongByPrivateKey(byte[] bArr, String str, int i) throws Exception {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, bArr, str, i)) == null) {
            PrivateKey generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, generatePrivate);
            int i2 = i / 8;
            StringBuilder sb = new StringBuilder();
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = length - i3;
                if (i2 < i4) {
                    i4 = i2;
                }
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i3, bArr2, 0, i4);
                i3 += i4;
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
            PrivateKey generatePrivate = KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePrivate);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] encryptByPublicKey(byte[] bArr, String str) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bArr, str)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] encryptLongByPublicKey(byte[] bArr, String str, int i) throws Exception {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, bArr, str, i)) == null) {
            PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, generatePublic);
            int i2 = i / 8;
            int i3 = i2 - 11;
            int length = bArr.length;
            byte[] bArr2 = new byte[(((length + i3) - 1) / i3) * i2];
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = length - i4;
                if (i3 < i6) {
                    i6 = i3;
                }
                byte[] bArr3 = new byte[i6];
                System.arraycopy(bArr, i4, bArr3, 0, i6);
                i4 += i6;
                System.arraycopy(cipher.doFinal(bArr3), 0, bArr2, i5, i2);
                i5 += i2;
            }
            return bArr2;
        }
        return (byte[]) invokeLLI.objValue;
    }

    public static Map<String, Object> generateKey(int i) throws NoSuchAlgorithmException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
            keyPairGenerator.initialize(i);
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
                    return (RSAPrivateKey) KeyFactory.getInstance(ALGORITHM_RSA).generatePrivate(new RSAPrivateKeySpec(bigInteger, bigInteger2));
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
                    return (RSAPublicKey) KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new RSAPublicKeySpec(bigInteger, bigInteger2));
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, map)) == null) ? Base64.encode(((Key) map.get(PRIVATE_KEY)).getEncoded(), IMAudioTransRequest.CHARSET) : (String) invokeL.objValue;
    }

    public static String getPublicKey(Map<String, Object> map) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) ? Base64.encode(((Key) map.get(PUBLIC_KEY)).getEncoded(), IMAudioTransRequest.CHARSET) : (String) invokeL.objValue;
    }
}
