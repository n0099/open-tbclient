package com.baidu.sapi2.utils.b;

import com.baidu.sapi2.utils.L;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class a {
    private static final String a = "UTF-8";
    private static final String b = "AES/CBC/NoPadding";
    private static final String c = "AES";
    private String d;
    private String e;
    private String f;

    public a() {
        this(c, b, a);
    }

    public a(String str, String str2, String str3) {
        this.d = a;
        this.e = b;
        this.f = c;
        this.f = str;
        this.e = str2;
        this.d = str3;
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
}
