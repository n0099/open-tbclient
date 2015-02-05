package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.core.util.s;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a cU(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.cv(aVar.error_code);
        } else if (!s.cb(String.valueOf(s.on()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.cv(aVar.error_code);
        } else {
            String e = z.e(s.cj(str));
            if (e == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.cv(aVar.error_code);
            } else {
                String b = s.b(e, 1, true);
                if (s.aa(str, b)) {
                    aVar.path = b;
                    aVar.md5 = e;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.cv(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ad(String str, String str2) {
        return s.aa(str, s.b(str2, 1, true));
    }

    public static synchronized void qP() {
        synchronized (b.class) {
            File file = new File(String.valueOf(s.on()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
