package com.baidu.fsg.base.utils;

import android.os.Build;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class Crypto {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5527a = 16;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5528b = 8;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5529c = 128;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5530d = 64;

    /* renamed from: e  reason: collision with root package name */
    public static final int f5531e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f5532f = 1000;

    /* renamed from: g  reason: collision with root package name */
    public static SecureRandom f5533g = new SecureRandom();

    public static byte[] a(int i2) {
        byte[] bArr = new byte[i2];
        f5533g.nextBytes(bArr);
        return bArr;
    }

    public static byte[] aesDecrypt(byte[] bArr, String str) {
        if (bArr == null || bArr.length < 24) {
            return null;
        }
        byte[] copyOf = Arrays.copyOf(bArr, 8);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 8, 24);
        SecretKey a2 = a(str, copyOf);
        if (a2 == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(2, a2, new IvParameterSpec(copyOfRange));
            int length = copyOf.length + copyOfRange.length;
            return cipher.doFinal(bArr, length, bArr.length - length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] aesEncrypt(byte[] bArr, String str) {
        byte[] a2 = a(8);
        SecretKey a3 = a(str, a2);
        if (a3 == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(1, a3);
            return a(a2, cipher.getIV(), cipher.doFinal(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static SecretKey b(String str, byte[] bArr) {
        if (str == null) {
            str = "";
        }
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance(a()).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 64)).getEncoded(), "DES");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] desDecrypt(byte[] bArr, String str) throws Exception {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] copyOf = Arrays.copyOf(bArr, 8);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 8, 16);
        SecretKey b2 = b(str, copyOf);
        if (b2 == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("DES/CTR/NoPadding");
            cipher.init(2, b2, new IvParameterSpec(copyOfRange));
            int length = copyOf.length + copyOfRange.length;
            return cipher.doFinal(bArr, length, bArr.length - length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] desEncrypt(byte[] bArr, String str) {
        byte[] a2 = a(8);
        SecretKey b2 = b(str, a2);
        try {
            Cipher cipher = Cipher.getInstance("DES/CTR/NoPadding");
            cipher.init(1, b2);
            return a(a2, cipher.getIV(), cipher.doFinal(bArr));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] rsaDecrypt(byte[] bArr, String str) {
        return RSA.a(RSA.b(Base64.decode(str, 2)), bArr);
    }

    public static byte[] rsaEncrypt(byte[] bArr, String str) {
        return RSA.a(RSA.a(Base64.decode(str, 2)), bArr);
    }

    public static String sha1(byte[] bArr) throws Exception {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a() {
        return Build.VERSION.SDK_INT >= 19 ? "PBKDF2WithHmacSHA1And8bit" : "PBKDF2withHmacSHA1";
    }

    public static SecretKey a(String str, byte[] bArr) {
        if (str == null) {
            str = "";
        }
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance(a()).generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 1000, 128)).getEncoded(), "AES");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String sha1(String str) throws Exception {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return a(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return a(bArr, bArr3);
        }
        if (bArr3 == null) {
            return a(bArr, bArr2);
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr4, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, bArr.length + bArr2.length, bArr3.length);
        return bArr4;
    }
}
