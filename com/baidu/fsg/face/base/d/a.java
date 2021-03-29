package com.baidu.fsg.face.base.d;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5596a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5597b = "AES/CBC/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5598c = "AES";

    /* renamed from: d  reason: collision with root package name */
    public String f5599d;

    /* renamed from: e  reason: collision with root package name */
    public String f5600e;

    /* renamed from: f  reason: collision with root package name */
    public String f5601f;

    public a() {
        this("AES", "AES/CBC/NoPadding", "UTF-8");
    }

    public byte[] a(String str, String str2, String str3) throws Exception {
        if (str != null && str.length() != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f5599d));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f5601f);
                Cipher cipher = Cipher.getInstance(this.f5600e);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(a(str).getBytes());
            } catch (NoSuchAlgorithmException e2) {
                d.a(e2);
                return null;
            } catch (NoSuchPaddingException e3) {
                d.a(e3);
                return null;
            }
        }
        throw new Exception("Empty string");
    }

    public a(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public a(String str, String str2, String str3) {
        this.f5599d = "UTF-8";
        this.f5600e = "AES/CBC/NoPadding";
        this.f5601f = "AES";
        this.f5601f = str;
        this.f5600e = str2;
        this.f5599d = str3;
    }

    public byte[] a(byte[] bArr, String str, String str2) throws Exception {
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = new byte[0];
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f5599d));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f5601f);
                Cipher cipher = Cipher.getInstance(this.f5600e);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                d.a(th);
                return bArr2;
            }
        }
        throw new Exception("Empty string");
    }

    public static String a(String str) {
        int length = 16 - (str.length() % 16);
        for (int i = 0; i < length; i++) {
            str = str + ' ';
        }
        return str;
    }
}
