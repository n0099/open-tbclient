package com.baidu.sapi2.utils;

import com.baidu.sapi2.NoProguard;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes15.dex */
public class AES implements NoProguard {
    private static final String d = "UTF-8";
    private static final String e = "AES/CBC/NoPadding";
    private static final String f = "AES";

    /* renamed from: a  reason: collision with root package name */
    private String f3526a;
    private String b;
    private String c;

    public AES() {
        this("AES", e, "UTF-8");
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
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f3526a));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.c);
                Cipher cipher = Cipher.getInstance(this.b);
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (Throwable th) {
                Log.e(Log.TAG, th.toString());
                return bArr2;
            }
        }
        throw new Exception("Empty string");
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str != null && str.length() != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f3526a));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.c);
                Cipher cipher = Cipher.getInstance(this.b);
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(a(str).getBytes());
            } catch (NoSuchAlgorithmException e2) {
                Log.e(Log.TAG, e2.toString());
                return null;
            } catch (NoSuchPaddingException e3) {
                Log.e(Log.TAG, e3.toString());
                return null;
            }
        }
        throw new Exception("Empty string");
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.f3526a = "UTF-8";
        this.b = e;
        this.c = "AES";
        this.c = str;
        this.b = str2;
        this.f3526a = str3;
    }
}
