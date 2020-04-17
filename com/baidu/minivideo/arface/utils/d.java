package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes3.dex */
public class d extends c {
    private static d bjO;

    private d() {
    }

    public static d Kj() {
        if (bjO == null) {
            init();
        }
        return bjO;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bjO == null) {
                bjO = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.JY();
        setState(new File(com.baidu.minivideo.arface.c.Ke()).exists() ? 2 : 3);
    }
}
