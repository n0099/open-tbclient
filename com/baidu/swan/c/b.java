package com.baidu.swan.c;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
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
public final class b {
    private static final boolean DEBUG = a.DEBUG;
    private static String bqj = null;
    public static int INVALID_INDEX = -1;
    public static int aSU = 1;

    public static boolean jX(String str) {
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
        if (DEBUG) {
            Log.d("FileUtils", "delete file:" + file);
        }
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
            } else if (DEBUG) {
                Log.d("FileUtils", "a special file:" + file);
            }
        } else if (DEBUG) {
            Log.d("FileUtils", "not found the file to delete:" + file);
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
    /* JADX WARN: Removed duplicated region for block: B:44:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        OutputStream outputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    f(inputStream, fileOutputStream);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            if (DEBUG) {
                                Log.d("FileUtils", "catch IOException");
                            }
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.d("FileUtils", "catch FileNotFoundException");
                    }
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            if (DEBUG) {
                                Log.d("FileUtils", "catch IOException");
                            }
                            e3.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        if (DEBUG) {
                            Log.d("FileUtils", "catch IOException");
                        }
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
            if (0 != 0) {
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [408=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    public static long e(File file, File file2) {
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
                    j = f(fileInputStream, fileOutputStream);
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

    public static String B(File file) {
        try {
            return a(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public static boolean b(Context context, String str, String str2, int i) {
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

    public static String ap(Context context, String str) {
        try {
            return a(context.openFileInput(str));
        } catch (FileNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
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

    public static boolean C(File file) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [966=4] */
    public static boolean bl(String str, String str2) {
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null) {
            return false;
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    bufferedInputStream2 = null;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!TextUtils.isEmpty(nextElement.getName()) && !ka(nextElement.getName())) {
                                File file = new File(str2 + "/" + nextElement.getName());
                                if (!nextElement.isDirectory()) {
                                    if (!file.exists()) {
                                        C(file);
                                    }
                                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 2048);
                                    } catch (IOException e) {
                                        e = e;
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
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        c(bufferedInputStream3);
                                        c(bufferedOutputStream);
                                        bufferedInputStream3.close();
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream2 = bufferedInputStream3;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream2 = bufferedInputStream3;
                                        e.printStackTrace();
                                        c(bufferedOutputStream2);
                                        c(bufferedInputStream2);
                                        c(zipFile);
                                        long currentTimeMillis2 = System.currentTimeMillis();
                                        if (DEBUG) {
                                            Log.i("FileUtils", "unZip:" + str + "cost:" + (currentTimeMillis2 - currentTimeMillis) + "ms");
                                        }
                                        return false;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream = bufferedInputStream3;
                                        c(bufferedOutputStream2);
                                        c(bufferedInputStream);
                                        c(zipFile);
                                        long currentTimeMillis3 = System.currentTimeMillis();
                                        if (DEBUG) {
                                            Log.i("FileUtils", "unZip:" + str + "cost:" + (currentTimeMillis3 - currentTimeMillis) + "ms");
                                        }
                                        throw th;
                                    }
                                } else if (!file.exists()) {
                                    file.mkdirs();
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                        }
                    }
                    c(bufferedOutputStream2);
                    c(bufferedInputStream2);
                    c(zipFile);
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (DEBUG) {
                        Log.i("FileUtils", "unZip:" + str + "cost:" + (currentTimeMillis4 - currentTimeMillis) + "ms");
                    }
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedInputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
            bufferedInputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
            bufferedInputStream = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1036=4] */
    public static boolean bm(String str, String str2) {
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
                e = e;
                inputStream2 = inputStream;
            } catch (Throwable th) {
                th = th;
                zipInputStream = null;
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
                    } else if (!TextUtils.isEmpty(nextEntry.getName()) && !ka(nextEntry.getName())) {
                        File file2 = new File(str2 + File.separator + nextEntry.getName());
                        if (nextEntry.isDirectory()) {
                            if (!file2.exists()) {
                                file2.mkdir();
                            }
                        } else if (file2.exists()) {
                            continue;
                        } else {
                            C(file2);
                            try {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        c(bufferedOutputStream);
                                        throw th;
                                    }
                                }
                                c(bufferedOutputStream);
                                bufferedOutputStream2 = bufferedOutputStream;
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedOutputStream = bufferedOutputStream2;
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                e = e2;
                zipInputStream2 = zipInputStream;
                inputStream2 = inputStream;
                try {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    c(inputStream2);
                    c(zipInputStream2);
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    zipInputStream = zipInputStream2;
                    inputStream = inputStream2;
                    c(inputStream);
                    c(zipInputStream);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                c(inputStream);
                c(zipInputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream2 = null;
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            inputStream = null;
        }
    }

    public static String bn(String str, String str2) {
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

    public static String jY(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        if (lastIndexOf != INVALID_INDEX && length > lastIndexOf) {
            return str.substring(lastIndexOf + aSU, length);
        }
        return str;
    }

    public static String jZ(String str) {
        int lastIndexOf;
        String jY = jY(str);
        if (TextUtils.isEmpty(jY) || (lastIndexOf = jY.lastIndexOf(".")) == INVALID_INDEX || lastIndexOf == jY.length() - 1) {
            return "";
        }
        return jY.substring(lastIndexOf + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1178=4] */
    @Nullable
    public static String aq(Context context, String str) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str2 = null;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        inputStream = context.getAssets().open(str);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader2 = null;
                        inputStream = null;
                    } catch (Throwable th) {
                        bufferedReader = null;
                        inputStream = null;
                        th = th;
                    }
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            str2 = sb.toString();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    if (DEBUG) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e3) {
                                    if (DEBUG) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e5) {
                                    if (DEBUG) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e6) {
                                    if (DEBUG) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                            return str2;
                        }
                    } catch (IOException e7) {
                        e = e7;
                        bufferedReader2 = null;
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e8) {
                                if (DEBUG) {
                                    e8.printStackTrace();
                                }
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                if (DEBUG) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
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

    public static boolean ka(String str) {
        return str.contains("../");
    }
}
