package com.baidu.searchbox.common.util.crypto.rsa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.preference.PreferenceManager;
import android.security.KeyPairGeneratorSpec;
import android.util.Log;
import com.baidu.nadcore.exp.ADConfigError;
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
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.chromium.net.AndroidKeyStore;
@Deprecated
/* loaded from: classes3.dex */
public class EncryptTool {
    public static final String DEFAULT_KEY_ALIAS = "default";
    public static final int NORMAL_MODE = 0;
    public static final String SP_KEY = "sk";
    public static final String SP_MODE_KEY = "sk_mode";
    public static final String TAG = "EncryptTool";
    public static final int WRAP_MODE = 1;
    @SuppressLint({"StaticFieldLeak"})
    public static EncryptTool mInstance;
    public Context mContext;
    public KeyPair mPair;
    public SecretKey mSecretKey = null;

    /* loaded from: classes3.dex */
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

    private SecretKey generateSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom());
        return keyGenerator.generateKey();
    }

    public static EncryptTool getInstance() {
        if (mInstance == null) {
            synchronized (EncryptTool.class) {
                if (mInstance == null) {
                    mInstance = new EncryptTool();
                }
            }
        }
        return mInstance;
    }

    private void initKeyPair() throws Exception {
        KeyStore keyStore = KeyStore.getInstance(AndroidKeyStore.TAG);
        keyStore.load(null);
        if (!keyStore.containsAlias("default")) {
            generateKeyPair(this.mContext);
        }
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("default", null);
        this.mPair = new KeyPair(privateKeyEntry.getCertificate().getPublicKey(), privateKeyEntry.getPrivateKey());
    }

    public boolean isInitialized() {
        if (this.mContext != null && this.mSecretKey != null) {
            return true;
        }
        return false;
    }

    @SuppressLint({"GetInstance", "BDThrowableCheck"})
    private CryptResult doCrypt(byte[] bArr, int i) {
        if (i != 2 && i != 1) {
            throw new IllegalArgumentException("mode must be Cipher.DECRYPT_MODE or Cipher.ENCRYPT_MODE");
        }
        CryptResult cryptResult = new CryptResult();
        if (bArr == null) {
            Log.w(TAG, ADConfigError.REASON_NULL_DATA);
            cryptResult.statusCode = -1;
            return cryptResult;
        } else if (!isInitialized()) {
            cryptResult.statusCode = 1;
            return cryptResult;
        } else {
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
        }
    }

    @SuppressLint({"TrulyRandom"})
    private void generateKeyPair(Context context) throws Exception {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 100);
        if (Build.VERSION.SDK_INT >= 18) {
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context).setAlias("default").setSubject(new X500Principal("C=CN,ST=BJ,L=BJ,O=BaiDu,OU=BaiDu,CN=default")).setSerialNumber(BigInteger.ONE).setStartDate(gregorianCalendar.getTime()).setEndDate(gregorianCalendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", AndroidKeyStore.TAG);
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        }
    }

    public void init(Context context) {
        if (isInitialized()) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        try {
            if (this.mSecretKey == null) {
                String string = PreferenceManager.getDefaultSharedPreferences(this.mContext).getString("sk", null);
                if (string == null) {
                    SecretKey generateSecretKey = generateSecretKey();
                    this.mSecretKey = generateSecretKey;
                    storeSecretKey(generateSecretKey);
                } else {
                    this.mSecretKey = restoreSecretKey(android.util.Base64.decode(string, 0));
                }
            }
        } catch (Exception e) {
            String str = TAG;
            Log.w(str, "init error: " + e.getMessage());
            this.mSecretKey = null;
        }
    }

    private SecretKey restoreSecretKey(byte[] bArr) throws Exception {
        int i = PreferenceManager.getDefaultSharedPreferences(this.mContext).getInt("sk_mode", 1);
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

    private void storeSecretKey(SecretKey secretKey) {
        byte[] encoded;
        if (Build.VERSION.SDK_INT >= 18) {
            int i = 1;
            try {
                encoded = wrap(secretKey);
            } catch (Exception e) {
                String str = TAG;
                Log.d(str, "store key fail! " + e.getMessage());
                encoded = secretKey.getEncoded();
                i = 0;
            }
            PreferenceManager.getDefaultSharedPreferences(this.mContext).edit().putString("sk", android.util.Base64.encodeToString(encoded, 0)).putInt("sk_mode", i).apply();
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(this.mContext).edit().putString("sk", android.util.Base64.encodeToString(secretKey.getEncoded(), 0)).putInt("sk_mode", 0).apply();
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

    public CryptResult decrypt(byte[] bArr) {
        return doCrypt(bArr, 2);
    }

    public CryptResult encrypt(byte[] bArr) {
        return doCrypt(bArr, 1);
    }
}
