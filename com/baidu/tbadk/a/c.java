package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> aho = new AtomicReference<>(null);
    private static final e ahp = uJ();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c ahq = new c();
    }

    public static c uJ() {
        return a.ahq;
    }
}
