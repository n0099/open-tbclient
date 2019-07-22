package com.baidu.swan.c;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
/* loaded from: classes2.dex */
public final class a {
    private static String bxu = null;
    public static int INVALID_INDEX = -1;
    public static int aWx = 1;

    public static boolean lf(String str) {
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

    public static boolean b(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        b(str.getBytes(), file);
        return true;
    }

    public static void b(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        c(byteArrayInputStream, file);
        c(byteArrayInputStream);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [323=4] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    f(inputStream, fileOutputStream);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [408=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static long f(File file, File file2) {
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
                    j = f(fileInputStream, (OutputStream) fileOutputStream);
                    c(fileInputStream);
                    c(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream3 = fileInputStream;
                    fileInputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        c(fileInputStream3);
                        c(fileInputStream2);
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        c(fileInputStream);
                        c(fileInputStream3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream3 = fileOutputStream;
                    c(fileInputStream);
                    c(fileInputStream3);
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

    public static long f(InputStream inputStream, OutputStream outputStream) {
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

    public static String v(File file) {
        try {
            return a(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    public static boolean c(Context context, String str, String str2, int i) {
        return a(context, str, str2.getBytes(), i);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [675=4, 677=4, 678=4, 679=4] */
    public static boolean a(Context context, String str, byte[] bArr, int i) {
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

    public static String ac(Context context, String str) {
        try {
            return a(context.openFileInput(str));
        } catch (FileNotFoundException e) {
            return "";
        }
    }

    private static String a(FileInputStream fileInputStream) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        try {
                            fileInputStream.close();
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
                    fileInputStream.close();
                    return "";
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return "";
                }
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    public static boolean safeDeleteFile(String str) {
        return !TextUtils.isEmpty(str) && safeDeleteFile(new File(str));
    }

    public static boolean safeDeleteFile(File file) {
        boolean deleteFile;
        if (file != null) {
            try {
                if (file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath);
                    File file3 = new File(absolutePath + System.currentTimeMillis() + ".tmp");
                    if (file2.renameTo(file3)) {
                        deleteFile = deleteFile(file3);
                    } else {
                        deleteFile = deleteFile(file);
                    }
                    return deleteFile;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        deleteFile = true;
        return deleteFile;
    }

    public static boolean w(File file) {
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

    public static boolean bs(String str, String str2) {
        return bt(str, str2) == null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [995=4] */
    public static Exception bt(String str, String str2) {
        ZipFile zipFile;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream3;
        ZipFile zipFile2 = null;
        System.currentTimeMillis();
        if (str == null) {
            return new Exception("srcFileName is null");
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                bufferedOutputStream = null;
                bufferedInputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        if (!TextUtils.isEmpty(nextElement.getName()) && !li(nextElement.getName())) {
                            File file = new File(str2 + "/" + nextElement.getName());
                            if (!nextElement.isDirectory()) {
                                if (!file.exists()) {
                                    w(file);
                                }
                                BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                try {
                                    bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file), 2048);
                                } catch (IOException e) {
                                    e = e;
                                    zipFile2 = zipFile;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    bufferedInputStream2 = bufferedInputStream3;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedInputStream = bufferedInputStream3;
                                }
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = bufferedInputStream3.read(bArr, 0, 2048);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream3.write(bArr, 0, read);
                                    }
                                    c(bufferedInputStream3);
                                    c(bufferedOutputStream3);
                                    bufferedOutputStream = bufferedOutputStream3;
                                    bufferedInputStream = bufferedInputStream3;
                                } catch (IOException e2) {
                                    e = e2;
                                    zipFile2 = zipFile;
                                    bufferedInputStream2 = bufferedInputStream3;
                                    bufferedOutputStream2 = bufferedOutputStream3;
                                    try {
                                        e.printStackTrace();
                                        c(bufferedOutputStream2);
                                        c(bufferedInputStream2);
                                        c(zipFile2);
                                        System.currentTimeMillis();
                                        return e;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedInputStream = bufferedInputStream2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        zipFile = zipFile2;
                                        c(bufferedOutputStream);
                                        c(bufferedInputStream);
                                        c(zipFile);
                                        System.currentTimeMillis();
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    bufferedInputStream = bufferedInputStream3;
                                    c(bufferedOutputStream);
                                    c(bufferedInputStream);
                                    c(zipFile);
                                    System.currentTimeMillis();
                                    throw th;
                                }
                            } else if (!file.exists()) {
                                file.mkdirs();
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zipFile2 = zipFile;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedInputStream2 = bufferedInputStream;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                c(bufferedOutputStream);
                c(bufferedInputStream);
                c(zipFile);
                System.currentTimeMillis();
                return null;
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream2 = null;
                zipFile2 = zipFile;
                bufferedOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1065=4] */
    public static boolean bu(String str, String str2) {
        ZipInputStream zipInputStream;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        ZipInputStream zipInputStream2 = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            inputStream = AppRuntime.getAppContext().getAssets().open(str);
            try {
                zipInputStream = new ZipInputStream(inputStream);
            } catch (IOException e) {
                inputStream2 = inputStream;
            } catch (Throwable th) {
                th = th;
                zipInputStream = null;
            }
        } catch (IOException e2) {
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
            inputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            BufferedOutputStream bufferedOutputStream2 = null;
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    c(inputStream);
                    c(zipInputStream);
                    return true;
                } else if (!TextUtils.isEmpty(nextEntry.getName()) && !li(nextEntry.getName())) {
                    File file2 = new File(str2 + File.separator + nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                    } else if (file2.exists()) {
                        continue;
                    } else {
                        w(file2);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                            while (true) {
                                try {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(bArr, 0, read);
                                } catch (Throwable th3) {
                                    th = th3;
                                    c(bufferedOutputStream);
                                    throw th;
                                }
                            }
                            c(bufferedOutputStream);
                            bufferedOutputStream2 = bufferedOutputStream;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream = bufferedOutputStream2;
                        }
                    }
                }
            }
        } catch (IOException e3) {
            zipInputStream2 = zipInputStream;
            inputStream2 = inputStream;
            c(inputStream2);
            c(zipInputStream2);
            return false;
        } catch (Throwable th5) {
            th = th5;
            c(inputStream);
            c(zipInputStream);
            throw th;
        }
    }

    public static String bv(String str, String str2) {
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

    public static String lg(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        if (lastIndexOf != INVALID_INDEX && length > lastIndexOf) {
            return str.substring(lastIndexOf + aWx, length);
        }
        return str;
    }

    public static String lh(String str) {
        int lastIndexOf;
        String lg = lg(str);
        if (TextUtils.isEmpty(lg) || (lastIndexOf = lg.lastIndexOf(".")) == INVALID_INDEX || lastIndexOf == lg.length() - 1) {
            return "";
        }
        return lg.substring(lastIndexOf + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1207=4] */
    @Nullable
    public static String ad(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        BufferedReader bufferedReader;
        String str2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                inputStream = context.getAssets().open(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                } catch (IOException e) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                }
            } catch (IOException e2) {
                bufferedReader = null;
                inputStream = null;
            } catch (Throwable th3) {
                inputStream = null;
                th = th3;
                bufferedReader = null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                str2 = sb.toString();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (IOException e5) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return str2;
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                    }
                }
                throw th;
            }
        }
        return str2;
    }

    public static void c(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean li(String str) {
        return str.contains("../");
    }
}
