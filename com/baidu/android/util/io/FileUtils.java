package com.baidu.android.util.io;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class FileUtils {
    public static final int BUFFER_SIZE = 1024;
    public static final boolean DEBUG = false;
    public static final String EXTERNAL_STORAGE_DIRECTORY = "/baidu";
    public static final String FILE_SCHEMA = "file://";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static int FS_BLOCK_SIZE = 0;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;
    public static final String SEARCHBOX_FOLDER = "searchbox";
    public static final String TAG = "FileUtils";
    public static final String UNKNOW = "未知";
    public static final int UNZIP_BUFFER = 2048;
    public static String sCacheDir;

    public static boolean cache(Context context, String str, String str2, int i2) {
        return cache(context, str, str2.getBytes(), i2);
    }

    public static long copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        long j = 0;
        if (file == null || file2 == null || !file.exists()) {
            return 0L;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    j = copyStream(fileInputStream2, fileOutputStream);
                    Closeables.closeSafely(fileInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(fileOutputStream);
                        return j;
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        Closeables.closeSafely(fileOutputStream);
        return j;
    }

    @Deprecated
    public static long copyFile(File file, File file2) {
        return copy(file, file2);
    }

    @Deprecated
    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream);
    }

    public static boolean createFileSafely(File file) {
        if (file != null && !file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                return file.createNewFile();
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Deprecated
    public static boolean createNewFileSafely(File file) {
        return createFileSafely(file);
    }

    public static boolean deleteCache(Context context, String str) {
        try {
            return context.deleteFile(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return deleteFile(file);
        }
        return false;
    }

    public static boolean ensureDirectoryExist(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.mkdirs();
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean exists(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String generateFileSizeText(long j) {
        Float valueOf;
        String str;
        if (j <= 0) {
            return UNKNOW;
        }
        if (j < 1024) {
            return j + "B";
        }
        if (j < 1048576) {
            valueOf = Float.valueOf(((float) j) / 1024.0f);
            str = "KB";
        } else if (j < 1073741824) {
            valueOf = Float.valueOf(((float) j) / 1048576.0f);
            str = "MB";
        } else {
            valueOf = Float.valueOf(((float) j) / 1.0737418E9f);
            str = "GB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
        return decimalFormat.format(valueOf) + str;
    }

    @TargetApi(8)
    public static String getCacheDir(@NonNull Context context) {
        if (TextUtils.isEmpty(sCacheDir)) {
            sCacheDir = getDeviceCacheDir(context.getApplicationContext());
        }
        return sCacheDir;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(8)
    public static String getDeviceCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getFilesDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return null;
    }

    public static long getDirectorySize(File file) throws IOException {
        long length;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.length();
        }
        int length2 = listFiles.length;
        long j = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            if (listFiles[i2].isDirectory()) {
                length = getDirectorySize(listFiles[i2]);
            } else {
                length = listFiles[i2].length();
            }
            j += length;
        }
        return j;
    }

    public static int getFSBlockSize() {
        if (FS_BLOCK_SIZE == 0) {
            int blockSize = new StatFs("/data").getBlockSize();
            FS_BLOCK_SIZE = blockSize;
            if (blockSize <= 0) {
                FS_BLOCK_SIZE = 8192;
            }
        }
        return FS_BLOCK_SIZE;
    }

    public static String getFileNameFromPath(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        return (lastIndexOf == INVALID_INDEX || length <= lastIndexOf) ? str : str.substring(lastIndexOf + ONE_INCREAMENT, length);
    }

    public static String getFileNameFromUrl(String str) {
        int lastIndexOf;
        String decode = Uri.decode(str);
        if (decode != null) {
            int indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                return decode.substring(lastIndexOf);
            }
        }
        return null;
    }

    public static String getFileNameNoExt(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length()) ? str : str.substring(0, lastIndexOf);
    }

    public static File getPublicExternalDiretory(String str, String str2) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File file = new File(externalStorageDirectory, EXTERNAL_STORAGE_DIRECTORY + File.separator + str2);
        if (ensureDirectoryExist(file)) {
            return new File(file, str);
        }
        return null;
    }

    @Deprecated
    public static Drawable getSkinDrawableFromBaiduFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists() || !file.isDirectory()) {
            try {
                System.currentTimeMillis();
                Drawable createFromPath = Drawable.createFromPath(str);
                System.currentTimeMillis();
                return createFromPath;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String insertTagInFileName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        StringBuilder sb = new StringBuilder();
        if (lastIndexOf <= -1 || lastIndexOf >= str.length()) {
            return str;
        }
        sb.append(str.substring(0, lastIndexOf));
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        sb.append(str.substring(lastIndexOf));
        return sb.toString();
    }

    @Deprecated
    public static boolean isExistFile(String str) {
        return exists(str);
    }

    @Deprecated
    public static boolean isGzipFile(String str) {
        return GZIP.isGzipFile(str);
    }

    @Deprecated
    public static boolean isZipFile(File file) {
        return ZipUtils.isZipFile(file);
    }

    @Deprecated
    public static String readAssetData(Context context, String str) {
        return AssetUtils.readAsset(context, str);
    }

    public static String readCacheData(Context context, String str) {
        try {
            return readInputStream(context.openFileInput(str));
        } catch (FileNotFoundException unused) {
            return "";
        }
    }

    public static String readFileData(File file) {
        try {
            return readInputStream(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return "";
        }
    }

    public static String readInputStream(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return sb2;
            } catch (IOException e3) {
                e3.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return "";
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    public static boolean safeDeleteFile(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath);
                    long currentTimeMillis = System.currentTimeMillis();
                    File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                    file2.renameTo(file3);
                    return file3.delete();
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static File saveCacheFile(Context context, byte[] bArr, String str) {
        if (context == null || bArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getCacheDir(), str);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        Closeables.closeSafely(byteArrayInputStream);
        return file;
    }

    public static boolean saveFile(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        saveFileCommon(str.getBytes(), file);
        return true;
    }

    public static void saveFileCommon(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        Closeables.closeSafely(byteArrayInputStream);
    }

    public static void saveToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
            try {
                copyStream(inputStream, fileOutputStream);
                fileOutputStream.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static boolean saveToFileWithReturn(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return saveToFileWithReturn(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static void saveToGzip(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream;
        if (bArr == null || bArr.length <= 0 || file == null) {
            return;
        }
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file, false));
            try {
                byte[] bArr2 = new byte[1024];
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                while (true) {
                    try {
                        int read = byteArrayInputStream.read(bArr2, 0, 1024);
                        if (read <= 0) {
                            break;
                        }
                        gZIPOutputStream2.write(bArr2, 0, read);
                    } catch (IOException e2) {
                        e = e2;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            e.printStackTrace();
                            Closeables.closeSafely(gZIPOutputStream);
                            Closeables.closeSafely(byteArrayInputStream);
                        } catch (Throwable th) {
                            th = th;
                            Closeables.closeSafely(gZIPOutputStream);
                            Closeables.closeSafely(byteArrayInputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPOutputStream = gZIPOutputStream2;
                        Closeables.closeSafely(gZIPOutputStream);
                        Closeables.closeSafely(byteArrayInputStream);
                        throw th;
                    }
                }
                gZIPOutputStream2.finish();
                Closeables.closeSafely(gZIPOutputStream2);
            } catch (IOException e3) {
                e = e3;
                byteArrayInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
        }
        Closeables.closeSafely(byteArrayInputStream);
    }

    @Deprecated
    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase(Locale.getDefault());
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    @Deprecated
    public static boolean unGzipFile(File file, File file2) {
        GZIPInputStream gZIPInputStream;
        FileOutputStream fileOutputStream;
        if (file == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                gZIPInputStream = new GZIPInputStream(fileInputStream2);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = gZIPInputStream.read(bArr, 0, 8192);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.flush();
                                Closeables.closeSafely(fileInputStream2);
                                Closeables.closeSafely(fileOutputStream);
                                Closeables.closeSafely(gZIPInputStream);
                                return true;
                            }
                        }
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(fileOutputStream);
                        Closeables.closeSafely(gZIPInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(fileOutputStream);
                        Closeables.closeSafely(gZIPInputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Exception unused3) {
                gZIPInputStream = null;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
                fileOutputStream = null;
            }
        } catch (Exception unused4) {
            gZIPInputStream = null;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            fileOutputStream = null;
        }
    }

    @Deprecated
    public static boolean unzipFile(String str, String str2) {
        return ZipUtils.unzipFile(str, str2);
    }

    @Deprecated
    public static boolean unzipFileFromAsset(String str, String str2, Context context) {
        return AssetUtils.unzipFileFromAsset(str, str2, context);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0018 -> B:31:0x0031). Please submit an issue!!! */
    public static boolean cache(Context context, String str, byte[] bArr, int i2) {
        boolean z = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    try {
                        fileOutputStream = context.openFileOutput(str, i2);
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        z = true;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    @TargetApi(8)
    @Deprecated
    public static String getCacheDir() {
        return getCacheDir(AppRuntime.getAppContext());
    }

    public static File getPublicExternalDiretory(String str) {
        return getPublicExternalDiretory(str, SEARCHBOX_FOLDER);
    }

    public static boolean saveFile(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!file.exists() || z) {
            saveFileCommon(str.getBytes(), file);
            return true;
        }
        return false;
    }

    public static boolean saveToFileWithReturn(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
        } catch (FileNotFoundException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean z2 = copyStream(inputStream, fileOutputStream) != 0;
            Closeables.closeSafely(fileOutputStream);
            return z2;
        } catch (FileNotFoundException unused2) {
            fileOutputStream2 = fileOutputStream;
            Closeables.closeSafely(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            Closeables.closeSafely(fileOutputStream2);
            throw th;
        }
    }

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                return true & file.delete();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= deleteFile(file2);
                    }
                }
                return z & file.delete();
            }
            return true;
        }
        return true;
    }

    public static long getDirectorySize(String str) throws IOException {
        long length;
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.length();
        }
        int length2 = listFiles.length;
        long j = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            if (listFiles[i2].isDirectory()) {
                length = getDirectorySize(listFiles[i2]);
            } else {
                length = listFiles[i2].length();
            }
            j += length;
        }
        return j;
    }

    public static boolean saveFile(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return saveFile(str, new File(str2), z);
    }

    public static File saveFile(Context context, byte[] bArr, String str, String str2) {
        if (context == null || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null && !externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        File file = new File(externalFilesDir, str2);
        saveFileCommon(bArr, file);
        return file;
    }

    @Deprecated
    public static void saveToFile(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        saveToFile(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[3072];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j += read;
                    } else {
                        outputStream.flush();
                        return j;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    @Deprecated
    public static void saveToFile(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
            try {
                copyStream(inputStream, fileOutputStream);
                fileOutputStream.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }
}
