package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.w;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.s;
import java.io.File;
/* loaded from: classes.dex */
public class r {
    public static String qJ() {
        return w.fB();
    }

    public static String cV(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String cW(String str) {
        return s.n(str, 1);
    }

    public static String cX(String str) {
        return com.baidu.adp.lib.util.d.at(cV(str));
    }

    public static boolean ax(String str) {
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
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
