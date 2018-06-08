package com.baidu.ar.recorder.g;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static final String a = a.class.getSimpleName();

    public static void a(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean b(String str) {
        return new File(str).delete();
    }
}
