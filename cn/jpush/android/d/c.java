package cn.jpush.android.d;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes3.dex */
public final class c {
    public static String a(Context context, String str) {
        try {
            File d = d(context, str);
            if (d == null) {
                return "";
            }
            if (d.isFile()) {
                d.delete();
            }
            if (!d.exists()) {
                d.mkdirs();
            }
            return d.getAbsolutePath() + File.separator;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.substring(str.lastIndexOf("/") + 1, str.length());
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean a(File file) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    return file.delete();
                }
                String[] list = file.list();
                if (list != null) {
                    for (String str : list) {
                        File file2 = new File(file, str);
                        if (file2.isDirectory()) {
                            a(file2);
                        } else {
                            file2.delete();
                        }
                    }
                }
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes("UTF-8");
            } catch (Exception e) {
                return false;
            }
        } else {
            bytes = null;
        }
        return b(str, bytes);
    }

    public static boolean a(String str, byte[] bArr) {
        return bArr != null && bArr.length > 0 && b(str, bArr);
    }

    public static String b(Context context, String str) {
        File[] listFiles;
        try {
            if (a.a()) {
                String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + File.separator + str + File.separator;
                File file = new File(str2);
                if (file.exists()) {
                    return str2;
                }
                file.mkdirs();
                return str2;
            }
            File d = d(context, "rich");
            if (d != null && d.exists() && d.isDirectory() && (listFiles = d.listFiles()) != null && listFiles.length > 10) {
                Arrays.sort(listFiles, new d());
                a(listFiles[listFiles.length - 1]);
            }
            return a(context, "rich" + File.separator + str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static boolean b(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists()) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                    }
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            a(fileOutputStream);
            return true;
        } catch (Exception e3) {
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }

    public static String c(Context context, String str) {
        String str2;
        try {
            if (a.a()) {
                str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + File.separator + str;
                if (!new File(str2).exists()) {
                    f.c("DirectoryUtils", "Can't find developer picture resource in SDCard.");
                    str2 = "";
                }
            } else {
                f.c("DirectoryUtils", "No SDCard found.");
                str2 = "";
            }
            return str2;
        } catch (Exception e) {
            f.c("DirectoryUtils", "Get developer picture resource failed.");
            e.printStackTrace();
            return "";
        }
    }

    private static File d(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return new File(filesDir, str);
    }
}
