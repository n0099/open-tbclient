package com.baidu.sofire.b;

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
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.f.x);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] doFinal = cipher.doFinal(bArr2);
            byte[] a = j.a(bArr2);
            byte[] bArr4 = new byte[doFinal.length + a.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(a, 0, bArr4, doFinal.length, a.length);
            return bArr4;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.f.x);
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

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0043: ARRAY_LENGTH  (r7v0 int A[REMOVE]) = (r2v7 byte[]))] */
    public static int a(File file, File file2, byte[] bArr) {
        byte[] bArr2;
        if (file == null || !file.exists()) {
            return -1;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr3 = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr3);
                if (read != -1) {
                    new StringBuilder().append(read).toString();
                    com.baidu.sofire.b.a();
                    if (read < bArr3.length) {
                        bArr2 = new byte[read];
                        System.arraycopy(bArr3, 0, bArr2, 0, read);
                    } else {
                        bArr2 = bArr3;
                    }
                    byte[] a = a(bArr, bArr2, false);
                    new StringBuilder().append(a.length).toString();
                    com.baidu.sofire.b.a();
                    fileOutputStream.write(a);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
            }
        } catch (Throwable th) {
            d.a(th);
            return -1;
        }
    }
}
