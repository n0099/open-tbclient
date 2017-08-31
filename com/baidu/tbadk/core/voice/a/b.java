package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.util.k;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a ew(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dE(aVar.error_code);
        } else if (!k.dl(k.uG() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dE(aVar.error_code);
        } else {
            String e = r.e(k.dv(str));
            if (e == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dE(aVar.error_code);
            } else {
                String b = k.b(e, 1, true);
                if (k.ac(str, b)) {
                    aVar.path = b;
                    aVar.md5 = e;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dE(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ai(String str, String str2) {
        return k.ac(str, k.b(str2, 1, true));
    }

    public static synchronized void xC() {
        synchronized (b.class) {
            File file = new File(k.uG() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
