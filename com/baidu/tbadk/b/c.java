package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> cJM = new AtomicReference<>(null);
    private static final e cJN = ayx();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c cJO = new c();
    }

    public static c ayx() {
        return a.cJO;
    }
}
