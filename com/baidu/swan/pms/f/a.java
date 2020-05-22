package com.baidu.swan.pms.f;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes11.dex */
public class a {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [61=5] */
    public static String toMd5(File file, boolean z) {
        Throwable th;
        FileInputStream fileInputStream;
        String str = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = toHexString(messageDigest.digest(), "", z);
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                    return str;
                } catch (IOException e2) {
                    e = e2;
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                    return str;
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    if (com.baidu.swan.pms.d.DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.e.d.closeSafely(fileInputStream);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.e.d.closeSafely(null);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileInputStream = null;
        } catch (IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.swan.e.d.closeSafely(null);
            throw th;
        }
        return str;
    }

    private static String toHexString(byte[] bArr, String str, boolean z) {
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
}
