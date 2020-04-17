package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> djf = new AtomicReference<>(null);
    private static final e djg = aGN();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c djh = new c();
    }

    public static c aGN() {
        return a.djh;
    }
}
