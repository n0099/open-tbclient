package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static String aov() {
        return q.guid();
    }

    public static String oC(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String getVoiceFilePath(String str) {
        return m.getStoreFile(str, 1);
    }

    public static String oD(String str) {
        return f.getFilePath(oC(str));
    }

    public static boolean delFile(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            TiebaStatic.voiceError(-1103, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
