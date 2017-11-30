package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.k;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a eB(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dO(aVar.error_code);
        } else if (!k.dh(k.um() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dO(aVar.error_code);
        } else {
            String e = s.e(k.du(str));
            if (e == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dO(aVar.error_code);
            } else {
                String b = k.b(e, 1, true);
                if (k.ab(str, b)) {
                    aVar.path = b;
                    aVar.md5 = e;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dO(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean renameFile(String str, String str2) {
        return k.ab(str, k.b(str2, 1, true));
    }

    public static synchronized void xc() {
        synchronized (b.class) {
            File file = new File(k.um() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
