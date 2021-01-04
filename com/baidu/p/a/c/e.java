package com.baidu.p.a.c;

import java.io.File;
/* loaded from: classes5.dex */
public class e {
    public static boolean a(String str, File file, boolean z, Object obj) {
        boolean b2;
        synchronized (obj) {
            b2 = f.b(str, file, z);
        }
        return b2;
    }

    public static String a(File file, Object obj) {
        String readFileData;
        synchronized (obj) {
            readFileData = f.readFileData(file);
        }
        return readFileData;
    }
}
