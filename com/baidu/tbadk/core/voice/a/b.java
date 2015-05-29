package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.ac;
import com.baidu.tbadk.core.util.o;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a du(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.cA(aVar.error_code);
        } else if (!o.cy(String.valueOf(o.st()) + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.cA(aVar.error_code);
        } else {
            String e = ac.e(o.cG(str));
            if (e == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.cA(aVar.error_code);
            } else {
                String b = o.b(e, 1, true);
                if (o.af(str, b)) {
                    aVar.path = b;
                    aVar.md5 = e;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.cA(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean ai(String str, String str2) {
        return o.af(str, o.b(str2, 1, true));
    }

    public static synchronized void uH() {
        synchronized (b.class) {
            File file = new File(String.valueOf(o.st()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
