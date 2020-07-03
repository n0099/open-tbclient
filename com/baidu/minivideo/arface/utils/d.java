package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes3.dex */
public class d extends c {
    private static d bwr;

    private d() {
    }

    public static d Nm() {
        if (bwr == null) {
            init();
        }
        return bwr;
    }

    private static synchronized void init() {
        synchronized (d.class) {
            if (bwr == null) {
                bwr = new d();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.f
    public void run() {
        com.baidu.minivideo.arface.b.MZ();
        setState(new File(com.baidu.minivideo.arface.c.Nh()).exists() ? 2 : 3);
    }
}
