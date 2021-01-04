package com.baidu.minivideo.arface.utils;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
/* loaded from: classes6.dex */
public class h {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String j(InputStream inputStream) throws IOException {
        return g(inputStream, null);
    }

    public static String g(InputStream inputStream, String str) throws IOException {
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
        if ("utf-8".equalsIgnoreCase(str) && stringWriter2.startsWith("\ufeff")) {
            return stringWriter2.substring(1);
        }
        return stringWriter2;
    }
}
