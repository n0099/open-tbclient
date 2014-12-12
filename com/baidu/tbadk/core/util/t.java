package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String HD = TbadkCoreApplication.m255getInst().getApp().getFileStreamPath("").getAbsolutePath();

    public static boolean cr(String str) {
        try {
            return new File(new StringBuilder(String.valueOf(HD)).append("/").append(str).toString()).exists();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.checkFile " + str);
            return false;
        }
    }

    public static boolean cs(String str) {
        try {
            File file = new File(String.valueOf(HD) + "/" + str);
            if (file.exists()) {
                return false;
            }
            return file.createNewFile();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.createFile " + str);
            return false;
        }
    }

    public static void n(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            n(listFiles[i]);
                        }
                    }
                }
                file.delete();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.deleteFileOrDir");
        }
    }

    public static boolean ct(String str) {
        try {
            File file = new File(String.valueOf(HD) + "/" + str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return false;
                }
                n(file);
            }
            return file.mkdirs();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.cleanDirectory " + str);
            return false;
        }
    }

    public static String cu(String str) {
        String str2 = null;
        try {
            File file = new File(String.valueOf(HD) + "/" + str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                long j = 0;
                for (int i = 0; i < length; i++) {
                    if (j > listFiles[i].lastModified()) {
                        j = listFiles[i].lastModified();
                        str2 = listFiles[i].getName();
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.getLatestFileName " + str);
        }
        return str2;
    }
}
