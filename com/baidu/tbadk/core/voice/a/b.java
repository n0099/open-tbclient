package com.baidu.tbadk.core.voice.a;

import com.baidu.adp.lib.util.r;
import com.baidu.tbadk.core.util.k;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a et(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.error_code = 6;
            aVar.error_msg = a.dB(aVar.error_code);
        } else if (!k.dm(k.uA() + "voice")) {
            aVar.error_code = 7;
            aVar.error_msg = a.dB(aVar.error_code);
        } else {
            String k = r.k(k.dw(str));
            if (k == null) {
                aVar.error_code = 5;
                aVar.error_msg = a.dB(aVar.error_code);
            } else {
                String b = k.b(k, 1, true);
                if (k.Z(str, b)) {
                    aVar.path = b;
                    aVar.md5 = k;
                } else {
                    aVar.error_code = 1;
                    aVar.error_msg = a.dB(aVar.error_code);
                }
            }
        }
        return aVar;
    }

    public static boolean af(String str, String str2) {
        return k.Z(str, k.b(str2, 1, true));
    }

    public static synchronized void xs() {
        synchronized (b.class) {
            File file = new File(k.uA() + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
