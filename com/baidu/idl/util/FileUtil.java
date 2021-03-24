package com.baidu.idl.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes2.dex */
public class FileUtil {
    public static final String TAG = "FileUtil";

    public FileUtil() {
        throw new RuntimeException("This class instance can not be created.");
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
        if (file.exists()) {
            return true;
        }
        try {
            file.createNewFile();
            return true;
        } catch (IOException e2) {
            StuLogEx.e("FileUtil", "创建文件失败", e2);
            return false;
        }
    }

    public static boolean loadPropertiesFile(File file, Properties properties) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.load(bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            StuLogEx.e("FileUtil", e.getMessage(), e);
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public static boolean savePropertiesFile(File file, Properties properties) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            properties.store(bufferedOutputStream, (String) null);
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            StuLogEx.e("FileUtil", e.getMessage(), e);
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }
}
