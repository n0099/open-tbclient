package com.baidu.swan.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class c {
    private static final boolean DEBUG = a.DEBUG;

    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [79=6, 81=5, 82=5, 83=5, 84=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0027 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(File file, boolean z) {
        Throwable th;
        FileInputStream fileInputStream;
        String str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        str = 0;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    str = toHexString(messageDigest.digest(), "", z);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (DEBUG) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    return str;
                } catch (IOException e4) {
                    e = e4;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            if (DEBUG) {
                                e5.printStackTrace();
                            }
                        }
                    }
                    return str;
                } catch (NoSuchAlgorithmException e6) {
                    e = e6;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            if (DEBUG) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        str.close();
                    } catch (IOException e8) {
                        if (DEBUG) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            fileInputStream = null;
        } catch (IOException e10) {
            e = e10;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }

    private static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }
}
