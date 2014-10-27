package com.baidu.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class d {
    private static String mH = "baidu";
    public static final File mI = Environment.getExternalStorageDirectory();

    public static boolean bm() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int eT() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            return 0;
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable") || externalStorageState.equals("removed")) {
            return 1;
        }
        if (externalStorageState.equals("shared")) {
            return 2;
        }
        return 3;
    }

    public static String ap(String str) {
        if (str != null) {
            return mI + "/" + mH + "/" + str + "/";
        }
        return mI + "/" + mH + "/";
    }

    public static String o(String str, String str2) {
        if (str != null) {
            return mI + "/" + mH + "/" + str + "/" + str2;
        }
        return mI + "/" + mH + "/" + str2;
    }

    public static boolean eU() {
        try {
            StatFs statFs = new StatFs(mI.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String aq(String str) {
        return o(null, str);
    }

    public static boolean ar(String str) {
        String ap = ap(str);
        if (bm()) {
            File file = new File(ap);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String as(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean p(String str, String str2) {
        File file = new File(as(o(str, str2)));
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    return false;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static File q(String str, String str2) {
        if (ar(str)) {
            try {
                return new File(o(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File r(String str, String str2) {
        if (ar(str)) {
            try {
                if (p(str, str2)) {
                    File q = q(str, str2);
                    if (!q.exists() || q.delete()) {
                        if (q.createNewFile()) {
                            return q;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [448=5, 449=5, 451=5, 452=5] */
    public static boolean a(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!ar(str) || !p(str, str2)) {
            return false;
        }
        File q = q(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (q.exists() && !q.delete()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                            return false;
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                            return false;
                        }
                    }
                    return false;
                } else if (!q.createNewFile()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                            return false;
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                            return false;
                        }
                    }
                    return false;
                } else {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(q);
                    try {
                        fileOutputStream3.write(bArr, 0, bArr.length);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        FileOutputStream fileOutputStream4 = null;
                        if (0 != 0) {
                            try {
                                fileOutputStream4.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                        }
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream3;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                                BdLog.e(e6.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(String str, byte[] bArr) {
        return a(null, str, bArr);
    }

    public static byte[] s(String str, String str2) {
        byte[] bArr = null;
        if (ar(str)) {
            File q = q(str, str2);
            try {
                if (q.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(q);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr2, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    return bArr;
                }
                return null;
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                return bArr;
            }
        }
        return null;
    }

    public static byte[] at(String str) {
        return s(null, str);
    }

    public static boolean t(String str, String str2) {
        if (ar(str)) {
            File q = q(str, str2);
            try {
                if (q.exists()) {
                    return q.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean au(String str) {
        return t(null, str);
    }

    public static void b(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static void av(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
