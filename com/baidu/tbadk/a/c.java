package com.baidu.tbadk.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c implements e {
    public static final AtomicReference<e> acp = new AtomicReference<>(null);
    private static final e acq = sz();

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static c acr = new c();
    }

    public static c sz() {
        return a.acr;
    }
}
