package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.q;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.k;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static String wT() {
        return q.hI();
    }

    public static String em(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String en(String str) {
        return k.q(str, 1);
    }

    public static String eo(String str) {
        return f.az(em(str));
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
