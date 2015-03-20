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
public class f {
    private static String yk = "baidu";
    public static final File yl = Environment.getExternalStorageDirectory();

    public static boolean fj() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int iv() {
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

    public static String az(String str) {
        if (str != null) {
            return yl + "/" + yk + "/" + str + "/";
        }
        return yl + "/" + yk + "/";
    }

    public static String s(String str, String str2) {
        if (str != null) {
            return yl + "/" + yk + "/" + str + "/" + str2;
        }
        return yl + "/" + yk + "/" + str2;
    }

    public static boolean iw() {
        try {
            StatFs statFs = new StatFs(yl.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String aA(String str) {
        return s(null, str);
    }

    public static boolean aB(String str) {
        String az = az(str);
        if (fj()) {
            File file = new File(az);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String aC(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean t(String str, String str2) {
        File file = new File(aC(s(str, str2)));
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

    public static File u(String str, String str2) {
        if (aB(str)) {
            try {
                return new File(s(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File x(String str, String str2) {
        if (aB(str)) {
            try {
                if (t(str, str2)) {
                    File u = u(str, str2);
                    if (!u.exists() || u.delete()) {
                        if (u.createNewFile()) {
                            return u;
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

    public static File y(String str, String str2) {
        if (aB(str)) {
            try {
                File u = u(str, str2);
                if (u.exists()) {
                    return u;
                }
                if (u.createNewFile()) {
                    return u;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File aD(String str) {
        return y(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [448=5, 449=5, 451=5, 452=5] */
    public static boolean d(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!aB(str) || !t(str, str2)) {
            return false;
        }
        File u = u(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (u.exists() && !u.delete()) {
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
                } else if (!u.createNewFile()) {
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
                    FileOutputStream fileOutputStream3 = new FileOutputStream(u);
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

    public static boolean d(String str, byte[] bArr) {
        return d(null, str, bArr);
    }

    public static byte[] z(String str, String str2) {
        byte[] bArr = null;
        if (aB(str)) {
            File u = u(str, str2);
            try {
                if (u.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(u);
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

    public static byte[] aE(String str) {
        return z(null, str);
    }

    public static boolean A(String str, String str2) {
        if (aB(str)) {
            File u = u(str, str2);
            try {
                if (u.exists()) {
                    return u.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aF(String str) {
        return A(null, str);
    }

    public static void c(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static void aG(String str) {
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
