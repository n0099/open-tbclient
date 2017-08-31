package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.p;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static String xB() {
        return p.hJ();
    }

    public static String et(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String eu(String str) {
        return k.q(str, 1);
    }

    public static String ev(String str) {
        return e.az(et(str));
    }

    public static boolean aE(String str) {
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
