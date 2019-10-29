package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch aJG;
    private boolean aJH;

    public void Ec() {
        if (!this.aJH) {
            this.aJH = true;
            this.aJG.countDown();
        }
    }
}
