package com.baidu.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public class f {
    private static String APP_DIR = "baidu";
    public static final File EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory();
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    public static boolean checkSD() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int getSdError() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            return 0;
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable") || externalStorageState.equals("removed")) {
            return 1;
        }
        if (externalStorageState.equals("shared")) {
            return 2;
        }
        return 3;
    }

    public static String getPath(String str) {
        if (str != null) {
            return EXTERNAL_STORAGE_DIRECTORY + "/" + APP_DIR + "/" + str + "/";
        }
        return EXTERNAL_STORAGE_DIRECTORY + "/" + APP_DIR + "/";
    }

    public static String getFilePath(String str, String str2) {
        if (str != null) {
            return EXTERNAL_STORAGE_DIRECTORY + "/" + APP_DIR + "/" + str + "/" + str2;
        }
        return EXTERNAL_STORAGE_DIRECTORY + "/" + APP_DIR + "/" + str2;
    }

    public static boolean checkSDHasSpace() {
        try {
            StatFs statFs = new StatFs(EXTERNAL_STORAGE_DIRECTORY.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getFilePath(String str) {
        return getFilePath(null, str);
    }

    public static boolean checkDir(String str) {
        String path = getPath(str);
        if (checkSD()) {
            File file = new File(path);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String getDir(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean checkAndMkdirs(String str, String str2) {
        File file = new File(getDir(getFilePath(str, str2)));
        if (!file.exists()) {
            try {
                if (!file.mkdirs()) {
                    return false;
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public static File getFile(String str, String str2) {
        if (checkDir(str)) {
            try {
                return new File(getFilePath(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File createFile(String str, String str2) {
        if (checkDir(str)) {
            try {
                if (checkAndMkdirs(str, str2)) {
                    File file = getFile(str, str2);
                    if (!file.exists() || file.delete()) {
                        if (file.createNewFile()) {
                            return file;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File createFileIfNotFound(String str, String str2) {
        if (checkDir(str)) {
            try {
                File file = getFile(str, str2);
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File createFileIfNotFound(String str) {
        return createFileIfNotFound(null, str);
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
        doCopyFile(file, file2, z);
    }

    private static void doCopyFile(File file, File file2, boolean z) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Error e;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileChannel2 = fileInputStream.getChannel();
                    try {
                        FileChannel channel = fileOutputStream2.getChannel();
                        try {
                            long size = fileChannel2.size();
                            for (long j = 0; j < size; j += channel.transferFrom(fileChannel2, j, size - j > 31457280 ? 31457280L : size - j)) {
                            }
                            n.close(channel);
                            n.close((OutputStream) fileOutputStream2);
                            n.close(fileChannel2);
                            n.close((InputStream) fileInputStream);
                            if (file.length() != file2.length()) {
                                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                            }
                            if (z) {
                                file2.setLastModified(file.lastModified());
                            }
                        } catch (Error e2) {
                            e = e2;
                            fileChannel = channel;
                            fileOutputStream = fileOutputStream2;
                            try {
                                throw new IOException("Failed Error to copy contents from '" + file + "' to '" + file2 + "' with " + e.toString());
                            } catch (Throwable th2) {
                                th = th2;
                                n.close(fileChannel);
                                n.close((OutputStream) fileOutputStream);
                                n.close(fileChannel2);
                                n.close((InputStream) fileInputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileChannel = channel;
                            fileOutputStream = fileOutputStream2;
                            n.close(fileChannel);
                            n.close((OutputStream) fileOutputStream);
                            n.close(fileChannel2);
                            n.close((InputStream) fileInputStream);
                            throw th;
                        }
                    } catch (Error e3) {
                        e = e3;
                        fileChannel = null;
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        fileChannel = null;
                        fileOutputStream = fileOutputStream2;
                    }
                } catch (Error e4) {
                    e = e4;
                    fileChannel = null;
                    fileChannel2 = null;
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable th5) {
                    th = th5;
                    fileChannel = null;
                    fileChannel2 = null;
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Error e5) {
                e = e5;
                fileChannel = null;
                fileChannel2 = null;
                fileOutputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileChannel = null;
                fileChannel2 = null;
                fileOutputStream = null;
            }
        } catch (Error e6) {
            e = e6;
            fileChannel = null;
            fileChannel2 = null;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileChannel = null;
            fileChannel2 = null;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static InputStream getInStreamFromFile(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static boolean delFile(String str, String str2) {
        if (checkDir(str)) {
            File file = getFile(str, str2);
            try {
                if (file.exists()) {
                    return file.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean delFile(String str) {
        return delFile(null, str);
    }

    public static void writeAmrFileHeader(OutputStream outputStream) throws IOException {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static long getFileSize(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        long j = 0;
        FileInputStream fileInputStream3 = null;
        try {
            if (!file.exists()) {
                fileInputStream2 = null;
            } else {
                fileInputStream2 = new FileInputStream(file);
                try {
                    j = fileInputStream2.available();
                } catch (Exception e) {
                    fileInputStream3 = fileInputStream2;
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream3);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    throw th;
                }
            }
            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream2);
        } catch (Exception e2) {
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return j;
    }

    public static boolean deleteQuietly(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                cleanDirectory(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static void cleanDirectory(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e = null;
        for (File file2 : listFiles) {
            try {
                forceDelete(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (!file.delete()) {
            if (!exists) {
                throw new FileNotFoundException("File does not exist: " + file);
            }
            throw new IOException("Unable to delete file: " + file);
        }
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean isSymlink(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (isSystemWindows()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int indexOfExtension = indexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return str.substring(indexOfExtension + 1);
    }

    public static int indexOfExtension(String str) {
        int lastIndexOf;
        if (str != null && indexOfLastSeparator(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }
}
