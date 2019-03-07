package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private CountDownLatch aoW;
    private boolean aoX;

    public void xG() {
        if (!this.aoX) {
            this.aoX = true;
            this.aoW.countDown();
        }
    }
}
