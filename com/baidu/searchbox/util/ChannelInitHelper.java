package com.baidu.searchbox.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.l95;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class ChannelInitHelper {
    public static String getFromByFile() {
        String str = null;
        try {
            File GetFile = FileHelper.GetFile(TbConfig.FROM_FILE);
            if (GetFile == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GetFile));
            str = bufferedReader.readLine();
            bufferedReader.close();
            return str;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, "TiebaApplication.getFromByFile");
            return str;
        }
    }

    public static String getFromByShare() {
        return l95.m().s("from_id", null);
    }

    public static boolean hasInitFinish() {
        if (TbConfig.getCurrentFrom() != null && TbConfig.getFrom() != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x006f -> B:38:0x0072). Please submit an issue!!! */
    public static void init() {
        BufferedReader bufferedReader;
        Exception e;
        String fromByShare;
        BufferedReader bufferedReader2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                fromByShare = getFromByShare();
                bufferedReader = new BufferedReader(new InputStreamReader(TbadkCoreApplication.getInst().getResources().getAssets().open("channel"), "gbk"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                String readLine = bufferedReader.readLine();
                TbConfig.setCurrentFrom(readLine);
                if (fromByShare == null) {
                    String fromByFile = getFromByFile();
                    if (fromByFile != null && fromByFile.length() > 0) {
                        TbConfig.setFrom(fromByFile);
                        saveFromToShare(fromByFile);
                    } else if (readLine != null && readLine.length() > 0) {
                        TbConfig.setFrom(readLine);
                        saveFromToShare(readLine);
                        saveFromToFile(readLine);
                    }
                } else {
                    TbConfig.setFrom(fromByShare);
                }
                bufferedReader.close();
            } catch (Exception e3) {
                e = e3;
                BdLog.e(e.getMessage());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (Exception e4) {
            bufferedReader = null;
            e = e4;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    bufferedReader2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void saveFromToFile(String str) {
        if (str != null && str.length() > 0) {
            try {
                File CreateFile = FileHelper.CreateFile(TbConfig.FROM_FILE);
                if (CreateFile != null) {
                    FileWriter fileWriter = new FileWriter(CreateFile);
                    fileWriter.append((CharSequence) str);
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "TiebaApplication.saveFromToFile");
            }
        }
    }

    public static void saveFromToShare(String str) {
        if (str == null || str.length() <= 0 || !TbadkCoreApplication.getInst().isMainProcess(true)) {
            return;
        }
        l95.m().B("from_id", str);
    }
}
