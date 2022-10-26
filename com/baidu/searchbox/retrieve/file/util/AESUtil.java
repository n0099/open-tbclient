package com.baidu.searchbox.retrieve.file.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.GregorianCalendar;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes2.dex */
public class AESUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ALGORITHM_NAME = "AES";
    public static final String CBC_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static final String DEFAULT_KEY_ALIAS = "default";
    public static final String ECB_TRANSFORMATION = "AES/ECB/PKCS5Padding";
    public static final int NORMAL_MODE = 0;
    public static final String SP_KEY = "sk";
    public static final String SP_MODE_KEY = "sk_mode";
    public static final int WRAP_MODE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public KeyPair mPair;
    public SecretKey mSecretKey;
    public String nameSpace;

    /* renamed from: com.baidu.searchbox.retrieve.file.util.AESUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context context;
        public String nameSpace;

        public Builder() {
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

        public Builder setContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                this.context = context.getApplicationContext();
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setNameSpace(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.nameSpace = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public AESUtil build() throws ModeNotMatchException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.context != null) {
                    if (!TextUtils.isEmpty(this.nameSpace)) {
                        return new AESUtil(this, null);
                    }
                    throw new ModeNotMatchException("need package nameSpace");
                }
                throw new ModeNotMatchException("need set appContext");
            }
            return (AESUtil) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class CryptResult {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int FAIL = -1;
        public static final int NOT_INITIALIZED = 1;
        public static final int SUCCESS = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] result;
        public int statusCode;

        public CryptResult() {
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

        public byte[] getResult() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.result;
            }
            return (byte[]) invokeV.objValue;
        }

        public int getStatusCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.statusCode;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class ModeNotMatchException extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public ModeNotMatchException() {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModeNotMatchException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    public AESUtil(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSecretKey = null;
        this.nameSpace = builder.nameSpace;
        Context context = builder.context;
        this.context = context;
        if (context != null) {
            init(context);
        }
    }

    private SecretKey unwrap(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, bArr)) == null) {
            if (this.mPair == null) {
                initKeyPair();
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(4, this.mPair.getPrivate());
            return (SecretKey) cipher.unwrap(bArr, "AES", 3);
        }
        return (SecretKey) invokeL.objValue;
    }

    public /* synthetic */ AESUtil(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static byte[] decryptECB(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(ECB_TRANSFORMATION);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] encryptECB(String str, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(ECB_TRANSFORMATION);
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] decryptCBC(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static byte[] encryptCBC(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    private CryptResult doCrypt(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, bArr, i)) == null) {
            if (i != 2 && i != 1) {
                throw new IllegalArgumentException("mode must be Cipher.DECRYPT_MODE or Cipher.ENCRYPT_MODE");
            }
            CryptResult cryptResult = new CryptResult();
            if (bArr == null) {
                cryptResult.statusCode = -1;
                return cryptResult;
            } else if (this.context != null && !TextUtils.isEmpty(this.nameSpace)) {
                try {
                    Cipher cipher = Cipher.getInstance("AES");
                    cipher.init(i, this.mSecretKey);
                    cryptResult.result = cipher.doFinal(bArr);
                    cryptResult.statusCode = 0;
                } catch (Exception unused) {
                    cryptResult.result = null;
                    cryptResult.statusCode = -1;
                }
                return cryptResult;
            } else {
                cryptResult.statusCode = 1;
                return cryptResult;
            }
        }
        return (CryptResult) invokeLI.objValue;
    }

    private void generateKeyPair(Context context) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
            gregorianCalendar2.add(1, 100);
            if (Build.VERSION.SDK_INT >= 18) {
                KeyPairGeneratorSpec.Builder builder = new KeyPairGeneratorSpec.Builder(context);
                KeyPairGeneratorSpec.Builder alias = builder.setAlias("default" + this.nameSpace);
                KeyPairGeneratorSpec build = alias.setSubject(new X500Principal("C=CN,ST=BJ,L=BJ,O=BaiDu,OU=BaiDu,CN=default" + this.nameSpace)).setSerialNumber(BigInteger.ONE).setStartDate(gregorianCalendar.getTime()).setEndDate(gregorianCalendar2.getTime()).build();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAUtil.ALGORITHM_RSA, "AndroidKeyStore");
                keyPairGenerator.initialize(build);
                keyPairGenerator.generateKeyPair();
            }
        }
    }

    private SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom());
            return keyGenerator.generateKey();
        }
        return (SecretKey) invokeV.objValue;
    }

    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            try {
                if (this.mSecretKey == null) {
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    String string = defaultSharedPreferences.getString("sk_" + this.nameSpace, null);
                    if (string == null) {
                        SecretKey generateSecretKey = generateSecretKey();
                        this.mSecretKey = generateSecretKey;
                        storeSecretKey(generateSecretKey);
                    } else {
                        this.mSecretKey = restoreSecretKey(Base64.decode(string, 0));
                    }
                }
            } catch (Exception unused) {
                this.mSecretKey = null;
            }
        }
    }

    private SecretKey restoreSecretKey(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, bArr)) == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
            int i = defaultSharedPreferences.getInt("sk_mode_" + this.nameSpace, 1);
            if (Build.VERSION.SDK_INT >= 18) {
                if (i == 1) {
                    return unwrap(bArr);
                }
                return SecretKeyFactory.getInstance("AES").generateSecret(new SecretKeySpec(bArr, "AES"));
            } else if (i == 0) {
                return SecretKeyFactory.getInstance("AES").generateSecret(new SecretKeySpec(bArr, "AES"));
            } else {
                return null;
            }
        }
        return (SecretKey) invokeL.objValue;
    }

    private void initKeyPair() throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias("default" + this.nameSpace)) {
                generateKeyPair(this.context);
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("default" + this.nameSpace, null);
            this.mPair = new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0011 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    private void storeSecretKey(SecretKey secretKey) {
        SharedPreferences.Editor putInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, secretKey) == null) {
            String str = "sk_mode_";
            String str2 = "sk_";
            int i = 0;
            i = 0;
            i = 0;
            if (Build.VERSION.SDK_INT >= 18) {
                byte[] bArr = null;
                bArr = null;
                int i2 = 1;
                i2 = 1;
                i2 = 1;
                try {
                    try {
                        String encodeToString = Base64.encodeToString(wrap(secretKey), 0);
                        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                        StringBuilder sb = new StringBuilder();
                        sb.append("sk_");
                        sb.append(this.nameSpace);
                        str2 = sb.toString();
                        SharedPreferences.Editor putString = edit.putString(str2, encodeToString);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("sk_mode_");
                        str = this.nameSpace;
                        sb2.append(str);
                        String sb3 = sb2.toString();
                        putInt = putString.putInt(sb3, 1);
                        bArr = sb3;
                        i = sb;
                    } catch (Exception unused) {
                        String encodeToString2 = Base64.encodeToString(secretKey.getEncoded(), 0);
                        SharedPreferences.Editor edit2 = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("sk_");
                        sb4.append(this.nameSpace);
                        str2 = sb4.toString();
                        SharedPreferences.Editor putString2 = edit2.putString(str2, encodeToString2);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("sk_mode_");
                        str = this.nameSpace;
                        sb5.append(str);
                        String sb6 = sb5.toString();
                        putInt = putString2.putInt(sb6, 0);
                        bArr = sb6;
                        i2 = sb4;
                    }
                    putInt.commit();
                    return;
                } catch (Throwable th) {
                    String encodeToString3 = Base64.encodeToString(bArr, i);
                    SharedPreferences.Editor edit3 = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                    SharedPreferences.Editor putString3 = edit3.putString(str2 + this.nameSpace, encodeToString3);
                    putString3.putInt(str + this.nameSpace, i2).commit();
                    throw th;
                }
            }
            String encodeToString4 = Base64.encodeToString(secretKey.getEncoded(), 0);
            SharedPreferences.Editor edit4 = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
            SharedPreferences.Editor putString4 = edit4.putString("sk_" + this.nameSpace, encodeToString4);
            putString4.putInt("sk_mode_" + this.nameSpace, 0).commit();
        }
    }

    private byte[] wrap(SecretKey secretKey) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, secretKey)) == null) {
            if (this.mPair == null) {
                initKeyPair();
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(3, this.mPair.getPublic());
            return cipher.wrap(secretKey);
        }
        return (byte[]) invokeL.objValue;
    }

    public CryptResult decrypt(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            return doCrypt(bArr, 2);
        }
        return (CryptResult) invokeL.objValue;
    }

    public CryptResult encrypt(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            return doCrypt(bArr, 1);
        }
        return (CryptResult) invokeL.objValue;
    }
}
