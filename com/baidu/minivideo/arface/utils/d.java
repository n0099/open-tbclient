package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes14.dex */
public class d extends c {
    private static d bYM;

    private d() {
    }

    public static d ZF() {
        if (bYM == null) {
            init();
        }
        return bYM;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bYM == null) {
                bYM = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.c
    protected void run() {
        com.baidu.minivideo.arface.b.Zs();
        setState(new File(com.baidu.minivideo.arface.c.ZA()).exists() ? 2 : 3);
    }
}
