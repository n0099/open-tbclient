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
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class e {
    private static String yp = "baidu";
    public static final File yq = Environment.getExternalStorageDirectory();
    private static final char yr = File.separatorChar;

    public static boolean dG() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int gS() {
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

    public static String aq(String str) {
        if (str != null) {
            return yq + "/" + yp + "/" + str + "/";
        }
        return yq + "/" + yp + "/";
    }

    public static String r(String str, String str2) {
        if (str != null) {
            return yq + "/" + yp + "/" + str + "/" + str2;
        }
        return yq + "/" + yp + "/" + str2;
    }

    public static boolean gT() {
        try {
            StatFs statFs = new StatFs(yq.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / IjkMediaMeta.AV_CH_SIDE_RIGHT) / IjkMediaMeta.AV_CH_SIDE_RIGHT > 2;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getFilePath(String str) {
        return r(null, str);
    }

    public static boolean ar(String str) {
        String aq = aq(str);
        if (dG()) {
            File file = new File(aq);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    private static String as(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean s(String str, String str2) {
        File file = new File(as(r(str, str2)));
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

    public static File t(String str, String str2) {
        if (ar(str)) {
            try {
                return new File(r(str, str2));
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File createFile(String str, String str2) {
        if (ar(str)) {
            try {
                if (s(str, str2)) {
                    File t = t(str, str2);
                    if (!t.exists() || t.delete()) {
                        if (t.createNewFile()) {
                            return t;
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

    public static File u(String str, String str2) {
        if (ar(str)) {
            try {
                File t = t(str, str2);
                if (t.exists()) {
                    return t;
                }
                if (t.createNewFile()) {
                    return t;
                }
                return null;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File at(String str) {
        return u(null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [484=5, 485=5, 487=5, 488=5] */
    public static boolean c(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        if (!ar(str) || !s(str, str2)) {
            return false;
        }
        File t = t(str, str2);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (t.exists() && !t.delete()) {
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
                } else if (!t.createNewFile()) {
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
                    FileOutputStream fileOutputStream3 = new FileOutputStream(t);
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
        return c((String) null, str, bArr);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x005a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static byte[] x(String str, String str2) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr = null;
        if (ar(str)) {
            File t = t(str, str2);
            ?? exists = t.exists();
            try {
                if (exists != 0) {
                    try {
                        fileInputStream = new FileInputStream(t);
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
                                o.j(fileInputStream);
                                o.d(byteArrayOutputStream);
                            } catch (IOException e) {
                                e = e;
                                BdLog.e(e.getMessage());
                                o.j(fileInputStream);
                                o.d(byteArrayOutputStream);
                                return bArr;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            byteArrayOutputStream = null;
                        } catch (Throwable th) {
                            exists = 0;
                            th = th;
                            o.j(fileInputStream);
                            o.d(exists);
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

    public static byte[] au(String str) {
        return x(null, str);
    }

    public static void b(File file, File file2) throws IOException {
        b(file, file2, true);
    }

    public static void b(File file, File file2, boolean z) throws IOException {
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
        c(file, file2, z);
    }

    private static void c(File file, File file2, boolean z) throws IOException {
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
                            o.d(fileOutputStream);
                            o.b(fileChannel2);
                            o.j(fileInputStream2);
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
                            o.d(fileOutputStream);
                            o.b(fileChannel);
                            o.j(fileInputStream);
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
                            o.d(fileOutputStream);
                            o.b(fileChannel);
                            o.j(fileInputStream);
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

    public static boolean y(String str, String str2) {
        if (ar(str)) {
            File t = t(str, str2);
            try {
                if (t.exists()) {
                    return t.delete();
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
        return y(null, str);
    }

    public static void e(OutputStream outputStream) throws IOException {
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

    public static void g(File file) throws IOException {
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

    public static void h(File file) throws IOException {
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

    public static void i(File file) throws IOException {
        if (file.exists()) {
            if (!j(file)) {
                g(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean j(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (gU()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    static boolean gU() {
        return yr == '\\';
    }

    public static void k(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static String av(String str) {
        if (str == null) {
            return null;
        }
        int aw = aw(str);
        if (aw == -1) {
            return "";
        }
        return str.substring(aw + 1);
    }

    public static int aw(String str) {
        int lastIndexOf;
        if (str != null && ax(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int ax(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }
}
