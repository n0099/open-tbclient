package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes6.dex */
public class d extends c {
    private static d bCp;

    private d() {
    }

    public static d Tl() {
        if (bCp == null) {
            init();
        }
        return bCp;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bCp == null) {
                bCp = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.SY();
        setState(new File(com.baidu.minivideo.arface.c.Tg()).exists() ? 2 : 3);
    }
}
