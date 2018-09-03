package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> ZN = new AtomicReference<>(null);
    private static final e ZO = rt();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c ZP = new c();
    }

    public static c rt() {
        return a.ZP;
    }
}
