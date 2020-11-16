package com.baidu.mario.a.c;

import java.io.File;
/* loaded from: classes6.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void jd(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean je(String str) {
        return new File(str).delete();
    }
}
