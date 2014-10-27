package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import java.io.File;
/* loaded from: classes.dex */
public class t {
    public static final String Dq = TbadkApplication.m251getInst().getApp().getFileStreamPath("").getAbsolutePath();

    public static boolean bz(String str) {
        try {
            return new File(new StringBuilder(String.valueOf(Dq)).append("/").append(str).toString()).exists();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "FileHelper.checkFile " + str);
            return false;
        }
    }

    public static boolean bA(String str) {
        try {
            File file = new File(String.valueOf(Dq) + "/" + str);
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

    public static boolean bB(String str) {
        try {
            File file = new File(String.valueOf(Dq) + "/" + str);
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

    public static String bC(String str) {
        String str2 = null;
        try {
            File file = new File(String.valueOf(Dq) + "/" + str);
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
