package com.baidu.adp.lib.f;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class b {
    private static String b = "baidu";

    /* renamed from: a  reason: collision with root package name */
    public static final File f432a = Environment.getExternalStorageDirectory();

    public static boolean a() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static String a(String str) {
        if (str != null) {
            return f432a + "/" + b + "/" + str + "/";
        }
        return f432a + "/" + b + "/";
    }

    public static String a(String str, String str2) {
        if (str != null) {
            return f432a + "/" + b + "/" + str + "/" + str2;
        }
        return f432a + "/" + b + "/" + str2;
    }

    public static boolean b() {
        try {
            StatFs statFs = new StatFs(f432a.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
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
            if (!file.exists() && !file.mkdirs()) {
                d.b("FileHelper", "checkDir", "error fulldirObj.mkdirs:" + a2);
                return false;
            }
            return true;
        }
        return false;
    }

    private static String d(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean b(String str, String str2) {
        String d = d(a(str, str2));
        File file = new File(d);
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    d.b("FileHelper", "checkAndMkdirs", "error fulldirObj.mkdirs:" + d);
                    return false;
                }
            } catch (Exception e) {
                d.b("FileHelper", "checkAndMkdirs", "error fulldirObj.mkdirs error:" + e.getMessage() + " " + d);
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
                d.b("FileHelper", "GetFile", "error = " + e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File d(String str, String str2) {
        File file = null;
        if (!c(str)) {
            d.b("FileHelper", "CreateFile", "error checkDir");
        } else {
            try {
                if (!b(str, str2)) {
                    d.b("FileHelper", "CreateFile", "error checkAndMkdirs");
                } else {
                    File c = c(str, str2);
                    if (c.exists() && !c.delete()) {
                        d.b("FileHelper", "CreateFile", "error file.delete");
                    } else if (c.createNewFile()) {
                        file = c;
                    } else {
                        d.b("FileHelper", "CreateFile", "error createNewFile" + str + str2);
                    }
                }
            } catch (Exception e) {
                d.b("FileHelper", "CreateFile", "error = " + e.getMessage() + " input:" + str + str2);
            }
        }
        return file;
    }

    public static void a(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }
}
