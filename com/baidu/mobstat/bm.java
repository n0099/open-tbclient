package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.SecureHelper;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public final class bm {

    /* loaded from: classes4.dex */
    public static class b {
        public static byte[] a(int i, byte[] bArr) throws Exception {
            int i2 = i - 1;
            if (i2 < 0 || br.f2645a.length <= i2) {
                return new byte[0];
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(br.f2645a[i2].getBytes(), com.baidu.sapi2.utils.e.q);
            Cipher cipher = Cipher.getInstance(SecureHelper.CIPHER_TRIPLE_AES);
            cipher.init(1, secretKeySpec);
            return cipher.doFinal(bArr);
        }

        public static byte[] b(int i, byte[] bArr) throws Exception {
            int i2 = i - 1;
            if (i2 < 0 || br.f2645a.length <= i2) {
                return new byte[0];
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(br.f2645a[i2].getBytes(), com.baidu.sapi2.utils.e.q);
            Cipher cipher = Cipher.getInstance(SecureHelper.CIPHER_TRIPLE_AES);
            cipher.init(2, secretKeySpec);
            return cipher.doFinal(bArr);
        }

        public static String c(int i, byte[] bArr) {
            try {
                return bp.b(a(i, bArr));
            } catch (Exception e) {
                return "";
            }
        }

        public static String d(int i, byte[] bArr) {
            String c = c(i, bArr);
            return TextUtils.isEmpty(c) ? "" : c + "|" + i;
        }
    }

    /* loaded from: classes4.dex */
    public static class a {
        @SuppressLint({"TrulyRandom"})
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr3);
        }

        public static byte[] a() throws Exception {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(com.baidu.sapi2.utils.e.q);
            keyGenerator.init(128, new SecureRandom());
            return keyGenerator.generateKey().getEncoded();
        }

        public static byte[] b() {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }

        public static String a(byte[] bArr) {
            try {
                return b(a(), b(), bArr);
            } catch (Exception e) {
                return "";
            }
        }

        public static String b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            try {
                return bp.b(a(bArr, bArr2, bs.a(bArr3))) + "|" + bv.a(bArr) + "|" + bv.a(bArr2);
            } catch (Exception e) {
                return "";
            }
        }
    }
}
