package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> bBh = new AtomicReference<>(null);
    private static final e bBi = aam();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c bBj = new c();
    }

    public static c aam() {
        return a.bBj;
    }
}
