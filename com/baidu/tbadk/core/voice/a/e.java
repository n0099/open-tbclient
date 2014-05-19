package com.baidu.tbadk.core.voice.a;

import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import java.io.File;
/* loaded from: classes.dex */
public class e {
    public static d a(String str) {
        d dVar = new d();
        if (str == null) {
            dVar.c = 6;
            dVar.d = d.a(dVar.c);
        } else if (!x.a(String.valueOf(x.d()) + "voice")) {
            dVar.c = 7;
            dVar.d = d.a(dVar.c);
        } else {
            String a = be.a(x.i(str));
            if (a == null) {
                dVar.c = 5;
                dVar.d = d.a(dVar.c);
            } else {
                String a2 = x.a(a, 1, true);
                if (x.g(str, a2)) {
                    dVar.b = a2;
                    dVar.a = a;
                } else {
                    dVar.c = 1;
                    dVar.d = d.a(dVar.c);
                }
            }
        }
        return dVar;
    }

    public static int a(String str, byte[] bArr) {
        if (str == null) {
            return 5;
        }
        if (bArr == null || bArr.length == 0) {
            return 6;
        }
        if (x.a(str, bArr, 1) == null) {
            return x.e() < ((long) bArr.length) ? 2 : 1;
        }
        return 0;
    }

    public static boolean a(String str, String str2) {
        return x.g(str, x.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(String.valueOf(x.d()) + "voice");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
