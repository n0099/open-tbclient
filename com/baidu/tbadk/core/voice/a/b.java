package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.core.util.s;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a cY(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.co(aVar.error_code);
        } else if (!s.cg(String.valueOf(s.or()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.co(aVar.error_code);
        } else {
            String e = z.e(s.co(str));
            if (e == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.co(aVar.error_code);
            } else {
                String b = s.b(e, 1, true);
                if (s.X(str, b)) {
                    aVar.path = b;
                    aVar.md5 = e;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.co(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean aa(String str, String str2) {
        return s.X(str, s.b(str2, 1, true));
    }

    public static synchronized void qK() {
        synchronized (b.class) {
            File file = new File(String.valueOf(s.or()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
