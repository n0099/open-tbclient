package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes8.dex */
public class d extends c {
    private static d cfm;

    private d() {
    }

    public static d acN() {
        if (cfm == null) {
            init();
        }
        return cfm;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (cfm == null) {
                cfm = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.c
    protected void run() {
        com.baidu.minivideo.arface.b.abY();
        setState(new File(com.baidu.minivideo.arface.c.acj()).exists() ? 2 : 3);
    }
}
