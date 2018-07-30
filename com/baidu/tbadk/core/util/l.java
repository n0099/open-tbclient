package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class l {
    public static final File CD = Environment.getExternalStorageDirectory();
    private static final File aos = TbadkCoreApplication.getInst().getApp().getCacheDir();

    public static boolean gd() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String yi() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TbadkCoreApplication.getInst().getApp().getString(d.j.error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TbadkCoreApplication.getInst().getApp().getString(d.j.error_no_sdcard);
        }
        if (externalStorageState.equals("shared")) {
            return TbadkCoreApplication.getInst().getApp().getString(d.j.error_sd_shared);
        }
        return TbadkCoreApplication.getInst().getApp().getString(d.j.error_sd_error);
    }

    public static boolean dR(String str) {
        if (gd()) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return false;
    }

    public static boolean yj() {
        return dR(CD + "/" + TbConfig.getTempDirName() + "/");
    }

    public static boolean dS(String str) {
        if (gd()) {
            try {
                return new File(new StringBuilder().append(CD).append("/").append(TbConfig.getTempDirName()).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "CheckFile", " ", str));
                return false;
            }
        }
        return false;
    }

    public static long Y(String str, String str2) {
        if (gd()) {
            try {
                if (new File(CD + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2).exists()) {
                    return TbConfig.getBigImageSize();
                }
                return -1L;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "checkImageFileSize", " ", str, "/", str2));
                return -1L;
            }
        }
        return -1L;
    }

    public static String dT(String str) {
        if (str == null) {
            return null;
        }
        return CD + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    public static File dU(String str) {
        if (!yj()) {
            return null;
        }
        return dW(CD + "/" + TbConfig.getTempDirName() + "/" + str);
    }

    public static File dV(String str) {
        return dW(aos + "/" + str);
    }

    public static File dW(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (SecurityException e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "GetFile", " ", str));
            return null;
        }
    }

    public static String dX(String str) {
        PackageInfo packageArchiveInfo;
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = CD + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.packageName;
    }

    public static PackageInfo dY(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = CD + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager != null) {
            return packageManager.getPackageArchiveInfo(str2, 128);
        }
        return null;
    }

    public static File dZ(String str) {
        if (!yj()) {
            return null;
        }
        return new File(CD + "/" + TbConfig.getTempDirName() + "/" + str);
    }

    public static File ea(String str) {
        if (yj()) {
            File file = new File(CD + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "CreateFile", " ", str));
                return null;
            }
        }
        return null;
    }

    public static File eb(String str) {
        if (!yj()) {
            return null;
        }
        return ed(new File(CD + "/" + TbConfig.getTempDirName() + "/" + str).getAbsolutePath());
    }

    public static File ec(String str) {
        return ed(new File(aos + "/" + str).getAbsolutePath());
    }

    public static File ed(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file;
            }
            if (file.createNewFile()) {
                return file;
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "CreateFileIfNotFound", " ", str));
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [528=4, 529=4, 531=4, 532=4, 533=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x01c8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean Z(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        String str3 = str != null ? CD + "/" + TbConfig.getTempDirName() + "/" + str + "/" : CD + "/" + TbConfig.getTempDirName() + "/";
        ?? sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str3).append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? com.baidu.adp.lib.util.l.k(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            fileInputStream = null;
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.file(e2, com.baidu.adp.lib.util.k.j("FileHelper", ".", "isGif", " ", str, "/", str2));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    TiebaStatic.file(e4, com.baidu.adp.lib.util.k.j("FileHelper", ".", "isGif", " ", str, "/", str2));
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", "isGif", " ", str, "/", str2));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    TiebaStatic.file(e6, com.baidu.adp.lib.util.k.j("FileHelper", ".", "isGif", " ", str, "/", str2));
                                }
                            }
                            return z;
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                            TiebaStatic.file(e7, com.baidu.adp.lib.util.k.j("FileHelper", ".", "isGif", " ", str, "/", str2));
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
                        TiebaStatic.file(e10, com.baidu.adp.lib.util.k.j("FileHelper", ".", "isGif", " ", str, "/", str2));
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

    public static boolean ee(String str) {
        InputStream g;
        boolean z = false;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory() && (g = com.baidu.adp.lib.util.f.g(file)) != null) {
                try {
                    byte[] bArr = new byte[7];
                    if (g.read(bArr, 0, 6) == 6) {
                        z = com.baidu.adp.lib.util.l.k(bArr);
                    }
                } catch (IOException e) {
                } finally {
                    com.baidu.adp.lib.g.a.f(g);
                }
            }
        }
        return z;
    }

    public static boolean ef(String str) {
        int[] eh = eh(str);
        if (eh[0] == 0 || eh[1] == 0) {
            return false;
        }
        float ak = com.baidu.adp.lib.util.l.ak(TbadkCoreApplication.getInst());
        float f = eh[1] / eh[0];
        return ((float) eh[0]) * ak >= 100.0f && f >= 3.0f && f <= 50.0f;
    }

    public static boolean eg(String str) {
        return str.endsWith(".heif") || str.endsWith(".heic");
    }

    public static int[] eh(String str) {
        FileInputStream fileInputStream;
        int[] iArr = new int[2];
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        BitmapFactory.decodeStream(fileInputStream, null, options);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            com.baidu.adp.lib.util.n.f(fileInputStream);
                            iArr[0] = options.outWidth;
                            iArr[1] = options.outHeight;
                            return iArr;
                        } finally {
                            com.baidu.adp.lib.util.n.f(fileInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
                iArr[0] = options.outWidth;
                iArr[1] = options.outHeight;
            }
        }
        return iArr;
    }

    public static String a(String str, String str2, Bitmap bitmap, int i) {
        String str3;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            str3 = CD + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = CD + "/" + TbConfig.getTempDirName() + "/";
        }
        if (!dR(str3) || bitmap == null) {
            return null;
        }
        File file = new File(str3 + str2);
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
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile1", " '", str, "/", str2));
            return null;
        }
    }

    public static String b(String str, String str2, Bitmap bitmap, int i) {
        return a(str, str2, bitmap, i, Bitmap.CompressFormat.PNG);
    }

    public static String a(String str, String str2, Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null || !dR(str) || bitmap == null) {
            return null;
        }
        File file = new File(str + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(compressFormat, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "saveFileAsPNG", " '", str, "/", str2));
            return null;
        }
    }

    public static String a(String str, Bitmap bitmap, float f, int i) {
        File dataDirectory;
        if (bitmap == null) {
            return null;
        }
        if (gd()) {
            dataDirectory = new File(CD + "/" + TbConfig.getTempDirName());
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
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > f) {
                    byteArrayOutputStream.reset();
                    i -= 5;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public static String a(String str, Bitmap bitmap, int i) {
        String absolutePath;
        if (bitmap == null) {
            return null;
        }
        if (gd()) {
            absolutePath = CD + "/" + TbConfig.getTempDirName();
        } else {
            absolutePath = Environment.getDataDirectory().getAbsolutePath();
        }
        return c(absolutePath, str, bitmap, i);
    }

    public static String c(String str, String str2, Bitmap bitmap, int i) {
        if (bitmap == null || StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        try {
            if ((!file2.exists() || file2.delete()) && file2.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file2.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "saveFileToSDOrMemory", " ", file2.getAbsolutePath()));
            return null;
        }
    }

    public static String i(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = CD + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str5 = CD + "/" + TbConfig.getTempDirName() + "/";
        }
        if (str3 != null) {
            str6 = CD + "/" + TbConfig.getTempDirName() + "/" + str3 + "/";
        } else {
            str6 = CD + "/" + TbConfig.getTempDirName() + "/";
        }
        if (dR(str5) && dR(str6)) {
            File file = new File(str5 + str2);
            File file2 = new File(str6 + str4);
            if (!file.renameTo(file2)) {
                TiebaStatic.file(com.baidu.adp.lib.util.k.j("renameTo", NotificationCompat.CATEGORY_ERROR), com.baidu.adp.lib.util.k.j("FileHelper", ".", "renameTo"));
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap aa(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = CD + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = CD + "/" + TbConfig.getTempDirName() + "/";
        }
        return ei(str3 + str2);
    }

    public static Bitmap ei(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            TiebaStatic.file(e.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "getImage", " ", str));
            System.gc();
            try {
                return BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e2) {
                TiebaStatic.file(e.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "getImage", " ", str));
                return null;
            }
        }
    }

    public static String g(String str, byte[] bArr) {
        return d((String) null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1009=5, 1010=5, 1012=5, 1013=5, 1014=10, 1015=5] */
    public static String d(String str, String str2, byte[] bArr) {
        String str3 = str != null ? CD + "/" + TbConfig.getTempDirName() + "/" + str + "/" : CD + "/" + TbConfig.getTempDirName() + "/";
        if (!dR(str3) || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(str3 + str2);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.exists() && !file.delete()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                            return null;
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            TiebaStatic.file(th.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                            return null;
                        }
                    }
                    return null;
                } else if (!file.createNewFile()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                            return null;
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                            TiebaStatic.file(th2.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                            return null;
                        }
                    }
                    return null;
                } else {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        fileOutputStream = null;
                        String path = file.getPath();
                        if (0 != 0) {
                            try {
                                fileOutputStream.close();
                                return path;
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                                TiebaStatic.file(th3.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                                return path;
                            }
                        }
                        return path;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return null;
                            } catch (Throwable th4) {
                                BdLog.e(th4.getMessage());
                                TiebaStatic.file(th4.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th6) {
                                BdLog.e(th6.getMessage());
                                TiebaStatic.file(th6.getMessage(), com.baidu.adp.lib.util.k.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private static String g(String str, boolean z) {
        return (z && str.startsWith(CD.toString())) ? str : CD + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1070=4, 1071=4, 1073=4, 1074=4, 1075=4, 1079=4, 1080=4, 1082=4, 1083=4, 1084=4] */
    public static boolean c(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            r3 = 0
            r1 = 0
            r2 = 0
            java.lang.String r4 = g(r8, r10)
            java.lang.String r5 = g(r9, r10)
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L221
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L221
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L221
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L221
            boolean r4 = r6.exists()     // Catch: java.lang.Throwable -> L221
            if (r4 != 0) goto L85
            if (r3 == 0) goto L21
            r1.close()     // Catch: java.lang.Throwable -> L27
        L21:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L56
        L26:
            return r0
        L27:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.CopyFile "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)
            goto L21
        L56:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L26
        L85:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L221
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L221
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L225
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L225
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L9e
        L93:
            int r5 = r4.read(r1)     // Catch: java.lang.Throwable -> L9e
            if (r5 <= 0) goto L109
            r6 = 0
            r2.write(r1, r6, r5)     // Catch: java.lang.Throwable -> L9e
            goto L93
        L9e:
            r1 = move-exception
            r3 = r4
        La0:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L21f
            com.baidu.adp.lib.util.BdLog.e(r4)     // Catch: java.lang.Throwable -> L21f
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L21f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21f
            r4.<init>()     // Catch: java.lang.Throwable -> L21f
            java.lang.String r5 = "FileHelper.CopyFile "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L21f
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L21f
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L21f
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L21f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L21f
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)     // Catch: java.lang.Throwable -> L21f
            if (r3 == 0) goto Ld2
            r3.close()     // Catch: java.lang.Throwable -> L17d
        Ld2:
            if (r2 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> Ld9
            goto L26
        Ld9:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L26
        L109:
            r4.close()     // Catch: java.lang.Throwable -> L9e
            r1 = 0
            r2.close()     // Catch: java.lang.Throwable -> L22a
            r2 = 0
            r0 = 1
            if (r3 == 0) goto L117
            r1.close()     // Catch: java.lang.Throwable -> L14e
        L117:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L11e
            goto L26
        L11e:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L26
        L14e:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.CopyFile "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)
            goto L117
        L17d:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r3)
            goto Ld2
        L1ad:
            r0 = move-exception
            r2 = r3
        L1af:
            if (r3 == 0) goto L1b4
            r3.close()     // Catch: java.lang.Throwable -> L1ba
        L1b4:
            if (r2 == 0) goto L1b9
            r2.close()     // Catch: java.lang.Throwable -> L1e9
        L1b9:
            throw r0
        L1ba:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r3)
            goto L1b4
        L1e9:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L1b9
        L218:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L1af
        L21c:
            r0 = move-exception
            r3 = r4
            goto L1af
        L21f:
            r0 = move-exception
            goto L1af
        L221:
            r1 = move-exception
            r2 = r3
            goto La0
        L225:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto La0
        L22a:
            r1 = move-exception
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.l.c(java.lang.String, java.lang.String, boolean):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1126=4, 1127=4, 1129=4, 1130=4, 1131=4, 1135=4, 1136=4, 1138=4, 1139=4, 1140=4] */
    public static boolean ab(java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 0
            r3 = 0
            r1 = 0
            r2 = 0
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L219
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L219
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L219
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L219
            boolean r4 = r5.exists()     // Catch: java.lang.Throwable -> L219
            if (r4 != 0) goto L7d
            if (r3 == 0) goto L19
            r1.close()     // Catch: java.lang.Throwable -> L1f
        L19:
            if (r3 == 0) goto L1e
            r2.close()     // Catch: java.lang.Throwable -> L4e
        L1e:
            return r0
        L1f:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.CopyFile "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)
            goto L19
        L4e:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L1e
        L7d:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L219
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L219
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L21d
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L21d
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L96
        L8b:
            int r5 = r4.read(r1)     // Catch: java.lang.Throwable -> L96
            if (r5 <= 0) goto L101
            r6 = 0
            r2.write(r1, r6, r5)     // Catch: java.lang.Throwable -> L96
            goto L8b
        L96:
            r1 = move-exception
            r3 = r4
        L98:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L217
            com.baidu.adp.lib.util.BdLog.e(r4)     // Catch: java.lang.Throwable -> L217
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L217
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L217
            r4.<init>()     // Catch: java.lang.Throwable -> L217
            java.lang.String r5 = "FileHelper.CopyFile "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L217
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L217
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L217
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L217
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L217
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)     // Catch: java.lang.Throwable -> L217
            if (r3 == 0) goto Lca
            r3.close()     // Catch: java.lang.Throwable -> L175
        Lca:
            if (r2 == 0) goto L1e
            r2.close()     // Catch: java.lang.Throwable -> Ld1
            goto L1e
        Ld1:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L1e
        L101:
            r4.close()     // Catch: java.lang.Throwable -> L96
            r1 = 0
            r2.close()     // Catch: java.lang.Throwable -> L222
            r2 = 0
            r0 = 1
            if (r3 == 0) goto L10f
            r1.close()     // Catch: java.lang.Throwable -> L146
        L10f:
            if (r3 == 0) goto L1e
            r2.close()     // Catch: java.lang.Throwable -> L116
            goto L1e
        L116:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L1e
        L146:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.CopyFile "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)
            goto L10f
        L175:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r3)
            goto Lca
        L1a5:
            r0 = move-exception
            r2 = r3
        L1a7:
            if (r3 == 0) goto L1ac
            r3.close()     // Catch: java.lang.Throwable -> L1b2
        L1ac:
            if (r2 == 0) goto L1b1
            r2.close()     // Catch: java.lang.Throwable -> L1e1
        L1b1:
            throw r0
        L1b2:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.CopyFile "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r3)
            goto L1ac
        L1e1:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.CopyFile "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r2)
            goto L1b1
        L210:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L1a7
        L214:
            r0 = move-exception
            r3 = r4
            goto L1a7
        L217:
            r0 = move-exception
            goto L1a7
        L219:
            r1 = move-exception
            r2 = r3
            goto L98
        L21d:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L98
        L222:
            r1 = move-exception
            goto L98
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.l.ab(java.lang.String, java.lang.String):boolean");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1206=5] */
    public static String a(String str, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        Throwable th;
        String str2 = null;
        if (!StringUtils.isNull(str) && inputStream != null) {
            File file = new File(str);
            String parent = file.getParent();
            if (!StringUtils.isNull(parent)) {
                File file2 = new File(parent);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            try {
                if (file.exists() && !file.delete()) {
                    com.baidu.adp.lib.util.n.b((OutputStream) null);
                } else if (file.createNewFile()) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            str2 = file.getPath();
                            com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                        } catch (IOException e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            TiebaStatic.file(e, "FileHelper.saveFile " + str);
                            com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                            return str2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                        throw th;
                    }
                } else {
                    com.baidu.adp.lib.util.n.b((OutputStream) null);
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                com.baidu.adp.lib.util.n.b((OutputStream) fileOutputStream);
                throw th;
            }
        }
        return str2;
    }

    public static byte[] ej(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
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
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.GetFileData " + str);
            return null;
        }
    }

    public static boolean d(String str, String str2, boolean z) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File[] listFiles = file.listFiles();
            byte[] bArr = new byte[1024];
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    File file4 = new File(str, file3.getName());
                    File file5 = new File(file2, file3.getName());
                    if (file4.isFile()) {
                        FileInputStream fileInputStream = new FileInputStream(file4);
                        FileOutputStream fileOutputStream = new FileOutputStream(file5);
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileInputStream.close();
                        fileOutputStream.close();
                    } else if (file4.isDirectory()) {
                        d(file4.toString(), file5.toString(), z);
                    }
                    if (z) {
                        file4.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean ac(String str, String str2) {
        return c(str, str2, false);
    }

    public static InputStream ek(String str) {
        return q(dU(str));
    }

    public static InputStream el(String str) {
        File file = new File(str);
        try {
            try {
                return q(file.exists() ? file : null);
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.GetStreamFromTmpFile " + str);
                return q(null);
            }
        } catch (Throwable th) {
            return q(file);
        }
    }

    public static InputStream q(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                TiebaStatic.file(th.getMessage(), "FileHelper.GetStreamFromFile");
                return null;
            }
        }
        return null;
    }

    public static boolean em(String str) {
        if (yj()) {
            File file = new File(CD + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                TiebaStatic.file(th.getMessage(), "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static void r(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            r(listFiles[i]);
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.deleteFileOrDir");
        }
    }

    public static String yk() {
        return CD + "/" + TbConfig.getTempDirName() + "/";
    }

    public static boolean ad(String str, String str2) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1510=5, 1511=5, 1513=5, 1514=5] */
    public static boolean h(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bArr, 0, bArr.length);
                            fileOutputStream3.flush();
                            fileOutputStream3.close();
                            FileOutputStream fileOutputStream4 = null;
                            z = true;
                            if (0 != 0) {
                                try {
                                    fileOutputStream4.close();
                                } catch (Exception e) {
                                    BdLog.e(e.getMessage());
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream3;
                            BdLog.e(e.getMessage());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e3) {
                                    BdLog.e(e3.getMessage());
                                }
                            }
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    BdLog.e(e4.getMessage());
                                }
                            }
                            throw th;
                        }
                    } else if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e5) {
                            BdLog.e(e5.getMessage());
                        }
                    }
                } else if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e6) {
                        BdLog.e(e6.getMessage());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e7) {
            e = e7;
        }
        return z;
    }

    public static long yl() {
        String absolutePath;
        if (gd()) {
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

    public static String i(int i, String str) {
        return a(i, str, false);
    }

    private static String a(int i, String str, boolean z) {
        if (aos == null) {
            return null;
        }
        File[] listFiles = aos.listFiles();
        String cE = cE(i);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2] != null && listFiles[i2].getName().startsWith(cE)) {
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

    public static String cE(int i) {
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

    public static String q(String str, int i) {
        if (str == null) {
            return null;
        }
        if (gd()) {
            if (dS(b(str, i, false))) {
                return b(str, i, true);
            }
            return null;
        }
        return i(1, str);
    }

    public static String b(String str, int i, boolean z) {
        if (!gd()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(yk());
        }
        sb.append(cE(i));
        sb.append(File.separator);
        sb.append(str);
        return sb.toString();
    }

    public static long en(String str) {
        if (StringUtils.isNull(str)) {
            return 0L;
        }
        return h(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long h(File file) {
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

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            TiebaStatic.file(e, "FileHelper.deleteFile");
            return false;
        }
    }

    public static long h(String str, boolean z) {
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

    public static void eo(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            TiebaStatic.file(e, "FileHelper.makeRootDirectory " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public static final String aot = TbadkCoreApplication.getInst().getApp().getFileStreamPath("").getAbsolutePath();

        public static boolean eq(String str) {
            try {
                return new File(new StringBuilder().append(aot).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.checkFile " + str);
                return false;
            }
        }

        public static boolean er(String str) {
            try {
                File file = new File(aot + "/" + str);
                if (file.exists()) {
                    return false;
                }
                return file.createNewFile();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.createFile " + str);
                return false;
            }
        }

        public static void r(File file) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                r(listFiles[i]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.deleteFileOrDir");
            }
        }

        public static boolean es(String str) {
            try {
                File file = new File(aot + "/" + str);
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        return false;
                    }
                    r(file);
                }
                return file.mkdirs();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.cleanDirectory " + str);
                return false;
            }
        }

        public static String et(String str) {
            String str2 = null;
            try {
                File file = new File(aot + "/" + str);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    long j = 0;
                    for (int i = 0; i < length; i++) {
                        if (j > listFiles[i].lastModified()) {
                            j = listFiles[i].lastModified();
                            str2 = listFiles[i].getName();
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.getLatestFileName " + str);
            }
            return str2;
        }
    }

    public static int a(String str, byte[] bArr, Context context) {
        String str2;
        Bitmap decodeByteArray;
        if (bArr == null || str == null || str.length() == 0 || context == null) {
            return -1;
        }
        try {
            if (!com.baidu.adp.lib.util.l.k(bArr)) {
                str2 = ".jpg";
            } else {
                str2 = ".gif";
            }
            if (com.baidu.adp.lib.util.l.l(bArr) && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                bArr = com.baidu.adp.lib.util.d.jm().Bitmap2Bytes(decodeByteArray, 100);
                decodeByteArray.recycle();
            }
            String eM = as.eM(str);
            if (eM != null) {
                String str3 = eM + str2;
                for (int i = 0; dS(str3) && i < 10000; i++) {
                    str3 = eM + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String g = g(str3, bArr);
                if (g != null) {
                    new x(context).ey(g);
                    return 0;
                }
                return -2;
            }
            return -1;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    public static int e(String str, String str2, Context context) {
        String str3;
        if (str2 == null || str2.length() == 0 || context == null) {
            return -1;
        }
        try {
            if (!ee(str)) {
                str3 = ".jpg";
            } else {
                str3 = ".gif";
            }
            String eM = as.eM(str2);
            if (eM != null) {
                String str4 = eM + str3;
                for (int i = 0; dS(str4) && i < 10000; i++) {
                    str4 = eM + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str3;
                }
                String str5 = yk() + str4;
                com.baidu.adp.lib.util.f.b(new File(str), new File(str5));
                new x(context).ey(str5);
                return 0;
            }
            return -1;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return -1;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0062 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public static String b(Context context, Uri uri) {
        Cursor cursor;
        int columnIndex;
        String string;
        if (uri == null || context == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || "file".equals(scheme)) {
            return uri.getPath();
        }
        ?? r1 = "content";
        try {
            if (!"content".equals(scheme)) {
                return null;
            }
            try {
                cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("_data")) > -1) {
                            string = cursor.getString(columnIndex);
                            com.baidu.adp.lib.g.a.e(cursor);
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.g.a.e(cursor);
                        return null;
                    }
                }
                string = null;
                com.baidu.adp.lib.g.a.e(cursor);
                return string;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                com.baidu.adp.lib.g.a.e(r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean ep(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("content:") || str.toLowerCase().startsWith("file:");
    }

    public static String ym() {
        return CD + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static InputStream ae(String str, String str2) {
        String ym = ym();
        if (dR(ym)) {
            String str3 = ym + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return com.baidu.adp.lib.util.f.g(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
