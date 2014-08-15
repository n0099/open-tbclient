package com.baidu.tbadk.core.voice.a;

import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.s;
import java.io.File;
/* loaded from: classes.dex */
public class b {
    public static a a(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.c = 6;
            aVar.d = a.a(aVar.c);
        } else if (!s.a(String.valueOf(s.d()) + "voice")) {
            aVar.c = 7;
            aVar.d = a.a(aVar.c);
        } else {
            String a = ba.a(s.i(str));
            if (a == null) {
                aVar.c = 5;
                aVar.d = a.a(aVar.c);
            } else {
                String a2 = s.a(a, 1, true);
                if (s.f(str, a2)) {
                    aVar.b = a2;
                    aVar.a = a;
                } else {
                    aVar.c = 1;
                    aVar.d = a.a(aVar.c);
                }
            }
        }
        return aVar;
    }

    public static boolean a(String str, String str2) {
        return s.f(str, s.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (b.class) {
            File file = new File(String.valueOf(s.d()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
