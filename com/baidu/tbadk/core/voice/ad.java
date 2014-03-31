package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public final class ad {
    public static String a(String str) {
        if (com.baidu.adp.lib.util.n.a(str)) {
            return null;
        }
        return "tb/voice/" + str;
    }

    public static boolean b(String str) {
        if (com.baidu.adp.lib.util.n.a(str)) {
            return false;
        }
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("FileHelper", "DelFile", "error = " + th.getMessage());
            TiebaStatic.b("", -1103, "FileHelper DelFile error: " + th.getMessage(), str);
            return false;
        }
    }
}
