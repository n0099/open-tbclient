package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.m;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a nx(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.it(aVar.error_code);
        } else if (!m.lO(m.acd() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.it(aVar.error_code);
        } else {
            String j = s.j(m.mj(str));
            if (j == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.it(aVar.error_code);
            } else {
                String b = m.b(j, 1, true);
                if (m.bI(str, b)) {
                    aVar.path = b;
                    aVar.md5 = j;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.it(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean renameFile(String str, String str2) {
        return m.bI(str, m.b(str2, 1, true));
    }

    public static synchronized void afs() {
        synchronized (b.class) {
            File file = new File(m.acd() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
