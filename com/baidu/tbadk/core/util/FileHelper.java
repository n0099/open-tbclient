package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.m.a;
import d.a.c.e.m.e;
import d.a.c.e.p.d;
import d.a.c.e.p.f;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.e.p.m;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class FileHelper {
    public static final String DIR_ANIMATION = "animation";
    public static final String DIR_DOWNLOAD = "download";
    public static final String DIR_ROOT = "tieba";
    public static final String FILE_CACHE_BUBBLE = "bubble";
    public static final String FILE_CACHE_CSS = ".css";
    public static final String FILE_CACHE_EMOTION_PACKAGE = "emotion";
    public static final String FILE_CACHE_HEIC = ".heic";
    public static final String FILE_CACHE_HEIF = ".heif";
    public static final String FILE_CACHE_VIDEO = ".video";
    public static final String FILE_CACHE_VOICE = "voice";
    public static final int FILE_TYPE_BUBBLE = 3;
    public static final int FILE_TYPE_EMOTION_PACKAGE = 2;
    public static final int FILE_TYPE_VOICE = 1;
    public static final File EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory();
    public static final File CACHE_DIR = TbadkCoreApplication.getInst().getApp().getCacheDir();

    /* loaded from: classes3.dex */
    public static class DataDir {
        public static final String PACKAGE_DATA_DIR = TbadkCoreApplication.getInst().getApp().getFileStreamPath("").getAbsolutePath();
        public static final String PACKAGE_VERSION_CUR_DIR = "/package.cur";
        public static final String PACKAGE_VERSION_LAST_DIR = "/package.last";

        /* loaded from: classes3.dex */
        public static class CompratorByLastModified implements Comparator<File> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                int i2 = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                if (i2 > 0) {
                    return 1;
                }
                return i2 == 0 ? 0 : -1;
            }
        }

        public static boolean checkFile(String str) {
            try {
                return new File(PACKAGE_DATA_DIR + "/" + str).exists();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.checkFile " + str);
                return false;
            }
        }

        public static boolean cleanDirectory(String str) {
            try {
                File file = new File(PACKAGE_DATA_DIR + "/" + str);
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        return false;
                    }
                    deleteFileOrDir(file);
                }
                return file.mkdirs();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.cleanDirectory " + str);
                return false;
            }
        }

        public static boolean createFile(String str) {
            try {
                File file = new File(PACKAGE_DATA_DIR + "/" + str);
                if (file.exists()) {
                    return false;
                }
                return file.createNewFile();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.createFile " + str);
                return false;
            }
        }

        public static void deleteFileOrDir(File file) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (listFiles[i2].isFile()) {
                                listFiles[i2].delete();
                            } else {
                                deleteFileOrDir(listFiles[i2]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.deleteFileOrDir");
            }
        }

        public static String getLatestFileName(String str) {
            String str2 = null;
            try {
                File file = new File(PACKAGE_DATA_DIR + "/" + str);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    long j = 0;
                    int length = listFiles.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (j > listFiles[i2].lastModified()) {
                            j = listFiles[i2].lastModified();
                            str2 = listFiles[i2].getName();
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.getLatestFileName " + str);
            }
            return str2;
        }

        public static String getLatestVersion() {
            File[] listFiles;
            try {
                File file = new File(PACKAGE_DATA_DIR + "/" + PACKAGE_VERSION_CUR_DIR);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                    Arrays.sort(listFiles, new CompratorByLastModified());
                    File file2 = listFiles[0];
                    if (file2 != null) {
                        return file2.getName();
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface MediaScanCallback {
        void callBack(HashMap<String, String> hashMap);
    }

    public static boolean CheckFile(String str) {
        if (checkSD()) {
            try {
                return new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str).exists();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckFile", " ", str));
                return false;
            }
        }
        return false;
    }

    public static boolean CheckTempDir(String str) {
        if (checkSD()) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e2) {
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return false;
    }

    public static boolean CopyDir(String str, String str2, boolean z) {
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
                        CopyDir(file4.toString(), file5.toString(), z);
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

    /* JADX WARN: Removed duplicated region for block: B:57:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean CopyFile(String str, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        String prefixPath = getPrefixPath(str, z);
        String prefixPath2 = getPrefixPath(str2, z);
        FileInputStream fileInputStream = null;
        try {
            File file = new File(prefixPath);
            File file2 = new File(prefixPath2);
            if (!file.exists()) {
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream2.close();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    BdLog.e(th.toString());
                                    TiebaStatic.file(th.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th2) {
                                            BdLog.e(th2.toString());
                                            TiebaStatic.file(th2.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th3) {
                                            BdLog.e(th3.toString());
                                            TiebaStatic.file(th3.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                            return false;
                                        }
                                    }
                                    return false;
                                } catch (Throwable th4) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th5) {
                                            BdLog.e(th5.toString());
                                            TiebaStatic.file(th5.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th6) {
                                            BdLog.e(th6.toString());
                                            TiebaStatic.file(th6.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = fileInputStream2;
                    BdLog.e(th.toString());
                    TiebaStatic.file(th.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
        }
    }

    public static File CreateFile(String str) {
        if (CheckTempDir()) {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (!file.exists() || file.delete()) {
                    if (file.createNewFile()) {
                        return file;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CreateFile", " ", str));
                return null;
            }
        }
        return null;
    }

    public static File CreateFileIfNotFound(String str) {
        if (CheckTempDir()) {
            return CreateFileIfNotFoundAbsolutePath(new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str).getAbsolutePath());
        }
        return null;
    }

    public static File CreateFileIfNotFoundAbsolutePath(String str) {
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
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, k.join("FileHelper", ".", "CreateFileIfNotFound", " ", str));
            return null;
        }
    }

    public static File CreateFileIfNotFoundInCache(String str) {
        return CreateFileIfNotFoundAbsolutePath(new File(CACHE_DIR + "/" + str).getAbsolutePath());
    }

    public static FileOutputStream CreateFileOutputStream(String str) {
        try {
            File CreateFile = CreateFile(str);
            if (CreateFile != null) {
                return new FileOutputStream(CreateFile, true);
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, k.join("FileHelper", ".", "CreateFileOutputStream", " ", str));
            return null;
        }
    }

    public static boolean DelFile(String str) {
        if (CheckTempDir()) {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                String message = th.getMessage();
                TiebaStatic.file(message, "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static File FileObject(String str) {
        if (CheckTempDir()) {
            return new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
        }
        return null;
    }

    public static File GetFile(String str) {
        if (CheckTempDir()) {
            return GetFileByAbsolutePath(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
        }
        return null;
    }

    public static File GetFileByAbsolutePath(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (SecurityException e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, k.join("FileHelper", ".", "GetFile", " ", str));
            return null;
        }
    }

    public static byte[] GetFileData(String str, String str2) {
        String str3;
        if (!CheckTempDir() || str2 == null) {
            return null;
        }
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        return GetFileData(str3 + str2);
    }

    public static File GetFileInCache(String str) {
        return GetFileByAbsolutePath(CACHE_DIR + "/" + str);
    }

    public static InputStream GetStreamFromFile(String str) {
        return GetStreamFromFile(GetFile(str));
    }

    public static InputStream GetStreamFromTmpFile(String str) {
        File file = new File(str);
        try {
            try {
                if (!file.exists()) {
                    file = null;
                }
                return GetStreamFromFile(file);
            } catch (SecurityException e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.GetStreamFromTmpFile " + str);
                return GetStreamFromFile((File) null);
            }
        } catch (Throwable unused) {
            return GetStreamFromFile(file);
        }
    }

    public static long SDAvailableSize() {
        String absolutePath = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getAbsolutePath() : null;
        if (absolutePath == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(absolutePath);
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String SaveFile(String str, String str2, Bitmap bitmap, int i2) {
        String str3;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        if (CheckTempDir(str3) && bitmap != null) {
            File file = new File(str3 + str2);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "SaveFile1", " '", str, "/", str2));
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00d8: MOVE  (r5 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:37:0x00d8 */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveGifFile(String str, String str2, byte[] bArr) {
        String str3;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        FileOutputStream fileOutputStream3 = null;
        if (!CheckTempDir(str3) || bArr == null) {
            return null;
        }
        File file = new File(str3 + str2);
        try {
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file.getPath();
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, k.join("FileHelper", ".", "SaveGifFile", " ", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                                TiebaStatic.file(e3, k.join("FileHelper", ".", "SaveGifFile", " ", str2));
                            }
                        }
                        return null;
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream3 = fileOutputStream2;
                if (fileOutputStream3 != null) {
                    try {
                        fileOutputStream3.close();
                    } catch (Exception e4) {
                        BdLog.e(e4.getMessage());
                        TiebaStatic.file(e4, k.join("FileHelper", ".", "SaveGifFile", " ", str2));
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream3 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveTempFile(int i2, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String tempFilePath = getTempFilePath(i2, str, true);
        if (tempFilePath != null) {
            return tempFilePath;
        }
        try {
            File createTempFile = File.createTempFile(getPrefixByType(i2), str, CACHE_DIR);
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
                } catch (IOException e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.SaveFile ");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            TiebaStatic.file(th.getMessage(), "FileHelper.SaveFile ");
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th3) {
                        BdLog.e(th3.getMessage());
                        TiebaStatic.file(th3.getMessage(), "FileHelper.SaveFile ");
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    public static long checkFileSize(String str, String str2) {
        if (checkSD()) {
            try {
                File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2);
                if (file.exists()) {
                    return file.length();
                }
                return -1L;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.checkFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    public static long checkImageFileSize(String str, String str2) {
        if (checkSD()) {
            try {
                if (new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2).exists()) {
                    return TbConfig.getBigImageSize();
                }
                return -1L;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "checkImageFileSize", " ", str, "/", str2));
                return -1L;
            }
        }
        return -1L;
    }

    public static boolean checkIsCssFile(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(FILE_CACHE_CSS);
    }

    public static boolean checkIsHeifImage(String str) {
        return str.endsWith(FILE_CACHE_HEIF) || str.endsWith(FILE_CACHE_HEIC);
    }

    public static boolean checkIsLongImage(String str) {
        int[] imageFileWH = getImageFileWH(str);
        if (imageFileWH[0] == 0 || imageFileWH[1] == 0) {
            return false;
        }
        float h2 = l.h(TbadkCoreApplication.getInst());
        float f2 = imageFileWH[1] / imageFileWH[0];
        return ((float) imageFileWH[0]) * h2 >= 100.0f && f2 >= 3.0f && f2 <= 50.0f;
    }

    public static boolean checkSD() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = null;
        }
        return "mounted".equals(str);
    }

    public static boolean cleanDirectory(String str) {
        try {
            File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return false;
                }
                deleteFileOrDir(file);
            }
            return file.mkdirs();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "FileHelper.cleanDirectory " + str);
            return false;
        }
    }

    public static void clearCacheDir(@NonNull String str) {
        if (str == null) {
            return;
        }
        deleteCacheDirFiles(new File(CACHE_DIR + "/" + str));
    }

    public static String compressBitmapToFile(String str, Bitmap bitmap, float f2, int i2) {
        File dataDirectory;
        if (bitmap == null) {
            return null;
        }
        if (checkSD()) {
            dataDirectory = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName());
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
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > f2) {
                    byteArrayOutputStream.reset();
                    i2 -= 5;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, k.join("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public static boolean copyFile(String str, String str2) {
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                return false;
            }
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream.close();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (Throwable th2) {
                                fileInputStream = null;
                                th = th2;
                                try {
                                    BdLog.e(th.toString());
                                    TiebaStatic.file(th.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th3) {
                                            BdLog.e(th3.toString());
                                            TiebaStatic.file(th3.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th4) {
                                            BdLog.e(th4.toString());
                                            TiebaStatic.file(th4.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                            return false;
                                        }
                                    }
                                    return false;
                                } catch (Throwable th5) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th6) {
                                            BdLog.e(th6.toString());
                                            TiebaStatic.file(th6.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th7) {
                                            BdLog.e(th7.toString());
                                            TiebaStatic.file(th7.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                fileOutputStream = null;
                th = th9;
            }
        } catch (Throwable th10) {
            fileInputStream = null;
            th = th10;
            fileOutputStream = null;
        }
    }

    public static int copyImageFile(String str, String str2, Context context) {
        if (str2 != null && str2.length() != 0 && context != null) {
            try {
                String str3 = isGifImage(str) ? ".gif" : ".jpg";
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                if (nameMd5FromUrl == null) {
                    return -1;
                }
                String str4 = nameMd5FromUrl + str3;
                for (int i2 = 0; CheckFile(str4) && i2 < 10000; i2++) {
                    str4 = nameMd5FromUrl + Math.round(Math.random() * 9.9999999E7d) + str3;
                }
                String str5 = getCacheDir() + str4;
                f.f(new File(str), new File(str5));
                new MediaScannerClient(context).saveImage(str5);
                return 0;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return -1;
    }

    public static void deleteCacheDirFiles(File file) {
        File[] listFiles;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteCacheDirFiles(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e2) {
            TiebaStatic.file(e2, "FileHelper.deleteFile");
            return false;
        }
    }

    public static void deleteFileOrDir(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (listFiles[i2].isFile()) {
                            listFiles[i2].delete();
                        } else {
                            deleteFileOrDir(listFiles[i2]);
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "FileHelper.deleteFileOrDir");
        }
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        String animationPath = getAnimationPath();
        if (CheckTempDir(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.x(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String getAnimationPath() {
        return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static PackageInfo getApkFileMetaData(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        return packageManager.getPackageArchiveInfo(str2, 128);
    }

    public static String getApkFilePackageName(String str) {
        PackageInfo packageArchiveInfo;
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.packageName;
    }

    public static long getAvailableSize() {
        String absolutePath;
        if (checkSD()) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            absolutePath = Environment.getRootDirectory().getAbsolutePath();
        }
        if (absolutePath == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(absolutePath);
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String getCacheDir() {
        return EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
    }

    public static String getCustomLoginCssFileName(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        return parse.getLastPathSegment();
    }

    public static String getCustomLoginCssStoragePath(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        return (TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/") + parse.getLastPathSegment();
    }

    public static long getDirectorySize(String str, boolean z) {
        return getDirectorySize(new File(str), z);
    }

    public static String getDownloadDir() {
        return EXTERNAL_STORAGE_DIRECTORY + "/tieba/download";
    }

    public static String getFileDireciory(String str) {
        if (str == null) {
            return null;
        }
        return EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    public static String getFilePath(String str, int i2, boolean z) {
        if (checkSD()) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                sb.append(getCacheDir());
            }
            sb.append(getPrefixByType(i2));
            sb.append(File.separator);
            sb.append(str);
            return sb.toString();
        }
        return null;
    }

    public static long getFileSize(String str) {
        if (StringUtils.isNull(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    public static Bitmap getImage(String str, String str2) {
        String str3;
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        return getImage(str3 + str2);
    }

    public static int[] getImageFileWH(String str) {
        int[] iArr = new int[2];
        if (StringUtils.isNull(str)) {
            return iArr;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return iArr;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                BitmapFactory.decodeStream(fileInputStream2, null, options);
                m.e(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    th.printStackTrace();
                    iArr[0] = options.outWidth;
                    iArr[1] = options.outHeight;
                    return iArr;
                } finally {
                    m.e(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        iArr[0] = options.outWidth;
        iArr[1] = options.outHeight;
        return iArr;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0044 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0046 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x001d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static String getImageRealPathFromUri(Context context, Uri uri) {
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str = null;
        if (uri == null || context == 0) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !"file".equals(scheme)) {
            try {
                if ("content".equals(scheme)) {
                    try {
                        context = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                    } catch (Exception e2) {
                        e = e2;
                        context = 0;
                    } catch (Throwable th) {
                        th = th;
                        a.a(cursor);
                        throw th;
                    }
                    if (context != 0) {
                        try {
                            boolean moveToFirst = context.moveToFirst();
                            context = context;
                            if (moveToFirst) {
                                int columnIndex = context.getColumnIndex("_data");
                                context = context;
                                if (columnIndex > -1) {
                                    str = context.getString(columnIndex);
                                    context = context;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            context = context;
                            a.a(context);
                            return str;
                        }
                    }
                    a.a(context);
                    return str;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = context;
            }
        } else {
            return uri.getPath();
        }
    }

    public static String getPrefixByType(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : FILE_CACHE_BUBBLE : FILE_CACHE_EMOTION_PACKAGE : "voice";
    }

    public static String getPrefixPath(String str, boolean z) {
        return (z && str.startsWith(EXTERNAL_STORAGE_DIRECTORY.toString())) ? str : EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    public static String getSdErrorString() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TbadkCoreApplication.getInst().getApp().getString(R.string.error_no_sdcard);
        }
        if (!externalStorageState.equals("unmounted") && !externalStorageState.equals("unmountable")) {
            if (externalStorageState.equals("shared")) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.error_sd_shared);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.error_sd_error);
        }
        return TbadkCoreApplication.getInst().getApp().getString(R.string.error_no_sdcard);
    }

    public static String getStoreFile(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (checkSD()) {
            if (CheckFile(getFilePath(str, i2, false))) {
                return getFilePath(str, i2, true);
            }
            return null;
        }
        return getTempFilePath(1, str);
    }

    public static String getTempFilePath(int i2, String str) {
        return getTempFilePath(i2, str, false);
    }

    public static String getVideoTmpDir() {
        return EXTERNAL_STORAGE_DIRECTORY + "/tieba/" + FILE_CACHE_VIDEO;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isGif(String str, String str2) {
        String str3;
        Throwable th;
        boolean z;
        Exception exc;
        String join;
        FileInputStream fileInputStream;
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(str3 + str2));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        } catch (IOException e3) {
            e = e3;
        }
        try {
            try {
                byte[] bArr = new byte[7];
                z = fileInputStream.read(bArr, 0, 6) == 6 ? l.B(bArr) : false;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        TiebaStatic.file(e4, k.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            z = false;
            e.printStackTrace();
            TiebaStatic.file(e, k.join("FileHelper", ".", "isGif", " ", str, "/", str2));
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e6) {
                    exc = e6;
                    exc.printStackTrace();
                    join = k.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                    TiebaStatic.file(exc, join);
                    return z;
                }
            }
            return z;
        } catch (IOException e7) {
            e = e7;
            fileInputStream2 = fileInputStream;
            z = false;
            e.printStackTrace();
            TiebaStatic.file(e, k.join("FileHelper", "isGif", " ", str, "/", str2));
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e8) {
                    exc = e8;
                    exc.printStackTrace();
                    join = k.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                    TiebaStatic.file(exc, join);
                    return z;
                }
            }
            return z;
        }
        try {
            fileInputStream.close();
            if (0 != 0) {
                try {
                    fileInputStream2.close();
                } catch (Exception e9) {
                    exc = e9;
                    exc.printStackTrace();
                    join = k.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                    TiebaStatic.file(exc, join);
                    return z;
                }
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            TiebaStatic.file(e, k.join("FileHelper", ".", "isGif", " ", str, "/", str2));
            if (fileInputStream2 != null) {
            }
            return z;
        } catch (IOException e11) {
            e = e11;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            TiebaStatic.file(e, k.join("FileHelper", "isGif", " ", str, "/", str2));
            if (fileInputStream2 != null) {
            }
            return z;
        }
        return z;
    }

    public static boolean isGifImage(String str) {
        InputStream x;
        if (StringUtils.isNull(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && !file.isDirectory() && (x = f.x(file)) != null) {
            try {
                byte[] bArr = new byte[7];
                if (x.read(bArr, 0, 6) == 6) {
                    boolean B = l.B(bArr);
                    a.c(x);
                    return B;
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                a.c(x);
                throw th;
            }
            a.c(x);
        }
        return false;
    }

    public static boolean isLocalFile(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            File file = new File(new URI(uri.toString()));
            return file.isFile() && file.exists();
        } catch (IllegalArgumentException | URISyntaxException unused) {
            return false;
        }
    }

    public static boolean isLocalImagePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("content:") || str.toLowerCase().startsWith("file:");
    }

    public static void makeRootDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e2) {
            TiebaStatic.file(e2, "FileHelper.makeRootDirectory " + str);
        }
    }

    public static String renameTo(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (str != null) {
            str5 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str5 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        if (str3 != null) {
            str6 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str3 + "/";
        } else {
            str6 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        if (CheckTempDir(str5) && CheckTempDir(str6)) {
            File file = new File(str5 + str2);
            File file2 = new File(str6 + str4);
            if (!file.renameTo(file2)) {
                TiebaStatic.file(k.join("renameTo", NotificationCompat.CATEGORY_ERROR), k.join("FileHelper", ".", "renameTo"));
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
    }

    public static String saveFile(String str, String str2, Bitmap bitmap, int i2) {
        if (bitmap != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
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
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file2.getAbsolutePath();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file2.getAbsolutePath()));
            }
        }
        return null;
    }

    public static String saveFileAsPNG(String str, String str2, Bitmap bitmap, int i2) {
        return saveFileAsPic(str, str2, bitmap, i2, Bitmap.CompressFormat.PNG);
    }

    public static String saveFileAsPic(String str, String str2, Bitmap bitmap, int i2, Bitmap.CompressFormat compressFormat) {
        if (bitmap != null && CheckTempDir(str) && bitmap != null) {
            File file = new File(str + str2);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(compressFormat, i2, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "saveFileAsPNG", " '", str, "/", str2));
            }
        }
        return null;
    }

    public static boolean saveFileByAbsolutePath(String str, byte[] bArr) {
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    public static String saveFileToSDOrMemory(String str, Bitmap bitmap, int i2) {
        String absolutePath;
        if (bitmap == null) {
            return null;
        }
        if (checkSD()) {
            absolutePath = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName();
        } else {
            absolutePath = Environment.getDataDirectory().getAbsolutePath();
        }
        return saveFile(absolutePath, str, bitmap, i2);
    }

    public static int saveImageFileByUser(String str, byte[] bArr, Context context) {
        Bitmap decodeByteArray;
        if (bArr != null && str != null && str.length() != 0 && context != null) {
            try {
                String str2 = l.B(bArr) ? ".gif" : ".jpg";
                if (l.z(bArr) && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                    bArr = d.d().a(decodeByteArray, 100);
                    decodeByteArray.recycle();
                }
                String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
                if (nameMd5FromUrl == null) {
                    return -1;
                }
                String str3 = nameMd5FromUrl + str2;
                for (int i2 = 0; CheckFile(str3) && i2 < 10000; i2++) {
                    str3 = nameMd5FromUrl + Math.round(Math.random() * 9.9999999E7d) + str2;
                }
                String SaveFile = SaveFile(str3, bArr);
                if (SaveFile != null) {
                    new MediaScannerClient(context).saveImage(SaveFile);
                    return 0;
                }
                return -2;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return -1;
    }

    public static void scanMediaFile(String[] strArr, final MediaScanCallback mediaScanCallback) {
        if (strArr == null || strArr.length == 0) {
            if (mediaScanCallback != null) {
                mediaScanCallback.callBack(null);
                return;
            }
            return;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                if (mediaScanCallback != null) {
                    mediaScanCallback.callBack(null);
                    return;
                }
                return;
            }
        }
        final HashMap hashMap = new HashMap();
        for (String str2 : strArr) {
            hashMap.put(str2, null);
        }
        final int length = strArr.length;
        MediaScannerConnection.scanFile(TbadkCoreApplication.getInst(), strArr, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.baidu.tbadk.core.util.FileHelper.1
            public int currentNumbers = 0;

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str3, Uri uri) {
                this.currentNumbers++;
                if (uri != null) {
                    hashMap.put(str3, uri.toString());
                }
                if (this.currentNumbers == length) {
                    e.a().post(new Runnable() { // from class: com.baidu.tbadk.core.util.FileHelper.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            MediaScanCallback mediaScanCallback2 = mediaScanCallback;
                            if (mediaScanCallback2 != null) {
                                mediaScanCallback2.callBack(hashMap);
                            }
                        }
                    });
                }
            }
        });
    }

    public static InputStream GetStreamFromFile(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                TiebaStatic.file(th.getMessage(), "FileHelper.GetStreamFromFile");
            }
        }
        return null;
    }

    public static long getDirectorySize(File file, boolean z) {
        long length;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isDirectory() && !z) {
                length = getDirectorySize(listFiles[i2], false);
            } else {
                length = listFiles[i2].length();
            }
            j += length;
        }
        return j;
    }

    public static String getTempFilePath(int i2, String str, boolean z) {
        File file = CACHE_DIR;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles();
        String prefixByType = getPrefixByType(i2);
        for (int i3 = 0; i3 < listFiles.length; i3++) {
            if (listFiles[i3] != null && listFiles[i3].getName().startsWith(prefixByType)) {
                if (listFiles[i3].getName().endsWith(str)) {
                    return listFiles[i3].getAbsolutePath();
                }
                if (z) {
                    listFiles[i3].delete();
                }
            }
        }
        return null;
    }

    public static long getFileSize(File file) {
        long j = 0;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            j = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            TiebaStatic.file(e, "FileHelper.getFileSize");
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return j;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
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
                } catch (Exception e4) {
                    e = e4;
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            TiebaStatic.file(e5, "FileHelper.getFileSize");
        }
        return j;
    }

    public static boolean CheckTempDir() {
        return CheckTempDir(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
    }

    public static boolean checkIsLongImage(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return false;
        }
        float f2 = width;
        float f3 = height / f2;
        return f2 * l.h(TbadkCoreApplication.getInst()) >= 100.0f && f3 >= 3.0f && f3 <= 50.0f;
    }

    public static Bitmap getImage(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            TiebaStatic.file(e2.getMessage(), k.join("FileHelper", ".", "getImage", " ", str));
            System.gc();
            try {
                return BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError unused) {
                TiebaStatic.file(e2.getMessage(), k.join("FileHelper", ".", "getImage", " ", str));
                return null;
            }
        }
    }

    public static byte[] GetFileData(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
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
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "FileHelper.GetFileData " + str);
            return null;
        }
    }

    public static String SaveFile(String str, byte[] bArr) {
        return SaveFile((String) null, str, bArr);
    }

    public static boolean renameTo(String str, String str2) {
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

    public static String SaveFile(String str, byte[] bArr, int i2) {
        if (checkSD()) {
            return SaveFile((String) null, getFilePath(str, i2, false), bArr);
        }
        return SaveTempFile(i2, str, bArr);
    }

    public static String saveFile(String str, String str2, InputStream inputStream) {
        String str3;
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        if (!CheckTempDir(str3) || inputStream == null || str2 == null) {
            return null;
        }
        return saveFile(str3 + "/" + str2, inputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveFile(String str, String str2, byte[] bArr) {
        String str3;
        Throwable th;
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        FileOutputStream fileOutputStream = null;
        if (!CheckTempDir(str3) || bArr == null || str2 == null) {
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
        try {
            if (file.exists()) {
                try {
                    try {
                        if (!file.delete()) {
                            return null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, k.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return null;
                            } catch (Throwable th2) {
                                BdLog.e(th2.getMessage());
                                TiebaStatic.file(th2.getMessage(), k.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                                return null;
                            }
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th4) {
                            BdLog.e(th4.getMessage());
                            TiebaStatic.file(th4.getMessage(), k.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                        }
                    }
                    throw th;
                }
            }
            if (file.createNewFile()) {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            }
            return null;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static String compressBitmapToFile(String str, String str2, Bitmap bitmap, float f2, int i2) {
        File dataDirectory;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            try {
                dataDirectory = new File(str);
            } catch (Exception unused) {
                if (checkSD()) {
                    dataDirectory = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName());
                } else {
                    dataDirectory = Environment.getDataDirectory();
                }
            }
        } else {
            dataDirectory = null;
        }
        if (dataDirectory == null) {
            return null;
        }
        if (dataDirectory.exists() && !dataDirectory.isDirectory()) {
            dataDirectory.delete();
        }
        if (!dataDirectory.exists()) {
            dataDirectory.mkdirs();
        }
        File file = new File(dataDirectory, str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > f2) {
                    byteArrayOutputStream.reset();
                    i2 -= 5;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, k.join("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
            return null;
        }
    }

    public static String saveFile(String str, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        OutputStream outputStream = null;
        if (StringUtils.isNull(str) || inputStream == null) {
            return null;
        }
        File file = new File(str);
        String parent = file.getParent();
        boolean isNull = StringUtils.isNull(parent);
        String str2 = parent;
        if (!isNull) {
            File file2 = new File(parent);
            boolean exists = file2.exists();
            str2 = exists;
            if (!exists) {
                file2.mkdirs();
                str2 = exists;
            }
        }
        try {
            try {
                if (file.exists() && !file.delete()) {
                    m.f(null);
                    return null;
                } else if (!file.createNewFile()) {
                    m.f(null);
                    return null;
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.flush();
                                String path = file.getPath();
                                m.f(fileOutputStream);
                                return path;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, "FileHelper.saveFile " + str);
                        m.f(fileOutputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                outputStream = str2;
                m.f(outputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            m.f(outputStream);
            throw th;
        }
    }

    public static boolean CopyFile(String str, String str2) {
        return CopyFile(str, str2, false);
    }
}
