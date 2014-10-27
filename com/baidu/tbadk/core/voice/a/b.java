package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.s;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a cg(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.bQ(aVar.error_code);
        } else if (!s.bo(String.valueOf(s.lw()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.bQ(aVar.error_code);
        } else {
            String b = u.b(s.bw(str));
            if (b == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.bQ(aVar.error_code);
            } else {
                String b2 = s.b(b, 1, true);
                if (s.N(str, b2)) {
                    aVar.path = b2;
                    aVar.md5 = b;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.bQ(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean P(String str, String str2) {
        return s.N(str, s.b(str2, 1, true));
    }

    public static synchronized void nJ() {
        synchronized (b.class) {
            File file = new File(String.valueOf(s.lw()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
