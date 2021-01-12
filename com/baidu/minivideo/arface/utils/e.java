package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes5.dex */
public class e extends d {
    private static e chB;

    private e() {
    }

    public static e aaR() {
        if (chB == null) {
            init();
        }
        return chB;
    }

    private static synchronized void init() {
        synchronized (e.class) {
            if (chB == null) {
                chB = new e();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.d
    protected void run() {
        com.baidu.minivideo.arface.b.ZU();
        setState(new File(com.baidu.minivideo.arface.c.aaf()).exists() ? 2 : 3);
    }
}
