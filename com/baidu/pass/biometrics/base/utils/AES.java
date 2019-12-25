package com.baidu.pass.biometrics.base.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class AES {
    private static final String DEFAULT_ALGORITHM = "AES";
    private static final String DEFAULT_ALGORITHM_MODE = "AES/CBC/NoPadding";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private String algorithm;
    private String algorithmMode;
    private String encoding;

    public AES() {
        this("AES", DEFAULT_ALGORITHM_MODE, "UTF-8");
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.encoding = "UTF-8";
        this.algorithmMode = DEFAULT_ALGORITHM_MODE;
        this.algorithm = "AES";
        this.algorithm = str;
        this.algorithmMode = str2;
        this.encoding = str3;
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.algorithm);
            Cipher cipher = Cipher.getInstance(this.algorithmMode);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(padString(str).getBytes());
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (NoSuchPaddingException e2) {
            return null;
        }
    }

    public byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("Empty string");
        }
        byte[] bArr2 = new byte[0];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.algorithm);
            Cipher cipher = Cipher.getInstance(this.algorithmMode);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            return bArr2;
        }
    }

    private static String padString(String str) {
        int length = 16 - (str.getBytes().length % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }
}
