package com.baidu.prologue.a.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes6.dex */
public class g {
    /* JADX WARN: Removed duplicated region for block: B:40:0x004c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(File file) {
        FileInputStream fileInputStream;
        int read;
        if (!file.exists()) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            byte[] bArr = new byte[BdStatsConstant.MAX_WRITE_LOG_SIZE];
            fileInputStream = new FileInputStream(file);
            do {
                try {
                    try {
                        read = fileInputStream.read(bArr, 0, bArr.length);
                        if (read < 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } while (read > 0);
            String u = u(messageDigest.digest());
            if (fileInputStream == null) {
                return u;
            }
            try {
                fileInputStream.close();
                return u;
            } catch (IOException e3) {
                e3.printStackTrace();
                return u;
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static String u(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char c = cArr[(b & 240) >> 4];
            char c2 = cArr[b & 15];
            sb.append(c);
            sb.append(c2);
        }
        return sb.toString();
    }
}
