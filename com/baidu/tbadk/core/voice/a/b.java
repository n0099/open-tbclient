package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.util.n;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a dv(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.cJ(aVar.error_code);
        } else if (!n.cz(String.valueOf(n.tA()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.cJ(aVar.error_code);
        } else {
            String e = t.e(n.cH(str));
            if (e == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.cJ(aVar.error_code);
            } else {
                String c = n.c(e, 1, true);
                if (n.ae(str, c)) {
                    aVar.path = c;
                    aVar.md5 = e;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.cJ(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ai(String str, String str2) {
        return n.ae(str, n.c(str2, 1, true));
    }

    public static synchronized void vL() {
        synchronized (b.class) {
            File file = new File(String.valueOf(n.tA()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
