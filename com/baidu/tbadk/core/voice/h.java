package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import java.io.File;
/* loaded from: classes.dex */
public class h {
    public static String vJ() {
        return r.jn();
    }

    public static String dD(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String dE(String str) {
        return n.q(str, 1);
    }

    public static String dF(String str) {
        return com.baidu.adp.lib.util.e.aB(dD(str));
    }

    public static boolean aG(String str) {
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
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
