package com.baidu.minivideo.arface.utils;

import java.io.File;
/* loaded from: classes6.dex */
public class e extends d {
    private static e cmp;

    private e() {
    }

    public static e aeJ() {
        if (cmp == null) {
            init();
        }
        return cmp;
    }

    private static synchronized void init() {
        synchronized (e.class) {
            if (cmp == null) {
                cmp = new e();
            }
        }
    }

    @Override // com.baidu.minivideo.arface.utils.d
    protected void run() {
        com.baidu.minivideo.arface.b.adM();
        setState(new File(com.baidu.minivideo.arface.c.adX()).exists() ? 2 : 3);
    }
}
