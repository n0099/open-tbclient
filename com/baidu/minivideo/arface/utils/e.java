package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes5.dex */
public class e extends d {
    private static e cnr;

    private e() {
    }

    public static e acI() {
        if (cnr == null) {
            init();
        }
        return cnr;
    }

    private static synchronized void init() {
        synchronized (e.class) {
            if (cnr == null) {
                cnr = new e();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.d
    protected void run() {
        com.baidu.minivideo.arface.b.abL();
        setState(new File(com.baidu.minivideo.arface.c.abW()).exists() ? 2 : 3);
    }
}
