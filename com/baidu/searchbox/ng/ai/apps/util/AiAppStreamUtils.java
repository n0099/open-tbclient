package com.baidu.searchbox.ng.ai.apps.util;

import android.text.TextUtils;
import android.util.Xml;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes2.dex */
public class AiAppStreamUtils {
    private static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;

    public static boolean bytesToFile(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        if (bArr == null || file == null) {
            return false;
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e) {
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            AiAppsFileUtils.closeSafely(fileOutputStream);
            return true;
        } catch (IOException e2) {
            AiAppsFileUtils.closeSafely(fileOutputStream);
            return false;
        } catch (Throwable th2) {
            th = th2;
            AiAppsFileUtils.closeSafely(fileOutputStream);
            throw th;
        }
    }

    public static byte[] streamToBytes(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr2);
                    if (-1 == read) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                AiAppsFileUtils.closeSafely(inputStream);
                AiAppsFileUtils.closeSafely(byteArrayOutputStream);
            }
        }
        return bArr;
    }

    public static String streamToString(InputStream inputStream) {
        return streamToString(inputStream, Xml.Encoding.UTF_8.toString());
    }

    public static String streamToString(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                AiAppsFileUtils.closeSafely(inputStream);
            } finally {
                AiAppsFileUtils.closeSafely(inputStream);
            }
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0051 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    public static boolean streamToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        ?? exists = parentFile.exists();
        if (exists == 0) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            fileOutputStream.flush();
                            AiAppsFileUtils.closeSafely(fileOutputStream);
                            AiAppsFileUtils.closeSafely(inputStream);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    AiAppsFileUtils.closeSafely(fileOutputStream);
                    AiAppsFileUtils.closeSafely(inputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                AiAppsFileUtils.closeSafely(exists);
                AiAppsFileUtils.closeSafely(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            exists = 0;
            AiAppsFileUtils.closeSafely(exists);
            AiAppsFileUtils.closeSafely(inputStream);
            throw th;
        }
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
        } catch (IOException e) {
            return false;
        }
    }
}
