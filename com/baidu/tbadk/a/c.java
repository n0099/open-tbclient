package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> Qd = new AtomicReference<>(null);
    private static final e Qe = nE();

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c Qf = new c(null);
    }

    public static c nE() {
        return a.Qf;
    }
}
