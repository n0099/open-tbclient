package com.baidu.baiduarsdk.util;

import android.text.TextUtils;
import com.baidu.ar.util.IoUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
/* loaded from: classes3.dex */
public class b {
    public static String a(InputStream inputStream) {
        return a(inputStream, null);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x005b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static String a(InputStream inputStream, String str) {
        ?? r1;
        NullPointerException nullPointerException;
        String str2;
        InputStreamReader inputStreamReader = null;
        if (inputStream == null) {
            throw new IllegalArgumentException("stream may not be null.");
        }
        if (TextUtils.isEmpty(str)) {
            r1 = IoUtils.UTF_8;
            str = System.getProperty("file.encoding", IoUtils.UTF_8);
        }
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(inputStream, str);
                try {
                    try {
                        StringWriter stringWriter = new StringWriter();
                        char[] cArr = new char[4096];
                        for (int read = inputStreamReader2.read(cArr); read > 0; read = inputStreamReader2.read(cArr)) {
                            stringWriter.write(cArr, 0, read);
                        }
                        str2 = stringWriter.toString();
                    } catch (NullPointerException e) {
                        str2 = null;
                        inputStreamReader = inputStreamReader2;
                        nullPointerException = e;
                    }
                    try {
                        if (IoUtils.UTF_8.equalsIgnoreCase(str) && str2.startsWith("\ufeff")) {
                            str2 = str2.substring(1);
                        }
                        a(inputStreamReader2);
                    } catch (NullPointerException e2) {
                        inputStreamReader = inputStreamReader2;
                        nullPointerException = e2;
                        try {
                            nullPointerException.printStackTrace();
                            a(inputStreamReader);
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            r1 = inputStreamReader;
                            a((Closeable) r1);
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    throw e3;
                }
            } catch (Throwable th2) {
                th = th2;
                a((Closeable) r1);
                throw th;
            }
        } catch (IOException e4) {
            throw e4;
        } catch (NullPointerException e5) {
            nullPointerException = e5;
            str2 = null;
        } catch (Throwable th3) {
            th = th3;
            r1 = 0;
            a((Closeable) r1);
            throw th;
        }
        return str2;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
