package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class bm {

    /* loaded from: classes2.dex */
    public static class b {
        public static byte[] a(int i2, byte[] bArr) throws Exception {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                String[] strArr = br.f8787a;
                if (strArr.length > i3) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(1, secretKeySpec);
                    return cipher.doFinal(bArr);
                }
            }
            return new byte[0];
        }

        public static byte[] b(int i2, byte[] bArr) throws Exception {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                String[] strArr = br.f8787a;
                if (strArr.length > i3) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), "AES");
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(2, secretKeySpec);
                    return cipher.doFinal(bArr);
                }
            }
            return new byte[0];
        }

        public static String c(int i2, byte[] bArr) {
            try {
                return bp.b(a(i2, bArr));
            } catch (Exception unused) {
                return "";
            }
        }

        public static String d(int i2, byte[] bArr) {
            String c2 = c(i2, bArr);
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            return c2 + "|" + i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        @SuppressLint({"TrulyRandom"})
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr3);
        }

        public static byte[] b() {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }

        public static String b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            try {
                byte[] a2 = a(bArr, bArr2, bs.a(bArr3));
                return bp.b(a2) + "|" + bv.a(bArr) + "|" + bv.a(bArr2);
            } catch (Exception unused) {
                return "";
            }
        }

        public static byte[] a() throws Exception {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom());
            return keyGenerator.generateKey().getEncoded();
        }

        public static String a(byte[] bArr) {
            try {
                return b(a(), b(), bArr);
            } catch (Exception unused) {
                return "";
            }
        }
    }
}
