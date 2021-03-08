package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.q;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.o;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static String bvH() {
        return q.guid();
    }

    public static String BR(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static String BS(String str) {
        return o.getStoreFile(str, 1);
    }

    public static String BT(String str) {
        return f.getFilePath(BR(str));
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
