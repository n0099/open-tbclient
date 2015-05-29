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
    private static String xZ = "baidu";
    public static final File ya = Environment.getExternalStorageDirectory();

    public static boolean fo() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int iM() {
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

    public static String aI(String str) {
        if (str != null) {
            return ya + "/" + xZ + "/" + str + "/";
        }
        return ya + "/" + xZ + "/";
    }

    public static String u(String str, String str2) {
        if (str != null) {
            return ya + "/" + xZ + "/" + str + "/" + str2;
        }
        return ya + "/" + xZ + "/" + str2;
    }

    public static boolean iN() {
        try {
            StatFs statFs = new StatFs(ya.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String aJ(String str) {
        return u(null, str);
    }

    public static boolean aK(String str) {
        String aI = aI(str);
        if (fo()) {
            File file = new File(aI);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String aL(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean x(String str, String str2) {
        File file = new File(aL(u(str, str2)));
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

    public static File y(String str, String str2) {
        if (aK(str)) {
            try {
                return new File(u(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File z(String str, String str2) {
        if (aK(str)) {
            try {
                if (x(str, str2)) {
                    File y = y(str, str2);
                    if (!y.exists() || y.delete()) {
                        if (y.createNewFile()) {
                            return y;
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

    public static File A(String str, String str2) {
        if (aK(str)) {
            try {
                File y = y(str, str2);
                if (y.exists()) {
                    return y;
                }
                if (y.createNewFile()) {
                    return y;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File aM(String str) {
        return A(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [448=5, 449=5, 451=5, 452=5] */
    public static boolean d(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!aK(str) || !x(str, str2)) {
            return false;
        }
        File y = y(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (y.exists() && !y.delete()) {
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
                } else if (!y.createNewFile()) {
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
                    FileOutputStream fileOutputStream3 = new FileOutputStream(y);
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

    public static boolean e(String str, byte[] bArr) {
        return d(null, str, bArr);
    }

    public static byte[] B(String str, String str2) {
        byte[] bArr = null;
        if (aK(str)) {
            File y = y(str, str2);
            try {
                if (y.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(y);
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

    public static byte[] aN(String str) {
        return B(null, str);
    }

    public static boolean C(String str, String str2) {
        if (aK(str)) {
            File y = y(str, str2);
            try {
                if (y.exists()) {
                    return y.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aO(String str) {
        return C(null, str);
    }

    public static void c(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static void aP(String str) {
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
