package com.baidu.idl.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes3.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    private FileUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [30=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean savePropertiesFile(File file, Properties properties) {
        BufferedOutputStream bufferedOutputStream;
        boolean z;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                try {
                    properties.store(bufferedOutputStream, (String) null);
                    z = true;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    StuLogEx.e(TAG, e.getMessage(), e);
                    z = false;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [50=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0038 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean loadPropertiesFile(File file, Properties properties) {
        ?? e;
        boolean z;
        try {
            try {
                e = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(e);
                    z = true;
                    if (e != 0) {
                        try {
                            e.close();
                        } catch (IOException e2) {
                            e = e2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    StuLogEx.e(TAG, e.getMessage(), e);
                    z = false;
                    if (e != 0) {
                        try {
                            e.close();
                        } catch (IOException e4) {
                            e = e4;
                        }
                    }
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                if (e != 0) {
                    try {
                        e.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            e = 0;
        } catch (Throwable th2) {
            th = th2;
            e = 0;
            if (e != 0) {
            }
            throw th;
        }
        return z;
    }

    public static boolean createFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists() && file.length() > 3145728) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                StuLogEx.e(TAG, "创建文件失败", e);
                return false;
            }
        }
        return true;
    }
}
