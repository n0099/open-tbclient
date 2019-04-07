package cn.jiguang.d.h.a;

import android.support.v4.view.ViewCompat;
import android.util.Base64;
import cn.jiguang.d.a.d;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public final class a {
    private static String a = "";
    private static int b = 0;

    public static String a() {
        return a(c());
    }

    public static String a(long j) {
        long j2;
        switch (((int) j) % 10) {
            case 1:
                j2 = (5 * j) + (j % 88);
                break;
            case 2:
                j2 = (23 * j) + (j % 15);
                break;
            case 3:
                j2 = (3 * j) + (j % 73);
                break;
            case 4:
                j2 = (13 * j) + (j % 96);
                break;
            case 5:
                j2 = (17 * j) + (j % 49);
                break;
            case 6:
                j2 = (7 * j) + (j % 68);
                break;
            case 7:
                j2 = (31 * j) + (j % 39);
                break;
            case 8:
                j2 = (29 * j) + (j % 41);
                break;
            case 9:
                j2 = (37 * j) + (j % 91);
                break;
            default:
                j2 = (8 * j) + (j % 74);
                break;
        }
        return cn.jiguang.g.a.a("JCKP" + String.valueOf(j2));
    }

    public static String a(String str) {
        try {
            if ("DFA84B10B7ACDD25".length() != 16) {
                return null;
            }
            byte[] k = k("DFA84B10B7ACDD25", HTTP.ASCII);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(k, "AES"), l(k));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 2);
        } catch (Exception e) {
            return "";
        }
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            if (str2.length() == 16) {
                byte[] k = k(str2, HTTP.ASCII);
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(k, "AES"), l(k));
                try {
                    return new String(cipher.doFinal(Base64.decode(str, 2)));
                } catch (Exception e) {
                    return null;
                }
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void a(int i) {
        b = i;
    }

    public static byte[] a(String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(k(str, "utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] bArr2;
        Exception e;
        int length = bArr.length - 24;
        byte[] bArr3 = new byte[24];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, 24);
        System.arraycopy(bArr, 24, bArr4, 0, length);
        String str = "";
        if (i == 1) {
            str = i(d.c(null));
        } else if (i == 0) {
            str = i(b);
        }
        try {
            byte[] a2 = a(str, bArr4);
            int length2 = a2.length + 24;
            bArr2 = new byte[length2];
            try {
                System.arraycopy(bArr3, 0, bArr2, 0, 24);
                System.arraycopy(a2, 0, bArr2, 24, a2.length);
                bArr2[0] = (byte) ((length2 >>> 8) & 255);
                bArr2[1] = (byte) (length2 & 255);
                bArr2[0] = (byte) (bArr2[0] | 128);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return bArr2;
            }
        } catch (Exception e3) {
            bArr2 = null;
            e = e3;
        }
        return bArr2;
    }

    public static byte[] a(byte[] bArr, String str, String str2) {
        if (str == null) {
            return null;
        }
        byte[] k = k(str, "utf-8");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(k, "AES"), l(str2.getBytes("utf-8")));
        return cipher.doFinal(bArr);
    }

    public static String b() {
        return a;
    }

    public static String b(String str, String str2) {
        try {
            return a(str, "DFA84B10B7ACDD25");
        } catch (Exception e) {
            return str2;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(k(str, "utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr);
    }

    public static int c() {
        return Math.abs(new SecureRandom().nextInt()) & ViewCompat.MEASURED_SIZE_MASK;
    }

    private static String i(long j) {
        long j2;
        String valueOf = String.valueOf(j);
        int length = valueOf.length();
        if (length >= 2) {
            valueOf = valueOf.substring(length - 2, length);
        }
        switch (Integer.parseInt(valueOf) % 10) {
            case 1:
                j2 = (5 * j) + (j % 88);
                break;
            case 2:
                j2 = (23 * j) + (j % 15);
                break;
            case 3:
                j2 = (3 * j) + (j % 73);
                break;
            case 4:
                j2 = (13 * j) + (j % 96);
                break;
            case 5:
                j2 = (17 * j) + (j % 49);
                break;
            case 6:
                j2 = (7 * j) + (j % 68);
                break;
            case 7:
                j2 = (31 * j) + (j % 39);
                break;
            case 8:
                j2 = (29 * j) + (j % 41);
                break;
            case 9:
                j2 = (37 * j) + (j % 91);
                break;
            default:
                j2 = (8 * j) + (j % 74);
                break;
        }
        String a2 = cn.jiguang.g.a.a("JCKP" + String.valueOf(j2));
        a = a2;
        return a2;
    }

    private static byte[] k(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    private static IvParameterSpec l(byte[] bArr) {
        try {
            return (IvParameterSpec) cn.jiguang.f.a.a(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
