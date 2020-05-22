package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes3.dex */
public class d extends c {
    private static d bro;

    private d() {
    }

    public static d Mb() {
        if (bro == null) {
            init();
        }
        return bro;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bro == null) {
                bro = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.LQ();
        setState(new File(com.baidu.minivideo.arface.c.LW()).exists() ? 2 : 3);
    }
}
