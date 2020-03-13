package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> cJO = new AtomicReference<>(null);
    private static final e cJP = ayz();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c cJQ = new c();
    }

    public static c ayz() {
        return a.cJQ;
    }
}
