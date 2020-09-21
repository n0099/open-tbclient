package com.baidu.ar.recorder.c;

import java.io.File;
/* loaded from: classes10.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void au(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean av(String str) {
        return new File(str).delete();
    }
}
