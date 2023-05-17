package com.baidu.mobstat;

import com.baidu.searchbox.pms.db.PackageTable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class bs {

    /* loaded from: classes3.dex */
    public static class a {
        public static String a(byte[] bArr) {
            try {
                return bs.b(MessageDigest.getInstance(PackageTable.MD5), bArr);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static String a(File file) {
            try {
                return bs.b(MessageDigest.getInstance("SHA-256"), file);
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }

        public static String a(byte[] bArr) {
            try {
                return bs.b(MessageDigest.getInstance("SHA-256"), bArr);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static String b(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        return a(messageDigest.digest());
    }

    public static String a(byte[] bArr) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i4 = (bArr[i3] >> 4) & 15;
            int i5 = bArr[i3] & 15;
            if (i4 >= 10) {
                i = (i4 + 97) - 10;
            } else {
                i = i4 + 48;
            }
            sb.append((char) i);
            if (i5 >= 10) {
                i2 = (i5 + 97) - 10;
            } else {
                i2 = i5 + 48;
            }
            sb.append((char) i2);
        }
        return sb.toString();
    }

    public static String b(MessageDigest messageDigest, File file) {
        FileInputStream fileInputStream;
        if (file.isFile()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception unused) {
                }
                try {
                    byte[] bArr = new byte[4048];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    fileInputStream.close();
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return a(messageDigest.digest());
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return a(messageDigest.digest());
        }
        return "";
    }
}
