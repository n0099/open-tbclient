package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch apS;
    private boolean apT;

    public void zd() {
        if (!this.apT) {
            this.apT = true;
            this.apS.countDown();
        }
    }
}
