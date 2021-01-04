package com.baidu.android.util.io;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
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
        Throwable th;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2;
        ZipOutputStream zipOutputStream3 = null;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                if (0 != 0) {
                    try {
                        zipOutputStream3.close();
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
            zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file));
            try {
                if (file2.isFile()) {
                    zipFileOrDirectory(zipOutputStream2, file2, "");
                } else {
                    for (File file3 : file2.listFiles()) {
                        zipFileOrDirectory(zipOutputStream2, file3, "");
                    }
                }
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                if (zipOutputStream2 != null) {
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            zipOutputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
    }

    @Deprecated
    public static void zip(File file, List<File> list) throws IOException {
        zip(list, file);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [155=4] */
    public static void zip(List<File> list, File file) throws IOException {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream2;
        FileInputStream fileInputStream2;
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                zipOutputStream.setComment(file.getName());
                fileInputStream = null;
                for (File file2 : list) {
                    try {
                        if (file2.canRead()) {
                            FileInputStream fileInputStream3 = new FileInputStream(file2);
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                                while (true) {
                                    int read = fileInputStream3.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                fileInputStream3.close();
                                fileInputStream2 = fileInputStream3;
                            } catch (FileNotFoundException e) {
                                zipOutputStream2 = zipOutputStream;
                                fileInputStream = fileInputStream3;
                                Closeables.closeSafely(fileInputStream);
                                Closeables.closeSafely(zipOutputStream2);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream3;
                                Closeables.closeSafely(fileInputStream);
                                Closeables.closeSafely(zipOutputStream);
                                throw th;
                            }
                        } else {
                            fileInputStream2 = fileInputStream;
                        }
                        fileInputStream = fileInputStream2;
                    } catch (FileNotFoundException e2) {
                        zipOutputStream2 = zipOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                zipOutputStream.flush();
                zipOutputStream.close();
                Closeables.closeSafely(fileInputStream);
                Closeables.closeSafely(zipOutputStream);
            } catch (FileNotFoundException e3) {
                zipOutputStream2 = zipOutputStream;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (FileNotFoundException e4) {
            zipOutputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
            fileInputStream = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [204=4] */
    private static void zipFileOrDirectory(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    zipFileOrDirectory(zipOutputStream, file2, str + file.getName() + "/");
                }
                fileInputStream2 = null;
            } else {
                byte[] bArr = new byte[4096];
                fileInputStream2 = new FileInputStream(file);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                } catch (IOException e) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                            return;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        } catch (IOException e5) {
            fileInputStream2 = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
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
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        if (str == null) {
            return false;
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            BufferedOutputStream bufferedOutputStream2 = null;
            BufferedInputStream bufferedInputStream2 = null;
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
                            } catch (IOException e) {
                                e = e;
                                fileOutputStream = null;
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = null;
                            }
                            try {
                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 2048);
                                try {
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = bufferedInputStream.read(bArr, 0, 2048);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        bufferedOutputStream.flush();
                                        Closeables.closeSafely(bufferedOutputStream);
                                        Closeables.closeSafely(bufferedInputStream);
                                        Closeables.closeSafely(fileOutputStream);
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream2 = bufferedInputStream;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        Closeables.closeSafely(bufferedOutputStream2);
                                        Closeables.closeSafely(bufferedInputStream);
                                        Closeables.closeSafely(fileOutputStream);
                                        throw th;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    Closeables.closeSafely(bufferedOutputStream);
                                    Closeables.closeSafely(bufferedInputStream);
                                    Closeables.closeSafely(fileOutputStream);
                                    return false;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                bufferedOutputStream = bufferedOutputStream2;
                            } catch (Throwable th3) {
                                th = th3;
                                Closeables.closeSafely(bufferedOutputStream2);
                                Closeables.closeSafely(bufferedInputStream);
                                Closeables.closeSafely(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            fileOutputStream = null;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = null;
                            bufferedInputStream = bufferedInputStream2;
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
