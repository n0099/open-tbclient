package com.baidu.searchbox;

import android.text.TextUtils;
import com.baidu.searchbox.bsdiff.BsPatchNative;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class NPSPatchUtils {
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static int nativePatch(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                File file2 = new File(str3);
                if (file2.exists() && file2.isFile()) {
                    try {
                        int patch = BsPatchNative.patch(str, str2, str3);
                        try {
                            file2.delete();
                            return patch;
                        } catch (Throwable unused) {
                            return patch;
                        }
                    } catch (Throwable unused2) {
                        return 1;
                    }
                }
            }
        }
        return 3;
    }

    public static int patch(String str, String str2, String str3) {
        return nativePatch(str, str2, str3);
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
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
        return sb.toString();
    }

    public static String toMd5(File file, boolean z) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    String hexString = toHexString(messageDigest.digest(), "", z);
                    closeSafely(fileInputStream);
                    return hexString;
                }
            }
        } catch (Throwable unused2) {
            closeSafely(fileInputStream);
            return null;
        }
    }
}
