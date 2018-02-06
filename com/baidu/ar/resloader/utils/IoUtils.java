package com.baidu.ar.resloader.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class IoUtils {

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
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, Operation operation) {
        byte[] bArr = new byte[1024];
        long j2 = 0;
        do {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
            if (operation != null) {
                operation.progress(j2, j);
            }
        } while (!operation.isCancelled());
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, final ProgressListener progressListener) {
        copyStream(inputStream, outputStream, j, new Operation() { // from class: com.baidu.ar.resloader.utils.IoUtils.1
            @Override // com.baidu.ar.resloader.utils.IoUtils.Cancelable
            public boolean isCancelled() {
                return false;
            }

            @Override // com.baidu.ar.resloader.utils.IoUtils.ProgressListener
            public void progress(long j2, long j3) {
                if (ProgressListener.this != null) {
                    ProgressListener.this.progress(j2, j3);
                }
            }
        });
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, final Cancelable cancelable) {
        copyStream(inputStream, outputStream, 0L, new Operation() { // from class: com.baidu.ar.resloader.utils.IoUtils.2
            @Override // com.baidu.ar.resloader.utils.IoUtils.Cancelable
            public boolean isCancelled() {
                if (Cancelable.this != null) {
                    return Cancelable.this.isCancelled();
                }
                return false;
            }

            @Override // com.baidu.ar.resloader.utils.IoUtils.ProgressListener
            public void progress(long j, long j2) {
            }
        });
    }

    public static String inputStream2String(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine + "/n");
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }
}
