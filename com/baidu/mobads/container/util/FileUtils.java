package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes2.dex */
public class FileUtils {
    public static final int IO_BUF_SIZE = 32768;

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0054, code lost:
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0062, code lost:
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006d, code lost:
        if (r4 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0070, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (FileNotFoundException unused) {
                fileOutputStream = null;
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (Throwable unused3) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream2.close();
                fileOutputStream.close();
                try {
                    fileInputStream2.close();
                } catch (Exception unused4) {
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused5) {
                }
                return true;
            } catch (FileNotFoundException unused6) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused7) {
                    }
                }
            } catch (IOException unused8) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused9) {
                    }
                }
            } catch (Throwable unused10) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused11) {
                    }
                }
            }
        } catch (FileNotFoundException unused12) {
            fileOutputStream = null;
        } catch (IOException unused13) {
            fileOutputStream = null;
        } catch (Throwable unused14) {
            fileOutputStream = null;
        }
    }

    public static void copyFileFromAssetsTo(Context context, String str, String str2) throws IOException {
        try {
            copyFileInputStream(context.getAssets().open(str), str2);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2);
        }
    }

    public static void copyFileInputStream(InputStream inputStream, String str) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static File deleteFileRecursive(File file) {
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    File deleteFileRecursive = deleteFileRecursive(file2);
                    if (deleteFileRecursive != null) {
                        return deleteFileRecursive;
                    }
                }
            }
            if (file.delete()) {
                return null;
            }
            return file;
        } catch (Exception unused) {
            if (file.delete()) {
                return null;
            }
            return file;
        }
    }

    public static String getFileName(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException unused) {
            return "";
        }
    }

    public static boolean isFileExistsAndCanRead(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0055 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static byte[] readFileToByteArray(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                if (file.exists()) {
                    fileInputStream = new FileInputStream((File) file);
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[32768];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    tryClose(byteArrayOutputStream);
                                    tryClose(fileInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            RemoteXAdLogger.getInstance().d("Failed to read file", e);
                            tryClose(byteArrayOutputStream);
                            tryClose(fileInputStream);
                            return null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        file = 0;
                        tryClose(file);
                        tryClose(fileInputStream);
                        throw th;
                    }
                } else {
                    throw new FileNotFoundException();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            file = 0;
        }
    }

    public static boolean renameFile(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:12:0x0026 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6 */
    public static void saveBytesToFile(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream4 = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = 0;
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(bArr);
                fileOutputStream.flush();
                bufferedOutputStream.flush();
                tryClose(fileOutputStream);
                fileOutputStream3 = bufferedOutputStream;
            } catch (IOException e3) {
                e = e3;
                fileOutputStream4 = fileOutputStream;
                fileOutputStream2 = bufferedOutputStream;
                try {
                    RemoteXAdLogger.getInstance().d("Failed to save file", e);
                    tryClose(fileOutputStream4);
                    fileOutputStream3 = fileOutputStream2;
                    tryClose(fileOutputStream3);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream4;
                    fileOutputStream4 = fileOutputStream2;
                    tryClose(fileOutputStream);
                    tryClose(fileOutputStream4);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream4 = bufferedOutputStream;
                try {
                    RemoteXAdLogger.getInstance().d("Failed to save file", th);
                    tryClose(fileOutputStream);
                    tryClose(fileOutputStream4);
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    tryClose(fileOutputStream);
                    tryClose(fileOutputStream4);
                    throw th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
        tryClose(fileOutputStream3);
    }

    public static void tryClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                RemoteXAdLogger.getInstance().e("Failed to close the target", e2);
            }
        }
    }

    public static boolean isFileExistsAndCanRead(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File deleteFileRecursive(String str) {
        return deleteFileRecursive(new File(str));
    }
}
