package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> dRx = new AtomicReference<>(null);
    private static final e dRy = bap();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c dRz = new c();
    }

    public static c bap() {
        return a.dRz;
    }
}
