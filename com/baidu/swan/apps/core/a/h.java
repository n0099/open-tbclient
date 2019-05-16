package com.baidu.swan.apps.core.a;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CountDownLatch apo;
    private boolean apq;

    public void yx() {
        if (!this.apq) {
            this.apq = true;
            this.apo.countDown();
        }
    }
}
