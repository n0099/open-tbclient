package com.baidu.adp.lib.g;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    private static String b = "baidu";
    public static final File a = Environment.getExternalStorageDirectory();

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
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

    public static boolean b() {
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
            if (!file.exists() && !file.mkdirs()) {
                e.b("FileHelper", "checkDir", "error fulldirObj.mkdirs:" + a2);
                return false;
            }
            return true;
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
        String g = g(a(str, str2));
        File file = new File(g);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    e.b("FileHelper", "checkAndMkdirs", "error fulldirObj.mkdirs:" + g);
                    return false;
                }
            } catch (Exception e) {
                e.b("FileHelper", "checkAndMkdirs", "error fulldirObj.mkdirs error:" + e.getMessage() + " " + g);
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
                e.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File d(String str, String str2) {
        File file = null;
        if (!c(str)) {
            e.b("FileHelper", "CreateFile", "error checkDir");
        } else {
            try {
                if (!b(str, str2)) {
                    e.b("FileHelper", "CreateFile", "error checkAndMkdirs");
                } else {
                    File c = c(str, str2);
                    if (c.exists() && !c.delete()) {
                        e.b("FileHelper", "CreateFile", "error file.delete");
                    } else if (c.createNewFile()) {
                        file = c;
                    } else {
                        e.b("FileHelper", "CreateFile", "error createNewFile" + str + str2);
                    }
                }
            } catch (Exception e) {
                e.b("FileHelper", "CreateFile", "error = " + e.getMessage() + " input:" + str + str2);
            }
        }
        return file;
    }

    public static File e(String str, String str2) {
        if (c(str)) {
            try {
                File c = c(str, str2);
                if (c.exists()) {
                    return c;
                }
                if (c.createNewFile()) {
                    return c;
                }
                return null;
            } catch (Exception e) {
                e.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File d(String str) {
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
                e.b("FileHelper", "DelFile", "error = " + e.getMessage());
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

    public static long a(String str, boolean z) {
        return a(new File(str), z);
    }

    public static long a(File file, boolean z) {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isDirectory() && !z) {
                length = a(listFiles[i], false);
            } else {
                length = listFiles[i].length();
            }
            j += length;
        }
        return j;
    }

    public static void f(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.b("BdFileHelper", "makeRootDirectory", "error = " + e.getMessage());
        }
    }

    public static long a(File file) {
        try {
            if (file.exists()) {
                return new FileInputStream(file).available();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }
}
