package com.baidu.ar.recorder.c;

import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static final String TAG = "a";

    public static void ax(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean ay(String str) {
        return new File(str).delete();
    }
}
