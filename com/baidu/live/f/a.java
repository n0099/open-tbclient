package com.baidu.live.f;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.Md5;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.FileHelper;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static String getFileMd5(File file) {
        String md5 = Md5.toMd5(FileHelper.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            return md5.toLowerCase();
        }
        return md5;
    }

    public static boolean existFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean isDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).isDirectory();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static void cleanDir(File file) {
        try {
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i].isFile()) {
                        listFiles[i].delete();
                    } else {
                        cleanDir(listFiles[i]);
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
