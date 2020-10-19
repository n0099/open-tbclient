package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes15.dex */
public class d extends c {
    private static d bMq;

    private d() {
    }

    public static d VV() {
        if (bMq == null) {
            init();
        }
        return bMq;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bMq == null) {
                bMq = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.c
    protected void run() {
        com.baidu.minivideo.arface.b.VI();
        setState(new File(com.baidu.minivideo.arface.c.VQ()).exists() ? 2 : 3);
    }
}
