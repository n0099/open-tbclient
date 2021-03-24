package com.baidu.pass.biometrics.base.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class AES {

    /* renamed from: d  reason: collision with root package name */
    public static final String f9553d = "UTF-8";

    /* renamed from: e  reason: collision with root package name */
    public static final String f9554e = "AES/CBC/NoPadding";

    /* renamed from: f  reason: collision with root package name */
    public static final String f9555f = "AES";

    /* renamed from: a  reason: collision with root package name */
    public String f9556a;

    /* renamed from: b  reason: collision with root package name */
    public String f9557b;

    /* renamed from: c  reason: collision with root package name */
    public String f9558c;

    public AES() {
        this("AES", "AES/CBC/NoPadding", "UTF-8");
    }

    public static String a(String str) {
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
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f9556a));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f9558c);
                Cipher cipher = Cipher.getInstance(this.f9557b);
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
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f9556a));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f9558c);
                Cipher cipher = Cipher.getInstance(this.f9557b);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(a(str).getBytes());
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
                return null;
            }
        }
        throw new Exception("Empty string");
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.f9556a = "UTF-8";
        this.f9557b = "AES/CBC/NoPadding";
        this.f9558c = "AES";
        this.f9558c = str;
        this.f9557b = str2;
        this.f9556a = str3;
    }
}
