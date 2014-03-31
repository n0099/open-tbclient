package com.baidu.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class c {
    private static String b = "baidu";
    public static final File a = Environment.getExternalStorageDirectory();

    private static String b(String str, String str2) {
        if (str != null) {
            return a + "/" + b + "/" + str + "/" + str2;
        }
        return a + "/" + b + "/" + str2;
    }

    public static boolean a() {
        try {
            StatFs statFs = new StatFs(a.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / FileUtils.ONE_KB) / FileUtils.ONE_KB > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String a(String str) {
        return b(null, str);
    }

    private static boolean e(String str) {
        String str2 = str != null ? a + "/" + b + "/" + str + "/" : a + "/" + b + "/";
        if (Environment.getExternalStorageState().equals("mounted")) {
            File file = new File(str2);
            if (!file.exists() && !file.mkdirs()) {
                f.b("FileHelper", "checkDir", "error fulldirObj.mkdirs:" + str2);
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean c(String str, String str2) {
        String b2 = b(str, str2);
        int lastIndexOf = b2.lastIndexOf("/");
        String substring = (lastIndexOf <= 0 || lastIndexOf >= b2.length()) ? null : b2.substring(0, lastIndexOf);
        File file = new File(substring);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    f.b("FileHelper", "checkAndMkdirs", "error fulldirObj.mkdirs:" + substring);
                    return false;
                }
            } catch (Exception e) {
                f.b("FileHelper", "checkAndMkdirs", "error fulldirObj.mkdirs error:" + e.getMessage() + " " + substring);
                return false;
            }
        }
        return true;
    }

    private static File d(String str, String str2) {
        if (e(str)) {
            try {
                return new File(b(str, str2));
            } catch (SecurityException e) {
                f.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0010 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0012 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.io.File */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public static File a(String str, String str2) {
        File file = 0;
        file = 0;
        file = 0;
        file = 0;
        file = 0;
        if (!e(null)) {
            f.b("FileHelper", "CreateFile", "error checkDir");
        } else {
            try {
                if (!c(null, str2)) {
                    f.b("FileHelper", "CreateFile", "error checkAndMkdirs");
                } else {
                    File d = d(null, str2);
                    if (d.exists() && !d.delete()) {
                        f.b("FileHelper", "CreateFile", "error file.delete");
                    } else if (d.createNewFile()) {
                        file = d;
                    } else {
                        f.b("FileHelper", "CreateFile", "error createNewFile" + ((String) null) + str2);
                    }
                }
            } catch (Exception e) {
                f.b("FileHelper", "CreateFile", "error = " + e.getMessage() + " input:" + ((String) file) + str2);
            }
        }
        return file;
    }

    private static File e(String str, String str2) {
        if (e(null)) {
            try {
                File d = d(null, str2);
                if (d.exists()) {
                    return d;
                }
                if (d.createNewFile()) {
                    return d;
                }
                return null;
            } catch (Exception e) {
                f.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File b(String str) {
        return e(null, str);
    }

    private static boolean f(String str, String str2) {
        if (e(null)) {
            File d = d(null, str2);
            try {
                if (d.exists()) {
                    return d.delete();
                }
                return false;
            } catch (Exception e) {
                f.b("FileHelper", "DelFile", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        return f(null, str);
    }

    public static void a(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static long a(String str, boolean z) {
        return a(new File(str), true);
    }

    private static long a(File file, boolean z) {
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

    public static void d(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            f.b("BdFileHelper", "makeRootDirectory", "error = " + e.getMessage());
        }
    }

    public static long a(File file) {
        FileInputStream fileInputStream;
        long j;
        FileInputStream fileInputStream2 = null;
        try {
            if (!file.exists()) {
                fileInputStream = null;
                j = 0;
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    j = fileInputStream.available();
                } catch (Exception e) {
                    fileInputStream2 = fileInputStream;
                    com.baidu.adp.lib.f.a.a((InputStream) fileInputStream2);
                    return 0L;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    com.baidu.adp.lib.f.a.a((InputStream) fileInputStream2);
                    throw th;
                }
            }
            com.baidu.adp.lib.f.a.a((InputStream) fileInputStream);
            return j;
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
