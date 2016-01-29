package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a dQ(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.du(aVar.error_code);
        } else if (!m.cO(String.valueOf(m.uW()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.du(aVar.error_code);
        } else {
            String f = t.f(m.cY(str));
            if (f == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.du(aVar.error_code);
            } else {
                String c = m.c(f, 1, true);
                if (m.Z(str, c)) {
                    aVar.path = c;
                    aVar.md5 = f;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.du(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ad(String str, String str2) {
        return m.Z(str, m.c(str2, 1, true));
    }

    public static synchronized void xy() {
        synchronized (b.class) {
            File file = new File(String.valueOf(m.uW()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
