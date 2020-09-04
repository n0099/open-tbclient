package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes6.dex */
public class d extends c {
    private static d bCs;

    private d() {
    }

    public static d Tl() {
        if (bCs == null) {
            init();
        }
        return bCs;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bCs == null) {
                bCs = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.SY();
        setState(new File(com.baidu.minivideo.arface.c.Tg()).exists() ? 2 : 3);
    }
}
