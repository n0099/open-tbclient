package com.baidu.ar.h;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.google.zxing.client.result.ResultParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
/* loaded from: classes.dex */
public class k {
    public static String a(InputStream inputStream) {
        return a(inputStream, (String) null);
    }

    public static String a(InputStream inputStream, String str) {
        if (inputStream != null) {
            if (TextUtils.isEmpty(str)) {
                str = System.getProperty("file.encoding", IMAudioTransRequest.CHARSET);
            }
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[4096];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            inputStreamReader.close();
            stringWriter.close();
            return (IMAudioTransRequest.CHARSET.equalsIgnoreCase(str) && stringWriter2.startsWith(ResultParser.BYTE_ORDER_MARK)) ? stringWriter2.substring(1) : stringWriter2;
        }
        throw new IllegalArgumentException("stream may not be null.");
    }

    public static void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = i.e(file);
            try {
                a(inputStream, fileOutputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
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
