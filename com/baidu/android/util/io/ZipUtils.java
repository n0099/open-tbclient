package com.baidu.android.util.io;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes6.dex */
public final class ZipUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "ZipUtils";

    private ZipUtils() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=5, 91=4, 92=4, 93=4] */
    public static void zip(String str, String str2) throws IOException {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (0 != 0) {
                    try {
                        zipOutputStream2.close();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            File file = new File(str2);
            File file2 = new File(str);
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                if (file2.isFile()) {
                    zipFileOrDirectory(zipOutputStream, file2, "");
                } else {
                    for (File file3 : file2.listFiles()) {
                        zipFileOrDirectory(zipOutputStream, file3, "");
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                zipOutputStream2 = zipOutputStream;
                th = th;
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            zipOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Deprecated
    public static void zip(File file, List<File> list) throws IOException {
        zip(list, file);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [155=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x008a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x002c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x0069 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable] */
    public static void zip(List<File> list, File file) throws IOException {
        ZipOutputStream zipOutputStream;
        ?? r2;
        Throwable th;
        Closeable closeable;
        ZipOutputStream zipOutputStream2 = null;
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                zipOutputStream.setComment(file.getName());
                Iterator<File> it = list.iterator();
                while (true) {
                    try {
                        r2 = zipOutputStream2;
                        if (!it.hasNext()) {
                            zipOutputStream.flush();
                            zipOutputStream.close();
                            Closeables.closeSafely((Closeable) r2);
                            Closeables.closeSafely(zipOutputStream);
                            return;
                        }
                        File next = it.next();
                        if (next.canRead()) {
                            ?? fileInputStream = new FileInputStream(next);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(next.getName()));
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    r2 = -1;
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                fileInputStream.close();
                                zipOutputStream2 = fileInputStream;
                            } catch (FileNotFoundException e) {
                                zipOutputStream2 = zipOutputStream;
                                closeable = fileInputStream;
                                Closeables.closeSafely(closeable);
                                Closeables.closeSafely(zipOutputStream2);
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                r2 = fileInputStream;
                                Closeables.closeSafely((Closeable) r2);
                                Closeables.closeSafely(zipOutputStream);
                                throw th;
                            }
                        } else {
                            zipOutputStream2 = r2;
                        }
                    } catch (FileNotFoundException e2) {
                        zipOutputStream2 = zipOutputStream;
                        closeable = r2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (FileNotFoundException e3) {
                closeable = null;
                zipOutputStream2 = zipOutputStream;
            } catch (Throwable th4) {
                r2 = 0;
                th = th4;
            }
        } catch (FileNotFoundException e4) {
            closeable = null;
        } catch (Throwable th5) {
            zipOutputStream = null;
            r2 = 0;
            th = th5;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [204=4] */
    private static void zipFileOrDirectory(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    zipFileOrDirectory(zipOutputStream, file2, str + file.getName() + "/");
                }
                fileInputStream = null;
            } else {
                byte[] bArr = new byte[4096];
                fileInputStream = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (IOException e5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isZipFile(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file.exists()) {
            byte[] bArr = new byte[4];
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e) {
                fileInputStream2 = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                fileInputStream.read(bArr);
                if ("504B0304".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                    Closeables.closeSafely(fileInputStream);
                    return true;
                }
                Closeables.closeSafely(fileInputStream);
                return false;
            } catch (Exception e2) {
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeSafely(fileInputStream);
                throw th;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=4, 309=4] */
    public static boolean unzipFile(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        if (str == null) {
            return false;
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            BufferedOutputStream bufferedOutputStream3 = null;
            BufferedInputStream bufferedInputStream3 = null;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.getName().contains(Constants.PATH_PARENT)) {
                    File file = new File(str2 + "/" + nextElement.getName());
                    if (!nextElement.isDirectory()) {
                        if (!file.exists()) {
                            FileUtils.createFileSafely(file);
                        }
                        try {
                            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream, 2048);
                                } catch (IOException e) {
                                    e = e;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    bufferedInputStream2 = bufferedInputStream;
                                } catch (Throwable th) {
                                    th = th;
                                }
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = bufferedInputStream.read(bArr, 0, 2048);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream2.write(bArr, 0, read);
                                    }
                                    bufferedOutputStream2.flush();
                                    Closeables.closeSafely(bufferedOutputStream2);
                                    Closeables.closeSafely(bufferedInputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    bufferedOutputStream3 = bufferedOutputStream2;
                                    bufferedInputStream3 = bufferedInputStream;
                                } catch (IOException e2) {
                                    e = e2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    bufferedInputStream2 = bufferedInputStream;
                                    try {
                                        e.printStackTrace();
                                        Closeables.closeSafely(bufferedOutputStream);
                                        Closeables.closeSafely(bufferedInputStream2);
                                        Closeables.closeSafely(fileOutputStream);
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream3 = bufferedOutputStream;
                                        bufferedInputStream = bufferedInputStream2;
                                        Closeables.closeSafely(bufferedOutputStream3);
                                        Closeables.closeSafely(bufferedInputStream);
                                        Closeables.closeSafely(fileOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream3 = bufferedOutputStream2;
                                    Closeables.closeSafely(bufferedOutputStream3);
                                    Closeables.closeSafely(bufferedInputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                fileOutputStream = null;
                                bufferedInputStream2 = bufferedInputStream;
                                bufferedOutputStream = bufferedOutputStream3;
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            bufferedInputStream2 = bufferedInputStream3;
                            fileOutputStream = null;
                            bufferedOutputStream = bufferedOutputStream3;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream = bufferedInputStream3;
                            fileOutputStream = null;
                        }
                    } else if (!file.exists()) {
                        file.mkdirs();
                    }
                }
            }
            System.currentTimeMillis();
            return true;
        } catch (IOException e5) {
            e5.printStackTrace();
            return false;
        } finally {
            System.currentTimeMillis();
        }
    }
}
