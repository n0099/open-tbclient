package com.baidu.pass.biometrics.base.utils;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class AES {
    public static final String d = "UTF-8";
    public static final String e = "AES/CBC/NoPadding";
    public static final String f = "AES";
    public String a;
    public String b;
    public String c;

    public AES() {
        this("AES", "AES/CBC/NoPadding", "UTF-8");
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.a = "UTF-8";
        this.b = "AES/CBC/NoPadding";
        this.c = "AES";
        this.c = str;
        this.b = str2;
        this.a = str3;
    }

    public static String a(String str) {
        int length = 16 - (str.getBytes().length % 16);
        for (int i = 0; i < length; i++) {
            str = str + WebvttCueParser.CHAR_SPACE;
        }
        return str;
    }

    public byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = new byte[0];
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.a));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.c);
                Cipher cipher = Cipher.getInstance(this.b);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Throwable unused) {
                return bArr2;
            }
        }
        throw new Exception("Empty string");
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str != null && str.length() != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.a));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.c);
                Cipher cipher = Cipher.getInstance(this.b);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(a(str).getBytes());
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
                return null;
            }
        }
        throw new Exception("Empty string");
    }
}
