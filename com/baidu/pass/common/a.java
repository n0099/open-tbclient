package com.baidu.pass.common;

import com.baidu.webkit.internal.ETAG;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes9.dex */
class a {

    /* renamed from: com.baidu.pass.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0273a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f2760a = "UTF-8";
        private static final String b = "AES/CBC/NoPadding";
        private static final String c = "AES";
        private String d;
        private String e;
        private String f;

        public C0273a() {
            this("AES", b, "UTF-8");
        }

        public byte[] a(String str, String str2, String str3) throws Exception {
            if (str != null && str.length() != 0) {
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f);
                    Cipher cipher = Cipher.getInstance(this.e);
                    cipher.init(1, secretKeySpec, ivParameterSpec);
                    return cipher.doFinal(a(str).getBytes());
                } catch (NoSuchAlgorithmException e) {
                    Log.e(e);
                    return null;
                } catch (NoSuchPaddingException e2) {
                    Log.e(e2);
                    return null;
                }
            }
            throw new Exception("Empty string");
        }

        public C0273a(String str, String str2, String str3) {
            this.d = "UTF-8";
            this.e = b;
            this.f = "AES";
            this.f = str;
            this.e = str2;
            this.d = str3;
        }

        public byte[] a(byte[] bArr, String str, String str2) throws Exception {
            if (bArr != null && bArr.length != 0) {
                byte[] bArr2 = new byte[0];
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.d));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f);
                    Cipher cipher = Cipher.getInstance(this.e);
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public String a(byte[] bArr) {
        int i;
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            int length = bArr.length * 8;
            byte b = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 6;
            int i5 = 0;
            do {
                if (i5 <= 0 || i4 <= 0) {
                    if (i5 == 0) {
                        b = (byte) ((bArr[i3] & 255) >> (8 - i4));
                        i5 = 2;
                        i4 = 4;
                    } else if (i4 == 0) {
                        b = (byte) (bArr[i3] & 63);
                        i4 = 6;
                        i5 = 0;
                    }
                } else {
                    i5 = 8 - i4;
                    b = (byte) (((byte) (((bArr[i3] & 255) << i4) | ((bArr[i3 + 1] & 255) >> i5))) & 63);
                    i4 = 6 - i5;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
                i2 += 6;
                i3 = i2 / 8;
                i = length - i2;
            } while (i >= 6);
            if (i > 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
            }
            int i6 = length % 3;
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append(ETAG.EQUAL);
            }
            return sb.toString();
        }
        return "";
    }
}
