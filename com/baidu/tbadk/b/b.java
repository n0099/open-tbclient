package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bAG = new AtomicReference<>(null);
    private static final d bAH = aag();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bAI = new b();
    }

    public static b aag() {
        return a.bAI;
    }
}
