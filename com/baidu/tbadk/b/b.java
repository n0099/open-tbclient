package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> esr = new AtomicReference<>(null);
    private static final d ess = bhC();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b est = new b();
    }

    public static b bhC() {
        return a.est;
    }
}
