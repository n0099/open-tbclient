package com.baidu.location;

import com.tencent.mm.sdk.platformtools.Util;
import java.security.MessageDigest;
/* loaded from: classes.dex */
class d {

    /* renamed from: if  reason: not valid java name */
    private static char[] f148if = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/.".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private static char[] f741a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    d() {
    }

    public static String a(String str) {
        try {
            char[] a2 = a((str + "webgis").getBytes("UTF-8"));
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length + 2];
            for (int i = 0; i < bytes.length; i++) {
                bArr[i] = bytes[i];
            }
            bArr[bytes.length] = (byte) (Integer.parseInt(String.copyValueOf(a2, 10, 2), 16) & Util.MASK_8BIT);
            bArr[bytes.length + 1] = (byte) (Integer.parseInt(String.copyValueOf(a2, 20, 2), 16) & Util.MASK_8BIT);
            String str2 = (("" + ((char) (Integer.parseInt(String.copyValueOf(a2, 6, 2), 16) & Util.MASK_8BIT))) + ((char) (Integer.parseInt(String.copyValueOf(a2, 16, 2), 16) & Util.MASK_8BIT))) + ((char) (Integer.parseInt(String.copyValueOf(a2, 26, 2), 16) & Util.MASK_8BIT));
            char[] a3 = a((str2 + "webgis").getBytes("iso-8859-1"));
            int length = bArr.length;
            int length2 = str2.length();
            byte[] bArr2 = new byte[length + length2];
            for (int i2 = 0; i2 < (length + 31) / 32; i2++) {
                int i3 = i2 * 32;
                for (int i4 = 0; i4 < 32 && i3 + i4 < length; i4++) {
                    bArr2[i3 + i4] = (byte) ((a3[i4] & 255) ^ (bArr[i3 + i4] & 255));
                }
            }
            for (int i5 = 0; i5 < length2; i5++) {
                bArr2[length + i5] = (byte) str2.charAt(i5);
            }
            return new String(m132if(bArr2));
        } catch (Exception e) {
            e.printStackTrace();
            return "UnsupportedEncodingException";
        }
    }

    private static char[] a(byte[] bArr) {
        char[] cArr = new char[32];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                cArr[i] = f741a[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = f741a[b & 15];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cArr;
    }

    /* renamed from: if  reason: not valid java name */
    private static char[] m132if(byte[] bArr) {
        boolean z;
        boolean z2;
        char[] cArr = new char[((bArr.length + 2) / 3) * 4];
        int i = 0;
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = (bArr[i2] & 255) << 8;
            if (i2 + 1 < bArr.length) {
                i3 |= bArr[i2 + 1] & 255;
                z = true;
            } else {
                z = false;
            }
            int i4 = i3 << 8;
            if (i2 + 2 < bArr.length) {
                i4 |= bArr[i2 + 2] & 255;
                z2 = true;
            } else {
                z2 = false;
            }
            cArr[i + 3] = f148if[z2 ? 63 - (i4 & 63) : 64];
            int i5 = i4 >> 6;
            cArr[i + 2] = f148if[z ? 63 - (i5 & 63) : 64];
            int i6 = i5 >> 6;
            cArr[i + 1] = f148if[63 - (i6 & 63)];
            cArr[i + 0] = f148if[63 - ((i6 >> 6) & 63)];
            i2 += 3;
            i += 4;
        }
        return cArr;
    }
}
