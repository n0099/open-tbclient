package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a ft(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dP(aVar.error_code);
        } else if (!l.dR(l.yj() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dP(aVar.error_code);
        } else {
            String g = s.g(l.el(str));
            if (g == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dP(aVar.error_code);
            } else {
                String b = l.b(g, 1, true);
                if (l.ad(str, b)) {
                    aVar.path = b;
                    aVar.md5 = g;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dP(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean renameFile(String str, String str2) {
        return l.ad(str, l.b(str2, 1, true));
    }

    public static synchronized void Bi() {
        synchronized (b.class) {
            File file = new File(l.yj() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
