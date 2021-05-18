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
    public static class C0115a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f9261a = "UTF-8";

        /* renamed from: b  reason: collision with root package name */
        public static final String f9262b = "AES/CBC/NoPadding";

        /* renamed from: c  reason: collision with root package name */
        public static final String f9263c = "AES";

        /* renamed from: d  reason: collision with root package name */
        public String f9264d;

        /* renamed from: e  reason: collision with root package name */
        public String f9265e;

        /* renamed from: f  reason: collision with root package name */
        public String f9266f;

        public C0115a() {
            this("AES", "AES/CBC/NoPadding", "UTF-8");
        }

        public byte[] a(String str, String str2, String str3) throws Exception {
            if (str != null && str.length() != 0) {
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f9264d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f9266f);
                    Cipher cipher = Cipher.getInstance(this.f9265e);
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

        public C0115a(String str, String str2, String str3) {
            this.f9264d = "UTF-8";
            this.f9265e = "AES/CBC/NoPadding";
            this.f9266f = "AES";
            this.f9266f = str;
            this.f9265e = str2;
            this.f9264d = str3;
        }

        public byte[] a(byte[] bArr, String str, String str2) throws Exception {
            if (bArr != null && bArr.length != 0) {
                byte[] bArr2 = new byte[0];
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f9264d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f9266f);
                    Cipher cipher = Cipher.getInstance(this.f9265e);
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
            for (int i2 = 0; i2 < length; i2++) {
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
        int i2;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length * 8;
        int i3 = 0;
        int i4 = 6;
        int i5 = 0;
        int i6 = 0;
        byte b2 = 0;
        do {
            if (i3 > 0 && i4 > 0) {
                int i7 = (bArr[i5] & 255) << i4;
                int i8 = 8 - i4;
                b2 = (byte) (((byte) (i7 | ((bArr[i5 + 1] & 255) >> i8))) & 63);
                i4 = 6 - i8;
                i3 = i8;
            } else if (i3 == 0) {
                b2 = (byte) ((bArr[i5] & 255) >> (8 - i4));
                i3 = 2;
                i4 = 4;
            } else if (i4 == 0) {
                b2 = (byte) (bArr[i5] & 63);
                i3 = 0;
                i4 = 6;
            }
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b2));
            i6 += 6;
            i5 = i6 / 8;
            i2 = length - i6;
        } while (i2 >= 6);
        if (i2 > 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i2)) & 63)));
        }
        int i9 = length % 3;
        for (int i10 = 0; i10 < i9; i10++) {
            sb.append("=");
        }
        return sb.toString();
    }
}
