package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> bsI = new AtomicReference<>(null);
    private static final e bsJ = UF();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c bsK = new c();
    }

    public static c UF() {
        return a.bsK;
    }
}
