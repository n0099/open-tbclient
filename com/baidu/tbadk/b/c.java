package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> cJZ = new AtomicReference<>(null);
    private static final e cKa = ayC();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c cKb = new c();
    }

    public static c ayC() {
        return a.cKb;
    }
}
