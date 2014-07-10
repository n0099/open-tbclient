package com.baidu.sapi2.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class f {
    private static final String a = "UTF-8";
    private static final String b = "AES/CBC/NoPadding";
    private static final String c = "AES";
    private String d;
    private String e;
    private String f;

    public f() {
        this("AES", "AES/CBC/NoPadding", a);
    }

    public f(String str, String str2) {
        this(str, str2, a);
    }

    public f(String str, String str2, String str3) {
        this.d = a;
        this.e = "AES/CBC/NoPadding";
        this.f = "AES";
        this.f = str;
        this.e = str2;
        this.d = str3;
    }

    public byte[] a(String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.d));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f);
            Cipher cipher = Cipher.getInstance(this.e);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(a(str).getBytes());
        } catch (NoSuchAlgorithmException e) {
            L.e(e);
            return null;
        } catch (NoSuchPaddingException e2) {
            L.e(e2);
            return null;
        }
    }

    public byte[] a(byte[] bArr, String str, String str2) {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.d));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f);
            Cipher cipher = Cipher.getInstance(this.e);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            L.e(e);
            return null;
        } catch (NoSuchPaddingException e2) {
            L.e(e2);
            return null;
        }
    }

    private static String a(String str) {
        int length = 16 - (str.length() % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }
}
