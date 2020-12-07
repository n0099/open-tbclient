package com.baidu.android.util.io;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
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
/* loaded from: classes6.dex */
public final class FileUtils {
    static final int BUFFER_SIZE = 1024;
    private static final boolean DEBUG = false;
    private static final String EXTERNAL_STORAGE_DIRECTORY = "/baidu";
    public static final String FILE_SCHEMA = "file://";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    private static final String SEARCHBOX_FOLDER = "searchbox";
    private static final String TAG = "FileUtils";
    public static final String UNKNOW = "未知";
    static final int UNZIP_BUFFER = 2048;
    private static String sCacheDir = null;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;

    private FileUtils() {
    }

    @TargetApi(8)
    public static String getCacheDir(Context context) {
        if (TextUtils.isEmpty(sCacheDir)) {
            sCacheDir = getDeviceCacheDir(context.getApplicationContext());
        }
        return sCacheDir;
    }

    @TargetApi(8)
    @Deprecated
    public static String getCacheDir() {
        return getCacheDir(AppRuntime.getAppContext());
    }

    @Deprecated
    public static boolean isExistFile(String str) {
        return exists(str);
    }

    public static boolean exists(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
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

    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                z = true & file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= deleteFile(file2);
                    }
                }
                z &= file.delete();
            }
        }
        return z;
    }

    public static boolean saveFile(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        saveFileCommon(str.getBytes(), file);
        return true;
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
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        File file = new File(externalFilesDir, str2);
        saveFileCommon(bArr, file);
        return file;
    }

    private static void saveFileCommon(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        Closeables.closeSafely(byteArrayInputStream);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [378=4] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    copyStream(inputStream, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    @Deprecated
    public static void saveToFile(String str, File file, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            saveToFile(new ByteArrayInputStream(str.getBytes()), file, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [428=4] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveToFile(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    copyStream(inputStream, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean saveToFileWithReturn(String str, File file, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return saveToFileWithReturn(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static boolean saveToFileWithReturn(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                r0 = copyStream(inputStream, fileOutputStream) != 0;
                Closeables.closeSafely(fileOutputStream);
            } catch (FileNotFoundException e) {
                Closeables.closeSafely(fileOutputStream);
                return r0;
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(fileOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return r0;
    }

    @Deprecated
    public static long copyFile(File file, File file2) {
        return copy(file, file2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [524=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static long copy(File file, File file2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ?? fileOutputStream;
        FileInputStream fileInputStream3 = null;
        long j = 0;
        if (file != null && file2 != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream2 = null;
                    fileInputStream3 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    j = copyStream(fileInputStream, fileOutputStream);
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely((Closeable) fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream3 = fileInputStream;
                    fileInputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream3);
                        Closeables.closeSafely(fileInputStream2);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        Closeables.closeSafely(fileInputStream3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream3 = fileOutputStream;
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely(fileInputStream3);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
        }
        return j;
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return 0L;
        }
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
        } catch (IOException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Deprecated
    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        return copy(inputStream, outputStream);
    }

    @SuppressLint({"NewApi"})
    @TargetApi(8)
    private static String getDeviceCacheDir(Context context) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [625=4] */
    public static void saveToGzip(byte[] bArr, File file) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayInputStream byteArrayInputStream = null;
        if (bArr == null || bArr.length <= 0 || file == null) {
            return;
        }
        try {
            gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file, false));
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    while (true) {
                        try {
                            int read = byteArrayInputStream2.read(bArr2, 0, 1024);
                            if (read <= 0) {
                                gZIPOutputStream.finish();
                                Closeables.closeSafely(gZIPOutputStream);
                                Closeables.closeSafely(byteArrayInputStream2);
                                return;
                            }
                            gZIPOutputStream.write(bArr2, 0, read);
                        } catch (IOException e) {
                            e = e;
                            byteArrayInputStream = byteArrayInputStream2;
                            e.printStackTrace();
                            Closeables.closeSafely(gZIPOutputStream);
                            Closeables.closeSafely(byteArrayInputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            byteArrayInputStream = byteArrayInputStream2;
                            Closeables.closeSafely(gZIPOutputStream);
                            Closeables.closeSafely(byteArrayInputStream);
                            throw th;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            gZIPOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
        }
    }

    public static String readFileData(File file) {
        try {
            return readInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static boolean cache(Context context, String str, String str2, int i) {
        return cache(context, str, str2.getBytes(), i);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [690=4, 692=4, 693=4, 694=4] */
    public static boolean cache(Context context, String str, byte[] bArr, int i) {
        boolean z = false;
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    fileOutputStream = context.openFileOutput(str, i);
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    z = true;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean deleteCache(Context context, String str) {
        try {
            return context.deleteFile(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readCacheData(Context context, String str) {
        try {
            return readInputStream(context.openFileInput(str));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        try {
                            inputStream.close();
                            return sb2;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return sb2;
                        }
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                    inputStream.close();
                    return "";
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
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
                    File file3 = new File(absolutePath + System.currentTimeMillis() + ".tmp");
                    file2.renameTo(file3);
                    return file3.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static boolean createNewFileSafely(File file) {
        return createFileSafely(file);
    }

    public static boolean createFileSafely(File file) {
        if (file == null || file.exists()) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            return false;
        }
    }

    @Deprecated
    public static boolean isZipFile(File file) {
        return ZipUtils.isZipFile(file);
    }

    @Deprecated
    public static boolean isGzipFile(String str) {
        return GZIP.isGzipFile(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [893=4] */
    @Deprecated
    public static boolean unGzipFile(File file, File file2) {
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (file == null) {
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                gZIPInputStream = new GZIPInputStream(fileInputStream);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = gZIPInputStream.read(bArr, 0, bArr.length);
                        if (read == -1) {
                            fileOutputStream.flush();
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(fileOutputStream);
                            Closeables.closeSafely(gZIPInputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e2) {
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream2 = fileInputStream;
                    Closeables.closeSafely(fileInputStream2);
                    Closeables.closeSafely(fileOutputStream2);
                    Closeables.closeSafely(gZIPInputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    Closeables.closeSafely(fileInputStream);
                    Closeables.closeSafely(fileOutputStream2);
                    Closeables.closeSafely(gZIPInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                gZIPInputStream = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th3) {
                th = th3;
                gZIPInputStream = null;
            }
        } catch (Exception e4) {
            gZIPInputStream = null;
            fileInputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            gZIPInputStream = null;
            fileInputStream = null;
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

    @Deprecated
    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (z) {
                hexString = hexString.toUpperCase(Locale.getDefault());
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.toString();
    }

    public static String getFileNameNoExt(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) > -1 && lastIndexOf < str.length()) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String insertTagInFileName(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf(46);
            StringBuilder sb = new StringBuilder();
            if (lastIndexOf > -1 && lastIndexOf < str.length()) {
                sb.append(str.substring(0, lastIndexOf));
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                }
                sb.append(str.substring(lastIndexOf));
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    public static String getFileNameFromPath(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        if (lastIndexOf != INVALID_INDEX && length > lastIndexOf) {
            return str.substring(lastIndexOf + ONE_INCREAMENT, length);
        }
        return str;
    }

    @Deprecated
    public static String readAssetData(Context context, String str) {
        return AssetUtils.readAsset(context, str);
    }

    public static File getPublicExternalDiretory(String str, String str2) {
        File file = new File(Environment.getExternalStorageDirectory(), EXTERNAL_STORAGE_DIRECTORY + File.separator + str2);
        if (!ensureDirectoryExist(file)) {
            return null;
        }
        return new File(file, str);
    }

    public static File getPublicExternalDiretory(String str) {
        return getPublicExternalDiretory(str, SEARCHBOX_FOLDER);
    }

    public static boolean ensureDirectoryExist(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                return false;
            }
        }
        return true;
    }

    public static String generateFileSizeText(long j) {
        String str;
        Float valueOf;
        if (j <= 0) {
            return UNKNOW;
        }
        if (j < 1024) {
            return j + "B";
        }
        if (j < 1048576) {
            str = "KB";
            valueOf = Float.valueOf(((float) j) / 1024.0f);
        } else if (j < 1073741824) {
            str = "MB";
            valueOf = Float.valueOf(((float) j) / 1048576.0f);
        } else {
            str = "GB";
            valueOf = Float.valueOf(((float) j) / 1.0737418E9f);
        }
        return new DecimalFormat("####.##").format(valueOf) + str;
    }

    public static long getDirectorySize(File file) throws IOException {
        long length;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.length();
        }
        int length2 = listFiles.length;
        long j = 0;
        for (int i = 0; i < length2; i++) {
            if (listFiles[i].isDirectory()) {
                length = getDirectorySize(listFiles[i]);
            } else {
                length = listFiles[i].length();
            }
            j += length;
        }
        return j;
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
        for (int i = 0; i < length2; i++) {
            if (listFiles[i].isDirectory()) {
                length = getDirectorySize(listFiles[i]);
            } else {
                length = listFiles[i].length();
            }
            j += length;
        }
        return j;
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
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
