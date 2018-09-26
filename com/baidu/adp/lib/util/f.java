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
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
/* loaded from: classes.dex */
public class f {
    private static String EY = "baidu";
    public static final File EZ = Environment.getExternalStorageDirectory();
    private static final char Fa = File.separatorChar;

    public static boolean hk() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int kt() {
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
            return EZ + "/" + EY + "/" + str + "/";
        }
        return EZ + "/" + EY + "/";
    }

    public static String z(String str, String str2) {
        if (str != null) {
            return EZ + "/" + EY + "/" + str + "/" + str2;
        }
        return EZ + "/" + EY + "/" + str2;
    }

    public static boolean ku() {
        try {
            StatFs statFs = new StatFs(EZ.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String bk(String str) {
        return z(null, str);
    }

    public static boolean bl(String str) {
        String bj = bj(str);
        if (hk()) {
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

    public static boolean A(String str, String str2) {
        File file = new File(bm(z(str, str2)));
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

    public static File B(String str, String str2) {
        if (bl(str)) {
            try {
                return new File(z(str, str2));
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
                if (A(str, str2)) {
                    File B = B(str, str2);
                    if (!B.exists() || B.delete()) {
                        if (B.createNewFile()) {
                            return B;
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

    public static File C(String str, String str2) {
        if (bl(str)) {
            try {
                File B = B(str, str2);
                if (B.exists()) {
                    return B;
                }
                if (B.createNewFile()) {
                    return B;
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
        return C(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [484=5, 485=5, 487=5, 488=5] */
    public static boolean c(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!bl(str) || !A(str, str2)) {
            return false;
        }
        File B = B(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (B.exists() && !B.delete()) {
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
                } else if (!B.createNewFile()) {
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
                    FileOutputStream fileOutputStream3 = new FileOutputStream(B);
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
        return c(null, str, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [521=4, 522=4] */
    public static byte[] D(String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        byte[] bArr = null;
        if (bl(str)) {
            File B = B(str, str2);
            if (B.exists()) {
                try {
                    fileInputStream = new FileInputStream(B);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                        try {
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
                                n.h(fileInputStream);
                                n.b((OutputStream) byteArrayOutputStream);
                            } catch (IOException e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                n.h(fileInputStream);
                                n.b((OutputStream) byteArrayOutputStream);
                                return bArr;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            n.h(fileInputStream);
                            n.b((OutputStream) byteArrayOutputStream);
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        byteArrayOutputStream = null;
                        th = th3;
                        n.h(fileInputStream);
                        n.b((OutputStream) byteArrayOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    fileInputStream = null;
                } catch (Throwable th4) {
                    byteArrayOutputStream = null;
                    fileInputStream = null;
                    th = th4;
                }
            }
        }
        return bArr;
    }

    public static byte[] bo(String str) {
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
                                n.h(fileInputStream);
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
                        n.h(fileInputStream2);
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
                        n.h(fileInputStream);
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

    public static InputStream m(File file) {
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
            File B = B(str, str2);
            try {
                if (B.exists()) {
                    return B.delete();
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static boolean bp(String str) {
        return E(null, str);
    }

    public static void c(OutputStream outputStream) throws IOException {
        outputStream.write(new byte[]{35, 33, 65, 77, 82, 10}, 0, 6);
    }

    public static long n(File file) {
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
                    com.baidu.adp.lib.g.a.h(fileInputStream2);
                    return j;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    com.baidu.adp.lib.g.a.h(fileInputStream2);
                    throw th;
                }
            }
            com.baidu.adp.lib.g.a.h(fileInputStream);
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return j;
    }

    public static boolean o(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                p(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    public static void p(File file) throws IOException {
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
                q(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void q(File file) throws IOException {
        if (file.isDirectory()) {
            r(file);
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

    public static void r(File file) throws IOException {
        if (file.exists()) {
            if (!s(file)) {
                p(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean s(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (kv()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    static boolean kv() {
        return Fa == '\\';
    }

    public static void t(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static String bq(String str) {
        if (str == null) {
            return null;
        }
        int br = br(str);
        if (br == -1) {
            return "";
        }
        return str.substring(br + 1);
    }

    public static int br(String str) {
        int lastIndexOf;
        if (str != null && bs(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int bs(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }
}
