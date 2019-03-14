package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class b implements d {
    public static final AtomicReference<d> bsC = new AtomicReference<>(null);
    private static final d bsD = UG();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static b bsE = new b();
    }

    public static b UG() {
        return a.bsE;
    }
}
