package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> bTP = new AtomicReference<>(null);
    private static final e bTQ = afa();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c bTR = new c();
    }

    public static c afa() {
        return a.bTR;
    }
}
