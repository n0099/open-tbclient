package com.baidu.android.imsdk.retrieve.util;

import java.io.File;
/* loaded from: classes.dex */
public class FileUtils {
    public static boolean deleteFile(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                return file.delete();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= deleteFile(file2);
                    }
                }
                return z & file.delete();
            }
            return true;
        }
        return true;
    }
}
