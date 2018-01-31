package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> aFG = new AtomicReference<>(null);
    private static final e aFH = uX();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c aFI = new c();
    }

    public static c uX() {
        return a.aFI;
    }
}
