package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> Rj = new AtomicReference<>(null);
    private static final e Rk = nA();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c Rl = new c();
    }

    public static c nA() {
        return a.Rl;
    }
}
