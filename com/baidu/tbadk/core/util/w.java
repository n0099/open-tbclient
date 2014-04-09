package com.baidu.tbadk.core.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.switchs.features.VoiceSwitchStatic;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class w {
    public static final File a = Environment.getExternalStorageDirectory();
    private static final File b = TbadkApplication.j().b().getCacheDir();

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String b() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TbadkApplication.j().b().getString(com.baidu.tbadk.l.error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TbadkApplication.j().b().getString(com.baidu.tbadk.l.error_sd_unmount);
        }
        if (externalStorageState.equals("shared")) {
            return TbadkApplication.j().b().getString(com.baidu.tbadk.l.error_sd_shared);
        }
        return TbadkApplication.j().b().getString(com.baidu.tbadk.l.error_sd_error);
    }

    public static boolean a(String str) {
        if (a()) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    return file.mkdirs();
                } catch (Exception e) {
                    TiebaStatic.a(e, "FileHelper.CheckTempDir " + str);
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean c() {
        return a(a + "/" + com.baidu.tbadk.core.data.n.f() + "/");
    }

    public static boolean b(String str) {
        if (a()) {
            try {
                return new File(new StringBuilder().append(a).append("/").append(com.baidu.tbadk.core.data.n.f()).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.CheckFile " + str);
                return false;
            }
        }
        return false;
    }

    public static long a(String str, String str2) {
        if (a()) {
            try {
                if (new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/" + str2).exists()) {
                    return com.baidu.tbadk.core.data.n.g();
                }
                return -1L;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.checkImageFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        return a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str;
    }

    public static File d(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "GetFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.GetFile" + str);
                return null;
            }
        }
        return null;
    }

    public static File e(String str) {
        if (!c()) {
            return null;
        }
        return new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str);
    }

    public static File f(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CreateFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.CreateFile " + str);
                return null;
            }
        }
        return null;
    }

    public static File g(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CreateFileIfNotFound", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.CreateFileIfNotFound " + str);
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [415=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x0143 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        ?? sb = new StringBuilder(String.valueOf(str != null ? a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/" : a + "/" + com.baidu.tbadk.core.data.n.f() + "/"));
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? com.baidu.adp.lib.util.i.a(bArr) : false;
                    try {
                        fileInputStream.close();
                    } catch (FileNotFoundException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        TiebaStatic.a(e2, "FileHelper.isGif " + str + "/" + str2);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                                TiebaStatic.a(e4, "FileHelper.isGif " + str + "/" + str2);
                            }
                        }
                        return z;
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                        TiebaStatic.a(e, "FileHelper.isGif " + str + "/" + str2);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                TiebaStatic.a(e6, "FileHelper.isGif " + str + "/" + str2);
                            }
                        }
                        return z;
                    }
                } catch (FileNotFoundException e7) {
                    e2 = e7;
                    z = false;
                } catch (IOException e8) {
                    e = e8;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
                if (sb != 0) {
                    try {
                        sb.close();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                        TiebaStatic.a(e9, "FileHelper.isGif " + str + "/" + str2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            fileInputStream = null;
            e2 = e10;
            z = false;
        } catch (IOException e11) {
            fileInputStream = null;
            e = e11;
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
            str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/";
        } else {
            str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
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
            com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", e.getMessage());
            TiebaStatic.a(e, "FileHelper.SaveFile1 " + str + "/" + str2);
            return null;
        }
    }

    public static String a(String str, Bitmap bitmap, int i) {
        File dataDirectory;
        if (bitmap == null) {
            return null;
        }
        if (a()) {
            dataDirectory = new File(a + "/" + com.baidu.tbadk.core.data.n.f());
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
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FileHelper", "saveFileToSDOrMemory", e.getMessage());
            TiebaStatic.a(e, "FileHelper.saveFileToSDOrMemory " + file.getAbsolutePath());
            return null;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/";
        } else {
            str5 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
        }
        if (str3 != null) {
            str6 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str3 + "/";
        } else {
            str6 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
        }
        if (a(str5) && a(str6)) {
            File file = new File(String.valueOf(str5) + str2);
            File file2 = new File(String.valueOf(str6) + str4);
            if (!file.renameTo(file2)) {
                TiebaStatic.a("renameTo err", "FileHelper.renameTo");
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static Bitmap c(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/";
        } else {
            str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = com.baidu.tbadk.core.data.n.b;
            return BitmapFactory.decodeFile(String.valueOf(str3) + str2, options);
        } catch (OutOfMemoryError e) {
            TiebaStatic.a(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
            System.gc();
            try {
                return BitmapFactory.decodeFile(String.valueOf(str3) + str2);
            } catch (OutOfMemoryError e2) {
                TiebaStatic.a(e.getMessage(), "FileHelper.getImage " + str + "/" + str2);
                return null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [625=4, 628=4, 629=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00d7 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x00d9 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00db */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0033 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.adp.widget.ImageView.b d(String str, String str2) {
        FileInputStream fileInputStream;
        com.baidu.adp.widget.ImageView.b bVar;
        ?? r2 = "/";
        String str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + a(3) + "/";
        try {
            try {
                fileInputStream = new FileInputStream(String.valueOf(str3) + str);
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inDither = true;
                    options.inScreenDensity = TbadkApplication.j().getResources().getDisplayMetrics().densityDpi;
                    options.inTargetDensity = options.inScreenDensity;
                    options.inDensity = options.inScreenDensity;
                    Rect rect = new Rect();
                    bVar = new com.baidu.adp.widget.ImageView.b(BitmapFactory.decodeStream(fileInputStream, rect, options), false, str2, rect);
                    try {
                        fileInputStream.close();
                        r2 = fileInputStream;
                    } catch (IOException e) {
                        com.baidu.adp.lib.util.f.e(e.getMessage());
                        r2 = fileInputStream;
                    }
                } catch (FileNotFoundException e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            com.baidu.adp.lib.util.f.e(e3.getMessage());
                        }
                    }
                    return null;
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    TiebaStatic.a(e.getMessage(), "FileHelper.getImage " + str3 + str);
                    System.gc();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            com.baidu.adp.lib.util.f.e(e5.getMessage());
                        }
                    }
                    bVar = null;
                    r2 = fileInputStream;
                    return bVar;
                }
            } catch (Throwable th) {
                th = th;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e6) {
                        com.baidu.adp.lib.util.f.e(e6.getMessage());
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
        return bVar;
    }

    public static String a(String str, byte[] bArr, int i) {
        return a() ? a((String) null, a(str, 1, false), bArr) : a(1, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [691=5, 694=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0179 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x017b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x008e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, byte[] bArr) {
        String str3;
        FileOutputStream fileOutputStream;
        String str4;
        if (!a(str != null ? a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/" : a + "/" + com.baidu.tbadk.core.data.n.f() + "/") || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        String parent = file.getParent();
        boolean a2 = com.baidu.adp.lib.util.o.a(parent);
        FileOutputStream fileOutputStream2 = a2;
        if (!a2) {
            ?? file2 = new File(parent);
            boolean exists = file2.exists();
            fileOutputStream2 = file2;
            if (!exists) {
                file2.mkdirs();
                fileOutputStream2 = file2;
            }
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream2 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th2) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th2.getMessage());
                        TiebaStatic.a(th2.getMessage(), "FileHelper.SaveFile2 " + str + "/" + str2);
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
        if ((!file.exists() || file.delete()) && file.createNewFile()) {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                str4 = file.getPath();
                fileOutputStream2 = fileOutputStream;
            } catch (IOException e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.SaveFile2 " + str + "/" + str2);
                String str5 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        str5 = fileOutputStream;
                    } catch (Throwable th4) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th4.getMessage());
                        String str6 = "FileHelper.SaveFile2 " + str + "/" + str2;
                        TiebaStatic.a(th4.getMessage(), str6);
                        str5 = str6;
                    }
                }
                str4 = null;
                fileOutputStream2 = str5;
                return str4;
            }
            return str4;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [750=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x010e */
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
        if (!a(str != null ? a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/" : a + "/" + com.baidu.tbadk.core.data.n.f() + "/") || inputStream == null || str2 == null) {
            return null;
        }
        File file = new File(String.valueOf(str3) + str2);
        String parent = file.getParent();
        boolean a2 = com.baidu.adp.lib.util.o.a(parent);
        ?? r2 = a2;
        if (!a2) {
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
                    l.a((OutputStream) null);
                    return null;
                } else if (!file.createNewFile()) {
                    l.a((OutputStream) null);
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
                                l.a((OutputStream) fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        e = e;
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                        TiebaStatic.a(e, "FileHelper.saveFile " + str + "/" + str2);
                        l.a((OutputStream) fileOutputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                l.a((OutputStream) r2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            l.a((OutputStream) r2);
            throw th;
        }
    }

    public static byte[] e(String str, String str2) {
        String str3;
        if (!c() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/";
        } else {
            str3 = a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
        }
        File file = new File(String.valueOf(str3) + str2);
        try {
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            com.baidu.adp.lib.util.f.b("FileHelper", "GetFileData", "error = " + e.getMessage());
            TiebaStatic.a(e, "FileHelper.GetFileData " + str + "/" + str2);
            return null;
        }
    }

    private static String b(String str, boolean z) {
        return (z && str.startsWith(a.toString())) ? str : a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static boolean a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            r3 = 0
            r0 = 0
            java.lang.String r1 = b(r7, r9)
            java.lang.String r2 = b(r8, r9)
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L13f
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L13f
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L13f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L13f
            boolean r2 = r5.exists()     // Catch: java.lang.Throwable -> L13f
            if (r2 != 0) goto L1b
        L1a:
            return r0
        L1b:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L13f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L13f
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L143
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L143
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L3c
        L29:
            int r5 = r4.read(r1)     // Catch: java.lang.Throwable -> L3c
            if (r5 > 0) goto L37
            r4.close()     // Catch: java.lang.Throwable -> L3c
            r2.close()     // Catch: java.lang.Throwable -> L148
            r0 = 1
            goto L1a
        L37:
            r6 = 0
            r2.write(r1, r6, r5)     // Catch: java.lang.Throwable -> L3c
            goto L29
        L3c:
            r1 = move-exception
            r3 = r4
        L3e:
            java.lang.String r4 = "FileHelper"
            java.lang.String r5 = "CopyFile"
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L13d
            com.baidu.adp.lib.util.f.b(r4, r5, r6)     // Catch: java.lang.Throwable -> L13d
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L13d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L13d
            java.lang.String r5 = "FileHelper.CopyFile "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L13d
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L13d
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L13d
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L13d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L13d
            com.baidu.tbadk.core.util.TiebaStatic.a(r1, r4)     // Catch: java.lang.Throwable -> L13d
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.lang.Throwable -> La2
        L6e:
            if (r2 == 0) goto L1a
            r2.close()     // Catch: java.lang.Throwable -> L74
            goto L1a
        L74:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.f.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.a(r1, r2)
            goto L1a
        La2:
            r1 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r1.toString()
            com.baidu.adp.lib.util.f.b(r3, r4, r5)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FileHelper.CopyFile "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.a(r1, r3)
            goto L6e
        Lcf:
            r0 = move-exception
            r2 = r3
        Ld1:
            if (r3 == 0) goto Ld6
            r3.close()     // Catch: java.lang.Throwable -> Ldc
        Ld6:
            if (r2 == 0) goto Ldb
            r2.close()     // Catch: java.lang.Throwable -> L109
        Ldb:
            throw r0
        Ldc:
            r1 = move-exception
            java.lang.String r3 = "FileHelper"
            java.lang.String r4 = "CopyFile"
            java.lang.String r5 = r1.toString()
            com.baidu.adp.lib.util.f.b(r3, r4, r5)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "FileHelper.CopyFile "
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            com.baidu.tbadk.core.util.TiebaStatic.a(r1, r3)
            goto Ld6
        L109:
            r1 = move-exception
            java.lang.String r2 = "FileHelper"
            java.lang.String r3 = "CopyFile"
            java.lang.String r4 = r1.toString()
            com.baidu.adp.lib.util.f.b(r2, r3, r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "FileHelper.CopyFile "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.tbadk.core.util.TiebaStatic.a(r1, r2)
            goto Ldb
        L136:
            r0 = move-exception
            r2 = r3
            r3 = r4
            goto Ld1
        L13a:
            r0 = move-exception
            r3 = r4
            goto Ld1
        L13d:
            r0 = move-exception
            goto Ld1
        L13f:
            r1 = move-exception
            r2 = r3
            goto L3e
        L143:
            r1 = move-exception
            r2 = r3
            r3 = r4
            goto L3e
        L148:
            r1 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.w.a(java.lang.String, java.lang.String, boolean):boolean");
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
                com.baidu.adp.lib.util.f.b("FileHelper", "GetFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.GetStreamFromTmpFile " + str);
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
                com.baidu.adp.lib.util.f.b("FileHelper", "GetStreamFromFile", "error = " + th.getMessage());
                TiebaStatic.a(th.getMessage(), "FileHelper.GetStreamFromFile");
                return null;
            }
        }
        return null;
    }

    public static boolean j(String str) {
        if (c()) {
            File file = new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                com.baidu.adp.lib.util.f.b("FileHelper", "DelFile", "error = " + th.getMessage());
                TiebaStatic.a(th.getMessage(), "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static String d() {
        return a + "/" + com.baidu.tbadk.core.data.n.f() + "/";
    }

    public static boolean g(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        String parent = file2.getParent();
        if (!com.baidu.adp.lib.util.o.a(parent)) {
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
                return VoiceSwitchStatic.VOICE;
            case 2:
                return "emotion";
            case 3:
                return "bubble";
            default:
                return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1080=4, 1083=4] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(int i, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String a2 = a(i, str, true);
        if (a2 != null) {
            return a2;
        }
        try {
            File createTempFile = File.createTempFile(a(i), str, b);
            if (createTempFile == null) {
                return null;
            }
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                try {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return createTempFile.getPath();
                } catch (IOException e) {
                    e = e;
                    com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + e.getMessage());
                    TiebaStatic.a(e, "FileHelper.SaveFile ");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th.getMessage());
                            TiebaStatic.a(th.getMessage(), "FileHelper.SaveFile ");
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        com.baidu.adp.lib.util.f.b("FileHelper", "SaveFile", "error = " + th3.getMessage());
                        TiebaStatic.a(th3.getMessage(), "FileHelper.SaveFile ");
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (a()) {
            if (b(a(str, 1, false))) {
                return a(str, 1, true);
            }
            return null;
        }
        return a(1, str, false);
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long b(File file) {
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
                        TiebaStatic.a(e, "FileHelper.getFileSize");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                TiebaStatic.a(e2, "FileHelper.getFileSize");
                            }
                        }
                        return j;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        TiebaStatic.a(e3, "FileHelper.getFileSize");
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        TiebaStatic.a(e4, "FileHelper.getFileSize");
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

    public static boolean c(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            TiebaStatic.a(e, "FileHelper.deleteFile");
            return false;
        }
    }

    public static long a(String str, boolean z) {
        return a(new File(str), z);
    }

    private static long a(File file, boolean z) {
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
            TiebaStatic.a(e, "FileHelper.makeRootDirectory " + str);
        }
    }

    public static long h(String str, String str2) {
        if (a()) {
            try {
                File file = new File(a + "/" + com.baidu.tbadk.core.data.n.f() + "/" + str + "/" + str2);
                if (file.exists()) {
                    return file.length();
                }
                return -1L;
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("FileHelper", "CheckFile", "error = " + e.getMessage());
                TiebaStatic.a(e, "FileHelper.checkFileSize " + str + "/" + str2);
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
            if (!com.baidu.adp.lib.util.i.a(bArr)) {
                str2 = ".jpg";
            } else {
                str2 = ".gif";
            }
            if (com.baidu.adp.lib.util.i.b(bArr)) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray != null) {
                    com.baidu.adp.lib.util.b.a();
                    bArr = com.baidu.adp.lib.util.b.a(decodeByteArray, 100);
                    decodeByteArray.recycle();
                } else {
                    com.baidu.adp.lib.util.f.b("Failed to decode the webp when save file.");
                }
            }
            if (bc.f(str) != null) {
                String str3 = String.valueOf(f) + str2;
                for (int i2 = 0; b(str3) && i2 < 10000; i2++) {
                    str3 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String a2 = a((String) null, str3, bArr);
                if (a2 != null) {
                    new ai(context).a(a2);
                    i = 0;
                    return 0;
                }
                return -2;
            }
            return -1;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("FileHelper", "saveImageFileByUser", "error" + e.getMessage());
            return i;
        }
    }
}
