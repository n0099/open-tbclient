package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> QY = new AtomicReference<>(null);
    private static final e QZ = nv();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c Ra = new c();
    }

    public static c nv() {
        return a.Ra;
    }
}
