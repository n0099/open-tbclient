package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes3.dex */
public class e extends d {
    private static e clQ;

    private e() {
    }

    public static e acF() {
        if (clQ == null) {
            init();
        }
        return clQ;
    }

    private static synchronized void init() {
        synchronized (e.class) {
            if (clQ == null) {
                clQ = new e();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.d
    protected void run() {
        com.baidu.minivideo.arface.b.abI();
        setState(new File(com.baidu.minivideo.arface.c.abT()).exists() ? 2 : 3);
    }
}
