package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a gc(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.el(aVar.error_code);
        } else if (!l.ez(l.getCacheDir() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.el(aVar.error_code);
        } else {
            String i = s.i(l.eT(str));
            if (i == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.el(aVar.error_code);
            } else {
                String b = l.b(i, 1, true);
                if (l.aw(str, b)) {
                    aVar.path = b;
                    aVar.md5 = i;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.el(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean renameFile(String str, String str2) {
        return l.aw(str, l.b(str2, 1, true));
    }

    public static synchronized void Ez() {
        synchronized (b.class) {
            File file = new File(l.getCacheDir() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
