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
public class c {
    private static String b = "baidu";
    public static final File a = Environment.getExternalStorageDirectory();

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int b() {
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

    public static String a(String str) {
        if (str != null) {
            return a + "/" + b + "/" + str + "/";
        }
        return a + "/" + b + "/";
    }

    public static String a(String str, String str2) {
        if (str != null) {
            return a + "/" + b + "/" + str + "/" + str2;
        }
        return a + "/" + b + "/" + str2;
    }

    public static boolean c() {
        try {
            StatFs statFs = new StatFs(a.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String b(String str) {
        return a((String) null, str);
    }

    public static boolean c(String str) {
        String a2 = a(str);
        if (a()) {
            File file = new File(a2);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String g(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean b(String str, String str2) {
        File file = new File(g(a(str, str2)));
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

    public static File c(String str, String str2) {
        if (c(str)) {
            try {
                return new File(a(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File d(String str, String str2) {
        if (c(str)) {
            try {
                if (b(str, str2)) {
                    File c = c(str, str2);
                    if (!c.exists() || c.delete()) {
                        if (c.createNewFile()) {
                            return c;
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
        if (!c(str) || !b(str, str2)) {
            return false;
        }
        File c = c(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (c.exists() && !c.delete()) {
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
                } else if (!c.createNewFile()) {
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
                    FileOutputStream fileOutputStream3 = new FileOutputStream(c);
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

    public static boolean a(String str, byte[] bArr) {
        return a(null, str, bArr);
    }

    public static byte[] e(String str, String str2) {
        byte[] bArr = null;
        if (c(str)) {
            File c = c(str, str2);
            try {
                if (c.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(c);
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

    public static byte[] d(String str) {
        return e(null, str);
    }

    public static boolean f(String str, String str2) {
        if (c(str)) {
            File c = c(str, str2);
            try {
                if (c.exists()) {
                    return c.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean e(String str) {
        return f(null, str);
    }

    public static void a(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static void f(String str) {
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
