package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> Rl = new AtomicReference<>(null);
    private static final e Rm = nB();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c Rn = new c();
    }

    public static c nB() {
        return a.Rn;
    }
}
