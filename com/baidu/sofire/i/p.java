package com.baidu.sofire.i;

import android.text.TextUtils;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes15.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f5556a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", com.baidu.pass.biometrics.face.liveness.d.b.f4080a, "c", "d", "e", "f"};

    private static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            stringBuffer.append(f5556a[i / 16] + f5556a[i % 16]);
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new String(str);
        } catch (Throwable th) {
        }
        try {
            return c(MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(str2.getBytes()));
        } catch (Throwable th2) {
            str3 = str2;
            e.a();
            return str3;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return c(MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(bArr));
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        String str = null;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = d(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.a();
                    }
                } catch (Throwable th) {
                    try {
                        e.a();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e.a();
                            }
                        }
                        return str;
                    } catch (Throwable th2) {
                        FileInputStream fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                e.a();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                fileInputStream = null;
            }
        }
        return str;
    }

    private static String d(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            cArr2[i * 2] = cArr[(b2 >>> 4) & 15];
            cArr2[(i * 2) + 1] = cArr[b2 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(bArr);
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }
}
