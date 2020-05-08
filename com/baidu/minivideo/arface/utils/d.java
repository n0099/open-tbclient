package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes3.dex */
public class d extends c {
    private static d bjT;

    private d() {
    }

    public static d Ki() {
        if (bjT == null) {
            init();
        }
        return bjT;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bjT == null) {
                bjT = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.JX();
        setState(new File(com.baidu.minivideo.arface.c.Kd()).exists() ? 2 : 3);
    }
}
