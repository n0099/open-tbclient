package com.baidu.pass.biometrics.base.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes11.dex */
public class AES {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2708a = "UTF-8";
    private static final String b = "AES/CBC/NoPadding";
    private static final String c = "AES";
    private String d;
    private String e;
    private String f;

    public AES() {
        this("AES", b, "UTF-8");
    }

    private static String a(String str) {
        int length = 16 - (str.getBytes().length % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }

    public byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = new byte[0];
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.d));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f);
                Cipher cipher = Cipher.getInstance(this.e);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                return bArr2;
            }
        }
        throw new Exception("Empty string");
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str != null && str.length() != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.d));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f);
                Cipher cipher = Cipher.getInstance(this.e);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(a(str).getBytes());
            } catch (NoSuchAlgorithmException e) {
                return null;
            } catch (NoSuchPaddingException e2) {
                return null;
            }
        }
        throw new Exception("Empty string");
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.d = "UTF-8";
        this.e = b;
        this.f = "AES";
        this.f = str;
        this.e = str2;
        this.d = str3;
    }
}
