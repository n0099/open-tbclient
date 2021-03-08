package com.baidu.mario.a.c;

import java.io.File;
/* loaded from: classes14.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void jb(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean jc(String str) {
        return new File(str).delete();
    }
}
