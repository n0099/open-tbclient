package com.baidu.ar.g;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
/* loaded from: classes11.dex */
public class k {
    public static String a(InputStream inputStream) {
        return a(inputStream, (String) null);
    }

    public static String a(InputStream inputStream, String str) {
        if (inputStream == null) {
            throw new IllegalArgumentException("stream may not be null.");
        }
        if (TextUtils.isEmpty(str)) {
            str = System.getProperty("file.encoding", "utf-8");
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[4096];
        for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
            stringWriter.write(cArr, 0, read);
        }
        String stringWriter2 = stringWriter.toString();
        inputStreamReader.close();
        stringWriter.close();
        return ("utf-8".equalsIgnoreCase(str) && stringWriter2.startsWith("\ufeff")) ? stringWriter2.substring(1) : stringWriter2;
    }

    public static void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = i.e(file);
            a(inputStream, fileOutputStream);
        } finally {
            closeQuietly(fileOutputStream);
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
