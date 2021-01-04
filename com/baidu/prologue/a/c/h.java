package com.baidu.prologue.a.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes5.dex */
public class h {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [54=4] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String v(File file) {
        Exception exc;
        FileInputStream fileInputStream;
        int read;
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5);
                messageDigest.reset();
                byte[] bArr = new byte[BdStatsConstant.MAX_WRITE_LOG_SIZE];
                fileInputStream = new FileInputStream(file);
                do {
                    try {
                        read = fileInputStream.read(bArr, 0, bArr.length);
                        if (read < 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e) {
                        exc = e;
                        if (com.baidu.prologue.a.b.a.ctd.get().ago()) {
                            throw new RuntimeException(exc);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return "";
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return "";
                            }
                        }
                        return "";
                    }
                } while (read > 0);
                String E = E(messageDigest.digest());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return E;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return E;
                    }
                }
                return E;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            exc = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }

    public static String E(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            char c = cArr[(b2 & 240) >> 4];
            char c2 = cArr[b2 & 15];
            sb.append(c);
            sb.append(c2);
        }
        return sb.toString();
    }
}
