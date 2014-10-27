package com.baidu.adp.lib.util.commonsio;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class a {
    public static final BigInteger nE = BigInteger.valueOf(1024);
    public static final BigInteger nF = nE.multiply(nE);
    public static final BigInteger nG = nE.multiply(nF);
    public static final BigInteger nH = nE.multiply(nG);
    public static final BigInteger nI = nE.multiply(nH);
    public static final BigInteger nJ = nE.multiply(nI);
    public static final BigInteger nK = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger nL = nE.multiply(nK);
    public static final File[] nM = new File[0];
    private static final Charset nN = Charset.forName("UTF-8");

    public static void a(File file, File file2) {
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
                            c.b(channel);
                            c.c(fileOutputStream);
                            c.b(fileChannel2);
                            c.c(fileInputStream2);
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
                            c.b(closeable);
                            c.c(fileOutputStream);
                            c.b(fileChannel);
                            c.c(fileInputStream);
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
                            c.b(closeable);
                            c.c(fileOutputStream);
                            c.b(fileChannel);
                            c.c(fileInputStream);
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

    public static void e(File file) {
        if (file.exists()) {
            if (!j(file)) {
                g(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
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
            e(file);
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
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static boolean j(File file) {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (b.fB()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }
}
