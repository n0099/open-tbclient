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
/* loaded from: classes.dex */
public final class ZipUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "ZipUtils";

    public static boolean isZipFile(File file) {
        FileInputStream fileInputStream;
        if (file.exists()) {
            byte[] bArr = new byte[4];
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileInputStream.read(bArr);
                if ("504B0304".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                    Closeables.closeSafely(fileInputStream);
                    return true;
                }
                Closeables.closeSafely(fileInputStream);
                return false;
            } catch (Exception unused2) {
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                throw th;
            }
        }
        return false;
    }

    public static boolean unzipFile(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        System.currentTimeMillis();
        if (str == null) {
            return false;
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            FileOutputStream fileOutputStream2 = null;
            BufferedInputStream bufferedInputStream2 = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!nextElement.getName().contains(Constants.PATH_PARENT)) {
                    File file = new File(str2 + "/" + nextElement.getName());
                    if (nextElement.isDirectory()) {
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } else {
                        if (!file.exists()) {
                            FileUtils.createFileSafely(file);
                        }
                        try {
                            try {
                                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream, FileUtils.getFSBlockSize());
                                    } catch (IOException e2) {
                                        e = e2;
                                        fileOutputStream2 = fileOutputStream;
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream2 = fileOutputStream;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (IOException e4) {
                                e = e4;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        try {
                            byte[] bArr = new byte[FileUtils.getFSBlockSize()];
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, FileUtils.getFSBlockSize());
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
                        } catch (IOException e5) {
                            e = e5;
                            fileOutputStream2 = fileOutputStream;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedInputStream2 = bufferedInputStream;
                            e.printStackTrace();
                            Closeables.closeSafely(bufferedOutputStream2);
                            Closeables.closeSafely(bufferedInputStream2);
                            Closeables.closeSafely(fileOutputStream2);
                            return false;
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream2 = fileOutputStream;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedInputStream2 = bufferedInputStream;
                            Closeables.closeSafely(bufferedOutputStream2);
                            Closeables.closeSafely(bufferedInputStream2);
                            Closeables.closeSafely(fileOutputStream2);
                            throw th;
                        }
                    }
                }
            }
            zipFile.close();
            System.currentTimeMillis();
            return true;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        } finally {
            System.currentTimeMillis();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x005e -> B:42:0x0061). Please submit an issue!!! */
    public static void zip(String str, String str2) throws IOException {
        ZipOutputStream zipOutputStream = null;
        try {
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            File file2 = new File(str);
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file));
            try {
                if (file2.isFile()) {
                    zipFileOrDirectory(zipOutputStream2, file2, "");
                } else {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            zipFileOrDirectory(zipOutputStream2, file3, "");
                        }
                    }
                }
                zipOutputStream2.close();
            } catch (IOException unused2) {
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static void zipFileOrDirectory(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.isDirectory()) {
                    byte[] bArr = new byte[4096];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
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
                        fileInputStream = fileInputStream2;
                    } catch (IOException unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            zipFileOrDirectory(zipOutputStream, file2, str + file.getName() + "/");
                        }
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
    }

    @Deprecated
    public static void zip(File file, List<File> list) throws IOException {
        zip(list, file);
    }

    public static void zip(List<File> list, File file) throws IOException {
        ZipOutputStream zipOutputStream;
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                zipOutputStream.setComment(file.getName());
                for (File file2 : list) {
                    if (file2.canRead()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream2.close();
                            fileInputStream = fileInputStream2;
                        } catch (FileNotFoundException unused) {
                            fileInputStream = fileInputStream2;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(zipOutputStream);
                            throw th;
                        }
                    }
                }
                zipOutputStream.flush();
                zipOutputStream.close();
            } catch (FileNotFoundException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused3) {
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        Closeables.closeSafely(fileInputStream);
        Closeables.closeSafely(zipOutputStream);
    }
}
