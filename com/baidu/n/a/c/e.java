package com.baidu.n.a.c;

import java.io.File;
/* loaded from: classes5.dex */
public class e {
    public static boolean a(String str, File file, boolean z, Object obj) {
        boolean a;
        synchronized (obj) {
            a = f.a(str, file, z);
        }
        return a;
    }

    public static String a(File file, Object obj) {
        String readFileData;
        synchronized (obj) {
            readFileData = f.readFileData(file);
        }
        return readFileData;
    }
}
