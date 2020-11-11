package com.baidu.mario.a.c;

import java.io.File;
/* loaded from: classes5.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void jj(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean jk(String str) {
        return new File(str).delete();
    }
}
