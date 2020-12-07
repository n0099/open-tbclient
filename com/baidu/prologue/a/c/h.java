package com.baidu.prologue.a.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes14.dex */
public class h {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [54=4] */
    public static String r(File file) {
        Exception exc;
        int read;
        if (!file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                byte[] bArr = new byte[BdStatsConstant.MAX_WRITE_LOG_SIZE];
                FileInputStream fileInputStream2 = new FileInputStream(file);
                do {
                    try {
                        read = fileInputStream2.read(bArr, 0, bArr.length);
                        if (read < 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e) {
                        fileInputStream = fileInputStream2;
                        exc = e;
                        if (com.baidu.prologue.a.b.a.clZ.get().aes()) {
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
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } while (read > 0);
                String G = G(messageDigest.digest());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        return G;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return G;
                    }
                }
                return G;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            exc = e5;
        }
    }

    public static String G(byte[] bArr) {
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
