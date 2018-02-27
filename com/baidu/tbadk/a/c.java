package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> aGO = new AtomicReference<>(null);
    private static final e aGP = vJ();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c aGQ = new c();
    }

    public static c vJ() {
        return a.aGQ;
    }
}
