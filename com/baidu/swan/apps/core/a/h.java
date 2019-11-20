package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch aJo;
    private boolean aJp;

    public void Ed() {
        if (!this.aJp) {
            this.aJp = true;
            this.aJo.countDown();
        }
    }
}
