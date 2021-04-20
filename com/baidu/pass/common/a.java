package com.baidu.pass.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: com.baidu.pass.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0117a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f9295a = "UTF-8";

        /* renamed from: b  reason: collision with root package name */
        public static final String f9296b = "AES/CBC/NoPadding";

        /* renamed from: c  reason: collision with root package name */
        public static final String f9297c = "AES";

        /* renamed from: d  reason: collision with root package name */
        public String f9298d;

        /* renamed from: e  reason: collision with root package name */
        public String f9299e;

        /* renamed from: f  reason: collision with root package name */
        public String f9300f;

        public C0117a() {
            this("AES", "AES/CBC/NoPadding", "UTF-8");
        }

        public byte[] a(String str, String str2, String str3) throws Exception {
            if (str != null && str.length() != 0) {
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f9298d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f9300f);
                    Cipher cipher = Cipher.getInstance(this.f9299e);
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(a(str).getBytes());
                } catch (NoSuchAlgorithmException e2) {
                    Log.e(e2);
                    return null;
                } catch (NoSuchPaddingException e3) {
                    Log.e(e3);
                    return null;
                }
            }
            throw new Exception("Empty string");
        }

        public C0117a(String str, String str2, String str3) {
            this.f9298d = "UTF-8";
            this.f9299e = "AES/CBC/NoPadding";
            this.f9300f = "AES";
            this.f9300f = str;
            this.f9299e = str2;
            this.f9298d = str3;
        }

        public byte[] a(byte[] bArr, String str, String str2) throws Exception {
            if (bArr != null && bArr.length != 0) {
                byte[] bArr2 = new byte[0];
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f9298d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f9300f);
                    Cipher cipher = Cipher.getInstance(this.f9299e);
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(bArr);
                } catch (Throwable th) {
                    Log.e(th);
                    return bArr2;
                }
            }
            throw new Exception("Empty string");
        }

        private String a(String str) {
            int length = 16 - (str.getBytes().length % 16);
            for (int i = 0; i < length; i++) {
                str = str + ' ';
            }
            return str;
        }
    }

    public String a(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public String a(byte[] bArr) {
        int i;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length * 8;
        int i2 = 0;
        int i3 = 6;
        int i4 = 0;
        int i5 = 0;
        byte b2 = 0;
        do {
            if (i2 > 0 && i3 > 0) {
                int i6 = (bArr[i4] & 255) << i3;
                int i7 = 8 - i3;
                b2 = (byte) (((byte) (i6 | ((bArr[i4 + 1] & 255) >> i7))) & 63);
                i3 = 6 - i7;
                i2 = i7;
            } else if (i2 == 0) {
                b2 = (byte) ((bArr[i4] & 255) >> (8 - i3));
                i2 = 2;
                i3 = 4;
            } else if (i3 == 0) {
                b2 = (byte) (bArr[i4] & 63);
                i2 = 0;
                i3 = 6;
            }
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b2));
            i5 += 6;
            i4 = i5 / 8;
            i = length - i5;
        } while (i >= 6);
        if (i > 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
        }
        int i8 = length % 3;
        for (int i9 = 0; i9 < i8; i9++) {
            sb.append("=");
        }
        return sb.toString();
    }
}
