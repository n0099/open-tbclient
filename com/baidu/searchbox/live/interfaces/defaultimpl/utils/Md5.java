package com.baidu.searchbox.live.interfaces.defaultimpl.utils;

import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class Md5 {
    public static final char[] HEX_DIGITS = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(HEX_DIGITS[(bArr[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[bArr[i] & 15]);
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r5 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r5 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String toMd5(InputStream inputStream) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = toHexString(messageDigest.digest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
