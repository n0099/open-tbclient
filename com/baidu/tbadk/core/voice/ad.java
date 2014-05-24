package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public class ad {
    public static String a() {
        return com.baidu.adp.lib.util.n.a();
    }

    public static String a(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String b(String str) {
        return com.baidu.tbadk.core.util.x.a(str, 1);
    }

    public static String c(String str) {
        return com.baidu.adp.lib.util.c.b(a(str));
    }

    public static boolean d(String str) {
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
            BdLog.e("FileHelper", "DelFile", "error = " + th.getMessage());
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
