package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes3.dex */
public class e {
    public static void deleteDir(File file) {
        d(file, true);
    }

    public static void d(File file, boolean z) {
        if (file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        d(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }
}
