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
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.r;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class l {
    public static final File ru = Environment.getExternalStorageDirectory();
    private static final File YL = TbadkCoreApplication.m9getInst().getApp().getCacheDir();

    public static boolean cy() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String tX() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TbadkCoreApplication.m9getInst().getApp().getString(r.l.error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TbadkCoreApplication.m9getInst().getApp().getString(r.l.error_sd_unmount);
        }
        if (externalStorageState.equals("shared")) {
            return TbadkCoreApplication.m9getInst().getApp().getString(r.l.error_sd_shared);
        }
        return TbadkCoreApplication.m9getInst().getApp().getString(r.l.error_sd_error);
    }

    public static boolean cU(String str) {
        if (cy()) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return false;
    }

    public static boolean tY() {
        return cU(ru + "/" + TbConfig.getTempDirName() + "/");
    }

    public static boolean cV(String str) {
        if (cy()) {
            try {
                return new File(new StringBuilder().append(ru).append("/").append(TbConfig.getTempDirName()).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "CheckFile", " ", str));
                return false;
            }
        }
        return false;
    }

    public static long V(String str, String str2) {
        if (cy()) {
            try {
                if (new File(ru + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2).exists()) {
                    return TbConfig.getBigImageSize();
                }
                return -1L;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "checkImageFileSize", " ", str, "/", str2));
                return -1L;
            }
        }
        return -1L;
    }

    public static String cW(String str) {
        if (str == null) {
            return null;
        }
        return ru + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    public static File cX(String str) {
        if (tY()) {
            File file = new File(ru + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "GetFile", " ", str));
                return null;
            }
        }
        return null;
    }

    public static String cY(String str) {
        PackageInfo packageArchiveInfo;
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = ru + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.packageName;
    }

    public static PackageInfo cZ(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = ru + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager != null) {
            return packageManager.getPackageArchiveInfo(str2, 128);
        }
        return null;
    }

    public static File da(String str) {
        if (!tY()) {
            return null;
        }
        return new File(ru + "/" + TbConfig.getTempDirName() + "/" + str);
    }

    public static File db(String str) {
        if (tY()) {
            File file = new File(ru + "/" + TbConfig.getTempDirName() + "/" + str);
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
                TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "CreateFile", " ", str));
                return null;
            }
        }
        return null;
    }

    public static File dc(String str) {
        if (tY()) {
            File file = new File(ru + "/" + TbConfig.getTempDirName() + "/" + str);
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
                TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "CreateFileIfNotFound", " ", str));
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [485=4, 486=4, 488=4, 489=4, 490=8, 491=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x01a6 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean W(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        ?? sb = new StringBuilder(String.valueOf(str != null ? ru + "/" + TbConfig.getTempDirName() + "/" + str + "/" : ru + "/" + TbConfig.getTempDirName() + "/"));
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? com.baidu.adp.lib.util.k.m(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            fileInputStream = null;
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.file(e2, com.baidu.adp.lib.util.j.j("FileHelper", ".", "isGif", " ", str, "/", str2));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    TiebaStatic.file(e4, com.baidu.adp.lib.util.j.j("FileHelper", ".", "isGif", " ", str, "/", str2));
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", "isGif", " ", str, "/", str2));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    TiebaStatic.file(e6, com.baidu.adp.lib.util.j.j("FileHelper", ".", "isGif", " ", str, "/", str2));
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
                            TiebaStatic.file(e7, com.baidu.adp.lib.util.j.j("FileHelper", ".", "isGif", " ", str, "/", str2));
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
                        TiebaStatic.file(e10, com.baidu.adp.lib.util.j.j("FileHelper", ".", "isGif", " ", str, "/", str2));
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
            str3 = ru + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/";
        }
        if (!cU(str3) || bitmap == null) {
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
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile1", " '", str, "/", str2));
            return null;
        }
    }

    public static String b(String str, String str2, Bitmap bitmap, int i) {
        String str3;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/";
        }
        if (!cU(str3) || bitmap == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFileAsPNG", " '", str, "/", str2));
            return null;
        }
    }

    public static String a(String str, Bitmap bitmap, int i) {
        File dataDirectory;
        if (bitmap == null) {
            return null;
        }
        if (cy()) {
            dataDirectory = new File(ru + "/" + TbConfig.getTempDirName());
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
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public static String i(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = ru + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str5 = ru + "/" + TbConfig.getTempDirName() + "/";
        }
        if (str3 != null) {
            str6 = ru + "/" + TbConfig.getTempDirName() + "/" + str3 + "/";
        } else {
            str6 = ru + "/" + TbConfig.getTempDirName() + "/";
        }
        if (cU(str5) && cU(str6)) {
            File file = new File(String.valueOf(str5) + str2);
            File file2 = new File(String.valueOf(str6) + str4);
            if (!file.renameTo(file2)) {
                TiebaStatic.file(com.baidu.adp.lib.util.j.j("renameTo", "err"), com.baidu.adp.lib.util.j.j("FileHelper", ".", "renameTo"));
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap X(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(String.valueOf(str3) + str2, options);
        } catch (OutOfMemoryError e) {
            TiebaStatic.file(e.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "getImage", " ", str, "/", str2));
            System.gc();
            try {
                return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
            } catch (OutOfMemoryError e2) {
                TiebaStatic.file(e.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "getImage", " ", str, "/", str2));
                return null;
            }
        }
    }

    public static String g(String str, byte[] bArr) {
        return d(null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [832=10, 833=5, 826=5, 827=5, 829=5, 830=5, 831=10] */
    public static String d(String str, String str2, byte[] bArr) {
        String str3 = str != null ? ru + "/" + TbConfig.getTempDirName() + "/" + str + "/" : ru + "/" + TbConfig.getTempDirName() + "/";
        if (!cU(str3) || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
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
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            TiebaStatic.file(th.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                        }
                    }
                    return null;
                } else if (!file.createNewFile()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                            TiebaStatic.file(th2.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
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
                                TiebaStatic.file(th3.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                                return path;
                            }
                        }
                        return path;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                BdLog.e(th4.getMessage());
                                TiebaStatic.file(th4.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
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
                                TiebaStatic.file(th6.getMessage(), com.baidu.adp.lib.util.j.j("FileHelper", ".", "SaveFile", " ", str, "/", str2));
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [888=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00fb */
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
        if (!cU(str != null ? ru + "/" + TbConfig.getTempDirName() + "/" + str + "/" : ru + "/" + TbConfig.getTempDirName() + "/") || inputStream == null || str2 == null) {
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
                    com.baidu.adp.lib.util.o.d(null);
                    return null;
                } else if (!file.createNewFile()) {
                    com.baidu.adp.lib.util.o.d(null);
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
                                com.baidu.adp.lib.util.o.d(fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, "FileHelper.saveFile " + str + "/" + str2);
                        com.baidu.adp.lib.util.o.d(fileOutputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.util.o.d(r2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            com.baidu.adp.lib.util.o.d(r2);
            throw th;
        }
    }

    public static byte[] Y(String str, String str2) {
        String str3;
        if (!tY() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = ru + "/" + TbConfig.getTempDirName() + "/";
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
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.GetFileData " + str + "/" + str2);
            return null;
        }
    }

    private static String k(String str, boolean z) {
        return (z && str.startsWith(ru.toString())) ? str : ru + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [976=4, 977=4, 979=4, 980=4, 981=8, 982=4, 985=4, 986=4, 988=4, 989=4, 990=8, 991=4] */
    public static boolean b(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            r3 = 0
            r1 = 0
            r2 = 0
            java.lang.String r4 = k(r8, r10)
            java.lang.String r5 = k(r9, r10)
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L1ed
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L1ed
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L1ed
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L1ed
            boolean r4 = r6.exists()     // Catch: java.lang.Throwable -> L1ed
            if (r4 != 0) goto L79
            if (r3 == 0) goto L21
            r1.close()     // Catch: java.lang.Throwable -> L27
        L21:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L50
        L26:
            return r0
        L27:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4)
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
        L50:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
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
        L79:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1ed
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L1ed
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L1f1
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L1f1
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> Ld0
        L87:
            int r5 = r4.read(r1)     // Catch: java.lang.Throwable -> Ld0
            if (r5 > 0) goto Lcb
            r4.close()     // Catch: java.lang.Throwable -> Ld0
            r1 = 0
            r2.close()     // Catch: java.lang.Throwable -> L1f6
            r2 = 0
            r0 = 1
            if (r3 == 0) goto L9b
            r1.close()     // Catch: java.lang.Throwable -> L1b7
        L9b:
            if (r3 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> La1
            goto L26
        La1:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
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
        Lcb:
            r6 = 0
            r2.write(r1, r6, r5)     // Catch: java.lang.Throwable -> Ld0
            goto L87
        Ld0:
            r1 = move-exception
            r3 = r4
        Ld2:
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L1ea
            com.baidu.adp.lib.util.BdLog.e(r4)     // Catch: java.lang.Throwable -> L1ea
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L1ea
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1ea
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1ea
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L1ea
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L1ea
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L1ea
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1ea
            com.baidu.tbadk.core.util.TiebaStatic.file(r1, r4)     // Catch: java.lang.Throwable -> L1ea
            if (r3 == 0) goto Lfe
            r3.close()     // Catch: java.lang.Throwable -> L12f
        Lfe:
            if (r2 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> L105
            goto L26
        L105:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
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
        L12f:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3)
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
            goto Lfe
        L158:
            r0 = move-exception
            r2 = r3
        L15a:
            if (r3 == 0) goto L15f
            r3.close()     // Catch: java.lang.Throwable -> L165
        L15f:
            if (r2 == 0) goto L164
            r2.close()     // Catch: java.lang.Throwable -> L18e
        L164:
            throw r0
        L165:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r3)
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
            goto L15f
        L18e:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r2)
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
            goto L164
        L1b7:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.BdLog.e(r4)
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
            goto L9b
        L1e1:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto L15a
        L1e6:
            r0 = move-exception
            r3 = r4
            goto L15a
        L1ea:
            r0 = move-exception
            goto L15a
        L1ed:
            r1 = move-exception
            r2 = r3
            goto Ld2
        L1f1:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto Ld2
        L1f6:
            r1 = move-exception
            goto Ld2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.l.b(java.lang.String, java.lang.String, boolean):boolean");
    }

    public static boolean c(String str, String str2, boolean z) {
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
                        c(file4.toString(), file5.toString(), z);
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

    public static boolean Z(String str, String str2) {
        return b(str, str2, false);
    }

    public static InputStream dd(String str) {
        return n(cX(str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (r1.exists() == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InputStream de(String str) {
        File file = null;
        File file2 = new File(str);
        try {
            try {
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.GetStreamFromTmpFile " + str);
                return n(file);
            }
        } catch (Throwable th) {
        }
        file = file2;
        return n(file);
    }

    public static InputStream n(File file) {
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

    public static boolean df(String str) {
        if (tY()) {
            File file = new File(ru + "/" + TbConfig.getTempDirName() + "/" + str);
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

    public static boolean dg(String str) {
        try {
            File file = new File(ru + "/" + TbConfig.getTempDirName() + "/" + str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return false;
                }
                o(file);
            }
            return file.mkdirs();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.cleanDirectory " + str);
            return false;
        }
    }

    public static void o(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            o(listFiles[i]);
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

    public static String tZ() {
        return ru + "/" + TbConfig.getTempDirName() + "/";
    }

    public static String ua() {
        return ru + "/tieba/download";
    }

    public static boolean aa(String str, String str2) {
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

    public static long ub() {
        String absolutePath;
        if (cy()) {
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

    public static String g(int i, String str) {
        return a(i, str, false);
    }

    private static String a(int i, String str, boolean z) {
        if (YL == null) {
            return null;
        }
        File[] listFiles = YL.listFiles();
        String cC = cC(i);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2] != null && listFiles[i2].getName().startsWith(cC)) {
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

    public static String cC(int i) {
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

    public static String r(String str, int i) {
        if (str == null) {
            return null;
        }
        if (cy()) {
            if (cV(b(str, i, false))) {
                return b(str, i, true);
            }
            return null;
        }
        return g(1, str);
    }

    public static String b(String str, int i, boolean z) {
        if (!cy()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(tZ());
        }
        sb.append(cC(i));
        sb.append(File.separator);
        sb.append(str);
        return sb.toString();
    }

    public static long getFileSize(String str) {
        if (StringUtils.isNull(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getFileSize(File file) {
        FileInputStream fileInputStream;
        long j = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                if (!file.exists()) {
                    fileInputStream = null;
                } else {
                    fileInputStream = new FileInputStream(file);
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
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        TiebaStatic.file(e3, "FileHelper.getFileSize");
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        TiebaStatic.file(e4, "FileHelper.getFileSize");
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return j;
    }

    public static boolean p(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            TiebaStatic.file(e, "FileHelper.deleteFile");
            return false;
        }
    }

    public static long l(String str, boolean z) {
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

    public static void dh(String str) {
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
        public static final String YM = TbadkCoreApplication.m9getInst().getApp().getFileStreamPath("").getAbsolutePath();

        public static boolean dk(String str) {
            try {
                return new File(new StringBuilder(String.valueOf(YM)).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.checkFile " + str);
                return false;
            }
        }

        public static boolean createFile(String str) {
            try {
                File file = new File(String.valueOf(YM) + "/" + str);
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

        public static void o(File file) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                o(listFiles[i]);
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

        public static boolean dg(String str) {
            try {
                File file = new File(String.valueOf(YM) + "/" + str);
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        return false;
                    }
                    o(file);
                }
                return file.mkdirs();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.cleanDirectory " + str);
                return false;
            }
        }

        public static String dl(String str) {
            String str2 = null;
            try {
                File file = new File(String.valueOf(YM) + "/" + str);
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
        String dD;
        Bitmap decodeByteArray;
        int i = -1;
        if (bArr == null || str == null || str.length() == 0 || context == null) {
            return -1;
        }
        try {
            if (!com.baidu.adp.lib.util.k.m(bArr)) {
                str2 = ".jpg";
            } else {
                str2 = ".gif";
            }
            if (com.baidu.adp.lib.util.k.n(bArr) && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                bArr = com.baidu.adp.lib.util.d.fR().Bitmap2Bytes(decodeByteArray, 100);
                decodeByteArray.recycle();
            }
            if (av.dD(str) != null) {
                String str3 = String.valueOf(dD) + str2;
                for (int i2 = 0; cV(str3) && i2 < 10000; i2++) {
                    str3 = String.valueOf(dD) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String g = g(str3, bArr);
                if (g != null) {
                    new x(context).dq(g);
                    i = 0;
                    return 0;
                }
                return -2;
            }
            return -1;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return i;
        }
    }

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
        if (!CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT.equals(scheme)) {
            return null;
        }
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst() && (columnIndex = cursor.getColumnIndex("_data")) > -1) {
                            string = cursor.getString(columnIndex);
                            com.baidu.adp.lib.g.a.a(cursor);
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        com.baidu.adp.lib.g.a.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.adp.lib.g.a.a(cursor);
                    throw th;
                }
            }
            string = null;
            com.baidu.adp.lib.g.a.a(cursor);
            return string;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.g.a.a(cursor);
            throw th;
        }
    }

    public static boolean di(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("content:") || str.toLowerCase().startsWith("file:");
    }

    public static String dj(String str) {
        String[] split;
        if (StringUtils.isNull(str, true) || (split = str.split(".")) == null || split.length <= 1) {
            return null;
        }
        return split[split.length - 1];
    }
}
