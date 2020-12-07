package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> ezx = new AtomicReference<>(null);
    private static final e ezy = bkN();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c ezz = new c();
    }

    public static c bkN() {
        return a.ezz;
    }
}
