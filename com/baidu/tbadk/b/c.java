package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> bSY = new AtomicReference<>(null);
    private static final e bSZ = aeY();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c bTa = new c();
    }

    public static c aeY() {
        return a.bTa;
    }
}
