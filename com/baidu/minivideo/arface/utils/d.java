package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes15.dex */
public class d extends c {
    private static d bUN;

    private d() {
    }

    public static d XP() {
        if (bUN == null) {
            init();
        }
        return bUN;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bUN == null) {
                bUN = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.c
    protected void run() {
        com.baidu.minivideo.arface.b.XC();
        setState(new File(com.baidu.minivideo.arface.c.XK()).exists() ? 2 : 3);
    }
}
