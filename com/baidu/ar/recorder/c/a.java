package com.baidu.ar.recorder.c;

import java.io.File;
/* loaded from: classes3.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();

    public static void aq(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean ar(String str) {
        return new File(str).delete();
    }
}
