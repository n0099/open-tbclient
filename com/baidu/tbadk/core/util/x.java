package com.baidu.tbadk.core.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class x {
    public static final File a = Environment.getExternalStorageDirectory();
    private static final File b = TbadkApplication.m252getInst().getApp().getCacheDir();

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.error_sd_unmount);
        }
        if (externalStorageState.equals("shared")) {
            return TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.error_sd_shared);
        }
        return TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.error_sd_error);
    }

    public static boolean a(String str) {
        if (a()) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    return file.mkdirs();
                } catch (Exception e) {
                    TiebaStatic.file(e, "FileHelper.CheckTempDir " + str);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(a + "/" + TbConfig.getTempDirName() + "/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(a).append("/").append(TbConfig.getTempDirName()).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e("FileHelper", "CheckFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.CheckFile " + str);
                return false;
            }
        }
        return false;
    }

    public static long a(String str, String str2) {
        if (a()) {
            try {
                if (new File(a + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2).exists()) {
                    return TbConfig.getBigImageSize();
                }
                return -1L;
            } catch (Exception e) {
                BdLog.e("FileHelper", "CheckFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.checkImageFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return a + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    public static File d(String str) {
        if (c()) {
            File file = new File(a + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                BdLog.e("FileHelper", "GetFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.GetFile" + str);
                return null;
            }
        }
        return null;
    }

    public static File e(String str) {
        if (!c()) {
            return null;
        }
        return new File(a + "/" + TbConfig.getTempDirName() + "/" + str);
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(a + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e("FileHelper", "CreateFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.CreateFile " + str);
                return null;
            }
        }
        return null;
    }

    public static File g(String str) {
        if (c()) {
            File file = new File(a + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                BdLog.e("FileHelper", "CreateFileIfNotFound", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.CreateFileIfNotFound " + str);
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [416=4, 417=4, 419=4, 420=4, 421=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x017d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        FileInputStream fileInputStream2 = null;
        ?? sb = new StringBuilder(String.valueOf(str != null ? a + "/" + TbConfig.getTempDirName() + "/" + str + "/" : a + "/" + TbConfig.getTempDirName() + "/"));
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? com.baidu.adp.lib.util.k.a(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.file(e2, "FileHelper.isGif " + str + "/" + str2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    TiebaStatic.file(e4, "FileHelper.isGif " + str + "/" + str2);
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            TiebaStatic.file(e, "FileHelper.isGif " + str + "/" + str2);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    TiebaStatic.file(e6, "FileHelper.isGif " + str + "/" + str2);
                                }
                            }
                            return z;
                        }
                    } else {
                        fileInputStream2 = fileInputStream;
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            TiebaStatic.file(e7, "FileHelper.isGif " + str + "/" + str2);
                        }
                    }
                } catch (FileNotFoundException e8) {
                    e2 = e8;
                    z = false;
                } catch (IOException e9) {
                    e = e9;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
                if (sb != 0) {
                    try {
                        sb.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        TiebaStatic.file(e10, "FileHelper.isGif " + str + "/" + str2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            fileInputStream = null;
            e2 = e11;
            z = false;
        } catch (IOException e12) {
            fileInputStream = null;
            e = e12;
            z = false;
        } catch (Throwable th2) {
            th = th2;
            sb = 0;
            if (sb != 0) {
            }
            throw th;
        }
        return z;
    }

    public static String a(String str, String str2, Bitmap bitmap, int i) {
        String str3;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            str3 = a + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = a + "/" + TbConfig.getTempDirName() + "/";
        }
        if (!a(str3) || bitmap == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e("FileHelper", "SaveFile", e.getMessage());
            TiebaStatic.file(e, "FileHelper.SaveFile1 " + str + "/" + str2);
            return null;
        }
    }

    public static String a(String str, Bitmap bitmap, int i) {
        File dataDirectory;
        if (bitmap == null) {
            return null;
        }
        if (a()) {
            dataDirectory = new File(a + "/" + TbConfig.getTempDirName());
        } else {
            dataDirectory = Environment.getDataDirectory();
        }
        if (dataDirectory.exists() && !dataDirectory.isDirectory()) {
            dataDirectory.delete();
        }
        if (!dataDirectory.exists()) {
            dataDirectory.mkdirs();
        }
        File file = new File(dataDirectory, str);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e("FileHelper", "saveFileToSDOrMemory", e.getMessage());
            TiebaStatic.file(e, "FileHelper.saveFileToSDOrMemory " + file.getAbsolutePath());
            return null;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = a + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str5 = a + "/" + TbConfig.getTempDirName() + "/";
        }
        if (str3 != null) {
            str6 = a + "/" + TbConfig.getTempDirName() + "/" + str3 + "/";
        } else {
            str6 = a + "/" + TbConfig.getTempDirName() + "/";
        }
        if (a(str5) && a(str6)) {
            File file = new File(String.valueOf(str5) + str2);
            File file2 = new File(String.valueOf(str6) + str4);
            if (!file.renameTo(file2)) {
                TiebaStatic.file("renameTo err", "FileHelper.renameTo");
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = a + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = a + "/" + TbConfig.getTempDirName() + "/";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(String.valueOf(str3) + str2, options);
        } catch (OutOfMemoryError e) {
            TiebaStatic.file(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
            System.gc();
            try {
                return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
            } catch (OutOfMemoryError e2) {
                TiebaStatic.file(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [626=4, 627=4, 629=4, 630=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00dd */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00df */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00e1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.adp.widget.a.a d(String str, String str2) {
        FileInputStream fileInputStream;
        com.baidu.adp.widget.a.a aVar;
        ?? r2 = "/";
        String str3 = a + "/" + TbConfig.getTempDirName() + "/" + a(3) + "/";
        try {
            try {
                fileInputStream = new FileInputStream(String.valueOf(str3) + str);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDither = true;
                    options.inScreenDensity = TbadkApplication.m252getInst().getResources().getDisplayMetrics().densityDpi;
                    options.inTargetDensity = options.inScreenDensity;
                    options.inDensity = options.inScreenDensity;
                    Rect rect = new Rect();
                    aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeStream(fileInputStream, rect, options), false, str2, rect);
                    r2 = fileInputStream;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            r2 = fileInputStream;
                        } catch (IOException e) {
                            BdLog.d(e.getMessage());
                            r2 = fileInputStream;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            BdLog.d(e3.getMessage());
                        }
                    }
                    return null;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    TiebaStatic.file(e.getMessage(), "FileHelper.getImage " + str3 + str);
                    System.gc();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    }
                    aVar = null;
                    r2 = fileInputStream;
                    return aVar;
                }
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e6) {
                        BdLog.d(e6.getMessage());
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            fileInputStream = null;
        } catch (OutOfMemoryError e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            if (r2 != 0) {
            }
            throw th;
        }
        return aVar;
    }

    public static String a(String str, byte[] bArr) {
        return a((String) null, str, bArr);
    }

    public static String a(String str, byte[] bArr, int i) {
        return a() ? a((String) null, a(str, i, false), bArr) : a(i, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [691=5, 692=5, 694=5, 695=10, 696=5, 697=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x0264 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0266 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x0094 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:70:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v50, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        String str3;
        FileOutputStream fileOutputStream;
        String str4;
        if (!a(str != null ? a + "/" + TbConfig.getTempDirName() + "/" + str + "/" : a + "/" + TbConfig.getTempDirName() + "/") || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        String parent = file.getParent();
        boolean isNull = StringUtils.isNull(parent);
        FileOutputStream fileOutputStream2 = isNull;
        if (!isNull) {
            ?? file2 = new File(parent);
            boolean exists = file2.exists();
            fileOutputStream2 = file2;
            if (!exists) {
                file2.mkdirs();
                fileOutputStream2 = file2;
            }
        }
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream2 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        BdLog.e("FileHelper", "SaveFile", "error = " + th2.getMessage());
                        TiebaStatic.file(th2.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = 0;
            if (fileOutputStream2 != 0) {
            }
            throw th;
        }
        if (file.exists() && !file.delete()) {
            if (0 != 0) {
                try {
                    fileOutputStream3.close();
                } catch (Throwable th4) {
                    BdLog.e("FileHelper", "SaveFile", "error = " + th4.getMessage());
                    TiebaStatic.file(th4.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                }
            }
            return null;
        } else if (!file.createNewFile()) {
            if (0 != 0) {
                try {
                    fileOutputStream3.close();
                } catch (Throwable th5) {
                    BdLog.e("FileHelper", "SaveFile", "error = " + th5.getMessage());
                    TiebaStatic.file(th5.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
                }
            }
            return null;
        } else {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream2 = 0;
                fileOutputStream2 = 0;
                str4 = file.getPath();
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th6) {
                        BdLog.e("FileHelper", "SaveFile", "error = " + th6.getMessage());
                        String str5 = "FileHelper.SaveFile2 " + str + "/" + str2;
                        TiebaStatic.file(th6.getMessage(), str5);
                        fileOutputStream2 = str5;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                BdLog.e("FileHelper", "SaveFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.SaveFile2 " + str + "/" + str2);
                String str6 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        str6 = fileOutputStream;
                    } catch (Throwable th7) {
                        BdLog.e("FileHelper", "SaveFile", "error = " + th7.getMessage());
                        String str7 = "FileHelper.SaveFile2 " + str + "/" + str2;
                        TiebaStatic.file(th7.getMessage(), str7);
                        str6 = str7;
                    }
                }
                str4 = null;
                fileOutputStream2 = str6;
                return str4;
            }
            return str4;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [751=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0118 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static String a(String str, String str2, InputStream inputStream) {
        String str3;
        FileOutputStream fileOutputStream;
        if (!a(str != null ? a + "/" + TbConfig.getTempDirName() + "/" + str + "/" : a + "/" + TbConfig.getTempDirName() + "/") || inputStream == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        String parent = file.getParent();
        boolean isNull = StringUtils.isNull(parent);
        ?? r2 = isNull;
        if (!isNull) {
            File file2 = new File(parent);
            boolean exists = file2.exists();
            r2 = file2;
            if (!exists) {
                file2.mkdirs();
                r2 = file2;
            }
        }
        try {
            try {
                if (file.exists() && !file.delete()) {
                    m.a((OutputStream) null);
                    return null;
                } else if (!file.createNewFile()) {
                    m.a((OutputStream) null);
                    return null;
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                fileOutputStream.flush();
                                String path = file.getPath();
                                m.a((OutputStream) fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        e = e;
                        BdLog.e("FileHelper", "SaveFile", "error = " + e.getMessage());
                        TiebaStatic.file(e, "FileHelper.saveFile " + str + "/" + str2);
                        m.a((OutputStream) fileOutputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                m.a((OutputStream) r2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            m.a((OutputStream) r2);
            throw th;
        }
    }

    public static byte[] e(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = a + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = a + "/" + TbConfig.getTempDirName() + "/";
        }
        File file = new File(String.valueOf(str3) + str2);
        try {
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            }
            return null;
        } catch (IOException e) {
            BdLog.e("FileHelper", "GetFileData", "error = " + e.getMessage());
            TiebaStatic.file(e, "FileHelper.GetFileData " + str + "/" + str2);
            return null;
        }
    }

    private static String b(String str, boolean z) {
        return (z && str.startsWith(a.toString())) ? str : a + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [838=4, 839=4, 841=4, 842=4, 843=4, 846=4, 847=4, 849=4, 850=4, 851=4] */
    public static boolean a(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            r3 = 0
            r1 = 0
            r2 = 0
            java.lang.String r4 = b(r8, r10)
            java.lang.String r5 = b(r9, r10)
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L236
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L236
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L236
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L236
            boolean r4 = r6.exists()     // Catch: java.lang.Throwable -> L236
            if (r4 != 0) goto L89
            if (r3 == 0) goto L21
            r1.close()     // Catch: java.lang.Throwable -> L27
        L21:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L58
        L26:
            return r0
        L27:
            r1 = move-exception
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4, r5, r6)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)
            goto L21
        L58:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L26
        L89:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L236
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L236
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L23a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L23a
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> Le9
        L97:
            int r5 = r4.read(r1)     // Catch: java.lang.Throwable -> Le9
            if (r5 > 0) goto Le4
            r4.close()     // Catch: java.lang.Throwable -> Le9
            r1 = 0
            r2.close()     // Catch: java.lang.Throwable -> L23f
            r2 = 0
            r0 = 1
            if (r3 == 0) goto Lab
            r1.close()     // Catch: java.lang.Throwable -> L1f8
        Lab:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> Lb2
            goto L26
        Lb2:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L26
        Le4:
            r6 = 0
            r2.write(r1, r6, r5)     // Catch: java.lang.Throwable -> Le9
            goto L97
        Le9:
            r1 = move-exception
            r3 = r4
        Leb:
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L233
            com.baidu.adp.lib.util.BdLog.e(r4, r5, r6)     // Catch: java.lang.Throwable -> L233
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L233
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L233
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L233
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L233
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L233
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L233
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L233
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)     // Catch: java.lang.Throwable -> L233
            if (r3 == 0) goto L11f
            r3.close()     // Catch: java.lang.Throwable -> L158
        L11f:
            if (r2 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L126
            goto L26
        L126:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L26
        L158:
            r1 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3, r4, r5)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FileHelper.CopyFile "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r3)
            goto L11f
        L189:
            r0 = move-exception
            r2 = r3
        L18b:
            if (r3 == 0) goto L190
            r3.close()     // Catch: java.lang.Throwable -> L196
        L190:
            if (r2 == 0) goto L195
            r2.close()     // Catch: java.lang.Throwable -> L1c7
        L195:
            throw r0
        L196:
            r1 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3, r4, r5)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FileHelper.CopyFile "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r3)
            goto L190
        L1c7:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L195
        L1f8:
            r1 = move-exception
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4, r5, r6)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)
            goto Lab
        L22a:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L18b
        L22f:
            r0 = move-exception
            r3 = r4
            goto L18b
        L233:
            r0 = move-exception
            goto L18b
        L236:
            r1 = move-exception
            r2 = r3
            goto Leb
        L23a:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto Leb
        L23f:
            r1 = move-exception
            goto Leb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.x.a(java.lang.String, java.lang.String, boolean):boolean");
    }

    public static boolean f(String str, String str2) {
        return a(str, str2, false);
    }

    public static InputStream h(String str) {
        return a(d(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r1.exists() == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InputStream i(String str) {
        File file = null;
        File file2 = new File(str);
        try {
            try {
            } catch (SecurityException e) {
                BdLog.e("FileHelper", "GetFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.GetStreamFromTmpFile " + str);
                return a(file);
            }
        } catch (Throwable th) {
        }
        file = file2;
        return a(file);
    }

    public static InputStream a(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                BdLog.e("FileHelper", "GetStreamFromFile", "error = " + th.getMessage());
                TiebaStatic.file(th.getMessage(), "FileHelper.GetStreamFromFile");
                return null;
            }
        }
        return null;
    }

    public static boolean j(String str) {
        if (c()) {
            File file = new File(a + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                BdLog.e("FileHelper", "DelFile", "error = " + th.getMessage());
                TiebaStatic.file(th.getMessage(), "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static String d() {
        return a + "/" + TbConfig.getTempDirName() + "/";
    }

    public static boolean g(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (!StringUtils.isNull(parent)) {
            File file3 = new File(parent);
            if (!file3.exists()) {
                file3.mkdirs();
            }
        }
        if (file.exists()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static long e() {
        String absolutePath;
        if (a()) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            absolutePath = Environment.getRootDirectory().getAbsolutePath();
        }
        if (absolutePath == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(absolutePath);
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static String a(int i, String str) {
        return a(i, str, false);
    }

    private static String a(int i, String str, boolean z) {
        if (b == null) {
            return null;
        }
        File[] listFiles = b.listFiles();
        String a2 = a(i);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2] != null && listFiles[i2].getName().startsWith(a2)) {
                if (listFiles[i2].getName().endsWith(str)) {
                    return listFiles[i2].getAbsolutePath();
                }
                if (z) {
                    listFiles[i2].delete();
                }
            }
        }
        return null;
    }

    public static String a(int i) {
        switch (i) {
            case 1:
                return "voice";
            case 2:
                return "emotion";
            case 3:
                return "bubble";
            default:
                return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1123=4, 1124=4, 1126=4, 1127=8, 1128=4, 1129=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x011a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x011c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        String str2;
        File createTempFile;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String a2 = a(i, str, true);
        if (a2 == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    createTempFile = File.createTempFile(a(i), str, b);
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            BdLog.e("FileHelper", "SaveFile", "error = " + th2.getMessage());
                            TiebaStatic.file(th2.getMessage(), "FileHelper.SaveFile ");
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            if (createTempFile == null) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th4) {
                        BdLog.e("FileHelper", "SaveFile", "error = " + th4.getMessage());
                        TiebaStatic.file(th4.getMessage(), "FileHelper.SaveFile ");
                    }
                }
                return null;
            }
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                fileOutputStream2 = null;
                fileOutputStream2 = null;
                str2 = createTempFile.getPath();
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th5) {
                        BdLog.e("FileHelper", "SaveFile", "error = " + th5.getMessage());
                        TiebaStatic.file(th5.getMessage(), "FileHelper.SaveFile ");
                        fileOutputStream2 = "FileHelper.SaveFile ";
                    }
                }
            } catch (IOException e2) {
                e = e2;
                BdLog.e("FileHelper", "SaveFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.SaveFile ");
                FileOutputStream fileOutputStream3 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        fileOutputStream3 = fileOutputStream;
                    } catch (Throwable th6) {
                        BdLog.e("FileHelper", "SaveFile", "error = " + th6.getMessage());
                        TiebaStatic.file(th6.getMessage(), "FileHelper.SaveFile ");
                        fileOutputStream3 = "FileHelper.SaveFile ";
                    }
                }
                str2 = null;
                fileOutputStream2 = fileOutputStream3;
                return str2;
            }
            return str2;
        }
        return a2;
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (a()) {
            if (b(a(str, i, false))) {
                return a(str, i, true);
            }
            return null;
        }
        return a(1, str);
    }

    public static String a(String str, int i, boolean z) {
        if (!a()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(d());
        }
        sb.append(a(i));
        sb.append(File.separator);
        sb.append(str);
        return sb.toString();
    }

    public static long k(String str) {
        return b(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(File file) {
        FileInputStream fileInputStream;
        long j = 0;
        try {
            if (!file.exists()) {
                fileInputStream = null;
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        j = fileInputStream.available();
                    } catch (Exception e) {
                        e = e;
                        TiebaStatic.file(e, "FileHelper.getFileSize");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                TiebaStatic.file(e2, "FileHelper.getFileSize");
                            }
                        }
                        return j;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            TiebaStatic.file(e3, "FileHelper.getFileSize");
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    TiebaStatic.file(e4, "FileHelper.getFileSize");
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
        return j;
    }

    public static boolean c(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            TiebaStatic.file(e, "FileHelper.deleteFile");
            return false;
        }
    }

    public static long a(String str, boolean z) {
        return a(new File(str), z);
    }

    public static long a(File file, boolean z) {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory() && !z) {
                    length = a(listFiles[i], false);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    public static void l(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            TiebaStatic.file(e, "FileHelper.makeRootDirectory " + str);
        }
    }

    public static long h(String str, String str2) {
        if (a()) {
            try {
                File file = new File(a + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2);
                if (file.exists()) {
                    return file.length();
                }
                return -1L;
            } catch (Exception e) {
                BdLog.e("FileHelper", "CheckFile", "error = " + e.getMessage());
                TiebaStatic.file(e, "FileHelper.checkFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    public static int a(String str, byte[] bArr, Context context) {
        String str2;
        String f;
        int i = -1;
        if (bArr == null || str == null || str.length() == 0 || context == null) {
            return -1;
        }
        try {
            if (!com.baidu.adp.lib.util.k.a(bArr)) {
                str2 = ".jpg";
            } else {
                str2 = ".gif";
            }
            if (com.baidu.adp.lib.util.k.b(bArr)) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray != null) {
                    bArr = com.baidu.adp.lib.util.b.a().a(decodeByteArray, 100);
                    decodeByteArray.recycle();
                } else {
                    BdLog.e("Failed to decode the webp when save file.");
                }
            }
            if (bg.f(str) != null) {
                String str3 = String.valueOf(f) + str2;
                for (int i2 = 0; b(str3) && i2 < 10000; i2++) {
                    str3 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a2 = a(str3, bArr);
                if (a2 != null) {
                    new al(context).a(a2);
                    i = 0;
                    return 0;
                }
                return -2;
            }
            return -1;
        } catch (Exception e) {
            BdLog.e("FileHelper", "saveImageFileByUser", "error" + e.getMessage());
            return i;
        }
    }
}
