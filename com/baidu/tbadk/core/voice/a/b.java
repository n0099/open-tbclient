package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.util.n;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a dO(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.df(aVar.error_code);
        } else if (!n.cO(String.valueOf(n.ui()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.df(aVar.error_code);
        } else {
            String f = t.f(n.cY(str));
            if (f == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.df(aVar.error_code);
            } else {
                String c = n.c(f, 1, true);
                if (n.aa(str, c)) {
                    aVar.path = c;
                    aVar.md5 = f;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.df(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ae(String str, String str2) {
        return n.aa(str, n.c(str2, 1, true));
    }

    public static synchronized void wB() {
        synchronized (b.class) {
            File file = new File(String.valueOf(n.ui()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
