package cn.com.chinatelecom.gateway.lib.a;

import cn.com.chinatelecom.gateway.lib.CtAuth;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1484a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static byte[] f1485b = "0000000000000000".getBytes();

    /* renamed from: c  reason: collision with root package name */
    public static byte[] f1486c = "vrf5g7h0tededwx3".getBytes();

    public static String a(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f1485b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bytes = str.getBytes("utf-8");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return e.a(cipher.doFinal(bytes));
        } catch (Throwable th) {
            CtAuth.warn(f1484a, "encryptAesNew error", th);
            return null;
        }
    }

    public static byte[] b(String str, String str2) {
        try {
            byte[] bytes = str.getBytes("utf-8");
            int length = bytes.length;
            while (length % 16 != 0) {
                length++;
            }
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                if (i < bytes.length) {
                    bArr[i] = bytes[i];
                } else {
                    bArr[i] = 0;
                }
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f1486c);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            CtAuth.warn(f1484a, "encrypt4Ux error", th);
            return null;
        }
    }

    public static String c(String str, String str2) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f1485b);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(e.a(str));
            if (doFinal != null) {
                return new String(doFinal);
            }
            CtAuth.info(f1484a, "Aes decrypt result is empty");
            return "";
        } catch (Throwable th) {
            CtAuth.warn(f1484a, "decryptAesNew error", th);
            return "";
        }
    }
}
