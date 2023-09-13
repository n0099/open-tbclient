package com.baidu.pass.common;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class a {
    public static final String a = "Security";

    /* renamed from: com.baidu.pass.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0120a {
        public static final String a = "UTF-8";
        public static final String b = "AES/CBC/NoPadding";
        public static final String c = "AES";
        public String d;
        public String e;
        public String f;

        public C0120a() {
            this("AES", "AES/CBC/NoPadding", "UTF-8");
        }

        public C0120a(String str, String str2, String str3) {
            this.d = "UTF-8";
            this.e = "AES/CBC/NoPadding";
            this.f = "AES";
            this.f = str;
            this.e = str2;
            this.d = str3;
        }

        private String a(String str) {
            int length = 16 - (str.getBytes().length % 16);
            for (int i = 0; i < length; i++) {
                str = str + WebvttCueParser.CHAR_SPACE;
            }
            return str;
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
    }

    private String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        try {
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
        } catch (Exception unused) {
            Log.e(a, "toHexString is error");
        }
        return sb.toString();
    }

    public String a(byte[] bArr) {
        int i;
        if (bArr != null && bArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            int length = bArr.length * 8;
            int i2 = 0;
            int i3 = 6;
            int i4 = 0;
            int i5 = 0;
            byte b = 0;
            do {
                if (i2 > 0 && i3 > 0) {
                    if (i4 >= 0 && i4 < bArr.length - 1) {
                        b = (byte) (((bArr[i4] & 255) << i3) | ((bArr[i4 + 1] & 255) >> (8 - i3)));
                    }
                    b = (byte) (b & 63);
                    i2 = 8 - i3;
                    i3 = 6 - i2;
                } else if (i2 == 0) {
                    if (i4 >= 0 && i4 < bArr.length) {
                        b = (byte) ((bArr[i4] & 255) >> (8 - i3));
                    }
                    i2 = 2;
                    i3 = 4;
                } else if (i3 == 0) {
                    if (i4 >= 0 && i4 < bArr.length) {
                        b = (byte) (bArr[i4] & 63);
                    }
                    i2 = 0;
                    i3 = 6;
                }
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
                i5 += 6;
                i4 = i5 / 8;
                i = length - i5;
            } while (i >= 6);
            if (i > 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
            }
            int i6 = length % 3;
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append("=");
            }
            return sb.toString();
        }
        return "";
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
}
