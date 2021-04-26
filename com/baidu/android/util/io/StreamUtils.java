package com.baidu.android.util.io;

import android.text.TextUtils;
import android.util.Xml;
import com.google.zxing.client.result.ResultParser;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
public class StreamUtils {
    public static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static final String TAG = "StreamUtils";

    public static boolean bytesToFile(byte[] bArr, File file) {
        if (bArr != null && file != null) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    Closeables.closeSafely(fileOutputStream2);
                    return true;
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    Closeables.closeSafely(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    Closeables.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return false;
    }

    public static String getStringFromInput(InputStream inputStream) {
        String readInputStream = FileUtils.readInputStream(inputStream);
        return readInputStream.startsWith(ResultParser.BYTE_ORDER_MARK) ? readInputStream.substring(1) : readInputStream;
    }

    public static byte[] streamToBytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(byteArrayOutputStream);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0043 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0045 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0021 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    @Deprecated
    public static boolean streamToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        int read;
        boolean z = false;
        if (inputStream == null) {
            return false;
        }
        if (file == null) {
            Closeables.closeSafely(inputStream);
            return false;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            z = true;
            Closeables.closeSafely(fileOutputStream);
            fileOutputStream2 = read;
        } catch (Exception e3) {
            e = e3;
            fileOutputStream3 = fileOutputStream;
            e.printStackTrace();
            Closeables.closeSafely(fileOutputStream3);
            fileOutputStream2 = fileOutputStream3;
            Closeables.closeSafely(inputStream);
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            Closeables.closeSafely(fileOutputStream2);
            Closeables.closeSafely(inputStream);
            throw th;
        }
        Closeables.closeSafely(inputStream);
        return z;
    }

    public static String streamToString(InputStream inputStream) {
        return streamToString(inputStream, Xml.Encoding.UTF_8.toString());
    }

    public static boolean streamToZipFile(InputStream inputStream, ZipOutputStream zipOutputStream, String str) {
        if (inputStream == null || zipOutputStream == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream.putNextEntry(new ZipEntry(str));
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x002e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0009 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    public static String streamToString(InputStream inputStream, String str) {
        BufferedReader bufferedReader = null;
        if (inputStream == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader((InputStream) inputStream, str), 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) inputStream);
                        Closeables.closeSafely(bufferedReader);
                        inputStream = sb.toString();
                        return inputStream;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) inputStream);
                        Closeables.closeSafely(bufferedReader);
                        inputStream = sb.toString();
                        return inputStream;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely((Closeable) inputStream);
                        Closeables.closeSafely(bufferedReader);
                        throw th;
                    }
                }
                Closeables.closeSafely((Closeable) inputStream);
                Closeables.closeSafely(bufferedReader2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        } catch (OutOfMemoryError e5) {
            e = e5;
        }
        inputStream = sb.toString();
        return inputStream;
    }
}
