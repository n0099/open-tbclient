package com.baidu.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
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
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / FileUtils.ONE_KB) / FileUtils.ONE_KB > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String b(String str) {
        return a(null, str);
    }

    public static boolean c(String str) {
        String a2 = a(str);
        if (a()) {
            File file = new File(a2);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String f(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean b(String str, String str2) {
        File file = new File(f(a(str, str2)));
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

    public static boolean e(String str, String str2) {
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

    public static boolean d(String str) {
        return e(null, str);
    }

    public static void a(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static void e(String str) {
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
