package com.baidu.sofire.b;

import com.baidu.sapi2.utils.SapiEnv;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public final class a {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] doFinal = cipher.doFinal(bArr2);
            byte[] b = l.b(bArr2);
            byte[] bArr4 = new byte[doFinal.length + b.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(b, 0, bArr4, doFinal.length, b.length);
            return bArr4;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance(SapiEnv.SHARE_AES_MODE);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, SapiEnv.SHARE_ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            if (z) {
                byte[] bArr4 = new byte[bArr2.length - 16];
                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length - 16);
                bArr2 = bArr4;
            }
            return cipher.doFinal(bArr2);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static int a(File file, File file2, byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr3 = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    new StringBuilder().append(read);
                    if (read < 8192) {
                        bArr2 = new byte[read];
                        System.arraycopy(bArr3, 0, bArr2, 0, read);
                    } else {
                        bArr2 = bArr3;
                    }
                    byte[] a = a(bArr, bArr2, false);
                    new StringBuilder().append(a.length);
                    fileOutputStream.write(a);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Throwable th) {
                d.a(th);
                i = -1;
            }
            return i;
        }
        return -1;
    }
}
