package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes15.dex */
public class d extends c {
    private static d cax;

    private d() {
    }

    public static d aao() {
        if (cax == null) {
            init();
        }
        return cax;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (cax == null) {
                cax = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.c
    protected void run() {
        com.baidu.minivideo.arface.b.aab();
        setState(new File(com.baidu.minivideo.arface.c.aaj()).exists() ? 2 : 3);
    }
}
