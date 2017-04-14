package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> QJ = new AtomicReference<>(null);
    private static final e QK = nX();

    private c() {
    }

    /* synthetic */ c(c cVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c QL = new c(null);
    }

    public static c nX() {
        return a.QL;
    }
}
