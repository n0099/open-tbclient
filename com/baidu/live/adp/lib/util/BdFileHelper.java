package com.baidu.live.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
/* loaded from: classes10.dex */
public class BdFileHelper {
    public static final int ERR_FILE_IO_SD = 3;
    public static final int ERR_FILE_NO_SD = 1;
    public static final int ERR_FILE_OK = 0;
    public static final int ERR_FILE_SHARED_SD = 2;
    public static final char EXTENSION_SEPARATOR = '.';
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = 1048576;
    public static final int SD_MIN_AVAILAALE_SIZE = 2;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';
    private static String APP_DIR = "baidu";
    public static final File EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory();
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    public static void setTmpDir(String str) {
        APP_DIR = str;
    }

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

    public static boolean checkFile(String str, String str2) {
        if (checkSD()) {
            try {
                return getFile(str, str2).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean checkFile(String str) {
        return checkFile(null, str);
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

    public static File getFile(String str) {
        return getFile(null, str);
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

    public static File createFile(String str) {
        return createFile(null, str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [393=4, 394=4, 396=4, 397=4] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean saveGifFile(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (!checkDir(str) || bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            File createFile = createFile(str, str2);
            if (createFile == null) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                        return false;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                        return false;
                    }
                }
                return false;
            }
            fileOutputStream = new FileOutputStream(createFile, true);
            try {
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    FileOutputStream fileOutputStream3 = null;
                    if (0 != 0) {
                        try {
                            fileOutputStream3.close();
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    BdLog.e(e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Exception e4) {
                            BdLog.e(e4.getMessage());
                            return false;
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        BdLog.e(e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean saveGifFile(String str, byte[] bArr) {
        return saveGifFile(null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [437=4, 438=4, 440=4, 441=4] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isGif(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(getFile(str, str2));
                try {
                    byte[] bArr = new byte[7];
                    r0 = fileInputStream.read(bArr, 0, 6) == 6 ? BdUtilHelper.isGif(bArr) : false;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    } else {
                        fileInputStream2 = fileInputStream;
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return r0;
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                    return r0;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream = null;
        } catch (IOException e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return r0;
    }

    public static boolean isGif(String str) {
        return isGif(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [484=5, 485=5, 487=5, 488=5] */
    public static boolean saveFile(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!checkDir(str) || !checkAndMkdirs(str, str2)) {
            return false;
        }
        File file = getFile(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file.exists() && !file.delete()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                            return false;
                        } catch (Exception e) {
                            BdLog.e(e.getMessage());
                            return false;
                        }
                    }
                    return false;
                } else if (!file.createNewFile()) {
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                            return false;
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                            return false;
                        }
                    }
                    return false;
                } else {
                    FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                    try {
                        fileOutputStream3.write(bArr, 0, bArr.length);
                        fileOutputStream3.flush();
                        fileOutputStream3.close();
                        FileOutputStream fileOutputStream4 = null;
                        if (0 != 0) {
                            try {
                                fileOutputStream4.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                        }
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream3;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (Exception e5) {
                                BdLog.e(e5.getMessage());
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                                BdLog.e(e6.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean saveFile(String str, byte[] bArr) {
        return saveFile(null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [521=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static byte[] getFileData(String str, String str2) {
        Throwable th;
        FileInputStream fileInputStream;
        ?? r2;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        if (checkDir(str)) {
            File file = getFile(str, str2);
            boolean exists = file.exists();
            try {
                if (exists) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream(1024);
                            try {
                                byte[] bArr2 = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr2, 0, 1024);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                                bArr = byteArrayOutputStream.toByteArray();
                                CloseUtil.close((InputStream) fileInputStream);
                                CloseUtil.close((OutputStream) byteArrayOutputStream);
                            } catch (IOException e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                CloseUtil.close((InputStream) fileInputStream);
                                CloseUtil.close((OutputStream) byteArrayOutputStream);
                                return bArr;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            byteArrayOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            r2 = 0;
                            CloseUtil.close((InputStream) fileInputStream);
                            CloseUtil.close((OutputStream) r2);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        fileInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        r2 = 0;
                        fileInputStream = null;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                r2 = exists;
            }
        }
        return bArr;
    }

    public static byte[] getFileData(String str) {
        return getFileData(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [555=4, 556=4, 558=4, 559=4, 562=4, 563=4, 565=4, 566=4] */
    public static boolean copyFile(String str, String str2, String str3, String str4) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        InputStream inputStream2 = null;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = getFile(str, str2);
                File file2 = getFile(str3, str4);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream.close();
                            inputStream = null;
                        } catch (Exception e) {
                            e = e;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                    try {
                        fileOutputStream.close();
                        OutputStream outputStream = null;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.toString());
                            }
                        }
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Exception e4) {
                                BdLog.e(e4.toString());
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        fileInputStream = null;
                        BdLog.e(e.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e6) {
                                BdLog.e(e6.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e7) {
                                BdLog.e(e7.toString());
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e8) {
                                BdLog.e(e8.toString());
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e9) {
                                BdLog.e(e9.toString());
                            }
                        }
                        throw th;
                    }
                } else {
                    if (0 != 0) {
                        try {
                            inputStream2.close();
                        } catch (Exception e10) {
                            BdLog.e(e10.toString());
                        }
                    }
                    if (0 != 0) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e11) {
                            BdLog.e(e11.toString());
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
        }
        return false;
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
        FileChannel fileChannel3;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileChannel2 = fileInputStream2.getChannel();
                    try {
                        fileChannel3 = fileOutputStream2.getChannel();
                    } catch (Error e) {
                        fileChannel3 = null;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = null;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                    }
                    try {
                        long size = fileChannel2.size();
                        for (long j = 0; j < size; j += fileChannel3.transferFrom(fileChannel2, j, size - j > FILE_COPY_BUFFER_SIZE ? 31457280L : size - j)) {
                        }
                        CloseUtil.close(fileChannel3);
                        CloseUtil.close((OutputStream) fileOutputStream2);
                        CloseUtil.close(fileChannel2);
                        CloseUtil.close((InputStream) fileInputStream2);
                        if (file.length() != file2.length()) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        }
                        if (z) {
                            file2.setLastModified(file.lastModified());
                        }
                    } catch (Error e2) {
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        try {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        } catch (Throwable th3) {
                            th = th3;
                            fileChannel = fileChannel3;
                            CloseUtil.close(fileChannel);
                            CloseUtil.close((OutputStream) fileOutputStream);
                            CloseUtil.close(fileChannel2);
                            CloseUtil.close((InputStream) fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileChannel = fileChannel3;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        CloseUtil.close(fileChannel);
                        CloseUtil.close((OutputStream) fileOutputStream);
                        CloseUtil.close(fileChannel2);
                        CloseUtil.close((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Error e3) {
                    fileChannel3 = null;
                    fileChannel2 = null;
                    fileOutputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                } catch (Throwable th5) {
                    th = th5;
                    fileChannel = null;
                    fileChannel2 = null;
                    fileOutputStream = fileOutputStream2;
                    fileInputStream = fileInputStream2;
                }
            } catch (Error e4) {
                fileChannel3 = null;
                fileChannel2 = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            } catch (Throwable th6) {
                th = th6;
                fileChannel = null;
                fileChannel2 = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
            }
        } catch (Error e5) {
            fileChannel3 = null;
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

    public static boolean copyFile(String str, String str2) {
        return copyFile(null, str, null, str2);
    }

    public static boolean renameFile(String str, String str2, String str3, String str4) {
        try {
            if (!checkAndMkdirs(str3, str4)) {
                return false;
            }
            File file = getFile(str, str2);
            File file2 = getFile(str3, str4);
            if (!file.exists() || file2.exists()) {
                return false;
            }
            return file.renameTo(file2);
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    public static boolean renameFile(String str, String str2) {
        return renameFile(null, str, null, str2);
    }

    public static InputStream getInStreamFromFile(String str, String str2) {
        return getInStreamFromFile(getFile(str, str2));
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

    public static OutputStream getOutStreamFromFile(String str, String str2) {
        return getOutStreamFromFile(getFile(str, str2));
    }

    public static OutputStream getOutStreamFromFile(File file) {
        if (file != null) {
            try {
                return new FileOutputStream(file);
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

    public static boolean deleteDir(String str, String str2) {
        return deleteDir(getFile(str, str2));
    }

    private static boolean deleteDir(File file) {
        String[] list;
        if (file == null) {
            return false;
        }
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void writeAmrFileHeader(OutputStream outputStream) throws IOException {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static void writeWaveFileHeader(DataOutputStream dataOutputStream, long j, long j2, long j3, int i, long j4) throws IOException {
        dataOutputStream.write(new byte[]{82, 73, 70, 70, (byte) (255 & j2), (byte) ((j2 >> 8) & 255), (byte) ((j2 >> 16) & 255), (byte) ((j2 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) i, 0, (byte) (255 & j3), (byte) ((j3 >> 8) & 255), (byte) ((j3 >> 16) & 255), (byte) ((j3 >> 24) & 255), (byte) (255 & j4), (byte) ((j4 >> 8) & 255), (byte) ((j4 >> 16) & 255), (byte) ((j4 >> 24) & 255), 4, 0, 16, 0, 100, 97, 116, 97, (byte) (255 & j), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)}, 0, 44);
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
            BdLog.e(e.getMessage());
        }
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
                    BdCloseHelper.close((InputStream) fileInputStream3);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    BdCloseHelper.close((InputStream) fileInputStream);
                    throw th;
                }
            }
            BdCloseHelper.close((InputStream) fileInputStream2);
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
