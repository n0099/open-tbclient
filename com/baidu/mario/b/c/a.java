package com.baidu.mario.b.c;

import java.io.File;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void dr(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean ds(String str) {
        return new File(str).delete();
    }
}
