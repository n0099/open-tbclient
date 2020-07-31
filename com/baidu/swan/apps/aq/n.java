package com.baidu.swan.apps.aq;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.common.security.RSAUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class n {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static String encrypt(String str, byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [104=5] */
    public static String encrypt(String str, File file, boolean z) {
        Throwable th;
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str2 = toHexString(messageDigest.digest(), "", z);
                    com.baidu.swan.d.d.closeSafely(fileInputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.d.d.closeSafely(fileInputStream);
                    return str2;
                } catch (IOException e2) {
                    e = e2;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.d.d.closeSafely(fileInputStream);
                    return str2;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.d.d.closeSafely(fileInputStream);
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.d.d.closeSafely(null);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileInputStream = null;
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.d.d.closeSafely(null);
            throw th;
        }
        return str2;
    }

    private static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    @CheckResult
    @NonNull
    public static String M(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
            Cipher cipher = Cipher.getInstance(str3);
            cipher.init(1, generatePublic);
            return Base64.encodeToString(cipher.doFinal(str2.getBytes("utf-8")), 2);
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanAppEncryptUtils", "rsaEncrypt", e);
            }
            return "";
        }
    }

    @CheckResult
    @NonNull
    public static String s(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        try {
            Cipher cipher = Cipher.getInstance(str3);
            cipher.init(1, new SecretKeySpec(str.getBytes("utf-8"), com.baidu.sapi2.utils.h.q), new IvParameterSpec(str4.getBytes("utf-8")));
            return Base64.encodeToString(cipher.doFinal(str2.getBytes("utf-8")), 2);
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanAppEncryptUtils", "aesEncrypt", e);
            }
            return "";
        }
    }
}
