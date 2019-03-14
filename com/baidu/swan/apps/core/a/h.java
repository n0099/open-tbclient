package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch aoX;
    private boolean aoY;

    public void xG() {
        if (!this.aoY) {
            this.aoY = true;
            this.aoX.countDown();
        }
    }
}
