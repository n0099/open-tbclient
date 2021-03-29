package com.baidu.sofire.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public final class a {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            byte[] doFinal = cipher.doFinal(bArr2);
            byte[] b2 = n.b(bArr2);
            byte[] bArr4 = new byte[doFinal.length + b2.length];
            System.arraycopy(doFinal, 0, bArr4, 0, doFinal.length);
            System.arraycopy(b2, 0, bArr4, doFinal.length, b2.length);
            return bArr4;
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            byte[] bArr3 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr3[i] = 0;
            }
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr2);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
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
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static int a(File file, File file2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        byte[] bArr2;
        if (file == null || !file.exists()) {
            return -1;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr3 = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr3);
                    if (read != -1) {
                        new StringBuilder().append(read);
                        com.baidu.sofire.b.a();
                        if (read < 8192) {
                            bArr2 = new byte[read];
                            System.arraycopy(bArr3, 0, bArr2, 0, read);
                        } else {
                            bArr2 = bArr3;
                        }
                        byte[] a2 = a(bArr, bArr2, false);
                        new StringBuilder().append(a2.length);
                        com.baidu.sofire.b.a();
                        fileOutputStream.write(a2);
                    } else {
                        try {
                            break;
                        } catch (Throwable unused2) {
                        }
                    }
                }
                fileInputStream2.close();
                try {
                    fileOutputStream.close();
                } catch (Throwable unused3) {
                }
                return 0;
            } catch (Throwable unused4) {
                fileInputStream = fileInputStream2;
                try {
                    d.a();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return -1;
                        } catch (Throwable unused5) {
                            return -1;
                        }
                    }
                    return -1;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused7) {
                        }
                    }
                }
            }
        } catch (Throwable unused8) {
            fileOutputStream = null;
        }
    }
}
