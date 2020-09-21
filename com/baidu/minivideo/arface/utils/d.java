package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes11.dex */
public class d extends c {
    private static d bFP;

    private d() {
    }

    public static d Uc() {
        if (bFP == null) {
            init();
        }
        return bFP;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bFP == null) {
                bFP = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.TP();
        setState(new File(com.baidu.minivideo.arface.c.TX()).exists() ? 2 : 3);
    }
}
