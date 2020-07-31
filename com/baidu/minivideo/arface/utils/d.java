package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes6.dex */
public class d extends c {
    private static d bwG;

    private d() {
    }

    public static d Nr() {
        if (bwG == null) {
            init();
        }
        return bwG;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bwG == null) {
                bwG = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.Ne();
        setState(new File(com.baidu.minivideo.arface.c.Nm()).exists() ? 2 : 3);
    }
}
