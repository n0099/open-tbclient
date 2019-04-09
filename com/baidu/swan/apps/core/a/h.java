package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch apc;
    private boolean apd;

    public void xF() {
        if (!this.apd) {
            this.apd = true;
            this.apc.countDown();
        }
    }
}
