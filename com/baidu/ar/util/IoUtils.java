package com.baidu.ar.util;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class IoUtils {
    public static final String UTF_8 = "utf-8";

    /* loaded from: classes3.dex */
    public interface Cancelable {
        boolean isCancelled();
    }

    /* loaded from: classes3.dex */
    public interface Operation extends Cancelable, ProgressListener {
    }

    /* loaded from: classes3.dex */
    public interface ProgressListener {
        void progress(long j, long j2);
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

    public static void copyStream(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = FileUtils.openFileOutputStream(file);
            copyStream(inputStream, fileOutputStream);
        } finally {
            closeQuietly(fileOutputStream);
        }
    }

    public static void copyStream(InputStream inputStream, File file, long j, ProgressListener progressListener) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = FileUtils.openFileOutputStream(file);
            copyStream(inputStream, fileOutputStream, j, progressListener);
        } finally {
            closeQuietly(fileOutputStream);
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, Operation operation) {
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
            if (operation != null) {
                operation.progress(j2, j);
                if (operation.isCancelled()) {
                    return;
                }
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, final ProgressListener progressListener) {
        copyStream(inputStream, outputStream, j, new Operation() { // from class: com.baidu.ar.util.IoUtils.1
            @Override // com.baidu.ar.util.IoUtils.Cancelable
            public boolean isCancelled() {
                return false;
            }

            @Override // com.baidu.ar.util.IoUtils.ProgressListener
            public void progress(long j2, long j3) {
                if (ProgressListener.this != null) {
                    ProgressListener.this.progress(j2, j3);
                }
            }
        });
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, final Cancelable cancelable) {
        copyStream(inputStream, outputStream, 0L, new Operation() { // from class: com.baidu.ar.util.IoUtils.2
            @Override // com.baidu.ar.util.IoUtils.Cancelable
            public boolean isCancelled() {
                if (Cancelable.this != null) {
                    return Cancelable.this.isCancelled();
                }
                return false;
            }

            @Override // com.baidu.ar.util.IoUtils.ProgressListener
            public void progress(long j, long j2) {
            }
        });
    }

    public static String loadContent(InputStream inputStream) {
        return loadContent(inputStream, null);
    }

    public static String loadContent(InputStream inputStream, String str) {
        if (inputStream == null) {
            throw new IllegalArgumentException("stream may not be null.");
        }
        if (TextUtils.isEmpty(str)) {
            str = System.getProperty("file.encoding", UTF_8);
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
        return (UTF_8.equalsIgnoreCase(str) && stringWriter2.startsWith("\ufeff")) ? stringWriter2.substring(1) : stringWriter2;
    }

    public static List<String> loadLineContent(InputStream inputStream) {
        return loadLineContent(inputStream, null);
    }

    public static List<String> loadLineContent(InputStream inputStream, String str) {
        ArrayList arrayList = new ArrayList();
        if (inputStream == null) {
            throw new IllegalArgumentException("stream may not be null.");
        }
        if (TextUtils.isEmpty(str)) {
            str = System.getProperty("file.encoding", UTF_8);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                inputStreamReader.close();
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }
}
