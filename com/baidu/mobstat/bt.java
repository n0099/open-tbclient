package com.baidu.mobstat;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public final class bt {

    /* loaded from: classes4.dex */
    public static class a {
        public static String a(byte[] bArr) {
            try {
                return bt.b(MessageDigest.getInstance("md5"), bArr);
            } catch (Exception e) {
                return "";
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static String a(byte[] bArr) {
            try {
                return bt.b(MessageDigest.getInstance("SHA-256"), bArr);
            } catch (Exception e) {
                return "";
            }
        }

        public static String a(File file) {
            try {
                return bt.b(MessageDigest.getInstance("SHA-256"), file);
            } catch (NoSuchAlgorithmException e) {
                return "";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return a(messageDigest.digest());
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [87=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public static String b(MessageDigest messageDigest, File file) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file.isFile()) {
            try {
                fileInputStream2 = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4048];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Exception e3) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                return a(messageDigest.digest());
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
            return a(messageDigest.digest());
        }
        return "";
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >> 4) & 15;
            int i3 = bArr[i] & 15;
            sb.append((char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48));
            sb.append((char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48));
        }
        return sb.toString();
    }
}
