package com.baidu.sofire.g;

import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f11446a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9, "a", "b", "c", "d", "e", "f"};

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str3 = new String(str);
            try {
                return c(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
            } catch (Throwable unused) {
                str2 = str3;
                d.a();
                return str2;
            }
        } catch (Throwable unused2) {
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            if (i < 0) {
                i += 256;
            }
            stringBuffer.append(f11446a[i / 16] + f11446a[i % 16]);
        }
        return stringBuffer.toString();
    }

    public static String d(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b2 >>> 4) & 15];
            cArr2[i2 + 1] = cArr[b2 & 15];
        }
        return new String(cArr2);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return c(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            String d2 = d(messageDigest.digest());
            try {
                fileInputStream.close();
            } catch (IOException unused2) {
                d.a();
            }
            return d2;
        } catch (Throwable unused3) {
            try {
                d.a();
                return null;
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                        d.a();
                    }
                }
            }
        }
    }
}
