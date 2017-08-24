package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.util.k;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a eD(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dD(aVar.error_code);
        } else if (!k.dv(k.uL() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dD(aVar.error_code);
        } else {
            String q = r.q(k.dF(str));
            if (q == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dD(aVar.error_code);
            } else {
                String b = k.b(q, 1, true);
                if (k.Z(str, b)) {
                    aVar.path = b;
                    aVar.md5 = q;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dD(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean af(String str, String str2) {
        return k.Z(str, k.b(str2, 1, true));
    }

    public static synchronized void xA() {
        synchronized (b.class) {
            File file = new File(k.uL() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
