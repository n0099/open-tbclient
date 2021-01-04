package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> eJa = new AtomicReference<>(null);
    private static final e eJb = bnm();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c eJc = new c();
    }

    public static c bnm() {
        return a.eJc;
    }
}
