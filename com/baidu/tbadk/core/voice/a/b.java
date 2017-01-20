package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.util.l;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a dZ(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dz(aVar.error_code);
        } else if (!l.cU(String.valueOf(l.tZ()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dz(aVar.error_code);
        } else {
            String k = t.k(l.de(str));
            if (k == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dz(aVar.error_code);
            } else {
                String b = l.b(k, 1, true);
                if (l.aa(str, b)) {
                    aVar.path = b;
                    aVar.md5 = k;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dz(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ah(String str, String str2) {
        return l.aa(str, l.b(str2, 1, true));
    }

    public static synchronized void wP() {
        synchronized (b.class) {
            File file = new File(String.valueOf(l.tZ()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
