package com.baidu.adp.lib.util;

import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public class e {
    private static String xT = "baidu";
    public static final File xU = Environment.getExternalStorageDirectory();
    private static final char xV = File.separatorChar;

    public static boolean fi() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int ix() {
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

    public static String aA(String str) {
        if (str != null) {
            return xU + "/" + xT + "/" + str + "/";
        }
        return xU + "/" + xT + "/";
    }

    public static String s(String str, String str2) {
        if (str != null) {
            return xU + "/" + xT + "/" + str + "/" + str2;
        }
        return xU + "/" + xT + "/" + str2;
    }

    public static boolean iy() {
        try {
            StatFs statFs = new StatFs(xU.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String aB(String str) {
        return s(null, str);
    }

    public static boolean aC(String str) {
        String aA = aA(str);
        if (fi()) {
            File file = new File(aA);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String aD(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean t(String str, String str2) {
        File file = new File(aD(s(str, str2)));
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

    public static File u(String str, String str2) {
        if (aC(str)) {
            try {
                return new File(s(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File x(String str, String str2) {
        if (aC(str)) {
            try {
                if (t(str, str2)) {
                    File u = u(str, str2);
                    if (!u.exists() || u.delete()) {
                        if (u.createNewFile()) {
                            return u;
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

    public static File y(String str, String str2) {
        if (aC(str)) {
            try {
                File u = u(str, str2);
                if (u.exists()) {
                    return u;
                }
                if (u.createNewFile()) {
                    return u;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File aE(String str) {
        return y(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [484=5, 485=5, 487=5, 488=5] */
    public static boolean d(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!aC(str) || !t(str, str2)) {
            return false;
        }
        File u = u(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (u.exists() && !u.delete()) {
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
                } else if (!u.createNewFile()) {
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
                    FileOutputStream fileOutputStream3 = new FileOutputStream(u);
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

    public static boolean e(String str, byte[] bArr) {
        return d(null, str, bArr);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x005a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static byte[] z(String str, String str2) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        if (aC(str)) {
            File u = u(str, str2);
            ?? exists = u.exists();
            try {
                if (exists != 0) {
                    try {
                        fileInputStream = new FileInputStream(u);
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
                                o.d(fileInputStream);
                                o.b((OutputStream) byteArrayOutputStream);
                            } catch (IOException e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                o.d(fileInputStream);
                                o.b((OutputStream) byteArrayOutputStream);
                                return bArr;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            byteArrayOutputStream = null;
                        } catch (Throwable th) {
                            exists = 0;
                            th = th;
                            o.d(fileInputStream);
                            o.b((OutputStream) exists);
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        exists = 0;
                        fileInputStream = null;
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return bArr;
    }

    public static byte[] aF(String str) {
        return z(null, str);
    }

    public static void copyFile(File file, File file2) {
        a(file, file2, true);
    }

    public static void a(File file, File file2, boolean z) {
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

    private static void b(File file, File file2, boolean z) {
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
                        } catch (Throwable th2) {
                            fileInputStream = fileInputStream2;
                            th = th2;
                            fileChannel = fileChannel2;
                            closeable = null;
                        }
                        try {
                            long size = fileChannel2.size();
                            for (long j = 0; j < size; j += channel.transferFrom(fileChannel2, j, size - j > 31457280 ? 31457280L : size - j)) {
                            }
                            o.b(channel);
                            o.b((OutputStream) fileOutputStream);
                            o.b(fileChannel2);
                            o.d(fileInputStream2);
                            if (file.length() != file2.length()) {
                                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                            }
                            if (z) {
                                file2.setLastModified(file.lastModified());
                            }
                        } catch (Throwable th3) {
                            fileInputStream = fileInputStream2;
                            th = th3;
                            fileChannel = fileChannel2;
                            closeable = channel;
                            o.b(closeable);
                            o.b((OutputStream) fileOutputStream);
                            o.b(fileChannel);
                            o.d(fileInputStream);
                            throw th;
                        }
                    } catch (Error e) {
                        fileOutputStream2 = fileOutputStream;
                        fileInputStream = fileInputStream2;
                        try {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        } catch (Throwable th4) {
                            fileOutputStream = fileOutputStream2;
                            fileChannel = fileChannel2;
                            closeable = null;
                            th = th4;
                            o.b(closeable);
                            o.b((OutputStream) fileOutputStream);
                            o.b(fileChannel);
                            o.d(fileInputStream);
                            throw th;
                        }
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

    public static boolean A(String str, String str2) {
        if (aC(str)) {
            File u = u(str, str2);
            try {
                if (u.exists()) {
                    return u.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean aG(String str) {
        return A(null, str);
    }

    public static void c(OutputStream outputStream) {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static boolean f(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                g(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static void g(File file) {
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
                h(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void h(File file) {
        if (file.isDirectory()) {
            i(file);
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

    public static void i(File file) {
        if (file.exists()) {
            if (!j(file)) {
                g(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean j(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (iz()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    static boolean iz() {
        return xV == '\\';
    }

    public static void k(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static String aH(String str) {
        if (str == null) {
            return null;
        }
        int aI = aI(str);
        if (aI == -1) {
            return "";
        }
        return str.substring(aI + 1);
    }

    public static int aI(String str) {
        int lastIndexOf;
        if (str != null && aJ(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int aJ(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }
}
