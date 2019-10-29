package com.baidu.live.tbadk.core.util;

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
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.lib.util.BdFileHelper;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdStringHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.CloseUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes6.dex */
public class FileHelper {
    private static final String DIR_DOWNLOAD = "download";
    public static final String DIR_ROOT = "tieba";
    private static final String FILE_CACHE_BUBBLE = "bubble";
    private static final String FILE_CACHE_EMOTION_PACKAGE = "emotion";
    private static final String FILE_CACHE_VIDEO = ".video";
    private static final String FILE_CACHE_VOICE = "voice";
    public static final int FILE_TYPE_BUBBLE = 3;
    public static final int FILE_TYPE_EMOTION_PACKAGE = 2;
    public static final int FILE_TYPE_VOICE = 1;
    public static final File EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory();
    private static final File CACHE_DIR = TbadkCoreApplication.getInst().getApp().getCacheDir();

    public static boolean checkSD() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String getSdErrorString() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("removed")) {
            return TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_no_sdcard);
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable")) {
            return TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_no_sdcard);
        }
        if (externalStorageState.equals("shared")) {
            return TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_sd_shared);
        }
        return TbadkCoreApplication.getInst().getApp().getString(a.i.sdk_error_sd_error);
    }

    public static boolean CheckTempDir(String str) {
        if (checkSD()) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "CheckTempDir", HanziToPinyin.Token.SEPARATOR, str));
                return false;
            }
        }
        return false;
    }

    public static boolean CheckTempDir() {
        return CheckTempDir(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
    }

    public static boolean CheckFile(String str) {
        if (checkSD()) {
            try {
                return new File(new StringBuilder().append(EXTERNAL_STORAGE_DIRECTORY).append("/").append(TbConfig.getTempDirName()).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "CheckFile", HanziToPinyin.Token.SEPARATOR, str));
                return false;
            }
        }
        return false;
    }

    public static long checkImageFileSize(String str, String str2) {
        if (checkSD()) {
            try {
                if (new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2).exists()) {
                    return TbConfig.getBigImageSize();
                }
                return -1L;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "checkImageFileSize", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
                return -1L;
            }
        }
        return -1L;
    }

    public static String getFileDireciory(String str) {
        if (str == null) {
            return null;
        }
        return EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    public static File GetFile(String str) {
        if (!CheckTempDir()) {
            return null;
        }
        return GetFileByAbsolutePath(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
    }

    public static File GetFileInCache(String str) {
        return GetFileByAbsolutePath(CACHE_DIR + "/" + str);
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
        } catch (SecurityException e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "GetFile", HanziToPinyin.Token.SEPARATOR, str));
            return null;
        }
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

    public static PackageInfo getApkFileMetaData(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        String str2 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
        PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
        if (packageManager != null) {
            return packageManager.getPackageArchiveInfo(str2, 128);
        }
        return null;
    }

    public static File FileObject(String str) {
        if (!CheckTempDir()) {
            return null;
        }
        return new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "CreateFile", HanziToPinyin.Token.SEPARATOR, str));
                return null;
            }
        }
        return null;
    }

    public static File CreateFileIfNotFound(String str) {
        if (!CheckTempDir()) {
            return null;
        }
        return CreateFileIfNotFoundAbsolutePath(new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str).getAbsolutePath());
    }

    public static File CreateFileIfNotFoundInCache(String str) {
        return CreateFileIfNotFoundAbsolutePath(new File(CACHE_DIR + "/" + str).getAbsolutePath());
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "CreateFileIfNotFound", HanziToPinyin.Token.SEPARATOR, str));
            return null;
        }
    }

    public static FileOutputStream CreateFileOutputStream(String str) {
        try {
            File CreateFile = CreateFile(str);
            if (CreateFile != null) {
                return new FileOutputStream(CreateFile, true);
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "CreateFileOutputStream", HanziToPinyin.Token.SEPARATOR, str));
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=5, 468=5, 470=5, 471=5, 472=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0136 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x007e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.lang.Exception */
    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: java.lang.Exception */
    /* JADX DEBUG: Multi-variable search result rejected for r1v18, resolved type: java.lang.Exception */
    /* JADX DEBUG: Multi-variable search result rejected for r1v19, resolved type: java.lang.Exception */
    /* JADX WARN: Multi-variable type inference failed */
    public static String SaveGifFile(String str, String str2, byte[] bArr) {
        String str3;
        String str4 = str != null ? EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" : EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        if (!CheckTempDir(str4) || bArr == null) {
            return null;
        }
        File file = new File(str4 + str2);
        FileOutputStream fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.exists() && !file.delete()) {
                    str3 = null;
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveGifFile", HanziToPinyin.Token.SEPARATOR, str2));
                            fileOutputStream = e;
                        }
                    }
                } else if (file.createNewFile()) {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    try {
                        fileOutputStream3.write(bArr);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        fileOutputStream2 = null;
                        fileOutputStream = null;
                        fileOutputStream = null;
                        str3 = file.getPath();
                        if (0 != 0) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e2) {
                                BdLog.e(e2.getMessage());
                                TiebaInitialize.file(e2, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveGifFile", HanziToPinyin.Token.SEPARATOR, str2));
                                fileOutputStream = e2;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream2 = fileOutputStream3;
                        BdLog.e(e.getMessage());
                        TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveGifFile", HanziToPinyin.Token.SEPARATOR, str2));
                        str3 = null;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                                TiebaInitialize.file(e4, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveGifFile", HanziToPinyin.Token.SEPARATOR, str2));
                                fileOutputStream = e4;
                            }
                        }
                        return str3;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                                TiebaInitialize.file(e5, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveGifFile", HanziToPinyin.Token.SEPARATOR, str2));
                            }
                        }
                        throw th;
                    }
                } else {
                    str3 = null;
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e6) {
                            BdLog.e(e6.getMessage());
                            TiebaInitialize.file(e6, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveGifFile", HanziToPinyin.Token.SEPARATOR, str2));
                            fileOutputStream = e6;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e7) {
            e = e7;
        }
        return str3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [522=4, 523=4, 525=4, 526=4, 527=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x01c8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isGif(String str, String str2) {
        FileInputStream fileInputStream;
        IOException e;
        boolean z;
        FileNotFoundException e2;
        String str3 = str != null ? EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" : EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        ?? sb = new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(new File(sb.append(str3).append(str2).toString()));
                try {
                    byte[] bArr = new byte[7];
                    z = fileInputStream.read(bArr, 0, 6) == 6 ? BdUtilHelper.isGif(bArr) : false;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            fileInputStream = null;
                        } catch (FileNotFoundException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaInitialize.file(e2, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "isGif", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    TiebaInitialize.file(e4, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "isGif", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
                                }
                            }
                            return z;
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", "isGif", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                    TiebaInitialize.file(e6, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "isGif", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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
                            TiebaInitialize.file(e7, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "isGif", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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
                        TiebaInitialize.file(e10, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "isGif", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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

    public static boolean isGifImage(String str) {
        InputStream inStreamFromFile;
        boolean z = false;
        if (!StringUtils.isNull(str)) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory() && (inStreamFromFile = BdFileHelper.getInStreamFromFile(file)) != null) {
                try {
                    byte[] bArr = new byte[7];
                    if (inStreamFromFile.read(bArr, 0, 6) == 6) {
                        z = BdUtilHelper.isGif(bArr);
                    }
                } catch (IOException e) {
                } finally {
                    BdCloseHelper.close(inStreamFromFile);
                }
            }
        }
        return z;
    }

    public static boolean checkIsLongImage(String str) {
        int[] imageFileWH = getImageFileWH(str);
        if (imageFileWH[0] == 0 || imageFileWH[1] == 0) {
            return false;
        }
        float equipmentDensity = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
        float f = imageFileWH[1] / imageFileWH[0];
        return ((float) imageFileWH[0]) * equipmentDensity >= 100.0f && f >= 3.0f && f <= 50.0f;
    }

    public static int[] getImageFileWH(String str) {
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
                            CloseUtil.close((InputStream) fileInputStream);
                            iArr[0] = options.outWidth;
                            iArr[1] = options.outHeight;
                            return iArr;
                        } finally {
                            CloseUtil.close((InputStream) fileInputStream);
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

    public static boolean checkIsLongImage(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == 0 || height == 0) {
            return false;
        }
        float f = height / width;
        return ((float) width) * BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()) >= 100.0f && f >= 3.0f && f <= 50.0f;
    }

    public static String saveFile2(String str, String str2, Bitmap bitmap, int i) {
        String str3;
        if (bitmap == null) {
            return null;
        }
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        if (!CheckTempDir(str3) || bitmap == null) {
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
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveFile1", " '", str, "/", str2));
            return null;
        }
    }

    public static String saveFileAsPNG(String str, String str2, Bitmap bitmap, int i) {
        return saveFileAsPic(str, str2, bitmap, i, Bitmap.CompressFormat.PNG);
    }

    public static String saveFileAsPic(String str, String str2, Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null || !CheckTempDir(str) || bitmap == null) {
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
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "saveFileAsPNG", " '", str, "/", str2));
            return null;
        }
    }

    public static String compressBitmapToFile(String str, Bitmap bitmap, float f, int i) {
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
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "compressBitmapToFile", HanziToPinyin.Token.SEPARATOR, file.getAbsolutePath()));
            return null;
        }
    }

    public static String saveFileToSDOrMemory(String str, Bitmap bitmap, int i) {
        String absolutePath;
        if (bitmap == null) {
            return null;
        }
        if (checkSD()) {
            absolutePath = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName();
        } else {
            absolutePath = Environment.getDataDirectory().getAbsolutePath();
        }
        return saveFile(absolutePath, str, bitmap, i);
    }

    public static String saveFile(String str, String str2, Bitmap bitmap, int i) {
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
            TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "saveFileToSDOrMemory", HanziToPinyin.Token.SEPARATOR, file2.getAbsolutePath()));
            return null;
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
                TiebaInitialize.file(BdStringHelper.join("renameTo", "err"), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "renameTo"));
                return null;
            }
            return file2.getAbsolutePath();
        }
        return null;
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

    public static Bitmap getImage(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = TbConfig.BitmapConfig;
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            TiebaInitialize.file(e.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "getImage", HanziToPinyin.Token.SEPARATOR, str));
            System.gc();
            try {
                return BitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e2) {
                TiebaInitialize.file(e.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "getImage", HanziToPinyin.Token.SEPARATOR, str));
                return null;
            }
        }
    }

    public static String saveFile2(String str, byte[] bArr) {
        return saveFile2((String) null, str, bArr);
    }

    public static String saveFile2(String str, byte[] bArr, int i) {
        return checkSD() ? saveFile2((String) null, getFilePath(str, i, false), bArr) : SaveTempFile(i, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [989=5, 990=5, 992=5, 993=5, 994=10, 995=5] */
    public static String saveFile2(String str, String str2, byte[] bArr) {
        String str3 = str != null ? EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" : EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
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
                            TiebaInitialize.file(th.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveFile", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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
                            TiebaInitialize.file(th2.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveFile", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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
                                TiebaInitialize.file(th3.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveFile", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
                                return path;
                            }
                        }
                        return path;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        TiebaInitialize.file(e, BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "saveFile2", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return null;
                            } catch (Throwable th4) {
                                BdLog.e(th4.getMessage());
                                TiebaInitialize.file(th4.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveFile", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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
                                TiebaInitialize.file(th6.getMessage(), BdStringHelper.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "SaveFile", HanziToPinyin.Token.SEPARATOR, str, "/", str2));
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

    private static String getPrefixPath(String str, boolean z) {
        return (z && str.startsWith(EXTERNAL_STORAGE_DIRECTORY.toString())) ? str : EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1050=4, 1051=4, 1053=4, 1054=4, 1055=4, 1059=4, 1060=4, 1062=4, 1063=4, 1064=4] */
    public static boolean copyFile2(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            r3 = 0
            r1 = 0
            r2 = 0
            java.lang.String r4 = getPrefixPath(r8, r10)
            java.lang.String r5 = getPrefixPath(r9, r10)
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
            com.baidu.live.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r4)
            goto L21
        L56:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
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
            com.baidu.live.adp.lib.util.BdLog.e(r4)     // Catch: java.lang.Throwable -> L21f
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L21f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21f
            r4.<init>()     // Catch: java.lang.Throwable -> L21f
            java.lang.String r5 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L21f
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L21f
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L21f
            java.lang.StringBuilder r4 = r4.append(r9)     // Catch: java.lang.Throwable -> L21f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L21f
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r4)     // Catch: java.lang.Throwable -> L21f
            if (r3 == 0) goto Ld2
            r3.close()     // Catch: java.lang.Throwable -> L17d
        Ld2:
            if (r2 == 0) goto L26
            r2.close()     // Catch: java.lang.Throwable -> Ld9
            goto L26
        Ld9:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
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
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
            goto L26
        L14e:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r4)
            goto L117
        L17d:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r3)
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
            com.baidu.live.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r3)
            goto L1b4
        L1e9:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.tbadk.core.util.FileHelper.copyFile2(java.lang.String, java.lang.String, boolean):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1106=4, 1107=4, 1109=4, 1110=4, 1111=4, 1115=4, 1116=4, 1118=4, 1119=4, 1120=4] */
    public static boolean copyFile(java.lang.String r7, java.lang.String r8) {
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
            com.baidu.live.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r4)
            goto L19
        L4e:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
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
            com.baidu.live.adp.lib.util.BdLog.e(r4)     // Catch: java.lang.Throwable -> L217
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L217
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L217
            r4.<init>()     // Catch: java.lang.Throwable -> L217
            java.lang.String r5 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L217
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch: java.lang.Throwable -> L217
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L217
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch: java.lang.Throwable -> L217
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L217
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r4)     // Catch: java.lang.Throwable -> L217
            if (r3 == 0) goto Lca
            r3.close()     // Catch: java.lang.Throwable -> L175
        Lca:
            if (r2 == 0) goto L1e
            r2.close()     // Catch: java.lang.Throwable -> Ld1
            goto L1e
        Ld1:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
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
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
            goto L1e
        L146:
            r1 = move-exception
            java.lang.String r4 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r4)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r5 = " to "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r4)
            goto L10f
        L175:
            r1 = move-exception
            java.lang.String r3 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r3)
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
            com.baidu.live.adp.lib.util.BdLog.e(r3)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " to "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r3)
            goto L1ac
        L1e1:
            r1 = move-exception
            java.lang.String r2 = r1.toString()
            com.baidu.live.adp.lib.util.BdLog.e(r2)
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "FileHelper.copyFile2 "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.baidu.live.tbadk.core.util.TiebaInitialize.file(r1, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.tbadk.core.util.FileHelper.copyFile(java.lang.String, java.lang.String):boolean");
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1186=5] */
    public static String saveFile(String str, InputStream inputStream) {
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
                    CloseUtil.close((OutputStream) null);
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
                            CloseUtil.close((OutputStream) fileOutputStream);
                        } catch (IOException e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            TiebaInitialize.file(e, "FileHelper.saveFile " + str);
                            CloseUtil.close((OutputStream) fileOutputStream);
                            return str2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        CloseUtil.close((OutputStream) fileOutputStream);
                        throw th;
                    }
                } else {
                    CloseUtil.close((OutputStream) null);
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                CloseUtil.close((OutputStream) fileOutputStream);
                throw th;
            }
        }
        return str2;
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, "FileHelper.cleanDirectory " + str);
            return false;
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

    public static byte[] GetFileData(String str) {
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
            TiebaInitialize.file(e, "FileHelper.GetFileData " + str);
            return null;
        }
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

    public static boolean copyFile2(String str, String str2) {
        return copyFile2(str, str2, false);
    }

    public static InputStream GetStreamFromFile(String str) {
        return GetStreamFromFile(GetFile(str));
    }

    public static InputStream GetStreamFromTmpFile(String str) {
        File file = null;
        File file2 = new File(str);
        try {
            if (file2.exists()) {
                file = file2;
            }
        } catch (SecurityException e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, "FileHelper.GetStreamFromTmpFile " + str);
        }
        return GetStreamFromFile(file);
    }

    public static InputStream GetStreamFromFile(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                TiebaInitialize.file(th.getMessage(), "FileHelper.GetStreamFromFile");
                return null;
            }
        }
        return null;
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
                TiebaInitialize.file(th.getMessage(), "FileHelper.DelFile " + str);
                return false;
            }
        }
        return false;
    }

    public static void deleteFileOrDir(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            deleteFileOrDir(listFiles[i]);
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaInitialize.file(e, "FileHelper.deleteFileOrDir");
        }
    }

    public static String getCacheDir() {
        return EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
    }

    public static String getDownloadDir() {
        return EXTERNAL_STORAGE_DIRECTORY + "/tieba/" + DIR_DOWNLOAD;
    }

    public static String getVideoTmpDir() {
        return EXTERNAL_STORAGE_DIRECTORY + "/tieba/" + FILE_CACHE_VIDEO;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1489=5, 1490=5, 1492=5, 1493=5] */
    public static boolean saveFileByAbsolutePath(String str, byte[] bArr) {
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
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static String getTempFilePath(int i, String str) {
        return getTempFilePath(i, str, false);
    }

    private static String getTempFilePath(int i, String str, boolean z) {
        if (CACHE_DIR == null) {
            return null;
        }
        File[] listFiles = CACHE_DIR.listFiles();
        String prefixByType = getPrefixByType(i);
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2] != null && listFiles[i2].getName().startsWith(prefixByType)) {
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

    public static String getPrefixByType(int i) {
        switch (i) {
            case 1:
                return "voice";
            case 2:
                return FILE_CACHE_EMOTION_PACKAGE;
            case 3:
                return FILE_CACHE_BUBBLE;
            default:
                return "";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1591=4, 1592=4, 1594=4, 1595=4, 1596=4, 1597=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x00aa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x00ac */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveTempFile(int i, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        String str2;
        File createTempFile;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String tempFilePath = getTempFilePath(i, str, true);
        if (tempFilePath == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    createTempFile = File.createTempFile(getPrefixByType(i), str, CACHE_DIR);
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            BdLog.e(th2.getMessage());
                            TiebaInitialize.file(th2.getMessage(), "FileHelper.saveFile2 ");
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
                        BdLog.e(th4.getMessage());
                        TiebaInitialize.file(th4.getMessage(), "FileHelper.saveFile2 ");
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
                        BdLog.e(th5.getMessage());
                        TiebaInitialize.file(th5.getMessage(), "FileHelper.saveFile2 ");
                        fileOutputStream2 = "FileHelper.saveFile2 ";
                    }
                }
            } catch (IOException e2) {
                e = e2;
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "FileHelper.saveFile2 ");
                FileOutputStream fileOutputStream3 = fileOutputStream;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        fileOutputStream3 = fileOutputStream;
                    } catch (Throwable th6) {
                        BdLog.e(th6.getMessage());
                        TiebaInitialize.file(th6.getMessage(), "FileHelper.saveFile2 ");
                        fileOutputStream3 = "FileHelper.saveFile2 ";
                    }
                }
                str2 = null;
                fileOutputStream2 = fileOutputStream3;
                return str2;
            }
            return str2;
        }
        return tempFilePath;
    }

    public static String getStoreFile(String str, int i) {
        if (str == null) {
            return null;
        }
        if (checkSD()) {
            if (CheckFile(getFilePath(str, i, false))) {
                return getFilePath(str, i, true);
            }
            return null;
        }
        return getTempFilePath(1, str);
    }

    public static String getFilePath(String str, int i, boolean z) {
        if (!checkSD()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(getCacheDir());
        }
        sb.append(getPrefixByType(i));
        sb.append(File.separator);
        sb.append(str);
        return sb.toString();
    }

    public static long SDAvailableSize() {
        String str = null;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        if (str == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static long getFileSize(String str) {
        if (StringUtils.isNull(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getFileSize(File file) {
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
                        TiebaInitialize.file(e, "FileHelper.getFileSize");
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e2) {
                                TiebaInitialize.file(e2, "FileHelper.getFileSize");
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
                            TiebaInitialize.file(e3, "FileHelper.getFileSize");
                        }
                    }
                    throw th;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    TiebaInitialize.file(e4, "FileHelper.getFileSize");
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
            TiebaInitialize.file(e, "FileHelper.deleteFile");
            return false;
        }
    }

    public static long getDirectorySize(String str, boolean z) {
        return getDirectorySize(new File(str), z);
    }

    public static long getDirectorySize(File file, boolean z) {
        long length;
        long j = 0;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory() && !z) {
                    length = getDirectorySize(listFiles[i], false);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    public static void makeRootDirectory(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            TiebaInitialize.file(e, "FileHelper.makeRootDirectory " + str);
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "FileHelper.checkFileSize " + str + "/" + str2);
                return -1L;
            }
        }
        return -1L;
    }

    /* loaded from: classes6.dex */
    public static class DataDir {
        public static final String PACKAGE_DATA_DIR = TbadkCoreApplication.getInst().getApp().getFileStreamPath("").getAbsolutePath();
        public static final String PACKAGE_VERSION_CUR_DIR = "/package.cur";
        public static final String PACKAGE_VERSION_LAST_DIR = "/package.last";

        public static boolean checkFile(String str) {
            try {
                return new File(new StringBuilder().append(PACKAGE_DATA_DIR).append("/").append(str).toString()).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "FileHelper.checkFile " + str);
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "FileHelper.createFile " + str);
                return false;
            }
        }

        public static void deleteFileOrDir(File file) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                deleteFileOrDir(listFiles[i]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "FileHelper.deleteFileOrDir");
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
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaInitialize.file(e, "FileHelper.cleanDirectory " + str);
                return false;
            }
        }

        public static String getLatestFileName(String str) {
            String str2 = null;
            try {
                File file = new File(PACKAGE_DATA_DIR + "/" + str);
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
                TiebaInitialize.file(e, "FileHelper.getLatestFileName " + str);
            }
            return str2;
        }
    }

    public static int saveImageFileByUser(String str, byte[] bArr, Context context) {
        String str2;
        Bitmap decodeByteArray;
        if (bArr == null || str == null || str.length() == 0 || context == null) {
            return -1;
        }
        try {
            if (!BdUtilHelper.isGif(bArr)) {
                str2 = ".jpg";
            } else {
                str2 = ".gif";
            }
            if (BdUtilHelper.isDataWebpFormat(bArr) && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                bArr = BdBitmapHelper.getInstance().Bitmap2Bytes(decodeByteArray, 100);
                decodeByteArray.recycle();
            }
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            if (nameMd5FromUrl != null) {
                String str3 = nameMd5FromUrl + str2;
                for (int i = 0; CheckFile(str3) && i < 10000; i++) {
                    str3 = nameMd5FromUrl + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str2;
                }
                String saveFile2 = saveFile2(str3, bArr);
                if (saveFile2 != null) {
                    new MediaScannerClient(context).saveImage(saveFile2);
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

    public static int copyImageFile(String str, String str2, Context context) {
        String str3;
        if (str2 == null || str2.length() == 0 || context == null) {
            return -1;
        }
        try {
            if (!isGifImage(str)) {
                str3 = ".jpg";
            } else {
                str3 = ".gif";
            }
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
            if (nameMd5FromUrl != null) {
                String str4 = nameMd5FromUrl + str3;
                for (int i = 0; CheckFile(str4) && i < 10000; i++) {
                    str4 = nameMd5FromUrl + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str3;
                }
                String str5 = getCacheDir() + str4;
                BdFileHelper.copyFile(new File(str), new File(str5));
                new MediaScannerClient(context).saveImage(str5);
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
    public static String getImageRealPathFromUri(Context context, Uri uri) {
        Cursor cursor;
        int columnIndex;
        String string;
        if (uri == null || context == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme == null || BdStatsConstant.OpSubType.FILE.equals(scheme)) {
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
                            BdCloseHelper.close(cursor);
                            return string;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        BdCloseHelper.close(cursor);
                        return null;
                    }
                }
                string = null;
                BdCloseHelper.close(cursor);
                return string;
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                BdCloseHelper.close((Cursor) r1);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isLocalImagePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().startsWith("content:") || str.toLowerCase().startsWith("file:");
    }

    public static String getCacheFilePath(String str) {
        return CACHE_DIR + "/" + str;
    }
}
