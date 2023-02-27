package com.baidu.searchbox.retrieve.file.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.common.security.RSAUtil;
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
    public static final String ALGORITHM_NAME = "AES";
    public static final String CBC_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static final String DEFAULT_KEY_ALIAS = "default";
    public static final String ECB_TRANSFORMATION = "AES/ECB/PKCS5Padding";
    public static final int NORMAL_MODE = 0;
    public static final String SP_KEY = "sk";
    public static final String SP_MODE_KEY = "sk_mode";
    public static final int WRAP_MODE = 1;
    public Context context;
    public KeyPair mPair;
    public SecretKey mSecretKey;
    public String nameSpace;

    /* loaded from: classes2.dex */
    public static class Builder {
        public Context context;
        public String nameSpace;

        public AESUtil build() throws ModeNotMatchException {
            if (this.context != null) {
                if (!TextUtils.isEmpty(this.nameSpace)) {
                    return new AESUtil(this);
                }
                throw new ModeNotMatchException("need package nameSpace");
            }
            throw new ModeNotMatchException("need set appContext");
        }

        public Builder setContext(@NonNull Context context) {
            this.context = context.getApplicationContext();
            return this;
        }

        public Builder setNameSpace(String str) {
            this.nameSpace = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class CryptResult {
        public static final int FAIL = -1;
        public static final int NOT_INITIALIZED = 1;
        public static final int SUCCESS = 0;
        public byte[] result;
        public int statusCode;

        public byte[] getResult() {
            return this.result;
        }

        public int getStatusCode() {
            return this.statusCode;
        }
    }

    /* loaded from: classes2.dex */
    public static class ModeNotMatchException extends Exception {
        public ModeNotMatchException() {
        }

        public ModeNotMatchException(String str) {
            super(str);
        }
    }

    public AESUtil(Builder builder) {
        this.mSecretKey = null;
        this.nameSpace = builder.nameSpace;
        Context context = builder.context;
        this.context = context;
        if (context != null) {
            init(context);
        }
    }

    private SecretKey unwrap(byte[] bArr) throws Exception {
        if (this.mPair == null) {
            initKeyPair();
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(4, this.mPair.getPrivate());
        return (SecretKey) cipher.unwrap(bArr, "AES", 3);
    }

    private byte[] wrap(SecretKey secretKey) throws Exception {
        if (this.mPair == null) {
            initKeyPair();
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(3, this.mPair.getPublic());
        return cipher.wrap(secretKey);
    }

    public CryptResult decrypt(byte[] bArr) throws Exception {
        return doCrypt(bArr, 2);
    }

    public CryptResult encrypt(byte[] bArr) throws Exception {
        return doCrypt(bArr, 1);
    }

    public static byte[] decryptECB(String str, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ECB_TRANSFORMATION);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptECB(String str, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(ECB_TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] decryptCBC(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] encryptCBC(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    private CryptResult doCrypt(byte[] bArr, int i) {
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

    private void generateKeyPair(Context context) throws Exception {
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

    private SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom());
        return keyGenerator.generateKey();
    }

    private void init(Context context) {
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

    private void initKeyPair() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (!keyStore.containsAlias("default" + this.nameSpace)) {
            generateKeyPair(this.context);
        }
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("default" + this.nameSpace, null);
        this.mPair = new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
    }

    private SecretKey restoreSecretKey(byte[] bArr) throws Exception {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x000f */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.lang.StringBuilder */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    private void storeSecretKey(SecretKey secretKey) {
        SharedPreferences.Editor putInt;
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
