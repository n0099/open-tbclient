package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a fv(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dN(aVar.error_code);
        } else if (!l.dU(l.ys() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dN(aVar.error_code);
        } else {
            String g = s.g(l.en(str));
            if (g == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dN(aVar.error_code);
            } else {
                String b = l.b(g, 1, true);
                if (l.af(str, b)) {
                    aVar.path = b;
                    aVar.md5 = g;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dN(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean renameFile(String str, String str2) {
        return l.af(str, l.b(str2, 1, true));
    }

    public static synchronized void Bu() {
        synchronized (b.class) {
            File file = new File(l.ys() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
