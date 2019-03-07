package com.baidu.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.Closeable;
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
    private static String FJ = "baidu";
    public static final File FK = Environment.getExternalStorageDirectory();
    private static final char FL = File.separatorChar;

    public static boolean hy() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int kH() {
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

    public static String bj(String str) {
        if (str != null) {
            return FK + "/" + FJ + "/" + str + "/";
        }
        return FK + "/" + FJ + "/";
    }

    public static String A(String str, String str2) {
        if (str != null) {
            return FK + "/" + FJ + "/" + str + "/" + str2;
        }
        return FK + "/" + FJ + "/" + str2;
    }

    public static boolean kI() {
        try {
            StatFs statFs = new StatFs(FK.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String bk(String str) {
        return A(null, str);
    }

    public static boolean bl(String str) {
        String bj = bj(str);
        if (hy()) {
            File file = new File(bj);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String bm(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean B(String str, String str2) {
        File file = new File(bm(A(str, str2)));
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

    public static File C(String str, String str2) {
        if (bl(str)) {
            try {
                return new File(A(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File createFile(String str, String str2) {
        if (bl(str)) {
            try {
                if (B(str, str2)) {
                    File C = C(str, str2);
                    if (!C.exists() || C.delete()) {
                        if (C.createNewFile()) {
                            return C;
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

    public static File D(String str, String str2) {
        if (bl(str)) {
            try {
                File C = C(str, str2);
                if (C.exists()) {
                    return C;
                }
                if (C.createNewFile()) {
                    return C;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File bn(String str) {
        return D(null, str);
    }

    public static void b(File file, File file2) throws IOException {
        a(file, file2, true);
    }

    public static void a(File file, File file2, boolean z) throws IOException {
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
        b(file, file2, z);
    }

    private static void b(File file, File file2, boolean z) throws IOException {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        Closeable closeable;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream2;
        FileChannel channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileChannel2 = fileInputStream2.getChannel();
                    try {
                        try {
                            channel = fileOutputStream.getChannel();
                        } catch (Error e) {
                            fileOutputStream2 = fileOutputStream;
                            fileInputStream = fileInputStream2;
                            try {
                                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                            } catch (Throwable th2) {
                                fileOutputStream = fileOutputStream2;
                                fileChannel = fileChannel2;
                                closeable = null;
                                th = th2;
                                n.b(closeable);
                                n.b((OutputStream) fileOutputStream);
                                n.b(fileChannel);
                                n.i(fileInputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        fileInputStream = fileInputStream2;
                        th = th3;
                        fileChannel = fileChannel2;
                        closeable = null;
                    }
                    try {
                        long size = fileChannel2.size();
                        for (long j = 0; j < size; j += channel.transferFrom(fileChannel2, j, size - j > 31457280 ? 31457280L : size - j)) {
                        }
                        n.b(channel);
                        n.b((OutputStream) fileOutputStream);
                        n.b(fileChannel2);
                        n.i(fileInputStream2);
                        if (file.length() != file2.length()) {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        }
                        if (z) {
                            file2.setLastModified(file.lastModified());
                        }
                    } catch (Throwable th4) {
                        fileInputStream = fileInputStream2;
                        th = th4;
                        fileChannel = fileChannel2;
                        closeable = channel;
                        n.b(closeable);
                        n.b((OutputStream) fileOutputStream);
                        n.b(fileChannel);
                        n.i(fileInputStream);
                        throw th;
                    }
                } catch (Error e2) {
                    fileChannel2 = null;
                    fileOutputStream2 = fileOutputStream;
                    fileInputStream = fileInputStream2;
                } catch (Throwable th5) {
                    fileChannel = null;
                    fileInputStream = fileInputStream2;
                    closeable = null;
                    th = th5;
                }
            } catch (Error e3) {
                fileChannel2 = null;
                fileOutputStream2 = null;
                fileInputStream = fileInputStream2;
            } catch (Throwable th6) {
                fileChannel = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                th = th6;
                closeable = null;
            }
        } catch (Error e4) {
            fileChannel2 = null;
            fileOutputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th7) {
            fileChannel = null;
            fileOutputStream = null;
            fileInputStream = null;
            th = th7;
            closeable = null;
        }
    }

    public static InputStream n(File file) {
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

    public static boolean E(String str, String str2) {
        if (bl(str)) {
            File C = C(str, str2);
            try {
                if (C.exists()) {
                    return C.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean bo(String str) {
        return E(null, str);
    }

    public static void c(OutputStream outputStream) throws IOException {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static long o(File file) {
        FileInputStream fileInputStream;
        long j = 0;
        FileInputStream fileInputStream2 = null;
        try {
            if (!file.exists()) {
                fileInputStream = null;
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    j = fileInputStream.available();
                } catch (Exception e) {
                    fileInputStream2 = fileInputStream;
                    com.baidu.adp.lib.g.a.i(fileInputStream2);
                    return j;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    com.baidu.adp.lib.g.a.i(fileInputStream2);
                    throw th;
                }
            }
            com.baidu.adp.lib.g.a.i(fileInputStream);
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return j;
    }

    public static boolean p(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                q(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static void q(File file) throws IOException {
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
                r(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void r(File file) throws IOException {
        if (file.isDirectory()) {
            s(file);
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

    public static void s(File file) throws IOException {
        if (file.exists()) {
            if (!t(file)) {
                q(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean t(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (kJ()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    static boolean kJ() {
        return FL == '\\';
    }

    public static void u(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static String bp(String str) {
        if (str == null) {
            return null;
        }
        int bq = bq(str);
        if (bq == -1) {
            return "";
        }
        return str.substring(bq + 1);
    }

    public static int bq(String str) {
        int lastIndexOf;
        if (str != null && br(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int br(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }
}
