package com.baidu.sofire.b;

import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.util.AiAppEncryptUtils;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class n {
    private static final String[] a = {"0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, "9", Config.APP_VERSION_CODE, "b", "c", "d", "e", "f"};

    private static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            stringBuffer.append(a[i / 16] + a[i % 16]);
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
            th = th;
        }
        try {
            return d(MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(str2.getBytes()));
        } catch (Throwable th2) {
            str3 = str2;
            th = th2;
            e.a(th);
            return str3;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return d(MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(bArr));
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        String str = null;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
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
                    str = e(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.a(e);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        e.a(th);
                        return str;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e.a(e2);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return str;
    }

    private static String e(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr2[i * 2] = cArr[(b >>> 4) & 15];
            cArr2[(i * 2) + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase).append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance(AiAppEncryptUtils.ENCRYPT_MD5).digest(bArr);
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }
}
