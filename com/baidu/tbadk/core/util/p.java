package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.File;
/* loaded from: classes.dex */
public class p {
    public static final String TX = TbadkCoreApplication.m411getInst().getApp().getFileStreamPath("").getAbsolutePath();

    public static boolean cK(String str) {
        try {
            return new File(new StringBuilder(String.valueOf(TX)).append("/").append(str).toString()).exists();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.checkFile " + str);
            return false;
        }
    }

    public static boolean cL(String str) {
        try {
            File file = new File(String.valueOf(TX) + "/" + str);
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

    public static void p(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    int length = listFiles.length;
                    for (int i = 0; i < length; i++) {
                        if (listFiles[i].isFile()) {
                            listFiles[i].delete();
                        } else {
                            p(listFiles[i]);
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

    public static boolean cM(String str) {
        try {
            File file = new File(String.valueOf(TX) + "/" + str);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    return false;
                }
                p(file);
            }
            return file.mkdirs();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.cleanDirectory " + str);
            return false;
        }
    }

    public static String cN(String str) {
        String str2 = null;
        try {
            File file = new File(String.valueOf(TX) + "/" + str);
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
