package com.baidu.r.a.c;

import java.io.File;
/* loaded from: classes14.dex */
public class e {
    public static boolean a(String str, File file, boolean z, Object obj) {
        boolean b;
        synchronized (obj) {
            b = f.b(str, file, z);
        }
        return b;
    }

    public static String a(File file, Object obj) {
        String readFileData;
        synchronized (obj) {
            readFileData = f.readFileData(file);
        }
        return readFileData;
    }
}
