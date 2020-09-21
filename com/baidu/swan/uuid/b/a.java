package com.baidu.swan.uuid.b;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes24.dex */
public class a {
    public static boolean saveFile(String str, File file) {
        File parentFile;
        if (TextUtils.isEmpty(str) || (parentFile = file.getParentFile()) == null || !parentFile.isDirectory()) {
            return false;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        saveFileCommon(str.getBytes(), file);
        return true;
    }

    public static void saveFileCommon(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        saveToFile(byteArrayInputStream, file);
        closeSafely(byteArrayInputStream);
    }

    public static void saveToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                try {
                    copyStream(inputStream, fileOutputStream);
                    closeSafely(fileOutputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                closeSafely(fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            closeSafely(fileOutputStream);
            throw th;
        }
    }

    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
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

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String q(File file) {
        FileReader fileReader;
        Throwable th;
        String str = null;
        if (file != null && file.exists()) {
            try {
                fileReader = new FileReader(file);
            } catch (Exception e) {
                fileReader = null;
            } catch (Throwable th2) {
                fileReader = null;
                th = th2;
            }
            try {
                char[] cArr = new char[256];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    charArrayWriter.write(cArr, 0, read);
                }
                str = charArrayWriter.toString();
                closeSafely(fileReader);
            } catch (Exception e2) {
                closeSafely(fileReader);
                return str;
            } catch (Throwable th3) {
                th = th3;
                closeSafely(fileReader);
                throw th;
            }
        }
        return str;
    }
}
