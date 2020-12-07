package com.baidu.android.imsdk.retrieve.util;

import java.io.File;
/* loaded from: classes9.dex */
public class FileUtils {
    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                z &= deleteFile(file2);
            }
        }
        return z & file.delete();
    }
}
