package com.baidu.tbadk.core.util;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class AES {
    public static final String ENCODING = "UTF-8";

    public static String bytesToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        String str = "";
        for (int i2 = 0; i2 < length; i2++) {
            str = (bArr[i2] & 255) < 16 ? str + "0" + Integer.toHexString(bArr[i2] & 255) : str + Integer.toHexString(bArr[i2] & 255);
        }
        return str;
    }

    public static byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        if (bArr != null && bArr.length != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        throw new Exception("Empty string");
    }

    public static byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str != null && str.length() != 0) {
            try {
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(padString(str).getBytes());
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        throw new Exception("Empty string");
    }

    public static byte[] hexToBytes(String str) {
        if (str != null && str.length() >= 2) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            }
            return bArr;
        }
        return null;
    }

    public static String padString(String str) {
        int length = 16 - (str.length() % 16);
        for (int i2 = 0; i2 < length; i2++) {
            str = str + ' ';
        }
        return str;
    }
}
