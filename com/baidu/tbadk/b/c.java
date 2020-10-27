package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> eoh = new AtomicReference<>(null);
    private static final e eoi = bfK();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c eoj = new c();
    }

    public static c bfK() {
        return a.eoj;
    }
}
