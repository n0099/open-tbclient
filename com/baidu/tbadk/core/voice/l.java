package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.o;
import java.io.File;
/* loaded from: classes.dex */
public class l {
    public static String uG() {
        return z.ju();
    }

    public static String dr(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String ds(String str) {
        return o.o(str, 1);
    }

    public static String dt(String str) {
        return com.baidu.adp.lib.util.f.aJ(dr(str));
    }

    public static boolean aO(String str) {
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
