package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> bsE = new AtomicReference<>(null);
    private static final e bsF = UI();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c bsG = new c();
    }

    public static c UI() {
        return a.bsG;
    }
}
