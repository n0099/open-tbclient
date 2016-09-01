package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a dZ(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.du(aVar.error_code);
        } else if (!m.cR(String.valueOf(m.getCacheDir()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.du(aVar.error_code);
        } else {
            String k = t.k(m.db(str));
            if (k == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.du(aVar.error_code);
            } else {
                String b = m.b(k, 1, true);
                if (m.aa(str, b)) {
                    aVar.path = b;
                    aVar.md5 = k;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.du(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ag(String str, String str2) {
        return m.aa(str, m.b(str2, 1, true));
    }

    public static synchronized void xb() {
        synchronized (b.class) {
            File file = new File(String.valueOf(m.getCacheDir()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
