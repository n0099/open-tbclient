package com.baidu.tbadk.b;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> dCp = new AtomicReference<>(null);
    private static final e dCq = aOd();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c dCr = new c();
    }

    public static c aOd() {
        return a.dCr;
    }
}
