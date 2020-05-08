package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> djj = new AtomicReference<>(null);
    private static final e djk = aGL();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c djl = new c();
    }

    public static c aGL() {
        return a.djl;
    }
}
