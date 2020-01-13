package com.baidu.mario.a.c;

import java.io.File;
/* loaded from: classes10.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void ej(String str) {
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
    }

    public static boolean ek(String str) {
        return new File(str).delete();
    }
}
